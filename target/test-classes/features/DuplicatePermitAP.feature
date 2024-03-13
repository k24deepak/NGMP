Feature: Validation HPC API's
	
	Scenario: Verify Afterpayment API for success UI URL using response
  Given Use Afterpayment for success UI URL using response "<responsecode>"
	When user calls HPC "Afterpayment" API with "Get" http request
	Then the HPC API call got success with status code 200	
	
	Examples:
				|             responsecode		   																											|  
				| 		       	GJ01AT2772 																															|
				
#	Scenario: Verify Fillvmonlineconfigurationdata API
 # Given Get details using Fillvmonlineconfigurationdata 
#	When user calls HPC "Fillvmonlineconfigurationdata" API with "Get" http request
#	Then the HPC API call got success with status code 200	
		
	Scenario: Verify Dms_config API
  Given Get details using Dms_config 
	When user calls HPC "Dms_config" API with "Post" http request
	Then the HPC API call got success with status code 200	s
	And "stateCd" in response body of Dms_config is "GJ"
	
		 Scenario: Verify Dms_Upload API
  Given Get details using Dms_Upload for AFFDQ
	When user calls HPC "Dms_Upload" API with "Post" http request
	Then the HPC API call got success with status code 200	
	And "stateCd" in response body of Dms_Upload AFFDQ is "GJ"
	
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
  Given Get details using Dms_List for AFFDQ
	When user calls HPC "Dms_List" API with "Post" http request
	Then the HPC API call got success with status code 200
				
#	Scenario: Verify Finalsubmitduprc API
 # Given Get details using Finalsubmitduprc 
#	When user calls HPC "Finalsubmitduprc" API with "Post" http request
#	Then the HPC API call got success with status code 200	
				


