
public class ManagementConsole {
    public ManagementConsole() {
    }

    public static void main(String[] args) {
        Library library = new Library();
        ConsoleHelper helper = new ConsoleHelper(library);
        helper.printMessage("Welcome to Library Manager 10.000! First let's create the library! \nFirst enter the number of floors the library has: ");
        helper.createLibrary();

        boolean breaker;
        do {
            breaker = false;
            int selectOption = helper.getInt("To move a shelf to a different floor 1.\nFor user level options press 2.\nFor book level options press 3.\nTo display all users press 4.\nTo display all books press 5\nTo display all shelves press 6.\nTo end the process and exit the program press 7.");
            switch (selectOption) {
                case 1:
                    helper.shelfLevelOptions();
                    break;
                case 2:
                    helper.userLevelOptions();
                    break;
                case 3:
                    helper.bookLevelOptions();
                    break;
                case 4:
                    helper.displayAllUsers();
                    break;
                case 5:
                    helper.displayAllBooks();
                    break;
                case 6:
                    helper.displayAllShelves();
                    break;
                case 7:
                    breaker = true;
            }
        } while(!breaker);

        helper.printMessage("Have a nice day.");
    }
}
