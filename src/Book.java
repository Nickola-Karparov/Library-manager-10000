
public class Book {
    private int bookId;
    private int lentToUserID;
    private String name;
    private String author;
    private String Language;
    private String Topic;
    private int length;

    public Book() {
    }

    public Book(int bookId, String name, String author, String language, String topic, int length) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.Topic = topic;
        this.length = length;
    }

    public int getBookId() {
        return this.bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getLentToUserID() {
        return this.lentToUserID;
    }

    public void setLentToUserID(int lentToUserID) {
        this.lentToUserID = lentToUserID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLanguage() {
        return this.Language;
    }


    public String getTopic() {
        return this.Topic;
    }

    public void setTopic(String topic) {
        this.Topic = topic;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
