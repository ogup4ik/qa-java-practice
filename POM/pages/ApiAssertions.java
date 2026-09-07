package pages;

import io.restassured.response.Response;
import org.testng.Assert;

public class ApiAssertions {

    public static void assertStatusCode(Response response, int expectedStatusCode) {
        Assert.assertEquals(response.statusCode(), expectedStatusCode);
    }
}
