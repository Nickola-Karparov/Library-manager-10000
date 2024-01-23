
import java.util.Arrays;
import java.util.Comparator;

public class Library {

    //region member vars
    private int shelfCount;
    private Shelf[] shelvesArray;
    private int userCount;
    private User[] userArray;
    private int bookCount;
    private Book[] bookArray;
    private int floorCount;
    //endregion

    //region constructors
    public Library() {
    }

    public Library(int shelfCount, Shelf[] shelvesArray, int userCount, User[] userArray, int bookCount, Book[] bookArray) {
        this.shelfCount = shelfCount;
        this.shelvesArray = shelvesArray;
        this.userCount = userCount;
        this.userArray = userArray;
        this.bookCount = bookCount;
        this.bookArray = bookArray;
    }
    //endregion

    //region getters and setters
    public int getFloorCount() {
        return this.floorCount;
    }

    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }

    public int getShelfCount() {
        return this.shelfCount;
    }

    public void setShelfCount(int shelfCount) {
        this.shelfCount = shelfCount;
    }

    public Shelf[] getShelvesArray() {
        return this.shelvesArray;
    }

    public int getShelvesArraySize() {
        return this.shelvesArray.length;
    }

    public void setShelvesArray(Shelf[] shelvesArray) {
        this.shelvesArray = shelvesArray;
    }

    public int getUserCount() {
        return this.userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public User[] getUserArray() {
        return this.userArray;
    }

    public void setUserArray(User[] userArray) {
        this.userArray = userArray;
    }

    public int getBookCount() {
        return this.bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public Book[] getBookArray() {
        return this.bookArray;
    }

    public void setBookArray(Book[] bookArray) {
        this.bookArray = bookArray;
    }
    //endregion

    //region misc
    public int getRandomNumber(int min, int max) {
        // Generate a random number within the specified range
        return (int)(Math.random() * (double)(max - min) + (double)min);
    }


    public void shelfCountArrayInitializer(int size) {
        // Initialize the shelves array with the specified size
        this.shelvesArray = new Shelf[size];
    }

    public void bookCountArrayInitializer(int size) {
        // Initialize the book array with the specified size
        this.bookArray = new Book[size];
    }
//endregion

    //region shelf level options

    public void moveShelf(int shelfId, int newFloor) {
        // Move a shelf to a different floor
        Shelf shelf = this.findShelfById(shelfId);
        if (shelf != null) {
            shelf.setFloor(newFloor);
            System.out.println("Shelf with ID " + shelfId + " has been moved to Floor " + newFloor);
        } else {
            System.out.println("Shelf not found.");
        }

    }

    public void sortBooksOnShelf(int shelfId) {
        // Sort books on a shelf alphabetically
        Shelf shelf = this.findShelfById(shelfId);
        assert shelf != null;
        shelf.sortBooksAlphabetically();
    }

    public void addShelf(String shelfLetter, int floor) {
        // Add a new shelf to the library
        if (this.shelvesArray == null) {
            this.shelvesArray = new Shelf[1];
        } else if (this.shelvesArray.length + 1 <= this.shelvesArray.length) {
            Shelf[] helperArray = (Shelf[])Arrays.copyOf(this.shelvesArray, this.shelvesArray.length + 1);
            helperArray[this.shelvesArray.length] = new Shelf(this.getRandomNumber(1, 1000000), floor, shelfLetter, (Book[])null);
            this.shelvesArray = helperArray;
        } else {
            this.shelvesArray[this.shelvesArray.length - 1] = new Shelf(this.getRandomNumber(1, 1000000), floor, shelfLetter, (Book[])null);
        }

    }

    public Shelf[] getAllShelves() {
        // Retrieve all shelves in the library
        return this.shelvesArray;

    }

    private Shelf findShelfById(int shelfId) {
        // Find a shelf in the library by its ID
        if (this.shelvesArray != null) {
            Shelf[] shelvesArr = this.shelvesArray;
            int length = shelvesArr.length;

            for(int i = 0; i < length; ++i) {
                Shelf shelf = shelvesArr[i];
                if (shelf != null && shelf.getShelfID() == shelfId) {
                    return shelf;
                }
            }
        }

        return null;
    }

    public void assignBookToShelf(int bookId, int shelfId) {
        // Assign a book to a shelf
        Book book = this.findBookById(bookId);
        Shelf shelf = this.findShelfById(shelfId);
        if (book != null && shelf != null) {
            shelf.addBookToShelf(book);
            System.out.println("Book with ID " + bookId + " has been assigned to Shelf with ID " + shelfId);
        } else {
            System.out.println("Book or Shelf not found.");
        }

    }


    //endregion

    //region user level options

    public User[] getAllUsers() {
        // Retrieve all users in the library
        return this.userArray;

    }

    public void lendBookToUser(int userId, int bookId) {
        // Lend a book to a user
        User user = this.findUserById(userId);
        Book book = this.findBookById(bookId);
        if (user != null && book != null) {
            if (user.isSubscriptionValid()) {
                user.setBorrowedBookID(bookId);
                book.setLentToUserID(userId);
                System.out.println("Book with ID " + bookId + " has been lent to User with ID " + userId);
            } else {
                System.out.println("User with ID " + userId + " has an invalid subscription.");
            }
        } else {
            System.out.println("User or Book not found.");
        }

    }

    private User findUserById(int userId) {
        // Find a user in the library by their ID
        if (userArray != null) {
            for (User user : userArray) {
                if (user != null && user.getUserID() == userId) {
                    return user;
                }
            }
        }
        return null;
    }

    public void addUser(String userName, boolean subscriptionValid) {
        // Add a new user to the library
        if (this.userArray == null) {
            this.userArray = new User[1];
        } else if (this.userArray.length + 1 >= this.userArray.length) {
            User[] helperArray = (User[])Arrays.copyOf(this.userArray, this.userArray.length + 1);
            helperArray[this.userArray.length] = new User(this.getRandomNumber(1, 1000000), userName, subscriptionValid);
            this.userArray = helperArray;
        } else {
            this.userArray[this.userArray.length] = new User(this.getRandomNumber(1, 1000000), userName, subscriptionValid);
        }

    }

    public void createInitialUsers(String userName, boolean subscriptionValid) {
        // Create initial users for the library
        if (this.userArray == null) {
            this.userArray = new User[1];
            this.createInitialUsers(userName, subscriptionValid);
        } else if (this.userArray.length + 1 <= this.userArray.length) {
            User[] helperArray = (User[])Arrays.copyOf(this.userArray, this.userArray.length + 1);
            helperArray[this.userArray.length] = new User(this.getRandomNumber(1, 1000000), userName, subscriptionValid);
            this.userArray = helperArray;
        } else {
            this.userArray[this.userArray.length - 1] = new User(this.getRandomNumber(1, 1000000), userName, subscriptionValid);
        }

    }

    //endregion

    //region book level options

    private Book findBookById(int bookId) {
        // Find a book in the library by its ID
        if (this.bookArray != null) {
            Book[] bookArray = this.bookArray;
            int length = bookArray.length;

            for(int i = 0; i < length; ++i) {
                Book book = bookArray[i];
                if (book != null && book.getBookId() == bookId) {
                    return book;
                }

            }
        }

        return null;
    }

    public void returnBook(int userId, int bookId) {
        // Return a book to the library
        User user = this.findUserById(userId);
        Book book = this.findBookById(bookId);
        if (user != null && book != null) {
            if (user.getBorrowedBookID() == bookId) {
                user.setBorrowedBookID(0);
                book.setLentToUserID(0);
                System.out.println("Book with ID " + bookId + " has been returned by User with ID " + userId);
            } else {
                System.out.println("User with ID " + userId + " has not borrowed the specified book.");
            }
        } else {
            System.out.println("User or Book not found.");
        }

    }


    public void addBook(String name, String topic, String author, String language, int length) {
        // Add a new book to the library
        if (this.bookArray == null) {
            this.bookArray = new Book[1];
        } else if (this.bookArray.length + 1 <= this.bookArray.length) {
            Book[] helperArray = (Book[])Arrays.copyOf(this.bookArray, this.bookArray.length + 1);
            helperArray[this.bookArray.length] = new Book(this.getRandomNumber(1, 1000000), name, author, language, topic, length);
            this.bookArray = helperArray;
        } else {
            this.bookArray[this.bookArray.length - 1] = new Book(this.getRandomNumber(1, 1000000), name, author, language, topic, length);
        }

    }

    public String findBookLocation(String bookName) {
        // Find and return the location of a book in the library
        if (bookArray != null) {
            for (Shelf shelf : shelvesArray) {
                if (shelf != null) {
                    Book[] booksOnShelf = shelf.getBookArray();
                    if (booksOnShelf != null) {
                        for (Book book : booksOnShelf) {
                            if (book != null && book.getName().equalsIgnoreCase(bookName)) {
                                return "Book '" + book.getName() + "' is on Floor " + shelf.getFloor() +
                                       ", Shelf ID " + shelf.getShelfID();
                            }
                        }
                    }
                }
            }
        }
        return "Book '" + bookName + "' not found in the library.";
    }

    public void sortBooks() {
        // Sort the books alphabetically using a lambda expression
        Arrays.sort(bookArray, Comparator.comparing(book ->
                book.getName().toLowerCase(), String.CASE_INSENSITIVE_ORDER));

        // Assign books to shelves based on the first letter of their name
        for (Book book : bookArray) {
            for (Shelf shelf : shelvesArray) {
                String bookName = book.getName();
                String shelfLetter = shelf.getShelfLetter();
                if (bookName != null && shelfLetter != null && !bookName.isEmpty() && !shelfLetter.isEmpty() &&
                    Character.toUpperCase(bookName.charAt(0)) == Character.toUpperCase(shelfLetter.charAt(0))) {
                    shelf.addBookToShelf(book);
                    break; // Once the book is assigned, move to the next book
                }
            }
        }
    }
    //endregion

}
