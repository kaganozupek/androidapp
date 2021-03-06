package com.khora.snitch.Fragments;

import com.khora.snitch.R;
import com.khora.snitch.Activities.SignupEmailActivity;
import com.khora.snitch.R.id;
import com.khora.snitch.R.layout;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class FragmentSubmitEmailNext extends Fragment {
	
	
	public static EditText Email;
	public static EditText Password;
	public  static EditText PhoneNumber;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View fragmentView = inflater.inflate(R.layout.fragment_submit_email_next, container,false);
		//View Implementations
		 Email = (EditText) fragmentView.findViewById(R.id.etMail2);
		 Password = (EditText) fragmentView.findViewById(R.id.etPassword);
		 PhoneNumber = (EditText) fragmentView.findViewById(R.id.etPhoneNumber);
		
		
		//ACtion bar settings
		Button prevBtn = (Button) getActivity().findViewById(
				R.id.btnPrevForSubmitEmailFragment);
		Button nextBtn = (Button) getActivity().findViewById(
				R.id.btnNextForSubmitEmailFragment);
		Button finishBtn = (Button) getActivity().findViewById(
				R.id.btnFinishForSubmitEmailNextFragment);
		
		prevBtn.setVisibility(View.VISIBLE);
		nextBtn.setVisibility(View.GONE);
		finishBtn.setVisibility(View.VISIBLE);
		//If fields not empy fill them
		
		if(SignupEmailActivity.signUpRequest.getEmail() != null)
		{
			Email.setText(SignupEmailActivity.signUpRequest.getEmail().toString());
			
		}
		if(SignupEmailActivity.signUpRequest.getPassword() != null)
		{
			Password.setText(SignupEmailActivity.signUpRequest.getPassword().toString());
			
		}
		if(SignupEmailActivity.signUpRequest.getPhoneNumber() != null)
		{
			PhoneNumber.setText(SignupEmailActivity.signUpRequest.getPhoneNumber().toString());
			
		}
		
		
		
		
		return fragmentView;
	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		//Save Instances
		
		SignupEmailActivity.signUpRequest.setEmail(Email.getText().toString());
		SignupEmailActivity.signUpRequest.setPassword(Password.getText().toString());
		SignupEmailActivity.signUpRequest.setPhoneNumber(PhoneNumber.getText().toString());
		
		
		
	
	
	}
	
	
	
	public static Fragment newInstance() {
		FragmentSubmitEmailNext mFrgment = new FragmentSubmitEmailNext();
		return mFrgment;
	}


}
