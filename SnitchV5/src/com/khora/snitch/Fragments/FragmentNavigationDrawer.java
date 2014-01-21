package com.khora.snitch.Fragments;

import com.khora.snitch.R;
import com.khora.snitch.R.layout;

import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class FragmentNavigationDrawer extends Fragment implements
		View.OnClickListener {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.navigation_drawer_fragment,
				container, false);

		RelativeLayout lyAnasayfa = (RelativeLayout) view
				.findViewById(R.id.lyAnasayfa);
		lyAnasayfa.setOnClickListener(this);

		return view;

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.lyAnasayfa:
		{
			
			
		break;	
		}
		case R.id.lyEniyi:
		{
		break;	
		}
		case R.id.lyEniyiler:
		{
		break;	
		}
		case R.id.lyHakkimizda:
		{
		break;	
		}
		case R.id.lyOneri:
		{
		break;	
		}
		case R.id.lyPaylas:
		{
		break;	
		}
		case R.id.lyProfil:
		{
		break;	
		}
		case R.id.lySorular:
		{
		break;	
		}
		
		}
		
	}

}
