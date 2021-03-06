package com.khora.snitch.Views;



import com.khora.snitch.StaticFunctions;
import com.khora.snitch.R;
import com.khora.snitch.R.drawable;
import com.khora.snitch.R.layout;

import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Dialog;
import android.content.Context;

import android.view.Window;

public class VievCustomDialog extends Dialog {

	Context ct;
	@SuppressLint("InlinedApi")
	public VievCustomDialog(final Context context) {
		 
        super(context);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        setContentView(R.layout.layout);
        ct=context;
       // getWindow().setLayout(GeneralStaticFunctions.convertDiptoPix(1200, context), 
       // GeneralStaticFunctions.convertDiptoPix(800,context ));
        getWindow().setLayout(StaticFunctions.convertDiptoPix(1000, context), LayoutParams.WRAP_CONTENT);
        getWindow().setBackgroundDrawableResource(R.drawable.background_dialog);
        setCancelable(true);
       
   }
	public void setSize(int x, int y)
	{
		 getWindow().setLayout(StaticFunctions.convertDiptoPix(x, ct), 
			        StaticFunctions.convertDiptoPix(y,ct ));
		
	}
	
	
	
}
