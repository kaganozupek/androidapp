package com.khora.snitch.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.khora.snitch.R;

public class NotificationFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View fragmentView = inflater.inflate(R.layout.fragment_notifications,
				container,false);
		// Actionbar Settings
		// Actionbar Settings
		Button questionBtn = (Button) getActivity().findViewById(R.id.btnQuestionMark);
		Button drawerBtn = (Button) getActivity().findViewById(
				R.id.btnOpenDrawer);
		Button homeBtn = (Button) getActivity().findViewById(R.id.btnHome);
		TextView actionBarTitle = (TextView) getActivity().findViewById(
				R.id.tvActionbarTitle);
		actionBarTitle.setText("Bildirimler");
		questionBtn.setVisibility(Button.GONE);
		drawerBtn.setVisibility(Button.VISIBLE);
		homeBtn.setVisibility(Button.VISIBLE);
		//

		return fragmentView;

	}
	
	public static Fragment newInstance() {
		NotificationFragment mFrgment = new NotificationFragment();
		return mFrgment;
	}


}
