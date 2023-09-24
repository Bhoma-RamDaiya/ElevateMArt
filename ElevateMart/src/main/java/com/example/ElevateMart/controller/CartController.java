package com.example.ElevateMart.controller;

import com.example.ElevateMart.dto.reponse.CartResponse;
import com.example.ElevateMart.dto.request.ItemRequest;
import com.example.ElevateMart.model.Item;
import com.example.ElevateMart.service.CartService;
import com.example.ElevateMart.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;
    @Autowired
    ItemService itemService;
    @PostMapping("/add")
    public ResponseEntity addCart(@RequestBody ItemRequest itemRequest){
        try {
            Item item= itemService.addCart(itemRequest);
            CartResponse cartResponse = cartService.addCart(itemRequest,item);
            return new ResponseEntity<>(cartResponse , HttpStatus.CREATED);
        }
      catch (Exception e){
            return new ResponseEntity<>(e.getMessage() , HttpStatus.BAD_REQUEST);
      }

    }

}
