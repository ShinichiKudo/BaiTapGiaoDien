package example.baitap;

import android.app.Activity;
import android.content.Intent;
//import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;

public class WelcomeScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcomescreen);
		Thread bamgio = new Thread() {
			public void run() {
				try {
					sleep(5000);
				} catch (Exception e) {

				} finally {
					doOpenManHinh2();
				}
			}
		};
		bamgio.start();
	}
	public void doOpenManHinh2() {
		Intent myIntent = new Intent(WelcomeScreen.this, ChoosingScreen.class);
		startActivity(myIntent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
