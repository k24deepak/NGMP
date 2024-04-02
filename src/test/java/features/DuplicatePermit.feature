Feature: Validating of duplicate permit flow API
	
	Scenario: verify regandchassisno validation api
  Given Use duplicat permit using "<VehNo>" "<chassis No>" "<State_Cd>" "<Pur_cd>"
  When user calls HPC "validateregandchasino" API with "Get" http request
	Then the HPC API call got success with status code 200
	And "stateCd" in  body of validateregandchasino Of duplicat permit flow  is "GJ"	
	
	Examples:
				| VehNo		   |  chassis No |	State_Cd |  Pur_cd |
				| GJ23W2575  | 		02981		 |	  GJ 		 |		34	 |
				
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
	
	Scenario: Verify GetPermit fee details API
  Given Use GetPermitFeeDetails Api for Fees 
	When user calls HPC "GetPermitFeeDetails" API with "Post" http request
	Then the HPC API call got success with status code 200		
				
	Scenario: Verify Beforepayment API of Duplicate permit
  Given Beforepayment of Duplicate permit
	When user calls HPC "Beforepayment" API with "Post" http request
	Then the HPC API call got success with status code 200	
	And Get the URL payment link in the body
	
	Scenario: Verify Afterpayment API of HPA Pemrit
  Given AP of HPA permit 
	When user calls HPC "Afterpayment" API with "Get" http request
	Then the HPC API call got success with status code 200	
	
		Scenario: Verify Fillvmonlineconfigurationdata API
  Given Get details using Fillvmonlineconfigurationdata 
	When user calls HPC "Fillvmonlineconfigurationdata" API with "Get" http request
 Then the HPC API call got success with status code 200	
		
	Scenario: Verify Dms_config api for duplicate permit 
  Given Use Dms_config for duplicate permit
	When user calls HPC "Dms_config" API with "Post" http request
	Then the HPC API call got success with status code 200
	And "stateCd" in response body of Dms_config of duplicate permit is "GJ"
	
		 Scenario: Verify Dms_Upload API
  Given Get details using Dms_Upload for AFFDQ
	When user calls HPC "Dms_Upload" API with "Post" http request
	Then the HPC API call got success with status code 200	
	And "stateCd" in response body of Dms_Upload AFFDQ is "GJ"
	
	Scenario: Verify Dms_Upload API
  Given Get details using Dms_Upload for AP
	When user calls HPC "Dms_Upload" API with "Post" http request
	Then the HPC API call got success with status code 200	
	And "stateCd" in response body of Dms_Upload AP is "GJ"
	
	 Scenario: Verify Dms_Upload API
  Given Get details using Dms_Upload for LIPD
	When user calls HPC "Dms_Upload" API with "Post" http request
	Then the HPC API call got success with status code 200	
	And "stateCd" in response body of Dms_Upload LIPD is "GJ"
	
	 Scenario: Verify Dms_Upload API
  Given Get details using Dms_Upload for PCSD
	When user calls HPC "Dms_Upload" API with "Post" http request
	Then the HPC API call got success with status code 200	
	And "stateCd" in response body of Dms_Upload PCSD is "GJ"
	
	 Scenario: Verify Dms_Upload API
  Given Get details using Dms_Upload for POT1Y
	When user calls HPC "Dms_Upload" API with "Post" http request
	Then the HPC API call got success with status code 200	
	And "stateCd" in response body of Dms_Upload POT1Y is "GJ"
	
	Scenario: Verify Dms_Upload API
  Given Get details using Dms_Upload for VINP
	When user calls HPC "Dms_Upload" API with "Post" http request
	Then the HPC API call got success with status code 200	
	And "stateCd" in response body of Dms_Upload VINP is "GJ"
	
	Scenario: Verify Dms_View API
  Given Get details using Dms_View for AFFDQ
	When user calls HPC "Dms_View" API with "Post" http request
	Then the HPC API call got success with status code 200	
	
	Scenario: Verify Dms_List API
  Given Get details using Dms_List for duplicate permit
	When user calls HPC "Dms_List" API with "Post" http request
	Then the HPC API call got success with status code 200
				
	Scenario: Verify Finalsubmitduprc API for duplicate permit
  Given Use Finalsubmitduprc for duplicate permits
	When user calls HPC "permitFinalSubmit" API with "Post" http request
	Then the HPC API call got success with status code 200	

#	Scenario: Verify CheckPaymentStatus API for HPA
#  Given Use CheckPaymentStatus for HPA
#	When user calls HPC "PaymentStatus" API with "Get" http request
#	Then the HPC API call got success with status code 200
	
#	Scenario: Verify Get_Appt_Config_data API for HPA
#  Given Use Get_Appt_Config_data for HPA
#	When user calls HPC "Get_Appt_Config_data" API with "Get" http request
#	Then the HPC API call got success with status code 200
	
#	Scenario: Verify Get_Days API for HPA
#  Given Use Get_Days for HPA
#	When user calls HPC "Get_Days" API with "Get" http request
#	Then the HPC API call got success with status code 200
	
#	Scenario: Verify Get_User_Details_dobj API for HPA
#  Given Use Get_User_Details_dobj for HPA
#	When user calls HPC "Get_User_Details_dobj" API with "Get" http request
#	Then the HPC API call got success with status code 200
#	And "stateCd" in response body of Get_User_Details_dobj api is "GJ"
