package com.example.ElevateMart.service;

import com.example.ElevateMart.dto.reponse.CustomerResponse;
import com.example.ElevateMart.dto.request.CustomerRequest;
import com.example.ElevateMart.model.Cart;
import com.example.ElevateMart.model.Customer;
import com.example.ElevateMart.repository.CustomerRepository;
import com.example.ElevateMart.transfer.CustomerTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class customerService {
    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
//        dto -> entity
//        Customer customer = new Customer();
//        customer.setName(customerRequest.getName());
//        customer.setEmailId(customerRequest.getEmailId());
//        customer.setGender(customerRequest.getGender());
//        customer.setMobileNo(customerRequest.getMobNo());
//        customer.setAdress(customerRequest.getAddress());
        //using builder dto-> entity
        Customer customer= CustomerTransfer.customerRequestdtotoCustomer(customerRequest);

        Cart cart = new Cart();
        cart.setCustomer(customer);
        cart.setCartTotal(0);
        customer.setCart(cart);
       Customer savedCustomer = customerRepository.save(customer);
        CustomerResponse customerResponse = CustomerTransfer.customerToCustomerResponse(savedCustomer);
        return customerResponse;

    }
}
