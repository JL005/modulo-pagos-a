package co.udea.sitas.mapper;

import co.udea.sitas.dto.CardPaidDTO;
import co.udea.sitas.dto.PayCardDTO;
import co.udea.sitas.utils.CardMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CardMapperTest {

    @Test
    public void testInfoCard() {
        // Arrange
        PayCardDTO payCardDTO = new PayCardDTO();
        payCardDTO.setCardNumber("1234567890123456");
        payCardDTO.setCardHolderName("John Doe");
        double amount = 100.0;
        String cardType = "Credit";
        // Act
        CardPaidDTO cardPaidDTO = CardMapper.infoCard(payCardDTO, amount, cardType);
        // Assert
        assertEquals(payCardDTO.getCardNumber(), cardPaidDTO.getCardNumber());
        assertEquals(payCardDTO.getCardHolderName(), cardPaidDTO.getName());
        assertEquals(amount, cardPaidDTO.getAmount());
        assertEquals(cardType, cardPaidDTO.getCardType());
    }
}