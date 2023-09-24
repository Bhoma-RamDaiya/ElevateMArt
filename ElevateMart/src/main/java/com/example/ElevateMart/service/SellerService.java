package com.example.ElevateMart.service;

import com.example.ElevateMart.dto.reponse.SellerResponse;
import com.example.ElevateMart.dto.request.SellerRequest;
import com.example.ElevateMart.model.Seller;
import com.example.ElevateMart.repository.SellerRepository;
import com.example.ElevateMart.transfer.SellerTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SellerService {
    @Autowired
    SellerRepository sellerRepository;
    public SellerResponse addSeller(SellerRequest sellerRequest) {
        Seller seller = SellerTransfer.sellerRequestDtoToSeller(sellerRequest);

//normal dto to seller
//        System.out.println(sellerRequest.getName());
//        Seller seller = new Seller();
//        seller.setName(sellerRequest.getName());
//        seller.setEmailId(sellerRequest.getEmailId());
//        seller.setGender(sellerRequest.getGender());
//        seller.setPanNo(sellerRequest.getPanNo());
//        seller.setMobNo(sellerRequest.getMobNo());


     Seller savedseller = sellerRepository.save(seller);
//     seller to response dto
//    SellerResponse sellerResponse = new SellerResponse();
//    sellerResponse.setName(savedseller.getName());
//    sellerResponse.setGender(savedseller.getGender());
//    sellerResponse.setPanNo(savedseller.getPanNo());
//   sellerResponse.setMobNo(savedseller.getMobNo());

       return SellerTransfer.sellerToSellerResponseDto(savedseller);

    }
}
