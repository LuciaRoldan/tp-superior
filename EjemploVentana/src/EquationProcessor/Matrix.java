package EquationProcessor;

import java.util.ArrayList;

public class Matrix {
	private int n;
	private int m;
	private ArrayList<Vector> vectors = new ArrayList<Vector>();

	public Matrix(int n, int m, ArrayList<Vector> vectors) {
		this.n = n;
		this.m = m;
		this.vectors = vectors;
	}
	
	public Matrix(int n, int m, Vector... vectors) {
		this.n = n;
		this.m = m;
		
		for (int i = 0; i < vectors.length; i++) {
			this.vectors.add(vectors[i]);
		}
	}

	public boolean isDiagonallyDominant() {
		return this.rowDominant() || this.columnDominant();
	}

	public boolean rowDominant() {
		int i = 0;
		int j = 0;

		ArrayList<Boolean> isDominant = new ArrayList<Boolean>();

		for (j = 0; j < m; j++) {
			for (i = 0; i < n; i++) {
				if (!vectors.get(i).compare(i))
					return false;
			}
		}

		return true;
	}

	public boolean columnDominant() {
		return false;
	}
	
	public int getMatrixSize() {
		return this.m;
	}
	
	public void mostrar() {
		this.vectors.stream().forEach(v -> v.mostrar());
	}
}
