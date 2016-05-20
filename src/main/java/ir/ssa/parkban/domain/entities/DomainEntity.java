package ir.ssa.parkban.domain.entities;

import ir.ssa.parkban.vertical.springcontext.SpeakWithApplicationContext;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.Authentication;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Behrouz-ZD on 5/20/2016.
 */

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class DomainEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "base_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "created_by_user", nullable = false)
    @CreatedBy
    private String createdByUser;

    @Column(name = "creation_date", nullable = false)
    @CreatedDate
    private Date creationDate;

    @Column(name = "modified_by_user", nullable = false)
    @LastModifiedBy
    private String modifiedByUser;

    @Column(name = "modification_date")
    @LastModifiedDate
    private Date modificationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(String createdByUser) {
        this.createdByUser = createdByUser;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getModifiedByUser() {
        return modifiedByUser;
    }

    public void setModifiedByUser(String modifiedByUser) {
        this.modifiedByUser = modifiedByUser;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }


   /* @PrePersist
    public void prePersist() {
        String createdByUser = SpeakWithApplicationContext.getCurrentAuthenticatedUserName();
        this.createdByUser = createdByUser;
        this.modifiedByUser = createdByUser;
    }

    @PreUpdate
    public void preUpdate() {
        String modifiedByUser = SpeakWithApplicationContext.getCurrentAuthenticatedUserName();
        this.modifiedByUser = modifiedByUser;
    }*/

}
