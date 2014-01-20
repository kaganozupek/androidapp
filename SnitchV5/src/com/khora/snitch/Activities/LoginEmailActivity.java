package com.khora.snitch.Activities;

import com.khora.snitch.R;
import com.khora.snitch.Fragments.FragmentSubmitEmail;
import com.khora.snitch.HttpRequests.RequestSignUp;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class LoginEmailActivity extends ActionBarActivity {
	public DrawerLayout mDrawerLayout;
	public FrameLayout drawerLayout;
	public FrameLayout fragmentContainer;
	public int currentFragment;
	public static RequestSignUp signUpRequest;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		getSupportActionBar().setCustomView(R.layout.abs_layout);
		setContentView(R.layout.activity_login_email);
		
		// Navigation Drawer Settings
		mDrawerLayout = (DrawerLayout) findViewById(R.id.layout_navigation_drawer);
		drawerLayout = (FrameLayout) findViewById(R.id.left_drawer);
		// Fragment Container Settings
		

		// ActionBarButtonSettings
		Button ActionBarDrawerButton = (Button) findViewById(R.id.btnOpenDrawer);
		ActionBarDrawerButton.setVisibility(Button.GONE);

		// Initialize Request Veriable
		

		
		
	}
	public void btnPrevPressedForSubmitEmailFragment(View v) {

		finish();
	}


}
