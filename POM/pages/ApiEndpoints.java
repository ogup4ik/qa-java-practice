package pages;

public class ApiEndpoints {

    public static final String BASE_URL =
            "https://jsonplaceholder.typicode.com";

    public static final String POSTS =
            BASE_URL + "/posts";

    public static String postById(int id) {
        return POSTS + "/" + id;
    }
}