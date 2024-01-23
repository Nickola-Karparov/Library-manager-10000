
public class User {
    private int userID;
    private String Name;
    private int borrowedBookID;
    private boolean subscriptionValid;

    public User() {
    }

    public User(int userID, String name, boolean subscriptionValid) {
        this.userID = userID;
        this.Name = name;
        this.subscriptionValid = subscriptionValid;
    }

    public int getUserID() {
        return this.userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getBorrowedBookID() {
        return this.borrowedBookID;
    }

    public void setBorrowedBookID(int borrowedBookID) {
        this.borrowedBookID = borrowedBookID;
    }

    public boolean isSubscriptionValid() {
        return this.subscriptionValid;
    }

    public void setSubscriptionValid(boolean subscriptionValid) {
        this.subscriptionValid = subscriptionValid;
    }
}
