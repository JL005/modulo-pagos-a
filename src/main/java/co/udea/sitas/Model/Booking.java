package co.udea.sitas.Model;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


public class Booking {
    private int bookingId;
    private int passengerId;
    private int flightId;
    private String bookingDate;
    private double basePrice;
    private double tax;
    private double totalPrice;

    public Booking() {
    }

    public Booking(int bookingId, int passengerId, int flightId, String bookingDate, double basePrice, double tax, double totalPrice) {
        this.bookingId = bookingId;
        this.passengerId = passengerId;
        this.flightId = flightId;
        this.bookingDate = bookingDate;
        this.basePrice = basePrice;
        this.tax = tax;
        this.totalPrice = totalPrice;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
