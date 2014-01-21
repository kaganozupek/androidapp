package com.khora.snitch.Fragments;

import com.khora.snitch.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class SnitchFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View fragmentView = inflater.inflate(R.layout.fragment_snitches,
				container, false);
		// Actionbar Settings
		Button questionBtn = (Button) getActivity().findViewById(R.id.btnQuestionMark);
		Button drawerBtn = (Button) getActivity().findViewById(
				R.id.btnOpenDrawer);
		Button homeBtn = (Button) getActivity().findViewById(R.id.btnHome);
		TextView actionBarTitle = (TextView) getActivity().findViewById(
				R.id.tvActionbarTitle);
		actionBarTitle.setText("Snitches");
		questionBtn.setVisibility(Button.GONE);
		drawerBtn.setVisibility(Button.VISIBLE);
		homeBtn.setVisibility(Button.VISIBLE);
		//

		return fragmentView;

	}

	public static Fragment newInstance() {
		SnitchFragment mFrgment = new SnitchFragment();
		return mFrgment;
	}

}
