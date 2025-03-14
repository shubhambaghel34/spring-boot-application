package com.eazybytes.accounts.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Customer extends  BaseEntity {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name="customer_id")
 private Long customerId;

 @Column(name="name")
 private String name;

 @Column(name = "email")
 private String email;

 @Column(name="mobile_number")
 private String mobileNumber;


//     `customer_id` int AUTO_INCREMENT  PRIMARY KEY,
//  `name` varchar(100) NOT NULL,
//  `email` varchar(100) NOT NULL,
//  `mobile_number` varchar(20) NOT NULL,
}
