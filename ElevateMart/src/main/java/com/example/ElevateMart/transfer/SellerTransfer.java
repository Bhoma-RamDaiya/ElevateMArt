package com.example.ElevateMart.transfer;

import com.example.ElevateMart.dto.reponse.SellerResponse;
import com.example.ElevateMart.dto.request.SellerRequest;
import com.example.ElevateMart.model.Customer;
import com.example.ElevateMart.model.Seller;

public class SellerTransfer {
    public static Seller sellerRequestDtoToSeller(SellerRequest sellerRequest){
//        return Seller.builder().name(sellerRequest.getName()).gender(sellerRequest.getGender())
//                .mobNo(sellerRequest.getMobNo()).emailId(sellerRequest.getEmailId())
//                .panNo(sellerRequest.getPanNo()).build();
        return Seller.builder()
                .name(sellerRequest.getName()).gender(sellerRequest.getGender())
                .emailId(sellerRequest.getEmailId()).mobNo(sellerRequest.getMobNo())
                .panNo(sellerRequest.getPanNo()).build();
    }
    public static SellerResponse sellerToSellerResponseDto(Seller seller){
        return SellerResponse.builder().name(seller.getName()).panNo(seller.getPanNo()).emailId(seller.getEmailId())
                .gender(seller.getGender()).mobNo(seller.getMobNo()).build();
    }
}
