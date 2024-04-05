package co.udea.sitas.Model.PaymentMethod;

public class CreditCard {
    private String cardNumber;
    private String cardHolderName;
    private String expirationDate;
    private int cvv;
    private int installments;
    private String phone;
    private int idNumber;

    public CreditCard() {
    }

    public CreditCard(String cardNumber, String cardHolderName, String expirationDate, int cvv, int installments, String phone, int idNumber) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.installments = installments;
        this.phone = phone;
        this.idNumber = idNumber;
    }

    // Getters y Setters

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getInstallments() {
        return installments;
    }

    public void setInstallments(int installments) {
        this.installments = installments;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }
}
