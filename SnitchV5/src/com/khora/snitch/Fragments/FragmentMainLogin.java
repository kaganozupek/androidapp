package com.khora.snitch.Fragments;

import com.facebook.Request;
import com.facebook.Request.GraphUserCallback;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;
import com.facebook.widget.LoginButton;
import com.khora.snitch.R;
import com.khora.snitch.Activities.ActivitySubmitEmail;
import com.khora.snitch.R.id;
import com.khora.snitch.R.layout;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.TextView;

public class FragmentMainLogin extends Fragment implements View.OnClickListener {
	private static final String TAG = "MainFragment";
	private UiLifecycleHelper uiHelper;

	private Session.StatusCallback callback = new Session.StatusCallback() {
		@SuppressWarnings("deprecation")
		@Override
		public void call(Session session, SessionState state,
				Exception exception) {

			if (session.isOpened()) {
				
				Request rqst = Request.newMeRequest(session, new Request.GraphUserCallback() {

					  // callback after Graph API response with user object
					  @Override
					  public void onCompleted(GraphUser user, Response response) {
					    if (user != null) {
					    	
					    	String name = user.getName();
					    	Log.i(TAG, name);
					    	
					      
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
		Session.getActiveSession().close();
		
		
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

	@SuppressWarnings("unused")
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
