package co.udea.sitas.service;

import co.udea.sitas.dto.CardPaidDTO;
import co.udea.sitas.dto.PayCardDTO;
import co.udea.sitas.model.Booking;
import co.udea.sitas.utils.CardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final BookingService bookingService;
    private final PaymentMethodService paymentMethodService;

    public CardPaidDTO payBookingWithCard(PayCardDTO paySavingsCard) {
        String cardType = this.validateCard(paySavingsCard);
        if(cardType == null){
            // TODO: ARROJAR ERROR DE TARJETA NO VÁLIDA O NO SOPORTADA
            return null;
        }
        Booking booking = this.bookingService.paidBooking(paySavingsCard.getBookingId());
        return CardMapper.infoCard(paySavingsCard, booking.getTotalPrice(), cardType);
    }

    public String validateCard(PayCardDTO payCreditCard) {
        String cardNumber = payCreditCard.getCardNumber();
        if (isVISA(cardNumber)) {
            return "VISA";
        } else if (isMastercard(cardNumber)) {
            return "Mastercard";
        } else if (isAmericanExpress(cardNumber)) {
            return "American Express";
        } else {
            return null;
        }
    }

    public static boolean isVISA(String cardNumber) {
        Pattern pattern = Pattern.compile("^4[0-9]{12}(?:[0-9]{3})?$");
        Matcher matcher = pattern.matcher(cardNumber);
        return matcher.matches();
    }

    public static boolean isMastercard(String cardNumber) {
        Matcher matcher = Pattern.compile("^5[1-5][0-9]{14}$").matcher(cardNumber);
        return matcher.matches();
    }

    public static boolean isAmericanExpress(String cardNumber) {
        Matcher matcher = Pattern.compile("^3[47][0-9]{13}$").matcher(cardNumber);
        return matcher.matches();
    }
}
