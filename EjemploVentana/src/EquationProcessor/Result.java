package EquationProcessor;

import java.util.ArrayList;

public class Result {
	
	ArrayList<Vector> coeficientes = new ArrayList<Vector>();
	ArrayList<Vector> errores = new ArrayList<Vector>();
	Vector infinito = new Vector();

	public Result() {};
	
	public Result(ArrayList<Vector> coef, ArrayList<Vector> err, Vector infinito) {
		this.setCoeficientes(coef);
		this.setErrores(err);
		this.setInfinito(infinito);
	}
	
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
	
	public Vector getInfinito() {
		return this.infinito;
	}
	
	public void setInfinito(Vector vector) {
		this.infinito = vector;
	}
	
	public void agregarResultado(Vector vectorResultado) {
		this.coeficientes.add(vectorResultado);
	}
	
	public void agregarError(Vector vectorError) {
		this.errores.add(vectorError);
	}
	
	public void agregarInfinito(double doub) {
		this.infinito.agregarNumerito(doub);
	}

}
