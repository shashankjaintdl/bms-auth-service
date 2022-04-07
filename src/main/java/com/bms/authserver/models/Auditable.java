package com.bms.authserver.models;



import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

import javax.persistence.*;


@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class Auditable <T>{

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @CreatedBy
    @Column(length = 25)
    private T createdBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @LastModifiedBy
    @Column(length = 25)
    private T updatedBy;
    
}

