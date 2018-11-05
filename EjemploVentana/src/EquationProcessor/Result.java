package EquationProcessor;

import java.util.ArrayList;

public class Result {
	
	ArrayList<Vector> coeficientes = new ArrayList<Vector>();
	ArrayList<Vector> errores = new ArrayList<Vector>();
	double inifinito;
	
	
	public ArrayList<Vector> getCoeficientes(){
		return this.coeficientes;
	}
	
	public void setCoeficientes(ArrayList<Vector> vector) {
		this.coeficientes = vector;
	}
	
	public ArrayList<Vector> getErrores() {
		return this.errores;
	}
	
	public void setErrores(ArrayList<Vector> vector) {
		this.errores = vector;
	}
	
	public double getInfinito() {
		return this.inifinito;
	}
	
	public void setInfinito(double doub) {
		this.inifinito = doub;
	}
	
	public void agregarResultado(Vector vectorResultado) {
		this.coeficientes.add(vectorResultado);
	}
	
	public void agregarError(Vector vectorError) {
		this.errores.add(vectorError);
	}

}
