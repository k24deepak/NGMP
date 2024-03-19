Feature: Validation HPC API's

	Scenario: verify regandchassisno validation api
  Given Use duplicat permit using "<VehNo>" "<chassis No>" "<State_Cd>" "<Pur_cd>"
	When user calls HPC "validateregandchasino" API with "Get" http request
	Then the HPC API call got success with status code 200
	And "stateCd" in  body of validateregandchasino Of duplicat permit flow  is "GJ"	
	
	Examples:
				| VehNo		   |  chassis No |	State_Cd |  Pur_cd |
				| 24BH6754A  | 		59316		 |	  UP 		 |		6		 |
				
 Scenario: Verify getstatecdandoffcd of DP API
  Given Get details state and off code details using DP api
	When user calls HPC "GetState_cdandOff_cd" API with "Get" http request
	Then the HPC API call got success with status code 200
	And "stateCd" in response body of dupPermit is "UP"


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
			
	Scenario: Verify HPADraft API
  Given Generate APPL no using HPADraft API
	When user calls HPC "HPADraft" API with "Post" http request
	Then the HPC API call got success with status code 200		
	And "stateCd" in response body of HPADraft is "GJ"
	
	Scenario: Verify Getfeedetails API
  Given Get details using Getfeedetails 
	When user calls HPC "Getfeedetails" API with "Get" http request
	Then the HPC API call got success with status code 200		
				
	Scenario: Verify Beforepayment API of HPA permit
  Given BP of HPA permit
	When user calls HPC "Beforepayment" API with "Post" http request
	Then the HPC API call got success with status code 200	
	And Get the URL Bpayment link in the body of HPA
	
	Scenario: Verify Afterpayment API of HPA Pemrit
  Given AP of HPA permit 
	When user calls HPC "Afterpayment" API with "Get" http request
	Then the HPC API call got success with status code 200	
	And "stateCd" in response body of AP of HPA is "GJ"
	
	Scenario: Verify Printreciept api of HPA service
  Given Use Printreciept 
	When user calls HPC "Printreciept" API with "Get" http request
	Then the HPC API call got success with status code 200	
	
	Scenario: Verify PrintForm34 API
  Given Get details using PrintForm34 
	When user calls HPC "Form34" API with "Get" http request
	Then the HPC API call got success with status code 200
	
	Scenario: Verify PrintForm36 API
  Given Get details using PrintForm36 
	When user calls HPC "Form36" API with "Get" http request
	Then the HPC API call got success with status code 200
	
	Scenario: Verify Fillvmonlineconfigurationdata API
  Given Get details using Fillvmonlineconfigurationdata 
	When user calls HPC "Fillvmonlineconfigurationdata" API with "Get" http request
	Then the HPC API call got success with status code 200	
	
	Scenario: Verify Dms_config API for the HPA service
  Given Use Dms_config API for the HPA service
	When user calls HPC "Dms_config" API with "Post" http request
	Then the HPC API call got success with status code 200	
	And "stateCd" in response body of Dms_config api for the HPA service is "GJ"
	
	Scenario: Verify Dms_Upload API for the HPA service 
  Given USE Dms_Upload for Signed document form34
	When user calls HPC "Dms_Upload" API with "Post" http request
	Then the HPC API call got success with status code 200	
	And "stateCd" in response body of Dms_Upload for Signed document form34 is "GJ"
	
	Scenario: Verify Dms_View API for HPA
  Given Use Dms_View for for Signed document form34
	When user calls HPC "Dms_View" API with "Post" http request
	Then the HPC API call got success with status code 200	
	
	Scenario: Verify Dms_List API
  Given Get details using Dms_List for RC
	When user calls HPC "Dms_List" API with "Post" http request
	Then the HPC API call got success with status code 200
	
	Scenario: Verify Finalsubmitduprc API for HPA
  Given Use Finalsubmitduprc for HPA
	When user calls HPC "Finalsubmitduprc" API with "Post" http request
	Then the HPC API call got success with status code 200	
	
	Scenario: Verify CheckPaymentStatus API for HPA
  Given Use CheckPaymentStatus for HPA
	When user calls HPC "PaymentStatus" API with "Post" http request
	Then the HPC API call got success with status code 200



