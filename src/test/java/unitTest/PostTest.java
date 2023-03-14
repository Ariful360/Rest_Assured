package unitTest;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostTest {

	@Test
	public void postTest() {
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body("{\"id\": 7,\"cityName\": \"Islamabad\",\"languageCode\": \"URD\",\"cityCode\": 70}")
		.basePath("/cities")
		.when()
		.post()
		.then()
		.log().all()
		.statusCode(201);
	}

	@Test(enabled = false)
	public void postTestStringBody400() {
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body("{\"id\": 21,\"cityCode\": 92,\"cityName\": \"Faridpul\",\"languageCode\": \"BNG\"}")
		.basePath("/players")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(400);
	}
	
	@Test(enabled = false)
	public void postTestFileBody500() {
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body(new File("src/test/resources/player.json"))
		.basePath("/players")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(500);
	}
	
	@Test(enabled = false)
	public void postTestInputStreamBody() {
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body(getClass().getClassLoader().getResourceAsStream("city.json"))
		.basePath("/cities")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(201);
	}
	
	@Test(enabled = false)
	public void postTestByteBody() {
		try {
			RestAssured.given()
			.baseUri("http://localhost:3000")
			.contentType(ContentType.JSON)
			.body(getClass().getClassLoader().getResourceAsStream("countries.json").readAllBytes())
			.basePath("/countries")
			.when()
			.log().all()
			.post()
			.then()
			.log().all()
			.statusCode(201);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test(enabled = true)
	public void postTestMapBody() {
		Map<String, Object> map = new HashMap<>();
		map.put("id", 22);
		map.put("cityName", "Madrid");
		map.put("languageCode", "ES");
		map.put("cityCode", 55);
		
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body(map)
		.basePath("/cities")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(201);
	}
}
