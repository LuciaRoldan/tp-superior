package EquationProcessor;

import java.util.ArrayList;

public class Jacobi {
	
	public Result jacobiIterations(Matriz matriz, Vector vectorCoeficientes, Vector vectorInicial, double criterioDeParo){
		
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
			
			Vector errores = anterior.minus(auxVector);
			resultado.agregarError(errores);
			
			Double normaInfinito = anterior.minus(auxVector).normaInfinito();
			resultado.agregarInfinito(normaInfinito);
			
			anterior = auxVector;
			auxVector = dInverseMultiplyLPlusU.multiplyVector(anterior).plusVector(dInverseMultiplyB);
			vectores.add(auxVector);
			resultado.agregarResultado(auxVector);
		}
		
		Vector errores = anterior.minus(auxVector);
		resultado.agregarError(errores);
		
		Double normaInfinito = anterior.minus(auxVector).normaInfinito();
		resultado.agregarInfinito(normaInfinito);
		
		return resultado;
	}

	private boolean cumpleCriterioDeParo(Vector anterior, Vector auxVector, double criterioDeParo) {		
		return anterior.minus(auxVector).normaInfinito() < criterioDeParo;
	}

}
