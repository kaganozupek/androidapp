package com.khora.snitch.Entitiy;

import java.sql.Date;

public class User {
	public int id;
	public String Name;
	public String Last_name;
	public Date Birth_date;
	public String Email;
	public String Phone;
	public String Password;
	public Boolean Is_active;
	public int Ban_count;
	
	public Date Ban_date;
	//public int Is_verified;
	public String Invite_code;
	public String Invited_by;
	public String Facebook_id;
	public String Twitter_id;
	public Date In_time;
	public Date Up_time;
	public String Current_Token;
}
