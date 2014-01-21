package com.khora.snitch.Fragments;

import com.khora.snitch.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class HomeFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View fragmentView = inflater.inflate(R.layout.fragment_home_main,
				container,false);
		// Actionbar Settings
		// Actionbar Settings
		Button questionBtn = (Button) getActivity().findViewById(R.id.btnQuestionMark);
		Button drawerBtn = (Button) getActivity().findViewById(
				R.id.btnOpenDrawer);
		Button homeBtn = (Button) getActivity().findViewById(R.id.btnHome);
		TextView actionBarTitle = (TextView) getActivity().findViewById(
				R.id.tvActionbarTitle);
		actionBarTitle.setText("Snitch");
		questionBtn.setVisibility(Button.VISIBLE);
		drawerBtn.setVisibility(Button.VISIBLE);
		homeBtn.setVisibility(Button.GONE);
		//

		return fragmentView;

	}
	
	public static Fragment newInstance() {
		HomeFragment mFrgment = new HomeFragment();
		return mFrgment;
	}

}
