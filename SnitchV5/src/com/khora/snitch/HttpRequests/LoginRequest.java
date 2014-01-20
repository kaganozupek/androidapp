package com.khora.snitch.HttpRequests;

public class LoginRequest {
	private String Email;
	private String Password;
	private String RequestType="LoginWithEmail";
	
	
	public String getuEmail() {
		return Email;
	}
	public void setuEmail(String uEmail) {
		this.Email = uEmail;
	}
	public String getuPassword() {
		return Password;
	}
	public void setuPassword(String uPassword) {
		this.Password = uPassword;
	}
	public String getRequestType() {
		return RequestType;
	}
	public void setRequestType(String requestType) {
		RequestType = requestType;
	}
	
	

}
