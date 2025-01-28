package day01linkedlist.doublylinkedlist.moviemanagement;

public class MovieManagementSystem {
    Movie head;
    Movie tail;

    public MovieManagementSystem() {
        this.head = null;
        this.tail = null;
    }

    public void addMovieAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    public void addMovieAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    public void addMovieAtPosition(String title, String director, int year, double rating, int position) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (position == 0) {
            addMovieAtBeginning(title, director, year, rating);
            return;
        }
        Movie temp = head;
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            addMovieAtEnd(title, director, year, rating);
        } else {
            newMovie.next = temp.next;
            if (temp.next != null) {
                temp.next.prev = newMovie;
            }
            temp.next = newMovie;
            newMovie.prev = temp;
        }
    }

    public void removeMovieByTitle(String title) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
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

    public Movie searchMovieByDirector(String director) {
        Movie temp = head;
        while (temp != null) {
            if (temp.director.equals(director)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public Movie searchMovieByRating(double rating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.rating == rating) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void displayAllMoviesForward() {
        Movie temp = head;
        if (temp == null) {
            System.out.println("No movies found.");
            return;
        }
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    public void displayAllMoviesReverse() {
        Movie temp = tail;
        if (temp == null) {
            System.out.println("No movies found.");
            return;
        }
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.prev;
        }
    }

    public void updateMovieRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                temp.rating = newRating;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    public static void main(String[] args) {
        MovieManagementSystem mms = new MovieManagementSystem();

        mms.addMovieAtBeginning("The Shawshank Redemption", "Frank Darabont", 1994, 9.3);
        mms.addMovieAtEnd("The Dark Knight", "Christopher Nolan", 2008, 9.0);
        mms.addMovieAtEnd("Inception", "Christopher Nolan", 2010, 8.8);
        mms.addMovieAtBeginning("Pulp Fiction", "Quentin Tarantino", 1994, 8.9);

        System.out.println("Movies in forward order:");
        mms.displayAllMoviesForward();

        System.out.println("\nMovies in reverse order:");
        mms.displayAllMoviesReverse();

        Movie movie = mms.searchMovieByDirector("Christopher Nolan");
        if (movie != null) {
            System.out.println("\nFound movie by Christopher Nolan: " + movie.title);
        } else {
            System.out.println("\nMovie by Christopher Nolan not found.");
        }

        movie = mms.searchMovieByRating(8.8);
        if (movie != null) {
            System.out.println("\nFound movie with rating 8.8: " + movie.title);
        } else {
            System.out.println("\nMovie with rating 8.8 not found.");
        }

        mms.updateMovieRating("Inception", 9.2);
        System.out.println("\nAfter updating rating:");
        mms.displayAllMoviesForward();

        mms.removeMovieByTitle("The Dark Knight");
        System.out.println("\nAfter removing The Dark Knight:");
        mms.displayAllMoviesForward();
    }
}
