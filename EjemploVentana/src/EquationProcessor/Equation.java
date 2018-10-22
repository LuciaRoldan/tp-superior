package EquationProcessor;

public class Equation {
	private int decimals;
	private double error;

	private Matrix coefficients;
	private Matrix variables;
	private Matrix independents;

	public Matrix getCoefficients() {
		return coefficients;
	}

	public Matrix getVariables() {
		return variables;
	}

	public Matrix getIndependents() {
		return independents;
	}

}
