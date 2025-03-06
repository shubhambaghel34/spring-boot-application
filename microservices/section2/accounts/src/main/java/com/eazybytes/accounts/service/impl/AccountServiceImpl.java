package com.eazybytes.accounts.service.impl;

import com.eazybytes.accounts.constants.AccountsConstants;
import com.eazybytes.accounts.dto.CustomerDto;
import com.eazybytes.accounts.entity.Accounts;
import com.eazybytes.accounts.entity.Customer;
import com.eazybytes.accounts.exception.CustomerAlreadyExistsException;
import com.eazybytes.accounts.mapper.CustomerMapper;
import com.eazybytes.accounts.repository.AccountRepository;
import com.eazybytes.accounts.repository.CustomerRepository;
import com.eazybytes.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {


   private AccountRepository accountRepository;
    private CustomerRepository customerRepository;


    @Override
    public void createAccount(CustomerDto customerDto) {
      Customer customer = CustomerMapper.mapToCustomer(customerDto,new Customer());
      Optional<Customer> optionalCustomer =customerRepository.findByMobileNumber(customerDto.getMobileNumber());
      if(optionalCustomer.isPresent()){
          throw  new CustomerAlreadyExistsException("Customer is already registered with given mobile number" +customerDto.getMobileNumber());
      }
      customer.setCreatedAt(LocalDate.now().toString());
      customer.setCreatedBy("Anonymous User");

      Customer savedCustomer =customerRepository.save(customer);//this will return with id
      accountRepository.save(createNewAccount(savedCustomer)); //will send customer data to create Account
    }
    /**
     * @param customer - Customer Object
     * @return the new account details
     */
    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDate.now().toString());
        newAccount.setCreatedBy("Anonymous User");
        return newAccount;
    }

}
