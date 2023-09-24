package com.example.ElevateMart.controller;

import com.example.ElevateMart.Enum.ProductCatagory;
import com.example.ElevateMart.dto.reponse.ProductResponse;
import com.example.ElevateMart.dto.request.ProductRequest;
import com.example.ElevateMart.exception.SellerNotFoundException;
import com.example.ElevateMart.model.Product;
import com.example.ElevateMart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("/add")
   public ResponseEntity addProduct( @RequestBody ProductRequest productRequest){
       try {
           ProductResponse productResponse = productService.addProduct(productRequest);
           return new ResponseEntity(productResponse , HttpStatus.CREATED);
       } catch(SellerNotFoundException e){
           return new ResponseEntity<>(e.getMessage() , HttpStatus.BAD_REQUEST);
       }

   }
   @GetMapping("/get_product_by_category_and_price_greater_than")
   public  ResponseEntity getProductByCategoryAndPriceGreaterThan(@RequestParam("price") int price , @RequestParam("catagory")  ProductCatagory catagory){
       List<ProductResponse>products =  productService.getProductByCategoryAndPriceGreaterThan(price , catagory);
       return new ResponseEntity(products , HttpStatus.ACCEPTED);
   }
}
