package example.sortingalgorithm;

import java.util.Arrays;

public class isArray {

	private String name = "";
	private int[] array;
	private int size;

	public void setn(int n) {
		this.size = n;
	}

	public int[] getArray() {
		return this.array;

	}

	public int getn() {
		return this.size;
	}

	public void setName() {
		name = Arrays.toString(array);

	}

	public String getName() {
		return this.name;
	}

	public String toString() {
		return name;
	}

	public void createArray(int size) {
		array = new int[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 10);
		}
	}
}
