package com.khora.snitch.Activities;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.khora.snitch.R;
import com.khora.snitch.Entitiy.User;
import com.khora.snitch.Fragments.FragmentSubmitEmail;
import com.khora.snitch.Fragments.HomeFragment;
import com.khora.snitch.Fragments.MySnitchFragment;
import com.khora.snitch.Fragments.NotificationFragment;
import com.khora.snitch.Fragments.PlacesFragment;
import com.khora.snitch.Fragments.SnitchFragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class HomeActivity extends ActionBarActivity implements OnClickListener {
	public DrawerLayout mDrawerLayout;
	public FrameLayout drawerLayout;
	public int currentFragment;
	public User loggedUser;
	public GsonBuilder builder;
	public Gson gson;
	private RadioGroup tabGroup;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		// GetLoggedUser
		Bundle bundle = getIntent().getExtras();
		String userJson = bundle.getString("LoggedUser");
		System.out.println("");

		builder = new GsonBuilder();
		gson = builder.create();

		Intent i = getIntent();
		loggedUser = gson.fromJson(i.getStringExtra("LoggedUser"), User.class);
		//

		// Drawer And Actionbar Settings
		getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		getSupportActionBar().setCustomView(R.layout.abs_layout);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.layout_navigation_drawer);
		drawerLayout = (FrameLayout) findViewById(R.id.left_drawer);
		//

		// TabButtons Configuration
		tabGroup = (RadioGroup) findViewById(R.id.tabGroup);
		RadioButton btnSnitches = (RadioButton) findViewById(R.id.rdSnitches);
		RadioButton btnPlaces = (RadioButton) findViewById(R.id.rdPlaces);
		RadioButton btnNotifications = (RadioButton) findViewById(R.id.rdNotifications);
		RadioButton btnMySnitches = (RadioButton) findViewById(R.id.rdMySnicthes);
		btnSnitches.setOnClickListener(this);
		btnPlaces.setOnClickListener(this);
		btnNotifications.setOnClickListener(this);
		btnMySnitches.setOnClickListener(this);

		// Set First Fragment

		android.support.v4.app.Fragment fragment = HomeFragment.newInstance();

		changeFragment(fragment);
		currentFragment = 1;
		tabGroup.clearCheck();
		
		
		Geocoder gcd = new Geocoder(this, Locale.getDefault());
		List<Address> addresses = null;
		try {
			addresses = gcd.getFromLocation(0, 0, 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (addresses.size() > 0) 
			
			System.out.println(addresses.get(0).getLocality());
	}

	public void openDrawer() {

		mDrawerLayout.openDrawer(drawerLayout);
	}

	public void DrawerOpenClickEvent(View v) {

		openDrawer();

	}

	public void HomeButtonPressed(View v) {
		System.out.println("");
	}

	public void btnHomePressed(View v) {
		if (currentFragment != 1) {

			android.support.v4.app.Fragment fragment = HomeFragment
					.newInstance();

			changeFragment(fragment);
			currentFragment = 1;
			tabGroup.clearCheck();
		}

	}

	public void changeFragment(Fragment fragment) {
		android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
		android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager
				.beginTransaction();

		fragmentTransaction.replace(R.id.fragmentContainerHome, fragment);
		fragmentTransaction.commit();

	}

	public void btnQuestionPressed(View v) {

	}

	@Override
	public void onClick(View v) {

		System.out.println("");
		switch (v.getId()) {

		case R.id.rdSnitches: {

			if (currentFragment != 2) {

				android.support.v4.app.Fragment fragment = SnitchFragment
						.newInstance();

				changeFragment(fragment);
				currentFragment = 2;
			}

			break;
		}
		case R.id.rdPlaces: {
			
			if (currentFragment != 3) {

				android.support.v4.app.Fragment fragment = PlacesFragment
						.newInstance();

				changeFragment(fragment);
				currentFragment = 3;
			}

			break;
		}
		case R.id.rdNotifications: {
			if (currentFragment != 4) {

				android.support.v4.app.Fragment fragment = NotificationFragment
						.newInstance();

				changeFragment(fragment);
				currentFragment = 4;
			}

			break;
		}
		case R.id.rdMySnicthes: {
			if (currentFragment != 5) {

				android.support.v4.app.Fragment fragment = MySnitchFragment
						.newInstance();

				changeFragment(fragment);
				currentFragment = 5;
			}

			break;
		}

		}

	}
}
