package com.eazybytes.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter @Setter @ToString
public class BaseEntity {

 @Column(updatable = false)
 private String createdAt;

 @Column(updatable = false)
 private String createdBy;

 @Column(insertable = false)
 private String updatedAt;

 @Column(insertable = false)
 private  String updatedBy;

}
