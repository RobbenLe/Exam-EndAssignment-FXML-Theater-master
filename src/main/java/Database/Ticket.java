package Database;
import java.io.Serializable;
import java.util.List;

import java.time.LocalDateTime;

public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDateTime purchaseTime;
    private int numberOfTickets;
    private String customerName;
    private String filmTitle;
    private LocalDateTime showingTime;
    private List<Integer> bookedSeats;

    public Ticket(LocalDateTime purchaseTime, int numberOfTickets, String customerName, String filmTitle, LocalDateTime showingTime, List<Integer> bookedSeats) {
        this.purchaseTime = purchaseTime;
        this.numberOfTickets = numberOfTickets;
        this.customerName = customerName;
        this.filmTitle = filmTitle;
        this.showingTime = showingTime;
        this.bookedSeats = bookedSeats;
    }

    // Getter methods
    public LocalDateTime getPurchaseTime() {
        return purchaseTime;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public LocalDateTime getShowingTime() {
        return showingTime;
    }
    public List<Integer> getBookedSeats() {  // Getter for the booked seats
        return bookedSeats;
    }
}
