package example.baitap;

import java.util.Arrays;

public class Sort {

	protected int[] data;
	protected int[] tmpData;
	protected String[] mangKQ = {"First pass", "Second pass", "Third pass",
			"Fourth pass", "Fifth pass", "Sixth pass", "Seventh pass",
			"Eighth pass", "Ninth pass", "Tenth pass"};
	protected String Kq = " ";
	
	public void prints1(int a, int b) {
		Kq = Kq + Arrays.toString(tmpData) + Arrays.toString(data) + "swap(" + data[a] + "," + data[b] + ")" + "\n";
		int tmp = tmpData[a];
		tmpData[a] = tmpData[b];
		tmpData[b] = tmp;
	}

	public void prints2(int i) {
		Kq = Kq + mangKQ[i - 1] + "\n";
	}

	public void prints3() {
		Kq = Kq + Arrays.toString(tmpData) + Arrays.toString(data) + "\n";
	}
	
	public void print4(String result){
		Kq = Kq + result;
	}
	public Sort() {
	}

	public void updateTmpData(){
		int size = data.length;
		tmpData = new int[size];
		for (int i = 0; i < size; i++){
			tmpData[i] = data[i];
		}
	}
	public Sort(int[] data) {
		this.data = data;
	}

	public void sort() {
	}

	public void sort(int low, int hight) {
	}
	
	public void sort(int low, int hight, int level){
		
	}

}
