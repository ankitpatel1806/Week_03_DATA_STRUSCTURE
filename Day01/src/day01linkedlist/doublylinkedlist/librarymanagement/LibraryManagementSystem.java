package day01linkedlist.doublylinkedlist.librarymanagement;

public class LibraryManagementSystem {
    Book head;
    Book tail;

    public LibraryManagementSystem() {
        this.head = null;
        this.tail = null;
    }

    public void addBookAtBeginning(String title, String author, String genre, int bookID, boolean availabilityStatus) {
        Book newBook = new Book(title, author, genre, bookID, availabilityStatus);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    public void addBookAtEnd(String title, String author, String genre, int bookID, boolean availabilityStatus) {
        Book newBook = new Book(title, author, genre, bookID, availabilityStatus);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    public void addBookAtPosition(String title, String author, String genre, int bookID, boolean availabilityStatus, int position) {
        Book newBook = new Book(title, author, genre, bookID, availabilityStatus);
        if (position == 0) {
            addBookAtBeginning(title, author, genre, bookID, availabilityStatus);
            return;
        }
        Book temp = head;
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            addBookAtEnd(title, author, genre, bookID, availabilityStatus);
        } else {
            newBook.next = temp.next;
            if (temp.next != null) {
                temp.next.prev = newBook;
            }
            temp.next = newBook;
            newBook.prev = temp;
        }
    }

    public void removeBookByID(int bookID) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookID == bookID) {
                if (temp == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else if (temp == tail) {
                    tail = tail.prev;
                    if (tail != null) {
                        tail.next = null;
                    }
                } else {
                    temp.prev.next = temp.next;
                    if (temp.next != null) {
                        temp.next.prev = temp.prev;
                    }
                }
                return;
            }
            temp = temp.next;
        }
    }

    public Book searchBookByTitle(String title) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public Book searchBookByAuthor(String author) {
        Book temp = head;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void updateBookAvailability(int bookID, boolean availabilityStatus) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookID == bookID) {
                temp.availabilityStatus = availabilityStatus;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    public void displayAllBooksForward() {
        Book temp = head;
        if (temp == null) {
            System.out.println("No books found.");
            return;
        }
        while (temp != null) {
            System.out.println("Book Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Book ID: " + temp.bookID + ", Availability: " + (temp.availabilityStatus ? "Available" : "Not Available"));
            temp = temp.next;
        }
    }

    public void displayAllBooksReverse() {
        Book temp = tail;
        if (temp == null) {
            System.out.println("No books found.");
            return;
        }
        while (temp != null) {
            System.out.println("Book Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Book ID: " + temp.bookID + ", Availability: " + (temp.availabilityStatus ? "Available" : "Not Available"));
            temp = temp.prev;
        }
    }

    public int countTotalBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        library.addBookAtBeginning("The Catcher in the Rye", "J.D. Salinger", "Fiction", 1, true);
        library.addBookAtEnd("To Kill a Mockingbird", "Harper Lee", "Fiction", 2, true);
        library.addBookAtEnd("1984", "George Orwell", "Dystopian", 3, false);
        library.addBookAtBeginning("Moby-Dick", "Herman Melville", "Adventure", 4, true);

        System.out.println("Books in forward order:");
        library.displayAllBooksForward();

        System.out.println("\nBooks in reverse order:");
        library.displayAllBooksReverse();

        Book book = library.searchBookByTitle("1984");
        if (book != null) {
            System.out.println("\nFound book by title '1984': " + book.title);
        } else {
            System.out.println("\nBook with title '1984' not found.");
        }

        book = library.searchBookByAuthor("Harper Lee");
        if (book != null) {
            System.out.println("\nFound book by author 'Harper Lee': " + book.title);
        } else {
            System.out.println("\nBook by author 'Harper Lee' not found.");
        }

        library.updateBookAvailability(3, true);
        System.out.println("\nAfter updating availability:");
        library.displayAllBooksForward();

        library.removeBookByID(2);
        System.out.println("\nAfter removing book with ID 2:");
        library.displayAllBooksForward();

        System.out.println("\nTotal number of books in the library: " + library.countTotalBooks());
    }
}
