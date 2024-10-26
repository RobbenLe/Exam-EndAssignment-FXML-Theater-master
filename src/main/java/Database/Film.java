package Database;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Film implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDateTime start;
    private LocalDateTime end;
    private Movies movie;
    private int seats;  // Seats available
    private int totalSeats;  // Total number of seats
    private List<Integer> bookedSeats = new ArrayList<>();
    private boolean ageCheckRequired;

    public Film(LocalDateTime start, LocalDateTime end, Movies movie, int seats, int totalSeats,boolean ageCheckRequired) {
        this.start = start;
        this.end = end;
        this.movie = movie;
        this.seats = seats;  // Seats available
        this.totalSeats = totalSeats;
        this.bookedSeats = new ArrayList<>();
        this.ageCheckRequired = ageCheckRequired;
    }
    public boolean requiresAgeCheck() {
        return ageCheckRequired;
    }

    // Getters and Setters
    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public String getTitle() {
        return movie.getTitle();
    }

    public int getSeats() {
        return seats;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public List<Integer> getBookedSeats() {
        return bookedSeats;
    }

    // Method to book specific seats
    public void bookSeats(List<Integer> seatNumbers) throws IllegalArgumentException {
        for (int seatNumber : seatNumbers) {
            if (!bookedSeats.contains(seatNumber)) {
                bookedSeats.add(seatNumber);
                seats--;
            }
        }
    }

    public void purchaseTickets(List<Integer> seatNumbers) throws IllegalArgumentException {
        bookSeats(seatNumbers);  // Delegate to the bookSeats method
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public void setTitle(String title) {
        this.movie.setTitle(title);
    }

}
