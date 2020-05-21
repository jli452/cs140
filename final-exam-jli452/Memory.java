package finalexam;

import java.util.Arrays;

public class Memory {
	public static final int DATA_SIZE = 512;
	private int[] data = new int[DATA_SIZE];
	
	public void setData(int index, int value) {
		if(index < 0 || index >= data.length) {
			throw new DataAccessException("ERROR: Cannot access data location " + index);
		}
		data[index] = value;
	}
	
	public int getData(int index) {
		if(index < 0 || index >= data.length) {
			throw new DataAccessException("ERROR: Cannot access data location " + index);
		}
		return data[index];
	}
	
	int[] getData() {
		return data;
	}

	public void clearData() {
		Arrays.fill(data, 0);		
	}
		
}
