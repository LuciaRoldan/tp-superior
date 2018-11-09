package EquationProcessor;

import java.util.List;
import java.util.ArrayList;

public class Vector {
	private List<Double> values = new ArrayList<Double>();

	public Vector(double... values) {
		for (int i = 0; i < values.length; i++) {
			this.values.add(values[i]);
		}
	}
	
	public Vector(ArrayList<Double> values) {
		this.values = values;
	}

	public List<Double> getValues() {
		return values;
	}
	
	public double valueAt(int i) {
		return values.get(i);
	}

	public boolean compare(int position) {
		double max = values.get(position);
		double sum = 0 - values.get(position);

		for (int i = 0; i < values.size(); i++) {
			sum += values.get(i);
		}

		return sum < Math.abs(max);
	}

	public double sumarFila() {
		return this.values.stream().mapToDouble(x -> Double.valueOf(x)).sum();
	}
	
	public double sumarFilaAbs() {
		return this.values.stream().mapToDouble(x -> Math.abs(Double.valueOf(x))).sum();
	}
	
	public Vector multiplyVector(Vector vector) {
		ArrayList<Double> values = new ArrayList<Double>();
		for (int i = 0; i < this.values.size(); i++) {
			values.add(this.valueAt(i) * vector.valueAt(i));
		}
		
		return new Vector(values);
	}
	
	public Vector plusVector(Vector vector) {
		ArrayList<Double> values = new ArrayList<Double>();
		for (int i = 0; i < this.values.size(); i++) {
			values.add(this.valueAt(i) + vector.valueAt(i));
		}
		
		return new Vector(values);
	}
	
	public void agregarNumerito(double numerito) {
		values.add(numerito);
	}

	public Vector minus(Vector vector) {
		ArrayList<Double> values = new ArrayList<Double>();
		for (int i = 0; i < this.values.size(); i++) {
			values.add(this.valueAt(i) - vector.valueAt(i));
		}
		
		return new Vector(values);
		
	}

	public double normaInfinito() {
		// TODO Auto-generated method stub
		return this.values.stream().mapToDouble(value -> Math.abs(value)).max().getAsDouble();
	}
	
}
