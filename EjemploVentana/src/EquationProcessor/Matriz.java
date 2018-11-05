package EquationProcessor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import cern.colt.matrix.*;
import cern.colt.matrix.impl.DenseDoubleMatrix2D;
import cern.colt.matrix.linalg.Algebra;

public class Matriz {
	private int n;
	private int m;
	private ArrayList<Vector> vectors = new ArrayList<Vector>();

	public Matriz(int n, int m, ArrayList<Vector> vectors) {
		this.n = n;
		this.m = m;
		this.vectors = vectors;
	}
	
	public Matriz(int n, int m, Vector... vectors) {
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
	
	public double normaInfinito() {
		return Collections.max(this.vectors.stream().map(v -> v.sumarFilaAbs()).collect(Collectors.toList()));
	}
	
	public double norma1() {
		//Norma 1 es la normalInfinito de la transpuesta
		return this.transposeMatrix().normaInfinito();
	}
	
	public double norma2() {
		Algebra alg = new Algebra();
		DoubleMatrix2D aMatrix = new DenseDoubleMatrix2D(this.getCoeficientes());
		return alg.norm2(aMatrix);
	}
	
	public Matriz transposeMatrix() {
		
		ArrayList<Vector> vectores = new ArrayList<Vector>();
		
		for (int i = 0; i < this.m; i++) {
			int j = i; //Por alguna razon no me deja con i
			Vector columnVector = new Vector(this.vectors.stream().mapToDouble(v -> v.valueAt(j)).toArray());
			vectores.add(columnVector);
		} 
				
		return new Matriz(this.m, this.m, vectores);
	}
	
	public Matriz multiplyMatrix(Matriz matriz) {
		
		Matriz auxMatrix = matriz.transposeMatrix();
		
		ArrayList<Vector> vectores = new ArrayList<Vector>();
		
		for(int i = 0; i < this.m; i++) {
			double[] coeficientes = new double[this.m];
			Vector fila = this.getVectors().get(i);
			for (int j = 0; j < this.m; j++) {
				Vector columna = auxMatrix.getVectors().get(j);
				coeficientes[j] = fila.multiplyVector(columna).sumarFila();
			}
			
			vectores.add(new Vector(coeficientes));			
		}
		
		return new Matriz(this.m, this.m, vectores);
	}
	
	public Matriz matrixL() {
		ArrayList<Vector> vectores = new ArrayList<Vector>();
		
		for(int i = 0; i < this.m; i++) {
			double[] coeficientes = new double[this.m];
			for (int j = 0; j < this.m; j++) {
				if(j < i) {
					coeficientes[j] = getPosition(i, j);
				}
				else coeficientes[j] = 0;
			}
			
			vectores.add(new Vector(coeficientes));			
		}
		
		return new Matriz(this.m, this.m, vectores);
	}
	
	public Matriz matrixU() {
		ArrayList<Vector> vectores = new ArrayList<Vector>();
		
		for(int i = 0; i < this.m; i++) {
			double[] coeficientes = new double[this.m];
			for (int j = 0; j < this.m; j++) {
				if(j > i) {
					coeficientes[j] = getPosition(i, j);
				}
				else coeficientes[j] = 0;
			}
			
			vectores.add(new Vector(coeficientes));			
		}
		
		return new Matriz(this.m, this.m, vectores);
	}
	
	public Matriz matrixD() {
		ArrayList<Vector> vectores = new ArrayList<Vector>();
		
		for(int i = 0; i < this.m; i++) {
			double[] coeficientes = new double[this.m];
			for (int j = 0; j < this.m; j++) {
				if(j == i) {
					coeficientes[j] = getPosition(i, j);
				}
				else coeficientes[j] = 0;
			}
			
			vectores.add(new Vector(coeficientes));			
		}
		
		return new Matriz(this.m, this.m, vectores);
	}
	
	public Matriz multiply(int value) {
		ArrayList<Vector> vectores = new ArrayList<Vector>();
		
		for(int i = 0; i < this.m; i++) {
			double[] coeficientes = new double[this.m];

			for (int j = 0; j < this.m; j++) {
				coeficientes[j] = getPosition(i, j) * value;
			}
			
			vectores.add(new Vector(coeficientes));			
		}
		
		return new Matriz(this.m, this.m, vectores);
	}
	
	public Matriz plus(Matriz matriz) {
		ArrayList<Vector> vectores = new ArrayList<Vector>();
		
		for(int i = 0; i < this.m; i++) {
			double[] coeficientes = new double[this.m];

			for (int j = 0; j < this.m; j++) {
				coeficientes[j] = this.getPosition(i, j) + matriz.getPosition(i, j);
			}
			
			vectores.add(new Vector(coeficientes));			
		}
		
		return new Matriz(this.m, this.m, vectores);
	}
	
	public Vector multiplyVector(Vector vector) {
		
		ArrayList<Vector> vectores = new ArrayList<Vector>();
		
		double[] coeficientes = new double[this.m];
		
		for(int i = 0; i < this.m; i++) {
			Vector fila = this.getVectors().get(i);
			coeficientes[i] = fila.multiplyVector(vector).sumarFila();
		}
		
		return new Vector(coeficientes);
	}

	public double getPosition(int i, int j) {
		return this.getVectors().get(i).valueAt(j);
	}
	
	public Matriz inverse() {
		
		Algebra alg = new Algebra();
		DoubleMatrix2D aMatrix = new DenseDoubleMatrix2D(this.getCoeficientes());
		ArrayList<Vector> vectores = this.initializeVectors(alg.inverse(aMatrix).toArray());
		return new Matriz(this.m, this.m, vectores);
	}
	
	private ArrayList<Vector> initializeVectors(double[][] array) {
		ArrayList<Vector> vectores = new ArrayList<Vector>();
		
		for(int i = 0; i < this.m; i++) {
			vectores.add(new Vector(array[i]));
		}
		
		return vectores;
	}

	public double[][] getCoeficientes(){
		
		double[][] coeficientes = new double[this.m][this.m];
		
		for(int i = 0; i < this.m; i++) {
			for (int j = 0; j < this.m; j++) {
				coeficientes[i][j] = this.getPosition(i, j);
			}
		}
		
		return coeficientes;
	}
}
