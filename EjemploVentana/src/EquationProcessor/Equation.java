package EquationProcessor;

public class Equation {
	private int decimals;
	private double error;

	private Matriz coefficients;
	private Matriz variables;
	private Matriz independents;

	public Matriz getCoefficients() {
		return coefficients;
	}

	public Matriz getVariables() {
		return variables;
	}

	public Matriz getIndependents() {
		return independents;
	}

}
