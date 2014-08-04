package com.example.floatingwidget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


/**
 * @author Narioinc
 * Class that initiates the floating widget service.
 * As a good behaviour always stop the service that has been started in onstart() or onresume() 
 * in onpause() or onresume()
 * 
 * Does nothing more...nothing less
 * 
 */
public class MainActivity extends Activity {

	private Button launchFloatingWidget;
	private Button stopFloatingWidget;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Bundle bundle = getIntent().getExtras();
		if(bundle != null && bundle.getString("LAUNCH").equals("YES")) {
			startService(new Intent(MainActivity.this, FloatingSnitch.class));
		}
		
		//provide buttons to launch/stop the service module
		stopFloatingWidget = (Button)findViewById(R.id.button2);
		launchFloatingWidget = (Button)findViewById(R.id.button1);
		
		launchFloatingWidget.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startService(new Intent(MainActivity.this, FloatingSnitch.class));
			}
		});

		
		stopFloatingWidget.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				stopService(new Intent(MainActivity.this, FloatingSnitch.class));
			}
		});

	}

	@Override
	protected void onResume() {
		Bundle bundle = getIntent().getExtras();

		if(bundle != null && bundle.getString("LAUNCH").equals("YES")) {
			startService(new Intent(MainActivity.this, FloatingSnitch.class));
		}
		super.onResume();
	}
}