package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import pages.Inventory;
import pages.LoginPage;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import pages.ApiAssertions;
public class TestAPI {
    @Test
    public void testApi(){
        Response response = ApiClient.get(ApiEndpoints.postById(1));
        System.out.println(response.asString());
        ApiAssertions.assertStatusCode(response, 200);
    }
    @Test
    public void createPostTest() {

        Post post = new Post(
                "Мій перший пост",
                "Текст мого поста",
                1
        );

        Response response = ApiClient.post(ApiEndpoints.POSTS, post);

        System.out.println(response.asString());
        ApiAssertions.assertStatusCode(response, 201);
        Post responsePost = response.as(Post.class);
        Assert.assertEquals(responsePost.title, post.title);
    }
}
