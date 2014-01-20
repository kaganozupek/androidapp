package com.khora.snitch.Fragments;

import com.khora.snitch.HttpFunctions;
import com.khora.snitch.R;
import com.khora.snitch.StaticFunctions;
import com.khora.snitch.Activities.ActivityLoginEmail;
import com.khora.snitch.Activities.ActivitySubmitEmail;
import com.khora.snitch.HttpRequests.LoginRequest;
import com.khora.snitch.Views.VievCustomDialog;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
			String Email = etEmail.getText().toString();
			String Password = etPassword.getText().toString();

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
				LoginRequest loginRequest = new LoginRequest();
				loginRequest.setuEmail(Email);
				loginRequest.setuPassword(Password);
				
				HttpFunctions.LoginWithEmail(loginRequest);
			}

		}

		}

	}

}
