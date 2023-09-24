package com.example.ElevateMart.service;

import com.example.ElevateMart.Enum.ProductStatus;
import com.example.ElevateMart.dto.reponse.OrderResponse;
import com.example.ElevateMart.dto.request.OrderRequest;
import com.example.ElevateMart.exception.CustomerNotFoundException;
import com.example.ElevateMart.exception.InsufficientproductQuantityException;
import com.example.ElevateMart.exception.InvalidCardException;
import com.example.ElevateMart.exception.ProductNotFoundException;
import com.example.ElevateMart.model.*;
import com.example.ElevateMart.repository.CardRepository;
import com.example.ElevateMart.repository.CustomerRepository;
import com.example.ElevateMart.repository.OrderRepository;
import com.example.ElevateMart.repository.ProductRepository;
import com.example.ElevateMart.transfer.ItemTransfer;
import com.example.ElevateMart.transfer.OrderTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CardRepository cardRepository;
    @Autowired
    CardService cardService;
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Customer customer = customerRepository.findByEmailId(orderRequest.getCustomerEmail());
        if (customer==null){
            throw  new CustomerNotFoundException("Enter your valid EmailId");
        }
        Optional<Product> optionalProduct = productRepository.findById(orderRequest.getProductId());
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product is out of Stock");
        }
        Card card = cardRepository.findByCardNo(orderRequest.getCardUsed());
        Date todayDate = new Date();
        if(card==null || card.getCvv()!=orderRequest.getCvv() || card.getValidTill().before(todayDate)){
            throw new InvalidCardException("Invalid card");
        }
        Product product = optionalProduct.get();
        if(product.getAvilavbleQuantity()<orderRequest.getRequiredQuantity()){
            throw new InsufficientproductQuantityException("Insufficient Quantity Avilable");
        }

        int newQuantity = product.getAvilavbleQuantity()-orderRequest.getRequiredQuantity();
        if(newQuantity==0){
            product.setProductStatus(ProductStatus.OUT_OF_STOCS);
        }

// entity involved product orderentity item product

//        prepare orderEntity
        //        set order id and total order as well in transfer function
        OrderEntity orderEntity = OrderTransfer.orderRequestDtoToOrderEntity(orderRequest , product);
// card used
        orderEntity.setCardUsed(cardService.genrateMaskedCard(orderRequest.getCardUsed()));
        Item item = ItemTransfer.requiredQuantiyToItem(orderRequest.getRequiredQuantity());

        item.setOrders(orderEntity);
        item.setProduct(product);

        orderEntity.setCustomer(customer);
//        orderEntity.getItems().add(item);
//        orderEntity.addItem(item);
        orderEntity.setItems(List.of(item));
        System.out.println(orderEntity.getItems().get(0));


        OrderEntity savedOrder = orderRepository.save(orderEntity); // saved order and item is here

        product.getItems().add(savedOrder.getItems().get(0));
        customer.getOrders().add(savedOrder);

//        productRepository.save(product);
//        customerRepository.save(customer);

        return OrderTransfer.orderToOrderResponse(savedOrder);

    }
}
