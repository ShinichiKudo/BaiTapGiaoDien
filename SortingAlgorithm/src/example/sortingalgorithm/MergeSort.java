package example.sortingalgorithm;

public class MergeSort extends Sort {
	
	private int[] temp;
	private int[][] results = new int[10][10];
	private int[][] dataBack = new int[10][10];
	private int levelMax = 0;
	
	public MergeSort(int[] data) {
		this.data = data;
		temp = new int[data.length];
		updateTmpData();
		for (int i =0; i < 10; i++)
			for (int j = 0; j < data.length; j++){
				results[i][j] = 0;
				dataBack[i][j] = this.data[j];
			}
	}
	@Override
	public void sort(int left, int right, int level) {
		
		if ((left >= right)) {
			return;
		}
		
		if (level > levelMax) levelMax = level;
		
		// The middle index of the range
		int mid = (left + right) / 2;
		//danh dau vi tri chia
		results[level][mid] = 1;
		
		sort(left, mid, level+1);
		sort(mid + 1, right, level+1);
		
		int i = left;
		int j = mid + 1;
		int k = left;
		boolean overLeft = false;
		boolean overRight = false;
		while (k <= right) {
			if ((overLeft == false) && (data[i] <= data[j])) {
				temp[k] = data[i];
				k++;
				i++;
				if (i == mid + 1) {
					overLeft = true;
					break;
				}
				continue;
			}
			if ((overRight == false) && (data[j] < data[i])) {
				temp[k] = data[j];
				k++;
				j++;
				if (j == right + 1) {
					overRight = true;
					break;
				}
				continue;
			}

		}
		if (overLeft) {
			for (; j <= right; j++, k++) {
				temp[k] = data[j];
			}
		}
		if (overRight) {
			for (; i <= mid; i++, k++) {
				temp[k] = data[i];
			}
		}
		for (int index = left; index <= right; index++) {
			data[index] = temp[index];
			dataBack[level][index] = temp[index];
		}
		
		//in du lieu
		if (level == 0){
			for (int t = 0; t < data.length; t++)
				print4(tmpData[t]+" ");
			print4("\n");
			for (int t = 0; t <= levelMax; t++){
				for (int u = 0; u < data.length; u++){
					if (t != 0)
						results[t][u] += results[t - 1][u];
					print4(tmpData[u] + " ");
					if (results[t][u] != 0)
						print4("     ");
				}
				print4("\n");
			}
			
			for (int t = 0; t < levelMax; t++){
				for (int u = 0;u < data.length; u++){
					print4(dataBack[levelMax - t][u] + " ");
					if (results[levelMax - t - 1][u] != 0)
						print4("     ");
				}
				print4("\n");
			}
			for (int t = 0; t < data.length; t++)
				print4(data[t]+" ");
			print4("\n");
		}
	
	}
	public String getKQ() {
		return Kq;
	}
}
