package com.khora.snitch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;
import com.facebook.widget.LoginButton;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentMainLogin extends Fragment implements View.OnClickListener {

	

	

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.fragment_main_login, container,
				false);

		// VIew implementations
		Button btnSubmitMail = (Button) v.findViewById(R.id.btnSubmitEmail);
		TextView tvLoginMail = (TextView) v.findViewById(R.id.tvLoginMail);
		

		// View setClick listeners

		btnSubmitMail.setOnClickListener(this);
		tvLoginMail.setOnClickListener(this);
		return v;

	}

	// clickListener
	@Override
	public void onClick(View v) {
		int idView = v.getId();

		switch (idView) {
		case R.id.btnSubmitEmail: {

			Intent i = new Intent(getActivity(), ActivitySubmitEmail.class);
			startActivity(i);

			break;
		}
		case R.id.tvLoginMail: {

		}

		}

	}

}
