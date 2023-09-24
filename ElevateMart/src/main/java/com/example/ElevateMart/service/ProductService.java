package com.example.ElevateMart.service;

import com.example.ElevateMart.Enum.ProductCatagory;
import com.example.ElevateMart.dto.reponse.ProductResponse;
import com.example.ElevateMart.dto.request.ProductRequest;
import com.example.ElevateMart.exception.SellerNotFoundException;
import com.example.ElevateMart.model.Product;
import com.example.ElevateMart.model.Seller;
import com.example.ElevateMart.repository.ProductRepository;
import com.example.ElevateMart.repository.SellerRepository;
import com.example.ElevateMart.transfer.ProductTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
@Autowired
    SellerRepository sellerRepository;
@Autowired
    ProductRepository productRepository;

    public  ProductResponse addProduct(ProductRequest productRequest){

        Seller seller = sellerRepository.findByEmailId(productRequest.getSellerEmail());
        if(seller== null){
            throw new SellerNotFoundException("Sellor Doesn't Exist");
        }

//        requestDto-> entity
        Product product = ProductTransfer.productRequestToProduct(productRequest);
//        sellelist set
        product.setSeller(seller);
        seller.getProducts().add(product);


        Seller savedSeller = sellerRepository.save(seller); //save both seller and product;
        List<Product>products = savedSeller.getProducts();
        Product latestProduct = products.get(products.size()-1);

//        prepareResponseDto
        return ProductTransfer.productToProductResponse(latestProduct);

    }

    public List<ProductResponse> getProductByCategoryAndPriceGreaterThan(int price, ProductCatagory catagory) {
        List<Product>productList = productRepository.getProductByCategoryAndPriceGreaterThan(price , catagory);
        List<ProductResponse> productResponses = new ArrayList<>();
      for(Product product:productList){
          productResponses.add(ProductTransfer.productToProductResponse(product));
      }
      return productResponses;
    }
}
