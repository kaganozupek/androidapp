package com.khora.snitch.Activities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.khora.snitch.R;
import com.khora.snitch.R.id;
import com.khora.snitch.R.layout;

import android.opengl.Visibility;
import android.os.Bundle;
import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class ActivityMainLogin extends ActionBarActivity {

	public DrawerLayout mDrawerLayout;
	public FrameLayout drawerLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_login);
		getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		getSupportActionBar().setCustomView(R.layout.abs_layout);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.layout_navigation_drawer);
		drawerLayout = (FrameLayout) findViewById(R.id.left_drawer);
		mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
		Button ActionBarDrawerButton = (Button) findViewById(R.id.btnOpenDrawer);
		ActionBarDrawerButton.setVisibility(Button.GONE);

	}
	public void openDrawer() {

		mDrawerLayout.openDrawer(drawerLayout);
	}

	public void DrawerOpenClickEvent(View v) {
		
		openDrawer();

	}
}
