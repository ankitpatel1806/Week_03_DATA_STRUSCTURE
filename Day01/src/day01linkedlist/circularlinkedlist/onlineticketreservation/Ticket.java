package day01linkedlist.circularlinkedlist.onlineticketreservation;

import java.time.LocalDateTime;

public class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    LocalDateTime bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, LocalDateTime bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}
