package EquationProcessor;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Vector {
	private List<Integer> values = new ArrayList<Integer>();

	public Vector(int... values) {
		for (int i = 0; i < values.length; i++) {
			this.values.add(values[i]);
		}
	}

	public List<Integer> getValues() {
		return values;
	}
	
	public int valueAt(int i) {
		return values.get(i);
	}

	public boolean compare(int position) {
		int max = values.get(position);
		int sum = 0 - values.get(position);

		for (int i = 0; i < values.size(); i++) {
			sum += values.get(i);
		}

		return sum < Math.abs(max);
	}

	public void mostrar() {
		for (int i = 0; i < values.size(); i++) {
			System.out.println("vector " + this.valueAt(i));
		}
	}
	
	public int sumarFila() {
		return this.values.stream().mapToInt(Integer::intValue).sum();
	}
}
