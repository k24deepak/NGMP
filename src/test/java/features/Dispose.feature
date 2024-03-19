Feature: Validation dispose API's
	@GetListOfAppl
  Scenario: Verify if The List of Application no details is available using GetListOFDisposeApplication API
  Given Get appl details using "<VehicleNo>"  "<ApplicationNO>" "<OTP>"
	When user calls "ListOFDisposeAppl" API with "Get" http request
	Then the API call got success with status code 200
	And "transaction_no" in response body is "GJ230426M0136285"
	And "regn_no" in response body is "GJ01CV2038"
	
		Examples:
				| VehicleNo  |   ApplicationNO   |  OTP  |
				| ML05M6270  | ML240314M0743520  | 1234  |
	
	@GetDetailsOfAppl
	Scenario: Verify DetailsDiposeAppl API
	Given Get Application details using vehicleNo and applNo "<ChassisNO>"
	When user calls "DetailsDiposeAppl" API with "Get" http request
	Then the API call got success with status code 200
	
	Examples:
				  | 		ChassisNO  		|
				  |	MA1ZC4GHKF1C31460 |

	@DisposeAppl
	Scenario: Verify DisposeAPPL API
	Given DisposeApplication payload
	When user calls "DisposeAPPL" API with "Post" http request
	Then the API call got success with status code 200
	
	
	