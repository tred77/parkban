package ir.ssa.parkban.service.dto.request;

/**
 * Created by Behrouz-ZD on 7/1/2016.
 */
public class UsernameAndNationalIdIsUsedRequest {

    private String username;
    private Long nationalId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getNationalId() {
        return nationalId;
    }

    public void setNationalId(Long nationalId) {
        this.nationalId = nationalId;
    }
}
