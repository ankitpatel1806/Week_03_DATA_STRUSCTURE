package day01linkedlist.doublylinkedlist.librarymanagement;

public class Book {
    String title;
    String author;
    String genre;
    int bookID;
    boolean availabilityStatus;
    Book next;
    Book prev;

    public Book(String title, String author, String genre, int bookID, boolean availabilityStatus) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookID = bookID;
        this.availabilityStatus = availabilityStatus;
        this.next = null;
        this.prev = null;
    }
}
