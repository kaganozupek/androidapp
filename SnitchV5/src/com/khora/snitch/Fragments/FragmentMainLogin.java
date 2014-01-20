package com.khora.snitch.Fragments;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;
import com.facebook.widget.LoginButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.khora.snitch.R;
import com.khora.snitch.Activities.LoginEmailActivity;
import com.khora.snitch.Activities.SignupEmailActivity;
import com.khora.snitch.HttpRequests.RequestLoginWithFacebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethod.SessionCallback;
import android.view.inputmethod.InputMethodSession;
import android.widget.Button;
import android.widget.TextView;

public class FragmentMainLogin extends Fragment implements View.OnClickListener  {
	private static final String TAG = "MainFragment";
	private UiLifecycleHelper uiHelper;
	View v;
	private Session.StatusCallback callback = new Session.StatusCallback() {

		@Override
		public void call(Session session, SessionState state,
				Exception exception) {

			if (session.isOpened()) {

				Request rqst = Request.newMeRequest(session,
						new Request.GraphUserCallback() {

							// callback after Graph API response with user
							// object
							@Override
							public void onCompleted(GraphUser user,
									Response response) {
								if (user != null) {
									GsonBuilder builder = new GsonBuilder();
									Gson gson = builder.create();
									RequestLoginWithFacebook loginRequest = new RequestLoginWithFacebook();
									loginRequest.setuFirstName(user
											.getFirstName());
									loginRequest.setuLastName(user
											.getLastName());
									loginRequest.setuBirthDate(user
											.getBirthday());
									loginRequest.setuEmail((String) user
											.asMap().get("email"));
									loginRequest.setuFacebookId(user.getId());
									
									try {
										loginRequest.setuProfilePcirtureURL(new URL("http://graph.facebook.com/"+user.getId()+"/picture?style=small").toString());
									} catch (MalformedURLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
									String jsonReques = gson.toJson(loginRequest);
									
									
									
									
									


								}
							}
						});

				rqst.executeAsync();

			}

			onSessionStateChange(session, state, exception);

		}
	};
	

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		uiHelper = new UiLifecycleHelper(getActivity(), callback);
		uiHelper.onCreate(savedInstanceState);
		Session currentSession = Session.getActiveSession();
		currentSession.closeAndClearTokenInformation();

	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		v = inflater.inflate(R.layout.fragment_main_login, container,
				false);

		// VIew implementations
		Button btnSubmitMail = (Button) v.findViewById(R.id.btnSubmitEmail);
		TextView tvLoginMail = (TextView) v.findViewById(R.id.tvLoginMail);
		LoginButton authButton = (LoginButton) v.findViewById(R.id.authButton);
		
		authButton.setFragment(this);
		authButton.setReadPermissions(Arrays.asList("user_likes",
				"user_status", "email", "user_birthday"));
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

			Intent i = new Intent(getActivity(), SignupEmailActivity.class);
			startActivity(i);

			break;
		}
		case R.id.tvLoginMail: {
			Intent i = new Intent(getActivity(),LoginEmailActivity.class);
			startActivity(i);
			
		}

		}

	}

	private void onSessionStateChange(Session session, SessionState state,
			Exception exception) {
		if (state.isOpened()) {

			Log.i(TAG, "name : LOGIN");

		} else if (state.isClosed()) {
			Log.i(TAG, "Logged out...");
		}
	}

	@Override
	public void onResume() {
		super.onResume();

		uiHelper.onResume();

		uiHelper.onResume();
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		uiHelper.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onPause() {
		super.onPause();
		uiHelper.onPause();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		uiHelper.onDestroy();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		uiHelper.onSaveInstanceState(outState);
	}

	
}
