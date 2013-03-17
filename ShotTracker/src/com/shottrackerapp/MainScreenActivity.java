package com.shottrackerapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.knoxhouse.shottracker.R;

public class MainScreenActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        
        TextView txtGunVault = (TextView)findViewById(R.id.txtGunVault);
        txtGunVault.setOnClickListener(onClickListenerGunVault);
        
        TextView txtShooterProfile = (TextView)findViewById(R.id.txtShooterProfile);
        txtShooterProfile.setOnClickListener(onClickListenerShooterProfile);
        
        TextView txtRangeDay = (TextView)findViewById(R.id.txtRangeDay);
        txtRangeDay.setOnClickListener(onClickListenerGunViewer);
        
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
    
    OnClickListener onClickListenerGunViewer = new OnClickListener() {
    	@Override
    	public void onClick(View v) {
    		Intent intent = new Intent(MainScreenActivity.this, GunViewerActivity.class);
    		startActivity(intent);
    	}
    };
}
