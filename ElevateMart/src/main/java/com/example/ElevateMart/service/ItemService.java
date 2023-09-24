package com.example.ElevateMart.service;

import com.example.ElevateMart.dto.reponse.CartResponse;
import com.example.ElevateMart.dto.request.ItemRequest;
import com.example.ElevateMart.exception.CustomerNotFoundException;
import com.example.ElevateMart.exception.InsufficientproductQuantityException;
import com.example.ElevateMart.exception.ProductNotFoundException;
import com.example.ElevateMart.model.Customer;
import com.example.ElevateMart.model.Item;
import com.example.ElevateMart.model.Product;
import com.example.ElevateMart.repository.CustomerRepository;
import com.example.ElevateMart.repository.ProductRepository;
import com.example.ElevateMart.transfer.ItemTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    public Item addCart(ItemRequest itemRequest) {
        Customer customer = customerRepository.findByEmailId(itemRequest.getCustomerEmail());
//        check customer is valid
        if(customer==null){
            throw new CustomerNotFoundException("customer does not found");
        }

        Optional<Product> optionalProduct = productRepository.findById(itemRequest.getProductId());
//        check product is not prsent
        if (optionalProduct.isEmpty()){
            throw new ProductNotFoundException("product is not avilable");
        }
        Product product = optionalProduct.get();
//        check for the Required Quantity
        if(product.getAvilavbleQuantity()<itemRequest.getRequiredQuantity()){
            throw new InsufficientproductQuantityException("Sorry Required Quantity is Not avilable");
        }
//
        Item item = ItemTransfer.requiredQuantiyToItem(itemRequest.getRequiredQuantity());
        item.setProduct(product);
        return  item;
    }
}
