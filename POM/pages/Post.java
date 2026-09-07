package pages;

public class Post {

    public int id;
    public String title;
    public String body;
    public int userId;

    public Post() {
    }

    public Post(String title, String body, int userId) {
        this.title = title;
        this.body = body;
        this.userId = userId;
    }
}
