package com.eazybytes.accounts.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AccountDto {

    private Long accountNumber;


    private String accountType;


    private String branchAddress;


}
