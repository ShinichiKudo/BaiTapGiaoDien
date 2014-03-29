package example.sortingalgorithm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SortAlgorithmScreen extends Activity {
	Button btnok;
	EditText edso;
	TextView txtchon;
	String name1;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sortalgorithmscreen);
		getControl();
		getData();
		addEvents();
	}

	private void getControl() {
		btnok = (Button) findViewById(R.id.btnOk);
		edso = (EditText) findViewById(R.id.editso);
		txtchon = (TextView) findViewById(R.id.txtview1);
	}

	private void getData() {
		Intent callerIntent = getIntent();
		Bundle packageFromCaller = callerIntent.getBundleExtra("MyPackage");
		name1 = packageFromCaller.getString("bt");
		txtchon.setText("The " + name1 + " sort is chosen");
	}

	private void addEvents() {
		btnok.setOnClickListener(new ProcessMyEvent());
	}

	public class ProcessMyEvent implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			int abc;
			try {
			abc = Integer.parseInt(edso.getText() + "");
			}catch (Exception e) {
				abc = 0;
			}
			if (abc <= 0 || abc > 10) {
				edso.requestFocus();
				edso.selectAll();
				Toast.makeText(SortAlgorithmScreen.this,
						"Bạn nhập sai! Số trong khoảng từ 1 đến 10!!", Toast.LENGTH_LONG).show();
				return;
			}
			Intent myIntent = new Intent(SortAlgorithmScreen.this,
					SortArrayScreen.class);
			Bundle bundle = new Bundle();
			bundle.putInt("soabc", abc);
			myIntent.putExtra("MyPackage", bundle);

			Bundle bundle1 = new Bundle();
			bundle1.putString("next", name1);
			myIntent.putExtra("MyPackage1", bundle1);
			startActivity(myIntent);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.manhinh3, menu);
		return true;
	}

}
