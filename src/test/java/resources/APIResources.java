package resources;

public enum APIResources {
	
	//Dispose API
	 ListOFDisposeAppl("vahancapi-dispose/getListOfDisposeApplication/{regn_no}/{appl_no}/{otp}"),
	 DetailsDiposeAppl("/vahancapi-dispose/detaildisposeapplication/{regn_no}/{chasi_no}/{appl_no}"),
	 DisposeAPPL("vahancapi-dispose/disposeApplication"),
	
	 //HPC API
	 GetState_cdandOff_cd("vahancapi-masterconfig/masterConfig/getstate_cdOffcd/{regn_no}"),
	 getownerDetailsInurancePuccPermit("vahancapi-common/api/getownerDetailsInurancePuccPermit/{regn_no}/{stateCd}/{chasi_no}"),
	 fillvmonlineservicechecksdata("vahancapi-masterconfig/masterConfig/fillvmonlineservicechecksdata/{stateCd}"),
	 validateregandchasino("vahancapi-common/api/validateregandchasino/{regn_no}/{chasi_no}/{stateCd}/{pur_cd}"),
	 GenerateOtp("vahancapi-common/api/generateOtp"),
	 VerifyOtp("vahancapi-common/api/verifyOtp"),
	 Getfeedetails("vahancapi-common/api/getfeedetails/{regn_no}/{stateCd}/{pur_cd}"),
	 Beforepayment("vahancapi-common/beforepayment"),
	 Afterpayment("vahancapi-common/afterpayment/{paymentToken}"),
	 Printreciept("vahancapi-common/printreciept/{state_cd}/{off_cd}/{transaction_no}/{reg_no}/{pur_cd}"),
	 Dms_config("vahancapi-dms-client/dms/config/v1.0"),
	 Dms_Upload("vahancapi-dms-client/dms/upload/v1.0"),
	 Dms_View("vahancapi-dms-client/dms/view/v1.0"),
	 Dms_List("vahancapi-dms-client/dms/list/v1.0"),
	 Dms_Update("vahancapi-dms-client/dms/update/v1.0"),
	 Fillvmonlineconfigurationdata("vahancapi-masterconfig/masterConfig/fillvmonlineconfigurationdata/{state_cd}"),
	 Finalsubmitduprc("vahancapi-common/finalsubmitduprc"),
	// Duplicate Permit API
	
	Permit_Document_List("vahancapi-permit/api/getPermitDocumentList/{regn_no}/{stateCd}"),
	Dup_Permit_Draft("vahancapi-permit/api/duppermitdraft");
	
	
	
	
	 private String resource;
		
		APIResources(String resource)
		{
			this.resource=resource;
		}
		
		public String getResource()
		{
			return resource;
		}
}
