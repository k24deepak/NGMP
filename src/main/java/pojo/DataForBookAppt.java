package pojo;

import java.util.List;

public class DataForBookAppt {
	
	private String appl_no;
	private String book_dt;
	private String off_cd;
	private String regn_no;
	private List<String> sel_services;
	private String state_cd;
	
	public String getAppl_no() {
		return appl_no;
	}
	public void setAppl_no(String appl_no) {
		this.appl_no = appl_no;
	}
	public String getBook_dt() {
		return book_dt;
	}
	public void setBook_dt(String book_dt) {
		this.book_dt = book_dt;
	}
	public String getOff_cd() {
		return off_cd;
	}
	public void setOff_cd(String off_cd) {
		this.off_cd = off_cd;
	}
	public String getRegn_no() {
		return regn_no;
	}
	public void setRegn_no(String regn_no) {
		this.regn_no = regn_no;
	}
	public List<String> getSel_services() {
		return sel_services;
	}
	public void setSel_services(List<String> sel_services) {
		this.sel_services = sel_services;
	}
	public String getState_cd() {
		return state_cd;
	}
	public void setState_cd(String state_cd) {
		this.state_cd = state_cd;
	}
	

}
