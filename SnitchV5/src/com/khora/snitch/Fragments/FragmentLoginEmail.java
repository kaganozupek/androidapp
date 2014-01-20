package com.khora.snitch.Fragments;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.khora.snitch.HttpFunctions;
import com.khora.snitch.R;
import com.khora.snitch.StaticFunctions;
import com.khora.snitch.Activities.HomeActivity;
import com.khora.snitch.Activities.LoginEmailActivity;
import com.khora.snitch.Activities.SignupEmailActivity;
import com.khora.snitch.HttpRequests.LoginRequest;
import com.khora.snitch.HttpResponses.LoginResponse;
import com.khora.snitch.Views.VievCustomDialog;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class FragmentLoginEmail extends Fragment implements OnClickListener {
	private EditText etEmail;
	private EditText etPassword;
	private Button btnLogin;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View fragmentView = inflater.inflate(R.layout.fragment_login_email,
				container, false);
		// View Implementations

		// Actionbar Settings
		Button prevBtn = (Button) getActivity().findViewById(
				R.id.btnPrevForSubmitEmailFragment);
		Button nextBtn = (Button) getActivity().findViewById(
				R.id.btnNextForSubmitEmailFragment);
		Button finishBtn = (Button) getActivity().findViewById(
				R.id.btnFinishForSubmitEmailNextFragment);

		prevBtn.setVisibility(View.VISIBLE);
		nextBtn.setVisibility(View.GONE);
		finishBtn.setVisibility(View.GONE);

		// View Implementations

		etEmail = (EditText) fragmentView.findViewById(R.id.etMailForLoging);
		etPassword = (EditText) fragmentView
				.findViewById(R.id.etPasswordForLogin);
		btnLogin = (Button) fragmentView.findViewById(R.id.btnLogin);

		// View On Click Events
		btnLogin.setOnClickListener(this);

		// Initialize Views for Instance State

		return fragmentView;
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		switch (id) {
		case R.id.btnLogin:// Login Button Pressed
		{
			String FailNameSurname = "Lütfen Adınızı ve Soyadınızı Birer boşluk bırakarak yazınız";
			String FailPassword = "Lütfen şifrenizi Türkçe karakter kullanmadan ve en az 6 hane olacak şekilde yazın";
			String FailEmail = "Mail adresi geçerli değil. Lütfen uygun bir mail adresi yazın";
			boolean isFailNameSurname, isFailPassword, isFailEmail;
			// String Email = etEmail.getText().toString();
			// String Password = etPassword.getText().toString();
			String Email = "gorkemkeles@a.com";
			String Password = "12345";

			// Check For a Valid Email

			if (Password.equals(""))
				isFailPassword = true;
			else
				isFailPassword = false;
			if (Email.equals("") || !StaticFunctions.isEmailValid(Email))
				isFailEmail = true;
			else
				isFailEmail = false;

			// Şifre türkçe karakter içeriyor mu onu kontrol et

			if (isFailEmail || isFailPassword) {
				VievCustomDialog dialog = new VievCustomDialog(getActivity());

				TextView tvWarning = (TextView) dialog
						.findViewById(R.id.tvWarning);
				String warning = "";

				if (isFailEmail) {
					warning += "  - " + FailEmail + "\n\n";

				}
				if (isFailPassword) {
					warning += "  - " + FailPassword + "\n\n";

				}
				tvWarning.setText(warning);
				dialog.show();

			} else {

				// Success

				final LoginRequest loginRequest = new LoginRequest();
				loginRequest.setuEmail(Email);
				loginRequest.setuPassword(Password);

				AsyncTask<String, String, String> LoginTask = new AsyncTask<String, String, String>() {
					LoginResponse loginResponse = new LoginResponse();
					
					@Override
					protected void onPreExecute() {
						// TODO Auto-generated method stub
						super.onPreExecute();
						StaticFunctions
								.createPleaseWaitDialog(FragmentLoginEmail.this);

					}

					@Override
					protected String doInBackground(String... params) {

						loginResponse = HttpFunctions
								.LoginWithEmail(loginRequest);

						return null;
					}

					@Override
					protected void onPostExecute(String result) {
						// TODO Auto-generated method stub
						super.onPostExecute(result);

						if (loginResponse.IsLoginSuccess) {
							GsonBuilder builder = new GsonBuilder();
							Gson gson = builder.create();
							String loggedUser = gson.toJson(loginResponse.User);
							
							Intent i = new Intent(getActivity(),
									HomeActivity.class);
							i.putExtra("LoggedUser", loggedUser);
							
							startActivity(i);

						} else {

						}
					}
				};

				LoginTask.execute(null, null, null);
			}

		}

		}

	}

}
