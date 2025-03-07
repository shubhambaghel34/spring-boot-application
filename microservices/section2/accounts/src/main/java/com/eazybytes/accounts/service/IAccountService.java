package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDto;

public interface IAccountService {

    void createAccount(CustomerDto customerdto);

    CustomerDto fetchAccount(String mobileNumber);


}
