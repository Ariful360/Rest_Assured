package functionalTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import endpoints.Countries;
public class PostCountryTest {
	
Countries countries;
	
	@BeforeMethod
	public void init() {
		countries = new Countries();
		countries.init();
	}
	
	@Test
	public void postACountry() {
		countries.postACountry();
		countries.validateStatusCode(201);
		countries.validatePayloadObject("countryName", "Argentina");
		countries.validate_w_JsonPath("countyCode", 1);
	}

}
