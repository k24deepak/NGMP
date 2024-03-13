package pojo;

import java.util.List;

public class GenerateOTPPayload {
	
	private String aadharNo;
	private String aadharType;
	private String chasiNo;
	private String eKYC;
	private String mobileNo;
	private String otpGenerated;
	private List<String> purCd;
	
	public List<String> getPurCd() {
		return purCd;
	}
	public void setPurCd(List<String> purCd) {
		this.purCd = purCd;
	}
	private String regNo;
	private String stateCd;
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	public String getAadharType() {
		return aadharType;
	}
	public void setAadharType(String aadharType) {
		this.aadharType = aadharType;
	}
	public String getChasiNo() {
		return chasiNo;
	}
	public void setChasiNo(String chasiNo) {
		this.chasiNo = chasiNo;
	}
	public String geteKYC() {
		return eKYC;
	}
	public void seteKYC(String eKYC) {
		this.eKYC = eKYC;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getOtpGenerated() {
		return otpGenerated;
	}
	public void setOtpGenerated(String otpGenerated) {
		this.otpGenerated = otpGenerated;
	}

	
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public String getStateCd() {
		return stateCd;
	}
	public void setStateCd(String stateCd) {
		this.stateCd = stateCd;
	}
	
}
