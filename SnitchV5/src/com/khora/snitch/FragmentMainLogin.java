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

	private UiLifecycleHelper uiHelper;

	private Session.StatusCallback callback = new Session.StatusCallback() {
		@Override
		public void call(Session session, SessionState state,
				Exception exception) {
			onSessionStateChange(session, state, exception);
		}
	};

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		uiHelper = new UiLifecycleHelper(getActivity(), callback);
		uiHelper.onCreate(savedInstanceState);

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
		LoginButton authButton = (LoginButton) v.findViewById(R.id.authButton);
		authButton.setBackgroundResource(R.drawable.button_facebook_login);
		authButton.setReadPermissions(Arrays.asList("email", "user_status"));
		authButton.setFragment(this);

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

	private void onSessionStateChange(Session session, SessionState state,
			Exception exception) {
		List<String> permissions = new ArrayList<String>();
		permissions.add("email");
		Session.openActiveSession(getActivity(), true, new StatusCallback() {

			@Override
			public void call(Session session, SessionState state,
					Exception exception) {
				// TODO Auto-generated method stub
				if (session.isOpened()) {
					Request.newMeRequest(session,
							new Request.GraphUserCallback() {

								
								@Override
								public void onCompleted(GraphUser user,
										Response response) {
									if (user != null) {
										
										
										
										String firstName = user.getFirstName();
										String lastName = user.getLastName();
										String id = user.getId();
										String email = user
												.getProperty("email")
												.toString();

										Log.e("facebookid", id);
										Log.e("firstName", firstName);
										Log.e("lastName", lastName);
										Log.e("email", email);

									}
								}
							}).executeAsync();

				}
			}
		});

	}

	@Override
	public void onResume() {
		super.onResume();
		Session session = Session.getActiveSession();
		if (session != null && (session.isOpened() || session.isClosed())) {
			onSessionStateChange(session, session.getState(), null);
		}

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
