package stepDefinations;

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
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HPC_StepDefination extends Utils{
		
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild data = new TestDataBuild();
	static String stateCode;
	static String VehicleNo;
	static String FullChassisno;
	static String Pur_cd;
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
	static String objectidICtrimed;
	static String applNO;
	static String BPOutputURL;
	
	@Given("Use duplicat permit using {string} {string} {string} {string}")
	public void use_duplicat_permit_using(String regn_no, String chasi_no, String stateCd, String Purpose_cd) throws IOException {
		stateCode = (stateCd);
		VehicleNo = (regn_no);
		last5chasi_no = (chasi_no);
		Pur_cd = (Purpose_cd);
		
		res = given().spec(requestSpecification()).pathParam("regn_no", regn_no).pathParam("chasi_no", chasi_no).pathParam("stateCd", stateCd).pathParam("pur_cd", Purpose_cd);
		
	}
	@When("user calls HPC {string} API with {string} http request")
	public void user_calls_hpc_api_with_http_request(String resource, String method) {

		APIResources resourceAPI=APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		if(method.equalsIgnoreCase("POST"))
		 response =res.when().post(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("GET"))
			 response =res.when().get(resourceAPI.getResource());
		System.out.println(response.asString());
	}
	
	@Then("the HPC API call got success with status code {int}")
	public void the_hpc_api_call_got_success_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(), 200);
	}
	
	@Then("{string} in  body of validateregandchasino Of duplicat permit flow  is {string}")
	public void in_body_of_validateregandchasino_of_duplicat_permit_flow_is(String keyValue, String Expectedvalue) {
		//assertEquals(Expectedvalue,getJsonPath(response,keyValue));
		FullChassisno = getJsonPath(response, "chasi_no");
		off_cd = getJsonPath(response, "off_cd");
	}
	
	@Given("Get details state and off code details using DP api")
	public void get_details_state_and_off_code_details_using_dp_api() throws IOException {
		res = given().spec(requestSpecification()).pathParam("regn_no", VehicleNo);
	}
	@Then("{string} in response body of dupPermit is {string}")
	public void in_response_body_of_dup_permit_is(String keyValue, String Expectedvalue) {
		assertEquals(Expectedvalue,getJsonPath(response,keyValue));
	}
	
	@Given("Get Owner detials using DP api")
	public void get_owner_detials_using_dp_api() throws IOException {
		res = given().spec(requestSpecification()).pathParam("regn_no", VehicleNo).pathParam("stateCd", stateCode).pathParam("chasi_no", last5chasi_no);
	}
	
	@Given("Use fillvmonlineservicechecksdata of DP API")
	public void use_fillvmonlineservicechecksdata_of_dp_api() throws IOException {
		res = given().spec(requestSpecification()).pathParam("stateCd", stateCode);
	}
	
	@Given("Get details using generateOtp using {string}")
	public void get_details_using_generate_otp_using(String MobileNo) throws IOException {
		MobNo = (MobileNo);
		res = given().spec(requestSpecification()).header("Content-Type", "application/json").body(data.GenerateMobileOTP(FullChassisno, MobileNo, Pur_cd, VehicleNo, stateCode));
	}
	
	@Then("{string} in response body of generateOtp is {string}")
	public void in_response_body_of_generate_otp_is(String keyValue, String Expectedvalue) {
		//assertEquals(Expectedvalue,getJsonPath(response,keyValue));
				MobileOTP = getJsonPath(response, "data.otp");
	}

	@Given("Get details using VerifyOtp")
	public void get_details_using_verify_otp() throws IOException {
		System.out.println(MobileOTP);
		res = given().spec(requestSpecification()).header("Content-Type", "application/json").body(data.VerifyeMobileOTP(FullChassisno, MobNo, MobileOTP, Pur_cd, VehicleNo, stateCode));
	}
	
	@Given("Get details using Permit_Document_List")
	public void get_details_using_permit_document_list() throws IOException {
		res = given().spec(requestSpecification()).pathParam("regn_no", VehicleNo).pathParam("stateCd", stateCode);
	}
	
	@Given("Get details using Dup_Permit_Draft")
	public void get_details_using_dup_permit_draft() throws IOException {
		res = given().spec(requestSpecification()).header("Content-Type", "application/json").body(data.duplicatePermitappl(off_cd, VehicleNo, stateCode));
	}
	@Then("{string} in response body of Dup_Permit_Draft is {string}")
	public void in_response_body_of_dup_permit_draft_is(String string, String string2) {
		//assertEquals(Expectedvalue,getJsonPath(response,keyValue));
		applNO = getJsonPath(response, "data.applNo");
	}
	
	@Given("Get details using Getfeedetails")
	public void get_details_using_getfeedetails() throws IOException {
		res = given().spec(requestSpecification()).pathParam("regn_no", VehicleNo).pathParam("stateCd", stateCode).pathParam("pur_cd", Pur_cd);
	}

	@Given("Get details using Beforepayment")
	public void get_details_using_beforepayment() throws IOException {
		res = given().spec(requestSpecification()).header("Content-Type", "application/json").body(data.BeforePaymentPayload(applNO, last5chasi_no, Pur_cd, VehicleNo, stateCode));
	}
	
	@Then("{string} in response body of Beforepayment is {string}")
	public void in_response_body_of_Beforepayment_is(String keyValue, String Expectedvalue) {
		//assertEquals(Expectedvalue,getJsonPath(response,keyValue));
				paymentrescode = getJsonPath(response, "returnUrl");
				int startPos = paymentrescode.indexOf("=") + 1;
				extractedrescode = paymentrescode.substring(startPos);
	}
	
	@Given("Beforepayment of Duplicate permit")
	public void beforepayment_of_duplicate_permit() throws IOException {
		res = given().spec(requestSpecification()).header("Content-Type", "application/json").body(data.duplicatePermitBP(applNO, last5chasi_no, Pur_cd, VehicleNo, stateCode));
	}
	@Then("Get the URL payment link in the body")
	public void get_the_url_payment_link_in_the_body() {
	   BPOutputURL = getJsonPath(response, "returnUrl");
	   System.out.println(BPOutputURL);
	   WebDriver driver = new EdgeDriver();
		driver.get(BPOutputURL);
		driver.findElement(By.cssSelector("input[value='S']")).click();
		driver.findElement(By.cssSelector("button[value='Enter']")).click();
	}
	
	@Given("Use Afterpayment for success UI URL using response {string}")
	public void use_afterpayment_for_success_ui_url_using_response(String response) throws IOException {
		res = given().spec(requestSpecification()).pathParam("paymentToken", response);
	}
	
	@Given("Get details using Afterpayment")
	public void get_details_using_afterpayment() throws IOException {
		res = given().spec(requestSpecification()).pathParam("paymentToken", extractedrescode);
	}

	@Then("{string} in response body of Afterpayment is {string}")
	public void in_response_body_of_afterpayment_is(String string, String string2) {
		//assertEquals(Expectedvalue,getJsonPath(response,keyValue));
		transaction_no = getJsonPath(response, "appl_no");
	}
	
	@Given("Get details using Printreciept")
	public void get_details_using_printreciept() throws IOException {
		res = given().spec(requestSpecification()).pathParam("state_cd", stateCode).pathParam("off_cd", off_cd).pathParam("transaction_no", transaction_no).pathParam("reg_no", VehicleNo).pathParam("pur_cd", Pur_cd);
	}
	
	@Given("Get details using Dms_config")
	public void get_details_using_dms_config() throws IOException {
		res = given().spec(requestSpecification()).header("Content-Type", "application/json").body(data.DmsConfig(transaction_no, Pur_cd, stateCode));
	}

	@Then("{string} in response body of Dms_config is {string}")
	public void in_response_body_of_dms_config_is(String string, String string2) {
		//assertEquals(Expectedvalue,getJsonPath(response,keyValue));
		cat_idIC = getJsonPath(response, "uploadDataDto.mandatoryList.subcategoryMasterDataList.cat_id[0][0]");
		sub_cat_idIC = getJsonPath(response, "uploadDataDto.mandatoryList.subcategoryMasterDataList.sub_cat_id[0][0]");
		cat_idNOBPA = getJsonPath(response, "uploadDataDto.mandatoryList.subcategoryMasterDataList.cat_id[1][0]");
		sub_cat_idNOBPA = getJsonPath(response, "uploadDataDto.mandatoryList.subcategoryMasterDataList.sub_cat_id[1][0]");
		cat_idPUCC= getJsonPath(response, "uploadDataDto.mandatoryList.subcategoryMasterDataList.cat_id[2][0]");
		sub_cat_idPUCC = getJsonPath(response, "uploadDataDto.mandatoryList.subcategoryMasterDataList.sub_cat_id[2][0]");
		cat_idRC = getJsonPath(response, "uploadDataDto.mandatoryList.subcategoryMasterDataList.cat_id[3][0]");
		sub_cat_idRC = getJsonPath(response, "uploadDataDto.mandatoryList.subcategoryMasterDataList.sub_cat_id[3][0]");
	}

	@Given("Get details using Dms_Upload for IC")
	public void get_details_using_dms_upload_for_ic() throws IOException {
		System.out.println(cat_idIC);
		System.out.println(sub_cat_idIC);
		System.out.println(cat_idNOBPA);
		System.out.println(sub_cat_idNOBPA);
		System.out.println(cat_idPUCC);
		System.out.println(sub_cat_idPUCC);
		System.out.println(cat_idRC);
		System.out.println(sub_cat_idRC);
		res = given().spec(requestSpecification()).header("Content-Type", "application/json").body(data.uploadfirst(cat_idIC, sub_cat_idIC, transaction_no, stateCode));
	}

	@Then("{string} in response body of Dms_Upload IC is {string}")
	public void in_response_body_of_dms_upload_ic_is(String string, String string2) {
		//assertEquals(Expectedvalue,getJsonPath(response,keyValue));
				objectidIC = getJsonPath(response, "dmsFileDetails.objectId[0]");
				
				 String modifiedString = objectidIC.replaceFirst("/", "#");
			        int indexOf = modifiedString.indexOf("/");
			         objectidICtrimed = objectidIC.substring(indexOf+1);
	}

	@Given("Get details using Dms_Upload for NOBPA")
	public void get_details_using_dms_upload_for_nobpa() throws IOException {
		res = given().spec(requestSpecification()).header("Content-Type", "application/json").body(data.uploadfirst(cat_idNOBPA, sub_cat_idNOBPA, transaction_no, stateCode));
	}

	@Then("{string} in response body of Dms_Upload NOBPA is {string}")
	public void in_response_body_of_dms_upload_nobpa_is(String string, String string2) {
		//assertEquals(Expectedvalue,getJsonPath(response,keyValue));
				//transaction_no = getJsonPath(response, "appl_no");
	}

	@Given("Get details using Dms_Upload for PUCC")
	public void get_details_using_dms_upload_for_pucc() throws IOException {
		res = given().spec(requestSpecification()).header("Content-Type", "application/json").body(data.uploadfirst(cat_idPUCC, sub_cat_idPUCC, transaction_no, stateCode));
	}

	@Then("{string} in response body of Dms_Upload PUCC is {string}")
	public void in_response_body_of_dms_upload_pucc_is(String string, String string2) {
		//assertEquals(Expectedvalue,getJsonPath(response,keyValue));
			//	transaction_no = getJsonPath(response, "appl_no");
	}

	@Given("Get details using Dms_Upload for RC")
	public void get_details_using_dms_upload_for_rc() throws IOException {
		res = given().spec(requestSpecification()).header("Content-Type", "application/json").body(data.uploadfirst(cat_idRC, sub_cat_idRC, transaction_no, stateCode));
	}

	@Then("{string} in response body of Dms_Upload RC is {string}")
	public void in_response_body_of_dms_upload_rc_is(String string, String string2) {
		//assertEquals(Expectedvalue,getJsonPath(response,keyValue));
				//transaction_no = getJsonPath(response, "appl_no");
	}
	
	@Given("Get details using Dms_View for RC")
	public void get_details_using_dms_view_for_rc() throws IOException {
		res = given().spec(requestSpecification()).header("Content-Type", "application/json").body(data.DmsView(transaction_no, objectidICtrimed));
	}

	@Given("Get details using Dms_List for RC")
	public void get_details_using_dms_list_for_rc() throws IOException {
		res = given().spec(requestSpecification()).header("Content-Type", "application/json").body(data.DmsList(transaction_no));
	}
	
	@Given("Get details using Fillvmonlineconfigurationdata")
	public void get_details_using_fillvmonlineconfigurationdata() throws IOException {
		res = given().spec(requestSpecification()).pathParam("state_cd", stateCode);
	}

	@Given("Get details using Finalsubmitduprc")
	public void get_details_using_finalsubmitduprc() throws IOException {
		res = given().spec(requestSpecification()).header("Content-Type", "application/json").body(data.finalsubmitpayload(transaction_no, last5chasi_no, VehicleNo, stateCode));
	}
	
	
}
