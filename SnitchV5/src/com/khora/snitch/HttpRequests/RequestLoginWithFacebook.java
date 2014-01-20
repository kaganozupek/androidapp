package com.khora.snitch.HttpRequests;

public class RequestLoginWithFacebook {
	private String RequestType = "FacebookLoginRequest";
	private String uFirstName;
	private String uLastName;
	private String uProfilePcirtureURL;
	
	public String getuProfilePcirtureURL() {
		return uProfilePcirtureURL;
	}
	public void setuProfilePcirtureURL(String uProfilePcirtureURL) {
		this.uProfilePcirtureURL = uProfilePcirtureURL;
	}
	public String getuFirstName() {
		return uFirstName;
	}
	public void setuFirstName(String uFirstName) {
		this.uFirstName = uFirstName;
	}
	public String getuLastName() {
		return uLastName;
	}
	public void setuLastName(String uLastName) {
		this.uLastName = uLastName;
	}
	
	private String uEmail;
	private String uBirthDate;
	public String getRequestType() {
		return RequestType;
	}
	public void setRequestType(String requestType) {
		RequestType = requestType;
	}
	
	
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public String getuBirthDate() {
		return uBirthDate;
	}
	public void setuBirthDate(String uBirthDate) {
		this.uBirthDate = uBirthDate;
	}
	public String getuFacebookId() {
		return uFacebookId;
	}
	public void setuFacebookId(String uFacebookId) {
		this.uFacebookId = uFacebookId;
	}
	private String uFacebookId;
	
	
}
