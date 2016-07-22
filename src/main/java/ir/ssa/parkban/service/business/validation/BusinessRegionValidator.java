package ir.ssa.parkban.service.business.validation;

import ir.ssa.parkban.domain.entities.QRegion;
import ir.ssa.parkban.domain.entities.Region;
import ir.ssa.parkban.domain.enums.RegionNodeType;
import ir.ssa.parkban.repository.RegionDAO;
import ir.ssa.parkban.service.dto.entity.RegionDto;
import ir.ssa.parkban.service.dto.exception.RegionInsertNotAllowedUnderLeafException;
import ir.ssa.parkban.service.dto.exception.RegionRootInsertNotAllowedException;
import ir.ssa.parkban.vertical.exceptions.data.validation.ArgumentRequiredException;
import ir.ssa.parkban.vertical.exceptions.data.validation.DataValidationException;
import ir.ssa.parkban.vertical.exceptions.entity.operation.EntityNotFoundException;
import ir.ssa.parkban.vertical.exceptions.entity.operation.NotDeletableException;
import ir.ssa.parkban.vertical.validations.validators.ValidationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * Created by Behrouz-ZD on 7/18/2016.
 */

@Component
public class BusinessRegionValidator implements ValidationHandler {

    @Autowired
    RegionDAO regionDAO;

    @Override
    public void invoke(Object... args) {

    }

    public void ValidateRegionDeletion(Object... args){
        if(args!=null && args.length==1){
            Region region = regionDAO.findOne((Long)args[0]);
            if(region==null)
                throw new EntityNotFoundException();
            List<Region> children = regionDAO.findByParentId(region.getId());
            if(children!=null && children.size()>0)
                throw new NotDeletableException();

        }
    }

    public void ValidateRegionInsertion(Object... args){
        if(args!=null && args.length==1){
            RegionDto region = (RegionDto)args[0];
            if(region==null)
                throw new ArgumentRequiredException();
            if(region.getParent()!=null && region.getParent().getId()!=null){
                Region parent = regionDAO.findOne(region.getParent().getId());
                if(parent==null)
                    throw new DataValidationException();
                if(parent.getRegionType().equals(RegionNodeType.LEAF))
                    throw new RegionInsertNotAllowedUnderLeafException();
            }else{
                Region parent = regionDAO.findOne(QRegion.region.parent.isNull());
                if(parent!=null)
                    throw new RegionRootInsertNotAllowedException();
            }

        }
    }
}
