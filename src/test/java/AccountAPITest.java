import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.GetUsersResponse;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;

public class AccountAPITest {

    @Test
    public void testCreateUser() {
        // API endpoint URL
        String URL = "https://demoqa.com/swagger/#/";
        String endpoint = "/Account/v1User";

        // Request body
        String requestBody = "{\n" +
                "  \"userName\": \"string\",\n" +
                "  \"password\": \"string\",\n" +
                "}";

        String contentType = ContentType.JSON.toString();

        Map<String, Object> header = new HashMap<>();
        header.put("Accept", "application/json");
        header.put("Authorization","Bearer ZGVtb19kZXZ1c2VyOkpITm9hWEp2TVNSVFNFRXRNalUySkRVd01EQXdNQ1JUWkZZNGVqQjFRbkY0ZDIxR2FWQkxkRlp6ZURsM1BUMGtPRkJSUWtVM2RFbHFMMDFsVEdoVFJYSTVhaXQwWVhac1JreDZNWEZhV1VOdU1XSmtNVXMyUldvMlZUMA==");

        // Perform POST request and validate response
        Response response = (Response) RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post(endpoint)
                .then()
                .statusCode(200) // Assuming 200 is the expected status code
                .body("message", equalTo("Kullanıcı başarılı şekilde oluşturuldu")); // Assuming this is the expected response

    }
}