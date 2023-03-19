package unitTest;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
public class PutTest {
	
	@Test
	public void putTest() {
		Map<String, Object> map = new HashMap<>();
		map.put("cityName", "Mumbai");
		map.put("cityCode", 113);
		map.put("languageCode", "HND");
		map.put("id", 24);
		
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.basePath("/cities/8")
		.contentType(ContentType.JSON)
		.body(map)
		.log().all()
		.put()
		.then()
		.log().all()
		.statusCode(200);
	}

}
