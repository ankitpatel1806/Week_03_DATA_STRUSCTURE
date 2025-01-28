package day01linkedlist.circularlinkedlist.onlineticketreservation;

import java.time.LocalDateTime;

public class TicketReservationSystem {
    private Ticket head;  // The head of the circular list
    private Ticket tail;  // The tail of the circular list

    public TicketReservationSystem() {
        head = null;
        tail = null;
    }

    // Add a new ticket reservation at the end of the circular list
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, LocalDateTime bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            tail = newTicket;
            newTicket.next = head;  // Circular link (tail points back to head)
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head;  // Maintain the circular link
        }
        System.out.println("Ticket booked successfully for " + customerName + "!");
    }

    // Remove a ticket by Ticket ID
    public void removeTicketById(int ticketId) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Ticket current = head;
        Ticket previous = null;

        do {
            if (current.ticketId == ticketId) {
                if (previous == null) {
                    // If it's the first ticket
                    head = current.next;
                    tail.next = head;  // Maintain the circular link
                } else {
                    previous.next = current.next;
                    if (current == tail) {
                        tail = previous;  // Update tail if last ticket is removed
                    }
                }
                System.out.println("Ticket with ID " + ticketId + " removed.");
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        System.out.println("Ticket with ID " + ticketId + " not found.");
    }

    // Display all the current tickets in the list
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket current = head;
        do {
            System.out.println("Ticket ID: " + current.ticketId + ", Customer Name: " + current.customerName +
                    ", Movie Name: " + current.movieName + ", Seat: " + current.seatNumber +
                    ", Booking Time: " + current.bookingTime);
            current = current.next;
        } while (current != head);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String name) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket current = head;
        boolean found = false;
        do {
            if (current.customerName.equalsIgnoreCase(name) || current.movieName.equalsIgnoreCase(name)) {
                System.out.println("Found Ticket - ID: " + current.ticketId + ", Customer: " + current.customerName +
                        ", Movie: " + current.movieName + ", Seat: " + current.seatNumber +
                        ", Booking Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No ticket found for customer or movie: " + name);
        }
    }

    // Calculate the total number of booked tickets
    public int getTotalBookedTickets() {
        if (head == null) {
            return 0;
        }

        int count = 0;
        Ticket current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);

        return count;
    }

    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        // Adding some tickets
        system.addTicket(1, "Ankit Patel", "Avengers", "A1", LocalDateTime.now());
        system.addTicket(2, "Ankit kumar", "Batman", "B2", LocalDateTime.now());
        system.addTicket(3, "Anand Soni", "Avengers", "C3", LocalDateTime.now());

        // Displaying all tickets
        System.out.println("\nAll Booked Tickets:");
        system.displayTickets();

        // Searching for a ticket by customer name
        System.out.println("\nSearching for tickets by customer 'Ankit Patel':");
        system.searchTicket("Ankit Patel");

        // Searching for a ticket by movie name
        System.out.println("\nSearching for tickets by movie 'Avengers':");
        system.searchTicket("Avengers");

        // Removing a ticket by ID
        System.out.println("\nRemoving ticket with ID 2:");
        system.removeTicketById(2);

        // Displaying all tickets after removal
        System.out.println("\nAll Booked Tickets after removal:");
        system.displayTickets();

        // Display total number of booked tickets
        System.out.println("\nTotal Booked Tickets: " + system.getTotalBookedTickets());
    }
}
