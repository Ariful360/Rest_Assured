package unitTest;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import java.net.http.HttpResponse.BodyHandler;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetTest {

	@Test(enabled = false)
	public void getCountryPreetyprint() {
		RestAssured.get("http://localhost:3000/countries").prettyPrint();
	}

	@Test(enabled = false)
	public void getCountryVar() {
		Response response = RestAssured.get("http://localhost:3000/countries");
		System.out.println(response.asString());
	}
	@Test(enabled = false)
	public void getCountryResponseCodeValidation() {
		RestAssured.get("http://localhost:3000/countries/3")
		.then()
		.statusCode(200);
	}
	
	@Test(enabled = false)
	public void getCountryResponseCodeValidationNagetiveTest() {
		RestAssured.get("http://localhost:3000/countries/100")
		.then()
		.statusCode(404);
	}
	
	@Test(enabled = false)
	public void getCountrylog() {
		RestAssured.given()
		.log().all()
		.get("http://localhost:3000/countries/10")
		.then()
		.log().all()
		.statusCode(200);
	}
	
	@Test(enabled = true)
	public void getCitiesReoponseValidation() {
		RestAssured.given()
		.log().all()
		.get("http://localhost:3000/cities/4")
		.then()
		.log().all()
		.statusCode(200)
		.and()
		.body("id", equalTo(4))
		.body("cityName", equalTo("Dhaka"))
		.body("languageCode", equalTo("BNG"));
	}
	
}
