package com.example.ElevateMart.service;

import com.example.ElevateMart.dto.reponse.CardResponse;
import com.example.ElevateMart.dto.request.CardRequest;
import com.example.ElevateMart.exception.CustomerNotFoundException;
import com.example.ElevateMart.model.Card;
import com.example.ElevateMart.model.Customer;
import com.example.ElevateMart.repository.CustomerRepository;
import com.example.ElevateMart.transfer.CardTransefer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    @Autowired
    CustomerRepository customerRepository;

    public CardResponse addCard(CardRequest cardRequest) {
        Customer customer = customerRepository.findByEmailId(cardRequest.getCustomerEmail());
        if(customer==null){
            throw new CustomerNotFoundException("Please Enter Your Correct  EmailId");
        }

// Request DTo -> Entity
        Card card = CardTransefer.cardRequestToCard(cardRequest);
        int cvvNo = Integer.parseInt(cardRequest.getCvv());
        card.setCvv(cvvNo);
        card.setCustomer(customer);
//        card.setCVV(cardRequest.getCVV());
//        System.out.println(cardRequest.getCVV());
        customer.getCard().add(card);
       Customer savedCustomer = customerRepository.save(customer);
        List<Card>cards = savedCustomer.getCard();
        Card latestCard = cards.get(cards.size()-1);
//        System.out.println(latestCard.getCVV());
//        card -> cardResponseDto
        CardResponse cardResponse = CardTransefer.cardToCardResponse(latestCard);
//        masking the  card no
        cardResponse.setCardNo(genrateMaskedCard(latestCard.getCardNo()));
        return cardResponse;

    }
    public String genrateMaskedCard(String cardNo){
        int cardLength = cardNo.length();
        String maskedCard = "";
        for (int i = 0; i < cardLength-4; i++) {
            maskedCard += "x";
        }
        maskedCard +=cardNo.substring(cardLength-4);
        return maskedCard;
    }
}
