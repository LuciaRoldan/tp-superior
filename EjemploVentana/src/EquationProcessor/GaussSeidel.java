package EquationProcessor;

import java.util.ArrayList;

public class GaussSeidel {

	public ArrayList<Vector> gaussSeidelIterations(Matriz matriz, Vector vectorCoeficientes, Vector vectorInicial, double criterioDeParo){
		
		ArrayList<Vector> vectores = new ArrayList<Vector>();
				
		Matriz lMatrix = matriz.matrixL().multiply(-1);

		Matriz dMinusL = matriz.matrixD().minus(lMatrix);
		
		Matriz dMinusLInverse = dMinusL.inverse();
		
		Matriz uMatrix = matriz.matrixU().multiply(-1);
		
		Matriz dMinusLInverseMultiplyU = dMinusLInverse.multiplyMatrix(uMatrix);
				
		Vector dMinusLInverseMultiplyB = dMinusLInverse.multiplyVector(vectorCoeficientes);
		
		Vector anterior = vectorInicial;
		
		vectores.add(anterior);
		
		Vector auxVector = dMinusLInverseMultiplyU.multiplyVector(anterior).plusVector(dMinusLInverseMultiplyB);
		
		vectores.add(auxVector);
						
		while(! cumpleCriterioDeParo(anterior, auxVector, criterioDeParo)) {
			
			anterior = auxVector;
			auxVector = dMinusLInverseMultiplyU.multiplyVector(anterior).plusVector(dMinusLInverseMultiplyB);
			vectores.add(auxVector);
		}
		
		vectores.forEach(v -> v.mostrar());
		
		return vectores;			
	}

	private boolean cumpleCriterioDeParo(Vector anterior, Vector auxVector, double criterioDeParo) {		
		return anterior.minus(auxVector).normaInfinito() < criterioDeParo;
	}

}
