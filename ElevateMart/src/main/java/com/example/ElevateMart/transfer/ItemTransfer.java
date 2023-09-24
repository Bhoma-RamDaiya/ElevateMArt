package com.example.ElevateMart.transfer;

import com.example.ElevateMart.dto.reponse.ItemResponse;
import com.example.ElevateMart.model.Item;

public class ItemTransfer {
    public static Item requiredQuantiyToItem(int requiredQuantity) {
        return Item.builder().requiredQuantity(requiredQuantity)
                .build();
    }

    public static ItemResponse itemToItemResponse(Item item){
        return ItemResponse.builder().itemName(item.getProduct().getProductName())
                .itemPrice(item.getProduct().getPrice()).productCatagory(item.getProduct().getCatagory())
                .quantityAdded(item.getRequiredQuantity())
                .build();
    }
}
