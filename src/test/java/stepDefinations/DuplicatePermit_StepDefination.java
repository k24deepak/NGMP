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

public class DuplicatePermit_StepDefination extends Utils{
	
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild testData = new TestDataBuild();
	static String stateCode;
	static String VehicleNo;
	static String FullChassisno;
	static String Purpose_cd;
	static String MobileOTP;
	static String MobNo;
	static String last5chasi_no;
	static String paymentrescode;
	static String extractedrescode;
	static String transaction_no;
	static String off_cd;
	static String cat_idIC;
	static String sub_cat_idIC;
	static String cat_idNOBPA;
	static String sub_cat_idNOBPA;
	static String cat_idPUCC;
	static String sub_cat_idPUCC;
	static String cat_idRC;
	static String sub_cat_idRC;
	static String objectidIC;
	static  String objectidICtrimed;
	
//	@Given("Use duplicat permit using {string} {string} {string}")
//	public void use_duplicat_permit_using(String regn_no, String chasi_no, String stateCd) throws IOException {
//		Purpose_cd = ("34");
//		stateCode = (stateCd);
//		VehicleNo = (regn_no);
//		last5chasi_no = (chasi_no);
//		
//		res = given().spec(requestSpecification()).pathParam("regn_no", regn_no).pathParam("chasi_no", chasi_no).pathParam("stateCd", stateCd).pathParam("pur_cd", Purpose_cd);
//		
//	}
//	@When("user calls duplicat permit  {string} API of DP with {string} http request")
//	public void user_calls_duplicat_permit_api_of_dp_with_http_request(String resource, String method) {
//		APIResources resourceAPI=APIResources.valueOf(resource);
//		System.out.println(resourceAPI.getResource());
//		
//		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
//		
//		if(method.equalsIgnoreCase("POST"))
//		 response =res.when().post(resourceAPI.getResource());
//		else if(method.equalsIgnoreCase("GET"))
//			 response =res.when().get(resourceAPI.getResource());
//		System.out.println(response.asString());
//	}
//	@Then("the duplicate permit  API call got success with sta_Cd {int}")
//	public void the_duplicate_permit_api_call_got_success_with_sta_cd(Integer int1) {
//		assertEquals(response.getStatusCode(), 200);
//	}
//	@Then("{string} in  body of validateregandchasino Of duplicat permit flow  is {string}")
//	public void in_body_of_validateregandchasino_of_duplicat_permit_flow_is(String keyValue, String Expectedvalue) {
//		//assertEquals(Expectedvalue,getJsonPath(response,keyValue));
//		FullChassisno = getJsonPath(response, "chasi_no");
//	}
//	
//	@Given("Get details state and off code details using DP api")
//	public void get_details_state_and_off_code_details_using_dp_api() throws IOException {
//		res = given().spec(requestSpecification()).pathParam("regn_no", VehicleNo);
//	}
//	@Then("{string} in response body of dupPermit is {string}")
//	public void in_response_body_of_dup_permit_is(String keyValue, String Expectedvalue) {
//		assertEquals(Expectedvalue,getJsonPath(response,keyValue));
//	}
//	
//	@Given("Get Owner detials using DP api")
//	public void get_owner_detials_using_dp_api() throws IOException {
//		res = given().spec(requestSpecification()).pathParam("regn_no", VehicleNo).pathParam("stateCd", stateCode).pathParam("chasi_no", last5chasi_no);
//	}
//	
//	@Given("Use fillvmonlineservicechecksdata of DP API")
//	public void use_fillvmonlineservicechecksdata_of_dp_api() throws IOException {
//		res = given().spec(requestSpecification()).pathParam("stateCd", stateCode);
//	}

}
