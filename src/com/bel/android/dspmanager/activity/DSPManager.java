package com.bel.android.dspmanager.activity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.bel.android.dspmanager.HeadsetService;
import com.bel.android.dspmanager.R;

public class DSPManager extends TabActivity {

	public static final String SHARED_PREFERENCES_BASENAME = "com.bel.android.dspmanager";
	public static final String ACTION_UPDATE_PREFERENCES = "com.bel.android.dspmanager.UPDATE";
	
	public static final int NOTIFY_FOREGROUND_ID = 1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);

		setContentView(R.layout.main);
		/* mostly for development: ensure that the service is running if it isn't running yet. */
		startService(new Intent(HeadsetService.NAME));

        	TabHost tabHost = getTabHost();

		TabSpec headsetspec = tabHost.newTabSpec("Headset");
		headsetspec.setIndicator("Headset", getResources().getDrawable(R.drawable.icon_headset_tab));
        	Intent headsetIntent = new Intent("com.bel.android.dspmanager.HEADSET");
        	headsetspec.setContent(headsetIntent);

		TabSpec speakerspec = tabHost.newTabSpec("Speaker");
		speakerspec.setIndicator("Speaker", getResources().getDrawable(R.drawable.icon_speaker_tab));
        	Intent speakerIntent = new Intent("com.bel.android.dspmanager.SPEAKER");
        	speakerspec.setContent(speakerIntent);

		TabSpec bluetoothspec = tabHost.newTabSpec("Bluetooth");
		bluetoothspec.setIndicator("Bluetooth", getResources().getDrawable(R.drawable.icon_bluetooth_tab));
        	Intent bluetoothIntent = new Intent("com.bel.android.dspmanager.BLUETOOTH");
        	bluetoothspec.setContent(bluetoothIntent);

        	tabHost.addTab(headsetspec);
        	tabHost.addTab(speakerspec);
        	tabHost.addTab(bluetoothspec);
    	}
}

