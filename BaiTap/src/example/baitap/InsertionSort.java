package example.baitap;

public class InsertionSort extends Sort {
	
	public InsertionSort(int[] data, String Kq) {
		this.data = data;
		this.Kq = Kq;
		updateTmpData();
	}

	public InsertionSort(int[] data) {
		this.data = data;
		updateTmpData();
	}

	public String getKQ() {
		return this.Kq;
	}

	@Override
	public void sort() {
		
		int key, j, i;
		for (i = 1; i < data.length; i++) {
			int h = 0;
			prints2(i);
			key = data[i];
			j = i;
			while ((j > 0) && (data[j - 1] > key)) {
				data[j] = data[j - 1];
				data[j - 1] = key;
				//prints1(data[j], data[j-1]); // xuong dong
				prints1(j, j-1);
				data[j - 1] = data[j];
				h = 1;
				j--;
			}
			data[j] = key;
			if (h == 0) {
				prints3();
			}
		}
	}
}
