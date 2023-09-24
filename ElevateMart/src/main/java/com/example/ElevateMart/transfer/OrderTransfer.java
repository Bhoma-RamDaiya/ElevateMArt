package com.example.ElevateMart.transfer;

import com.example.ElevateMart.dto.reponse.CartResponse;
import com.example.ElevateMart.dto.reponse.ItemResponse;
import com.example.ElevateMart.dto.reponse.OrderResponse;
import com.example.ElevateMart.dto.request.OrderRequest;
import com.example.ElevateMart.model.Cart;
import com.example.ElevateMart.model.Item;
import com.example.ElevateMart.model.OrderEntity;
import com.example.ElevateMart.model.Product;
import com.example.ElevateMart.service.CardService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderTransfer {
    public static OrderEntity orderRequestDtoToOrderEntity(OrderRequest orderRequest , Product product){
        return OrderEntity.builder().totalOrder(orderRequest.getRequiredQuantity()*product.getPrice())
                .orderId(String.valueOf(UUID.randomUUID()))
                .build();
    }



    public static OrderResponse orderToOrderResponse(OrderEntity order) {
        List<ItemResponse> itemResponsesToList = new ArrayList<>();
        for(Item item : order.getItems()){
            itemResponsesToList.add(ItemTransfer.itemToItemResponse(item));
        }
        return OrderResponse.builder().orderDate(order.getOrderDate()).orderId(order.getOrderId())
                .cardUsed(order.getCardUsed()).orderTotal(order.getTotalOrder())
                .customerName(order.getCustomer().getName())
                .item(itemResponsesToList)
                .build();
    }
}
