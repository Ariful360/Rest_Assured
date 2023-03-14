package functionalTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import endpoints.Cities;
public class GetCitiesTest {
	
Cities cities;
	
	@BeforeMethod
	public void initTests() {
		cities = new Cities();
		cities.init();
	}
	
	@Test
	public void getCitiesValidation() {
		cities.getCities();
		cities.validateStatusCode(200);
	}

}
