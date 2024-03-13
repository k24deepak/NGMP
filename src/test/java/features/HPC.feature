Feature: Validation HPC API's

	Scenario: verify regandchassisno validation api
  Given Use duplicat permit using "<VehNo>" "<chassis No>" "<State_Cd>" "<Pur_cd>"
		When user calls HPC "validateregandchasino" API with "Get" http request
	Then the HPC API call got success with status code 200
	And "stateCd" in  body of validateregandchasino Of duplicat permit flow  is "GJ"	
	
	Examples:
				| VehNo		   |  chassis No |	State_Cd |  Pur_cd |
				| GJ01AT2772 | 		50412		 |	  GJ 		 |		8		 |
				
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
#	And "developerMessage" in response body of generateOtp is "OTP verified successfully"			
			
	Scenario: Verify Getfeedetails API
  Given Get details using Getfeedetails 
	When user calls HPC "Getfeedetails" API with "Get" http request
	Then the HPC API call got success with status code 200		
				
	Scenario: Verify Beforepayment API
  Given Get details using Beforepayment 
	When user calls HPC "Beforepayment" API with "Post" http request
	Then the HPC API call got success with status code 200	
	And "stateCd" in response body of Beforepayment is "GJ"
	
	Scenario: Verify Afterpayment API
  Given Get details using Afterpayment 
	When user calls HPC "Afterpayment" API with "Get" http request
	Then the HPC API call got success with status code 200	
	And "stateCd" in response body of Afterpayment is "GJ"
	
	Scenario: Verify Printreciept API
  Given Get details using Printreciept 
	When user calls HPC "Printreciept" API with "Get" http request
	Then the HPC API call got success with status code 200	
	
	Scenario: Verify Dms_config API
  Given Get details using Dms_config 
	When user calls HPC "Dms_config" API with "Post" http request
	Then the HPC API call got success with status code 200	
	And "stateCd" in response body of Dms_config is "GJ"
	
		 Scenario: Verify Dms_Upload API
  Given Get details using Dms_Upload for IC
	When user calls HPC "Dms_Upload" API with "Post" http request
	Then the HPC API call got success with status code 200	
	And "stateCd" in response body of Dms_Upload IC is "GJ"
	
	 Scenario: Verify Dms_Upload API
  Given Get details using Dms_Upload for NOBPA
	When user calls HPC "Dms_Upload" API with "Post" http request
	Then the HPC API call got success with status code 200	
	And "stateCd" in response body of Dms_Upload NOBPA is "GJ"
	
	 Scenario: Verify Dms_Upload API
  Given Get details using Dms_Upload for PUCC
	When user calls HPC "Dms_Upload" API with "Post" http request
	Then the HPC API call got success with status code 200	
	And "stateCd" in response body of Dms_Upload PUCC is "GJ"
	
	 Scenario: Verify Dms_Upload API
  Given Get details using Dms_Upload for RC
	When user calls HPC "Dms_Upload" API with "Post" http request
	Then the HPC API call got success with status code 200	
	And "stateCd" in response body of Dms_Upload RC is "GJ"
	
	Scenario: Verify Dms_View API
  Given Get details using Dms_View for RC
	When user calls HPC "Dms_View" API with "Post" http request
	Then the HPC API call got success with status code 200	
	
	Scenario: Verify Dms_List API
  Given Get details using Dms_List for RC
	When user calls HPC "Dms_List" API with "Post" http request
	Then the HPC API call got success with status code 200
	
	Scenario: Verify Fillvmonlineconfigurationdata API
  Given Get details using Fillvmonlineconfigurationdata 
	When user calls HPC "Fillvmonlineconfigurationdata" API with "Get" http request
	Then the HPC API call got success with status code 200	
				
	Scenario: Verify Finalsubmitduprc API
  Given Get details using Finalsubmitduprc 
	When user calls HPC "Finalsubmitduprc" API with "Post" http request
	Then the HPC API call got success with status code 200	
				


