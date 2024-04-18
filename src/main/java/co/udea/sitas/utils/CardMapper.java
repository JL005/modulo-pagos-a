package co.udea.sitas.utils;

import co.udea.sitas.dto.CardPaidDTO;
import co.udea.sitas.dto.PayCardDTO;

public class CardMapper {

    public static CardPaidDTO infoCard(PayCardDTO savingsCardDTO, double amount, String cardType) {
        return CardPaidDTO.builder()
                .cardNumber(savingsCardDTO.getCardNumber())
                .name(savingsCardDTO.getCardHolderName())
                .amount(amount)
                .cardType(cardType)
                .build();
    }


}
