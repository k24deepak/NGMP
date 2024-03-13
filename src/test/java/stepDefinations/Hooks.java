package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DisposeAppl")
	public void beforeScenario() throws IOException { // execute this code only when place id is null
		// write a code that will give you place id

		DisposeStepDefination m = new DisposeStepDefination();
		if (DisposeStepDefination.regn_no == null && DisposeStepDefination.off_cd == null && DisposeStepDefination.transaction_no == null
				&& DisposeStepDefination.state_cd == null) {
			m.get_appl_details_using("GJ01CV2038", "GJ230426M0136285", "1234");
			m.user_calls_api_with_http_request("ListOFDisposeAppl", "Get");

		}

	}

}
