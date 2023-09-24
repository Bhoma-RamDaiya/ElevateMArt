package com.example.ElevateMart.transfer;

import com.example.ElevateMart.dto.reponse.CardResponse;
import com.example.ElevateMart.dto.request.CardRequest;
import com.example.ElevateMart.model.Card;

public class CardTransefer {
    public static Card cardRequestToCard(CardRequest cardRequest){
        return Card.builder().cardNo(cardRequest.getCardNo()).cardType(cardRequest.getCardType())
                .validTill(cardRequest.getValidTill())
                .build();
    }
    public static CardResponse cardToCardResponse(Card card){
        return CardResponse.builder().cardType(card.getCardType())
                .customerName(card.getCustomer().getName()).validTill(card.getValidTill())
                .build();
    }
}
