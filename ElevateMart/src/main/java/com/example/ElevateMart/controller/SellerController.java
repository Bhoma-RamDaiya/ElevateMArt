package com.example.ElevateMart.controller;

import com.example.ElevateMart.dto.reponse.SellerResponse;
import com.example.ElevateMart.dto.request.SellerRequest;
import com.example.ElevateMart.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
public class SellerController {
    @Autowired
    SellerService sellerService;
    @PostMapping("/add")
    public ResponseEntity addSeller(@RequestBody SellerRequest sellerRequest){
        System.out.println(sellerRequest.getName());
        SellerResponse sellerResponse = sellerService.addSeller(sellerRequest);
        return new ResponseEntity(sellerResponse , HttpStatus.CREATED);
    }
}
