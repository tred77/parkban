package ir.ssa.parkban.service.business.validation;

import ir.ssa.parkban.domain.enums.ParkbanErrorCode;
import ir.ssa.parkban.repository.UserDAO;
import ir.ssa.parkban.vertical.exceptions.entity.operation.DuplicateEntityException;
import ir.ssa.parkban.vertical.validations.validators.ValidationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * Created by Behrouz-ZD on 7/10/2016.
 */

@Component
public class BusinessUserValidator implements ValidationHandler {

    @Autowired
    UserDAO userDAO;

    @Override
    public void invoke(Object... args) {
    }

    public void duplicatedUser(Object[] args){
        if(!ObjectUtils.isEmpty(args) && args.length==2 ){
            String username = (String) args[0];
            Long nationalId = (Long) args[1];
            if(userDAO.findByUsernameAndNationalId(username,nationalId)!=null)
                throw new DuplicateEntityException(ParkbanErrorCode.USERNAME_NATIONAL_CODE_IS_DUPLICATED.toString(),ParkbanErrorCode.USERNAME_NATIONAL_CODE_IS_DUPLICATED.code());
            if(userDAO.findByNationalId(nationalId)!=null)
                throw new DuplicateEntityException(ParkbanErrorCode.NATIONAL_CODE_IS_DUPLICATED.toString(),ParkbanErrorCode.NATIONAL_CODE_IS_DUPLICATED.code());
            if(userDAO.findByUsername(username)!=null)
                throw new DuplicateEntityException(ParkbanErrorCode.USERNAME_IS_DUPLICATED.toString(),ParkbanErrorCode.USERNAME_IS_DUPLICATED.code());
        }
    }
}
