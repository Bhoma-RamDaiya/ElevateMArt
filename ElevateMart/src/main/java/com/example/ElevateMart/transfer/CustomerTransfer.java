package com.example.ElevateMart.transfer;

import com.example.ElevateMart.dto.reponse.CustomerResponse;
import com.example.ElevateMart.dto.request.CustomerRequest;
import com.example.ElevateMart.model.Customer;
import lombok.experimental.UtilityClass;

//    @UtilityClass // for ensuring class is not instantieated but not a standard practice to write
public class CustomerTransfer {
    public  static Customer customerRequestdtotoCustomer(CustomerRequest customerRequest){
        return Customer.builder().name(customerRequest.getName()).gender(customerRequest.getGender())
                .emailId(customerRequest.getEmailId()).mobileNo(customerRequest.getMobNo())
                .Adress(customerRequest.getAddress()).build();
    }
    public  static CustomerResponse customerToCustomerResponse(Customer customer){
        return  CustomerResponse.builder().name(customer.getName())
                .emailId(customer.getEmailId()).gender(customer.getGender())
                .mobNo(customer.getMobileNo())
                .build();
    }
}
