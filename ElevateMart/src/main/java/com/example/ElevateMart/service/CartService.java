package com.example.ElevateMart.service;

import com.example.ElevateMart.dto.reponse.CartResponse;
import com.example.ElevateMart.dto.request.ItemRequest;
import com.example.ElevateMart.model.Cart;
import com.example.ElevateMart.model.Customer;
import com.example.ElevateMart.model.Item;
import com.example.ElevateMart.model.Product;
import com.example.ElevateMart.repository.CartRepository;
import com.example.ElevateMart.repository.CustomerRepository;
import com.example.ElevateMart.repository.ItemRepository;
import com.example.ElevateMart.repository.ProductRepository;
import com.example.ElevateMart.transfer.CartTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
@Autowired
    CustomerRepository customerRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductRepository productRepository;
    public CartResponse addCart(ItemRequest itemRequest,Item item) {
        Customer customer = customerRepository.findByEmailId(itemRequest.getCustomerEmail());
        Product product = item.getProduct();
        Cart cart = customer.getCart();
        cart.setCartTotal(cart.getCartTotal()+itemRequest.getRequiredQuantity()*product.getPrice());

        item.setCart(cart);
        item.setProduct(product);

        Item  savedItem = itemRepository.save(item);//to avoid save duplicacy

        cart.getItems().add(savedItem);

        product.getItems().add(savedItem);
        Cart savedCart= cartRepository.save(cart);
        productRepository.save(product);

//        prepare ResponseDto
        return CartTransfer.cartToCartResponse(savedCart);

    }
}
