package functionalTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import endpoints.Countries;

public class GetCountriesTest {
	
Countries countries;
	
	@BeforeMethod
	public void init() {
		countries = new Countries();
		countries.init();
	}
	
	@Test(enabled = false)
	public void getCountries() {
		countries.getCountries();
		countries.validateStatusCode(200);
	}
	
	@Test(enabled = false)
	public void getCountryById() {
		countries.getEachCountry(10);
		countries.validateStatusCode(200);
		countries.validatePayloadObject("countryName", "Bangladesh");
		countries.validatePayloadObject("countryCode", 4);
		countries.validate_w_JsonPath("id", 4);
	}
	
	@Test
	public void responValidation() {
		countries.getEachCountry(4);
		System.out.println(countries.getResponse().getBody().jsonPath().getString("countrycode"));
	}

}
