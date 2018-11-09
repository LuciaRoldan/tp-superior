package EquationProcessor;

import java.util.ArrayList;

public class GaussSeidel {

	public Result gaussSeidelIterations(Matriz matriz, Vector vectorCoeficientes, Vector vectorInicial, double criterioDeParo){
		
		Result resultado = new Result();
		
		ArrayList<Vector> vectores = new ArrayList<Vector>();
				
		Matriz lMatrix = matriz.matrixL().multiply(-1);

		Matriz dMinusL = matriz.matrixD().minus(lMatrix);
		
		Matriz dMinusLInverse = dMinusL.inverse();
		
		Matriz uMatrix = matriz.matrixU().multiply(-1);
		
		Matriz dMinusLInverseMultiplyU = dMinusLInverse.multiplyMatrix(uMatrix);
				
		Vector dMinusLInverseMultiplyB = dMinusLInverse.multiplyVector(vectorCoeficientes);
		
		Vector anterior = vectorInicial;
		
		vectores.add(anterior);
		resultado.agregarResultado(anterior);
		
		Vector auxVector = dMinusLInverseMultiplyU.multiplyVector(anterior).plusVector(dMinusLInverseMultiplyB);
		
		vectores.add(auxVector);
		resultado.agregarResultado(auxVector);
						
		while(! cumpleCriterioDeParo(anterior, auxVector, criterioDeParo)) {
			
			//va aca?
			Vector errores = anterior.minus(auxVector);
			resultado.agregarError(errores);
			
			Double normaInfinito = anterior.minus(auxVector).normaInfinito();
			resultado.agregarInfinito(normaInfinito);			
			
			anterior = auxVector;
			auxVector = dMinusLInverseMultiplyU.multiplyVector(anterior).plusVector(dMinusLInverseMultiplyB);
			
			vectores.add(auxVector);
			resultado.agregarResultado(auxVector);
		}
		
		//como no entre al while, entonces no agregue errores y norma a resultado, agrego antes de terminar
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
