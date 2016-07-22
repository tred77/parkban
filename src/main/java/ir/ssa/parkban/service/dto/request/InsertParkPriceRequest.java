package ir.ssa.parkban.service.dto.request;

import ir.ssa.parkban.service.dto.entity.ParkPriceDto;

import java.util.List;

/**
 * Created by Behrouz-ZD on 7/22/2016.
 */
public class InsertParkPriceRequest {
    private Long regionId;
    private List<ParkPriceDto> parkPriceDto;

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public List<ParkPriceDto> getParkPriceDto() {
        return parkPriceDto;
    }

    public void setParkPriceDto(List<ParkPriceDto> parkPriceDto) {
        this.parkPriceDto = parkPriceDto;
    }
}
