package com.example.ElevateMart.transfer;

import com.example.ElevateMart.dto.reponse.CartResponse;
import com.example.ElevateMart.dto.reponse.ItemResponse;
import com.example.ElevateMart.model.Cart;
import com.example.ElevateMart.model.Item;

import java.util.ArrayList;
import java.util.List;

public class CartTransfer {
    public  static CartResponse cartToCartResponse(Cart cart){
        List<ItemResponse> itemResponsesToList = new ArrayList<>();
        for(Item item : cart.getItems()){
            itemResponsesToList.add(ItemTransfer.itemToItemResponse(item));
        }
 return CartResponse.builder().cartTotal(cart.getCartTotal())
         .itemResponses(itemResponsesToList)
         .customerName(cart.getCustomer().getName())
         .build();

    }
}
