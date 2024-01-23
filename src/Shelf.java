
import java.util.Arrays;
import java.util.Comparator;

public class Shelf {
    private int shelfID;
    private int floor;
    private String shelfLetter;
    Book[] bookArray;

    public Shelf() {
    }

    public Shelf(int shelfID, int floor, String shelfLetter, Book[] bookArray) {
        this.shelfID = shelfID;
        this.floor = floor;
        this.shelfLetter = shelfLetter;
        this.bookArray = bookArray;
    }

    public int getShelfID() {
        return this.shelfID;
    }

    public void setShelfID(int shelfID) {
        this.shelfID = shelfID;
    }

    public int getFloor() {
        return this.floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getShelfLetter() {
        return this.shelfLetter;
    }

    public void setShelfLetter(String shelfLetter) {
        this.shelfLetter = shelfLetter;
    }

    public Book[] getBookArray() {
        return this.bookArray;
    }

    public void setBookArray(Book[] bookArray) {
        this.bookArray = bookArray;
    }

    public void addBookToShelf(Book book) {
        if (this.bookArray.length >= this.bookArray.length + 1) {
            Book[] helperArray = (Book[])Arrays.copyOf(this.bookArray, this.bookArray.length + 1);
            helperArray[this.bookArray.length] = book;
            this.bookArray = helperArray;
        } else {
            this.bookArray[this.bookArray.length] = book;
        }

    }

    public void sortBooksAlphabetically() {
        if (this.bookArray != null) {
            Arrays.sort(this.bookArray, Comparator.comparing(Book::getName, String.CASE_INSENSITIVE_ORDER));
        }

    }
}
