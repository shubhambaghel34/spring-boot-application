package com.eazybytes.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter @ToString
public class BaseEntity {

 @CreatedDate
 @Column(updatable = false)
 private String createdAt;

 @CreatedBy
 @Column(updatable = false)
 private String createdBy;

 @LastModifiedDate
 @Column(insertable = false)
 private String updatedAt;

 @LastModifiedBy
 @Column(insertable = false)
 private  String updatedBy;

}
