package example.sortingalgorithm;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SortArrayScreen extends Activity {

	private TextView txtdaumh, txtgiuamh, txtmang;
	private Button btnNext;
	private int number;
	private String hello;
	private int[] thanh;
	String name1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sortarrayscreen);

		getControl();
		getDatatxt();
		getDatatnumber();

		isArray array = new isArray();
		array.setn(number);
		array.createArray(number);
		array.setName();
		thanh = array.getArray();
		hello = array.getName();
		txtmang.setText(hello);
		addEvents();
	}

	private void addEvents() {
		btnNext.setOnClickListener(new ProcessMyEvent2());
	}

	public class ProcessMyEvent2 implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			Intent myIntent = new Intent(SortArrayScreen.this,
					ResultScreen.class);
			Bundle bundle = new Bundle();
			bundle.putIntArray("hahaha", thanh);
			myIntent.putExtra("MyPackage45", bundle);

			Bundle bundle2 = new Bundle();
			bundle2.putString("hahaha2", name1);
			myIntent.putExtra("MyPackage35", bundle2);

			startActivity(myIntent);
		}

	}
	private void getDatatxt() {
		Intent callerIntent = getIntent();
		Bundle packageFromCaller = callerIntent.getBundleExtra("MyPackage1");
		name1 = packageFromCaller.getString("next");
		txtdaumh.setText("The " + name1 + " sort is chosen");
	}

	private void getDatatnumber() {
		Intent callerIntent = getIntent();
		Bundle packageFromCaller = callerIntent.getBundleExtra("MyPackage");
		number = packageFromCaller.getInt("soabc");

		txtgiuamh.setText("Chosen array for sorting. There are " + number
				+ " numbers.");
	}

	private void getControl() {
		txtdaumh = (TextView) findViewById(R.id.txtdaumh);
		txtgiuamh = (TextView) findViewById(R.id.txtgiuamh);
		txtmang = (TextView) findViewById(R.id.txtmang);
		btnNext = (Button) findViewById(R.id.btnNext);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.manhinh4, menu);
		return true;
	}

}
