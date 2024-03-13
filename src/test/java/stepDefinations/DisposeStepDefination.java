package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class DisposeStepDefination extends Utils {

	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild data = new TestDataBuild();
	static String off_cd;
	static String regn_no;
	static String state_cd;
	static String transaction_no;

	@Given("Get appl details using {string}  {string} {string}")
	public void get_appl_details_using(String VehicleNo, String ApplicationNo, String OTP) throws IOException {

		res = given().spec(requestSpecification()).pathParam("regn_no", VehicleNo).pathParam("appl_no", ApplicationNo)
				.pathParam("otp", OTP);
	}

	@When("user calls {string} API with {string} http request")
	public void user_calls_api_with_http_request(String resource, String method) {

		APIResources resourceAPI=APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		if(method.equalsIgnoreCase("POST"))
		 response =res.when().post(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("GET"))
			 response =res.when().get(resourceAPI.getResource());
		System.out.println(response.asString());
	}

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {

		assertEquals(response.getStatusCode(), 200);
		
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String Expectedvalue) {

		//assertEquals(Expectedvalue,getJsonPath(response,keyValue));
		 off_cd =getJsonPath(response,"off_cd[0]");
		 state_cd =getJsonPath(response,"state_cd[0]");
		 transaction_no =getJsonPath(response,"transaction_no[0]");
		 regn_no =getJsonPath(response,"regn_no[0]"); 
	}

	@Given("Get Application details using vehicleNo and applNo {string}")
	public void get_application_details_using_vehicleno_and_applno(String ChassisNO)
			throws IOException {

		res = given().spec(requestSpecification()).pathParam("regn_no", regn_no).pathParam("chasi_no", ChassisNO)
				.pathParam("appl_no", transaction_no);

	}
	
	@Given("DisposeApplication payload")
	public void dispose_application_payload() throws IOException {
		
		System.out.println(off_cd);
		System.out.println(state_cd);
		System.out.println(transaction_no);
		System.out.println(regn_no);
		res =given().spec(requestSpecification()).header("Content-Type", "application/json").body(data.disposeAPPL(off_cd, regn_no, state_cd, transaction_no));
	}

}
