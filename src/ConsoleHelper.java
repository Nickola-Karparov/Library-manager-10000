
import java.util.Scanner;

public class ConsoleHelper {

    //region member vars
    Library library = new Library();
    Scanner scanner;
    private final String[] numbers;

    //endregion

    //region constructors
    public ConsoleHelper() {
        // Initialize scanner and numbers array
        this.scanner = new Scanner(System.in);
        this.numbers = new String[]{"first", "second", "third", "forth", "fifth", "sixth", "seventh", "eight", "ninth", "tenth", "eleventh", "twelfth", "thirteenth", "fourteenth", "fifteenth", "sixteenth", "seventeenth", "eighteenth", "nineteenth", "twentieth"};
    }

    public ConsoleHelper(Library library) {
        // Constructor with library parameter
        this.scanner = new Scanner(System.in);
        this.numbers = new String[]{"first", "second", "third", "forth", "fifth", "sixth", "seventh", "eight", "ninth", "tenth", "eleventh", "twelfth", "thirteenth", "fourteenth", "fifteenth", "sixteenth", "seventeenth", "eighteenth", "nineteenth", "twentieth"};
        library = this.library;
    }
    //endregion

    //region helper functions
    public int getInt(String prompt) {
        // Prompt the user for an integer input
        System.out.println(prompt);
        int helper = this.scanner.nextInt();
        String helper2 = this.scanner.nextLine();
        return helper;
    }

    public String getStr(String prompt) {
        // Prompt the user for a string input
        System.out.println(prompt);
        return this.scanner.nextLine();
    }

    public void printMessage(String prompt) {
        // Print a message to the console
        System.out.println(prompt);
    }

    //endregion

    //region create library
    public void createLibrary() {
        // Initialize the library with user-defined parameters
        //set floor count
        setFloorCount();

        createShelves();

        createBooks();

        //assign books to shelves
        assignBooksToShelves();

        createInitialUsers();

    }

    public void createShelves(){
        //set shelf count
        setShelfCount();

        //create and populate shelves
        createAndPopulateShelves();
    }
    public void createBooks(){
        //set books count
        setBooksCount();

        //create books
        createAndPopulateBooks();

    }

    public void createInitialUsers(){
        //set user count
        setUserCount();

        //create users
        createUsers();
    }


    public void setFloorCount() {
        // Set the number of floors in the library
        this.library.setFloorCount(this.getInt("How many floors does the library have?"));
    }

    public void setShelfCount() {
        // Set the number of shelves in the library
        this.library.setShelfCount(this.getInt("How many shelves does the library have?"));
        int arrSize = this.library.getShelfCount();
        this.library.shelfCountArrayInitializer(arrSize);
    }

    public void createAndPopulateShelves() {
        // Create and populate shelves with user input
        int shelfCount = this.library.getShelfCount();

        for(int i = 0; i < shelfCount; ++i) {
            String number = this.numbers[i];
            String shelfLetter = this.getStr("Enter the letter of the " + number + " shelf: ");
            int shelfFloor = this.getInt("Select which floor to put the shelf on: ");
            if (shelfLetter.isEmpty()) {
                while(shelfLetter.isEmpty()) {
                    number = this.numbers[i];
                    shelfLetter = this.getStr("Enter the letter of the " + number + " shelf: ");
                }
            } else if (shelfFloor <= this.library.getFloorCount() && shelfFloor >= 0) {
                this.library.addShelf(shelfLetter, shelfFloor);
            } else {
                while(shelfFloor > this.library.getFloorCount() || shelfFloor < 0) {
                    shelfFloor = this.getInt("Invalid inout. Select floor for the shelf: ");
                }
            }
        }

    }

    public void setBooksCount() {
        // Set the number of books in the library
        this.library.setBookCount(this.getInt("How many books does the library have?"));
        int bookCount = this.library.getBookCount();
        this.library.bookCountArrayInitializer(bookCount);
        Book[] bookArray = this.library.getBookArray();
    }

    public void createAndPopulateBooks() {
        // Create and populate books with user input
        int bookCount = this.library.getBookCount();

        for(int i = 0; i < bookCount; ++i) {
            String number = this.numbers[i];
            String name = this.getStr("Enter name of " + number + " the book: ");
            String topic = this.getStr("Enter topic of the book:");
            String author = this.getStr("Enter author's name:");
            String language = this.getStr("Enter the language of the book:");
            int length = this.getInt("Enter the length of the book:");
            if (name.isEmpty()) {
                while(name.isEmpty()) {
                    name = this.getStr("Name of the book is empty. Please enter the name: ");
                }
            } else if (topic.isEmpty()) {
                while(topic.isEmpty()) {
                    topic = this.getStr("Topic of the book is empty. Please enter the topic: ");
                }
            } else if (author.isEmpty()) {
                while(author.isEmpty()) {
                    author = this.getStr("Name of author is empty. Please enter name of author: ");
                }
            } else if (language.isEmpty()) {
                while(language.isEmpty()) {
                    language = this.getStr("Language of the book is empty. Please enter the language: ");
                }
            } else if (length < 0) {
                while(length < 0) {
                    length = this.getInt("Invalid length. Enter length: ");
                }
            } else {
                this.library.addBook(name, topic, author, language, length);
            }
        }

    }

    public void assignBooksToShelves() {
        // Assign books to shelves and sort them
        this.library.sortBooks();
    }

    public void setUserCount() {
        // Set the number of users in the library
        this.library.setUserCount(this.getInt("How many users does the library currently have?: "));
    }

    public void createUsers() {
        // Create users with user input
        int userCount = this.library.getUserCount();

        for(int i = 0; i < userCount; ++i) {
            String userName = this.getStr("What is the name of the user?: ");
            String helper = this.getStr("Is the user's subscription valid? (y/n): ");
            if (userName.isEmpty()) {
                while(userName.isEmpty()) {
                    userName = this.getStr("Please enter the name of the user: ");
                }
            }

            if (helper.isEmpty()) {
                while(helper.isEmpty()) {
                    helper = this.getStr("Please enter if the subscription is valid (y/n): ");
                }
            }

            boolean subscriptionValid = helper.equalsIgnoreCase("y");
            this.library.createInitialUsers(userName, subscriptionValid);
        }

    }
    //endregion

    //region book level options
    public void bookLevelOptions() {
        // Display book level options based on user input
        this.displayAllBooks();
        int selectedOption = this.getInt("ROOM LEVEL OPTIONS\n1 - Add book\n2 - Assign book to a bookshelf\n3 - Find book location\n\n");
        if (selectedOption == 1) {
            this.addBook();
        }

        if (selectedOption == 2) {
            this.displayAllShelves();
            this.assignBookToShelf();
        }

        if (selectedOption == 3) {
            this.findBookLocation();
        }

    }

    public void addBook() {
        // Add a book to the library
        String name = this.getStr("Enter name of the book: ");
        String topic = this.getStr("Enter topic of the book:");
        String author = this.getStr("Enter author's name:");
        String language = this.getStr("Enter the language of the book:");
        int length = this.getInt("Enter the length of the book:");
        this.library.addBook(name, topic, author, language, length);
    }

    public void assignBookToShelf() {
        // Assign a book to a shelf based on user input
        int bookId = this.getInt("Enter the id of the book you want to assign: ");
        int shelfId = this.getInt("Enter the id of the shelf you want to assign the book to: ");
        this.library.assignBookToShelf(bookId, shelfId);
    }

    public void findBookLocation() {
        // Find and display the location of a book based on user input
        String bookName = this.getStr("Enter the name of the book you want to find");
        this.printMessage(this.library.findBookLocation(bookName));
    }

    public void displayAllBooks() {
        // Display all books in the library
        Book[] books = this.library.getBookArray();
        if (books != null) {
            this.printMessage("All Books in the Library:");
            int length = books.length;

            for(int i = 0; i < length; ++i) {
                Book book = books[i];
                if (book != null) {
                    this.printMessage("Book ID: " + book.getBookId());
                    this.printMessage("Name: " + book.getName());
                    this.printMessage("Author: " + book.getAuthor());
                    this.printMessage("Language: " + book.getLanguage());
                    this.printMessage("Topic: " + book.getTopic());
                    this.printMessage("Length: " + book.getLength());
                    this.printMessage("---------------------------");
                }
            }
        } else {
            this.printMessage("No books found in the library.");
        }

    }
    //endregion

    //region user level options
    public void userLevelOptions() {
        // Display user level options based on user input
        this.displayAllUsers();
        int selectedOption = this.getInt("USER LEVEL OPTIONS\n1 - Add user\n2 - Lend book to user\n3 - Return book\n\n");
        if (selectedOption == 1) {
            this.addUser();
        }

        if (selectedOption == 2) {
            this.lendBookToUser();
        }

        if (selectedOption == 3) {
            this.returnBook();
        }

    }

    public void lendBookToUser() {
        // Lend a book to a user based on user input
        int userId = this.getInt("Enter the id of the user: ");
        int bookId = this.getInt("Enter the id of the book: ");
        this.library.lendBookToUser(userId, bookId);
    }

    public void addUser() {
        // Add a user to the library based on user input
        String userName = this.getStr("Enter the name of the new user: ");
        String subscriptionValid = this.getStr("Is the user's subscription valid Y/N:");
        this.library.addUser(userName, subscriptionValid.equalsIgnoreCase("y"));
    }

    public void returnBook() {
        // Return a book to the library based on user input
        int userID = this.getInt("Enter the id of the user who is returning the book: ");
        int bookID = this.getInt("Enter the id of the book to be returned: ");
        this.library.returnBook(userID, bookID);
    }

    public void displayAllUsers() {
        // Display all users in the library
        User[] users = this.library.getAllUsers();
        if (users != null) {
            this.printMessage("All Users in the Library:");
            int length = users.length;

            for(int i = 0; i < length; ++i) {
                User user = users[i];
                if (user != null) {
                    this.printMessage("User ID: " + user.getUserID());
                    this.printMessage("Name: " + user.getName());
                    this.printMessage("Subscription Valid: " + user.isSubscriptionValid());
                    this.printMessage("---------------------------");
                }
            }
        } else {
            this.printMessage("No users found in the library.");
        }

    }
    //endregion

    //region shelf level options
    public void shelfLevelOptions() {
        // Display shelf level options based on user input
        this.displayAllShelves();
        int selectedOption = this.getInt("ROOM LEVEL OPTIONS\n1 - To move a shelf to a different floor\n2 - To sort the books on a self\n\n");
        if (selectedOption == 1) {
            this.moveShelf();
        }

        if (selectedOption == 2) {
            int shelfId = this.getInt("Select the ID of the shelf you wish to sort the books on: ");
            this.library.sortBooksOnShelf(shelfId);
        }

    }

    public void displayAllShelves() {
        // Display all shelves in the library
        Shelf[] shelves = this.library.getAllShelves();
        if (shelves != null) {
            this.printMessage("All Shelves in the Library:");
            int length = shelves.length;

            for(int i = 0; i < length; ++i) {
                Shelf shelf = shelves[i];
                if (shelf != null) {
                    this.printMessage("Shelf ID: " + shelf.getShelfID());
                    this.printMessage("Floor: " + shelf.getFloor());
                    this.printMessage("Shelf Letter: " + shelf.getShelfLetter());
                    this.printMessage("---------------------------");
                }
            }
        } else {
            this.printMessage("No shelves found in the library.");
        }

    }

    public void moveShelf() {
        // Move a shelf to a different floor based on user input
        int shelfID = this.getInt("Enter the id of the bookshelf you want to move");
        int newFloor = this.getInt("Enter the floor you want to move the shelf to");
        this.library.moveShelf(shelfID, newFloor);
    }
    //endregion
}
