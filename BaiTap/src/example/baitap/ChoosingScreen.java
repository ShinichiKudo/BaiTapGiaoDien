package example.baitap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ChoosingScreen extends Activity {

	Button btnbtton1, btnbtton2, btnbtton3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.choosingscreen);

		getControl();
		addEvents();

	}

	private void getControl() {
		btnbtton1 = (Button) findViewById(R.id.button1);
		btnbtton2 = (Button) findViewById(R.id.button2);
		btnbtton3 = (Button) findViewById(R.id.button3);
	}

	private void addEvents() {
		btnbtton1.setOnClickListener(new ProcessMyEvent());
		btnbtton2.setOnClickListener(new ProcessMyEvent());
		btnbtton3.setOnClickListener(new ProcessMyEvent());
	}

	public void sentData(String name) {
		Intent myIntent = new Intent(ChoosingScreen.this,
				SortAlgorithmScreen.class);
		Bundle bundle = new Bundle();
		bundle.putString("bt", name);
		myIntent.putExtra("MyPackage", bundle);
		startActivity(myIntent);
	}

	public class ProcessMyEvent implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			switch (arg0.getId()) {
				case R.id.button1 :
					sentData("Insertion");
					break;
				case R.id.button2 :
					sentData("Quick");
					break;
				case R.id.button3 :
					sentData("Merge");
					break;
			}

		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity1, menu);
		return true;
	}

}
