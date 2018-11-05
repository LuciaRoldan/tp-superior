package EquationProcessor;

import java.util.ArrayList;

public class Jacobi {
	
	public ArrayList<Vector> jacobiIterations(Matriz matriz, Vector vectorCoeficientes, Vector vectorInicial, double criterioDeParo){
		
		ArrayList<Vector> vectores = new ArrayList<Vector>();
		
		Matriz dMatrixInverse = matriz.matrixD().inverse();
		
		Matriz lMatrix = matriz.matrixL().multiply(-1);
		
		Matriz uMatrix = matriz.matrixU().multiply(-1);
		
		Matriz LPlusUMatrix = lMatrix.plus(uMatrix);
		
		Vector dInverseMultiplyB = dMatrixInverse.multiplyVector(vectorCoeficientes);
		
		Matriz dInverseMultiplyLPlusU = dMatrixInverse.multiplyMatrix(LPlusUMatrix);
		
		Vector anterior = vectorInicial;
		
		vectores.add(anterior);
		
		Vector auxVector = dInverseMultiplyLPlusU.multiplyVector(anterior).plusVector(dInverseMultiplyB);
		
		vectores.add(auxVector);
						
		while(! cumpleCriterioDeParo(anterior, auxVector, criterioDeParo)) {
			
			anterior = auxVector;
			auxVector = dInverseMultiplyLPlusU.multiplyVector(anterior).plusVector(dInverseMultiplyB);
			vectores.add(auxVector);
		}
		
		vectores.forEach(v -> v.mostrar());
		
		return vectores;			
	}

	private boolean cumpleCriterioDeParo(Vector anterior, Vector auxVector, double criterioDeParo) {		
		return anterior.minus(auxVector).normaInfinito() < criterioDeParo;
	}

}
