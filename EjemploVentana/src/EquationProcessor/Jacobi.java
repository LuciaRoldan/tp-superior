package EquationProcessor;

import java.util.ArrayList;

public class Jacobi {
	
	public Result jacobiIterations(Matriz matriz, Vector vectorCoeficientes, Vector vectorInicial, double criterioDeParo){
	//public ArrayList<Vector> jacobiIterations(Matriz matriz, Vector vectorCoeficientes, Vector vectorInicial, double criterioDeParo){
		
		Result resultado = new Result();
		
		ArrayList<Vector> vectores = new ArrayList<Vector>();
		
		Matriz dMatrixInverse = matriz.matrixD().inverse();
		
		Matriz lMatrix = matriz.matrixL().multiply(-1);
		
		Matriz uMatrix = matriz.matrixU().multiply(-1);
		
		Matriz LPlusUMatrix = lMatrix.plus(uMatrix);
		
		Vector dInverseMultiplyB = dMatrixInverse.multiplyVector(vectorCoeficientes);
		
		Matriz dInverseMultiplyLPlusU = dMatrixInverse.multiplyMatrix(LPlusUMatrix);
		
		Vector anterior = vectorInicial;
		
		vectores.add(anterior);
		resultado.agregarResultado(anterior);
		
		Vector auxVector = dInverseMultiplyLPlusU.multiplyVector(anterior).plusVector(dInverseMultiplyB);
		
		vectores.add(auxVector);
		resultado.agregarResultado(auxVector);
						
		while(! cumpleCriterioDeParo(anterior, auxVector, criterioDeParo)) {
			
			//agrego errores y norma infinito
			Vector errores = anterior.minus(auxVector);
			resultado.agregarError(errores);
			
			Double normaInfinito = anterior.minus(auxVector).normaInfinito();
			resultado.agregarInfinito(normaInfinito);
			
			anterior = auxVector;
			auxVector = dInverseMultiplyLPlusU.multiplyVector(anterior).plusVector(dInverseMultiplyB);
			vectores.add(auxVector);
			resultado.agregarResultado(auxVector);
		}
		
		//como no entre al while, entonces no agregue errores y norma a resultado, agrego antes de terminar
		Vector errores = anterior.minus(auxVector);
		resultado.agregarError(errores);
		
		Double normaInfinito = anterior.minus(auxVector).normaInfinito();
		resultado.agregarInfinito(normaInfinito);
		
		vectores.forEach(v -> v.mostrar());
		
		//return vectores;
		return resultado;
	}

	private boolean cumpleCriterioDeParo(Vector anterior, Vector auxVector, double criterioDeParo) {		
		return anterior.minus(auxVector).normaInfinito() < criterioDeParo;
	}

}
