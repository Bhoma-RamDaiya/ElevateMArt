package com.example.ElevateMart.controller;

import com.example.ElevateMart.dto.reponse.CardResponse;
import com.example.ElevateMart.dto.request.CardRequest;
import com.example.ElevateMart.exception.CustomerNotFoundException;
import com.example.ElevateMart.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    CardService cardService;

    @PostMapping("/add")
    public ResponseEntity addCard(@RequestBody CardRequest cardRequest){
      try {
          System.out.println(cardRequest.getCvv());
            CardResponse cardResponse = cardService.addCard(cardRequest);
            return  new ResponseEntity<>(cardResponse , HttpStatus.FOUND);
        }
          catch(CustomerNotFoundException e) {
          return new ResponseEntity<>(e.getMessage() , HttpStatus.NOT_FOUND);
       }
    }

}
