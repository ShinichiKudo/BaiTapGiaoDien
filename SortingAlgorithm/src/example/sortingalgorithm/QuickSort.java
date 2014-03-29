package example.sortingalgorithm;

public class QuickSort extends Sort{

	private int level = 1;
	public QuickSort(int[] data) {
		this.data = data;
		updateTmpData();
	}
	public QuickSort(int[] data, String kq) {
		this.data = data;
		this.Kq = kq;
		updateTmpData();
	}
	
	public String getKQ() {
		// TODO Auto-generated method stub
		return Kq;
	}
	
	@Override
	public void sort(int low, int high) {
		int i = low, j = high;
		prints2(level++);
		int pivot = data[low + (high - low) / 2];
		updateTmpData();
		while (i <=j) {

			while (data[i] < pivot) {
				i++;
			}
			while (data[j] > pivot) {
				j--;
			}
			if (i <= j) {
				exchange(i, j);
				prints1(i , j);
				i++;
				j--;
			}
		}
		// Recursion
		if (low < j) {
			sort(low, j);
		}
		if (i < high) {
			sort(i, high);
		}
	}

	private void exchange(int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	
}
