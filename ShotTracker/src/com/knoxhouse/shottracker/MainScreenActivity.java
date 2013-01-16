package com.knoxhouse.shottracker;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class MainScreenActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        
        TextView txtGunVault = (TextView)findViewById(R.id.txtGunVault);
        txtGunVault.setOnClickListener(onClickListenerGunVault);
        
        TextView txtShooterProfile = (TextView)findViewById(R.id.txtShooterProfile);
    }
    
    OnClickListener onClickListenerGunVault = new OnClickListener() {
        @Override
        public void onClick(View v) {
        	Intent intent = new Intent(MainScreenActivity.this, VaultActivity.class);
        	startActivity(intent);
        }
    };
    
    OnClickListener onClickListenerShooterProfile = new OnClickListener() {
    	@Override
    	public void onClick(View v) {
    		Intent intent = new Intent(MainScreenActivity.this, ProfileActivity.class);
    		startActivity(intent);
    	}
    };
    
    
}
