package co.udea.sitas.service;

import co.udea.sitas.dto.CardPaidDTO;
import co.udea.sitas.dto.PayCardDTO;
import co.udea.sitas.dto.PaypalDTO;
import co.udea.sitas.model.Booking;
import co.udea.sitas.model.PaypalAccount;
import co.udea.sitas.repository.PaypalAccountRepository;
import co.udea.sitas.utils.CardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final BookingService bookingService;
    private final PaymentMethodService paymentMethodService;
    private final PaypalAccountRepository paypalAccountRepository;

    public CardPaidDTO payBookingWithCard(PayCardDTO paySavingsCard) throws SQLDataException {
        String cardType = this.validateCard(paySavingsCard);
        if(cardType == null){

            return null;
        }
        Booking booking = this.bookingService.paidBooking(paySavingsCard.getBookingId());
        return CardMapper.infoCard(paySavingsCard, booking.getTotalPrice(), cardType);
    }

    private static final Map<String, Predicate<String>> cardValidators = new HashMap<>();

    static {
        cardValidators.put("VISA", cardNumber -> cardNumber.matches("^4\\d{12}(?:\\d{3})?$"));
        cardValidators.put("Mastercard", cardNumber -> cardNumber.matches("^5[1-5]\\d{14}$"));
        cardValidators.put("American Express", cardNumber -> cardNumber.matches("^3[47]\\d{13}$"));
    }

    public String validateCard(PayCardDTO payCreditCard) {
        String cardNumber = payCreditCard.getCardNumber();
        for (Map.Entry<String, Predicate<String>> entry : cardValidators.entrySet()) {
            if (entry.getValue().test(cardNumber)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static boolean isVISA(String cardNumber) {
        Pattern pattern = Pattern.compile("^4\\d{12}(?:\\d{3})?$");
        Matcher matcher = pattern.matcher(cardNumber);
        return matcher.matches();
    }

    public static boolean isMastercard(String cardNumber) {
        Matcher matcher = Pattern.compile("^5[1-5]\\d{14}$").matcher(cardNumber);
        return matcher.matches();
    }

    public static boolean isAmericanExpress(String cardNumber) {
        Matcher matcher = Pattern.compile("^3[47]\\d{13}$").matcher(cardNumber);
        return matcher.matches();
    }

    public boolean payPalPayment(PaypalDTO paypalDTO) throws SQLDataException {
        PaypalAccount account = this.paypalAccountRepository.findByEmail(paypalDTO.getEmail());
        if (account != null && account.getPassword().equals(paypalDTO.getPassword())){
            this.bookingService.paidBooking(paypalDTO.getBookingId());
            return true;
        }
        return false;

    }
}
