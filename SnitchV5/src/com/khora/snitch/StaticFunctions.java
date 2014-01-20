package com.khora.snitch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.khora.snitch.Views.VievCustomDialog;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class StaticFunctions {
	

	
	public static int convertDiptoPix(int dip, Context x) {
		float scale = x.getResources().getDisplayMetrics().density;
		return (int) ((dip - 0.5f) / scale);
	}
	public static String convertStreamToString(InputStream is) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {

		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();

			}
		}
		return sb.toString();

	}
	public static boolean isEmailValid(String email) {
		boolean isValid = false;

		String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		CharSequence inputStr = email;

		Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(inputStr);
		if (matcher.matches()) {
			isValid = true;
		}
		return isValid;
	}
	public static void createPleaseWaitDialog(Fragment sender)
	{
		VievCustomDialog dialog = new VievCustomDialog(
				sender.getActivity());
		LinearLayout dialogLayout = (LinearLayout) dialog
				.findViewById(R.id.dialogLayout);
		TextView tx = new TextView(sender.getActivity());
		tx.setText("Lütfen Bekleyin");
		tx.setGravity(Gravity.CENTER);
		tx.setTextSize(StaticFunctions.convertDiptoPix(50, sender.getActivity()));
		tx.setTextColor(sender.getResources().getColor(R.color.Red));
		ProgressBar progresBar = new ProgressBar(sender.getActivity());
		
		dialogLayout.removeAllViews();
		dialogLayout.addView(tx);
		dialogLayout.addView(progresBar);
		dialog.setCancelable(false);
		dialog.show();
		
	}

	

}
