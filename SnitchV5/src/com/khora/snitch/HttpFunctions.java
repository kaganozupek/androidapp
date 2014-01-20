package com.khora.snitch;

import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.khora.snitch.Entitiy.User;
import com.khora.snitch.HttpRequests.LoginRequest;
import com.khora.snitch.HttpResponses.LoginResponse;

public class HttpFunctions {

	public static LoginResponse LoginWithEmail(LoginRequest Request) {
		HttpClient client = new DefaultHttpClient();
		Bundle resultBnd = new Bundle();
		String RequestString = "";
		GsonBuilder builder = new GsonBuilder();
		Gson gson;
		gson = builder.create();
		try {
			String url = "http://94.122.225.25/AdminPage/api/mobile/LoginRequest";
			RequestString = gson.toJson(Request);
			HttpPost post = new HttpPost(url);
			StringEntity se = new StringEntity(RequestString);

			post.setEntity(se);

			post.setHeader("Content-type", "application/json");

			HttpResponse response = client.execute(post);
			InputStream stream = response.getEntity().getContent();
			String resultString = StaticFunctions.convertStreamToString(stream);
			LoginResponse Loginresponse = gson.fromJson(resultString, LoginResponse.class);
		
			return Loginresponse;
			
						
		

		} catch (Exception e) {
			
			return null;

		}
		
	}
	
	
	
	public static Bundle loginWithFacebook(String JsonRequest) {
		HttpClient client = new DefaultHttpClient();
		Bundle resultBnd = new Bundle();
		
		
		try {
			
			String url = "http://94.122.121.242/AdminPage/api/mobileHttpHandle/LoginRequest";
			
			HttpPost post = new HttpPost(url);
			StringEntity se = new StringEntity(JsonRequest);

			post.setEntity(se);

			post.setHeader("Content-type", "application/json");

			HttpResponse response = client.execute(post);
			InputStream stream = response.getEntity().getContent();
			String resultString = StaticFunctions.convertStreamToString(stream);
			GsonBuilder gsonb = new GsonBuilder();
			Gson gson = gsonb.create();
			//Response objesi olusturulacak o obje geri dondurulecek
			

		} catch (Exception e) {
			
		
			

		}
		return resultBnd ;
	}


}
