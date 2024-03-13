Feature: Validating of duplicate permit flow API
	
	Scenario: verify regandchassisno validation api
  Given Use duplicat permit using "<VehNo>" "<chassis No>" "<State_Cd>" "<Pur_cd>"
  When user calls HPC "validateregandchasino" API with "Get" http request
	Then the HPC API call got success with status code 200
	And "stateCd" in  body of validateregandchasino Of duplicat permit flow  is "GJ"	
	
	Examples:
				| VehNo		   |  chassis No |	State_Cd |  Pur_cd |
				| GJ23Y9981  | 		37887		 |	  GJ 		 |		34		 |
				
 Scenario: Verify getstatecdandoffcd of DP API
  Given Get details state and off code details using DP api
	When user calls HPC "GetState_cdandOff_cd" API with "Get" http request
	Then the HPC API call got success with status code 200
	And "stateCd" in response body of dupPermit is "GJ"
	And "offCd" in response body of dupPermit is "23"
	
	Scenario: Verify getownerDetailsInurancePuccPermit of DP API
  Given Get Owner detials using DP api
	When user calls HPC "getownerDetailsInurancePuccPermit" API with "Get" http request
	Then the HPC API call got success with status code 200
#	And "state_cd" in response body of HPC is "GJ"
#	And "off_cd" in response body of HPC is "23"
				
	Scenario: Verify fillvmonlineservicechecksdata of DP API
  Given Use fillvmonlineservicechecksdata of DP API
	When user calls HPC "fillvmonlineservicechecksdata" API with "Get" http request
	Then the HPC API call got success with status code 200
	
	Scenario: Verify generateOtp API
  Given Get details using generateOtp using "<MobileNo>" 
	When user calls HPC "GenerateOtp" API with "Post" http request
	Then the HPC API call got success with status code 200		
	And "stateCd" in response body of generateOtp is "GJ"
				
Examples:
				| MobileNo  |
				| 8825987874 |		
				
  Scenario: Verify VerifyOtp API
  Given Get details using VerifyOtp 
	When user calls HPC "VerifyOtp" API with "Post" http request
	Then the HPC API call got success with status code 200	
	
	Scenario: Verify Permit_Document_List API
  Given Get details using Permit_Document_List 
	When user calls HPC "Permit_Document_List" API with "Get" http request
	Then the HPC API call got success with status code 200	
	
	Scenario: Verify Dup_Permit_Draft API
  Given Get details using Dup_Permit_Draft 
	When user calls HPC "Dup_Permit_Draft" API with "Post" http request
	Then the HPC API call got success with status code 200	
	And "stateCd" in response body of Dup_Permit_Draft is "GJ"
	
	Scenario: Verify Getfeedetails API
  Given Get details using Getfeedetails 
	When user calls HPC "Getfeedetails" API with "Get" http request
	Then the HPC API call got success with status code 200		
				
	Scenario: Verify Beforepayment API of Duplicate permit
  Given Beforepayment of Duplicate permit
	When user calls HPC "Beforepayment" API with "Post" http request
	Then the HPC API call got success with status code 200	
	And Get the URL payment link in the body
	

