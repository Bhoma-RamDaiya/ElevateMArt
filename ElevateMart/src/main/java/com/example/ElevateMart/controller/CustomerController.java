package com.example.ElevateMart.controller;

import com.example.ElevateMart.dto.reponse.CustomerResponse;
import com.example.ElevateMart.dto.request.CustomerRequest;
import com.example.ElevateMart.service.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
  @Autowired
  customerService customerService;
  @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody CustomerRequest customerRequest){
      CustomerResponse customerResponse = customerService.addCustomer(customerRequest);
      return new ResponseEntity(customerResponse , HttpStatus.CREATED);
  }
}
