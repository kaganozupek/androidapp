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

public class HttpFunctions {

	public static Bundle checkLogin(final String email, final String password) {
		HttpClient client = new DefaultHttpClient();
		Bundle resultBnd = new Bundle();
		String Request = "";
		JSONObject requestObject = new JSONObject();
		try {
			requestObject.put("RequestType", "LoginRequest");
			requestObject.put("email", "kubra_tugsal@hotmail.com");
			requestObject.put("password", "qaz123");
			String url = "http://94.122.121.242/AdminPage/api/mobileHttpHandle/LoginRequest";
			Request = requestObject.toString();
			HttpPost post = new HttpPost(url);
			StringEntity se = new StringEntity(requestObject.toString());

			post.setEntity(se);

			post.setHeader("Content-type", "application/json");

			HttpResponse response = client.execute(post);
			InputStream stream = response.getEntity().getContent();
			String resultString = StaticFunctions.convertStreamToString(stream);
			GsonBuilder gsonb = new GsonBuilder();
			Gson gson = gsonb.create();
			//ModelUser user = gson.fromJson(resultString, ModelUser.class);

		
			//String jsonObject = gson.toJson(user);
		
			
			//resultBnd.putString("LoggedUser", jsonObject);
			resultBnd.putString("resultCode", "SUCCESS");
		

		} catch (Exception e) {
			
			resultBnd.putString("resultCode", "FAILED");
			

		}
		return resultBnd ;
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
