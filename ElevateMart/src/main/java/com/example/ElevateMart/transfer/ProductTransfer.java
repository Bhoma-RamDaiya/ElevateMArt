package com.example.ElevateMart.transfer;

import com.example.ElevateMart.Enum.ProductStatus;
import com.example.ElevateMart.dto.reponse.ProductResponse;
import com.example.ElevateMart.dto.request.ProductRequest;
import com.example.ElevateMart.model.Product;

public class ProductTransfer {
    public  static Product productRequestToProduct(ProductRequest productRequest){
        return Product.builder().productName(productRequest.getProductName())
                .price(productRequest.getPrice()).catagory(productRequest.getCatagory())
                .avilavbleQuantity(productRequest.getAvilavbleQuantity())
                .productStatus(ProductStatus.AVILABLE).build();
    }
    public static ProductResponse productToProductResponse(Product product){
        return ProductResponse.builder().productName(product.getProductName())
                .sellerName(product.getSeller().getName()).productStatus(product.getProductStatus())
                .avilavbleQuantity(product.getAvilavbleQuantity()).price(product.getPrice())
                .catagory(product.getCatagory())
                .build();
    }
}
