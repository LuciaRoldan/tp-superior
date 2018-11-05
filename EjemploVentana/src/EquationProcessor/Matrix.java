package EquationProcessor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

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
	
	public ArrayList<Vector> getVectors(){
		return this.vectors;
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
	
	public int normaInfinito() {
		return Collections.max(this.vectors.stream().map(v -> v.sumarFila()).collect(Collectors.toList()));
	}
	
	public int norma1() {
		//Norma 1 es la normalInfinito de la transpuesta
		return this.transposeMatrix().normaInfinito();
	}
	
	public Matrix transposeMatrix() {
		
		ArrayList<Vector> vectores = new ArrayList<Vector>();
		
		for (int i = 0; i < this.m; i++) {
			int j = i; //Por alguna razon no me deja con i
			Vector columnVector = new Vector(this.vectors.stream().mapToInt(v -> v.valueAt(j)).toArray());
			vectores.add(columnVector);
		} 
				
		return new Matrix(this.m, this.m, vectores);
	}
	
	public Matrix multiplyMatrix(Matrix matriz) {
		
		Matrix auxMatrix = matriz.transposeMatrix();
		
		ArrayList<Vector> vectores = new ArrayList<Vector>();
		
		for(int i = 0; i < this.m; i++) {
			int[] coeficientes = new int[this.m];
			Vector fila = this.getVectors().get(i);
			for (int j = 0; j < this.m; j++) {
				Vector columna = auxMatrix.getVectors().get(j);
				coeficientes[j] = fila.multiplyVector(columna).sumarFila();
			}
			
			vectores.add(new Vector(coeficientes));			
		}
		
		return new Matrix(this.m, this.m, vectores);
	}
}
