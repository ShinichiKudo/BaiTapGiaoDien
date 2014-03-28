package example.baitap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultScreen extends Activity {

	private Button btnReset;
	private TextView txtV;
	private TextView txtResult;
	private TextView txthienthiKQ;
	private int[] mangarray;
	private String txtVV;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resultscreen);
		getControls();
		String names = "";

		getDaTa();
		getDaTa1();
		txtResult.setText(txtVV + " sort result");
		if (txtVV.equals("Insertion")) {
			InsertionSort insertionSort = new InsertionSort(mangarray, names);

			insertionSort.sort();

			names = names + insertionSort.getKQ();
			txthienthiKQ.setText(names);
		} else {
			if (txtVV.equals("Quick")) {
				QuickSort quickSort = new QuickSort(mangarray);

				quickSort.sort(0, mangarray.length - 1);

				names = names + quickSort.getKQ();
				txthienthiKQ.setText(names);
			} else {
				MergeSort mergeSort = new MergeSort(mangarray);
				mergeSort.sort(0, mangarray.length - 1, 0);

				names = names + mergeSort.getKQ();
				txthienthiKQ.setGravity(Gravity.CENTER);
				txthienthiKQ.setText(names);
			}
		}

		doButtonReset();

	}
	public void getControls() {
		btnReset = (Button) findViewById(R.id.btnReset);
		txtV = (TextView) findViewById(R.id.txtV);
		txtResult = (TextView) findViewById(R.id.textResult);
		txthienthiKQ = (TextView) findViewById(R.id.txthienthiKQ);
	}

	public void getDaTa() {
		Intent callerIntent = getIntent();
		Bundle packageFromCaller = callerIntent.getBundleExtra("MyPackage45");
		mangarray = packageFromCaller.getIntArray("hahaha");
	}

	public void getDaTa1() {
		Intent callerIntent = getIntent();
		Bundle packageFromCaller = callerIntent.getBundleExtra("MyPackage35");
		txtVV = packageFromCaller.getString("hahaha2");
		txtV.setText("The " + txtVV + " sort is chosen");
	}

	public void doButtonReset() {
		btnReset.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent(ResultScreen.this,
						ChoosingScreen.class);

				// isArray is = new isArray();
				startActivity(myIntent);
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result_screen, menu);
		return true;
	}

}
