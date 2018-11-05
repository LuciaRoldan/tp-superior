package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import EquationProcessor.*;

public class MatrixTest {
	Vector v1 = new Vector(1, 2, 3);
	Vector v2 = new Vector(4, 5, 6);
	Vector v3 = new Vector(7, 8, 9);

	Matriz m = new Matriz(3, 3, v1, v2, v3);

	@Test
	// m should not be row diagonals
	public void test() {
		Assert.assertFalse(m.rowDominant());
	}
	
	@Test
	public void testNorma1() {
		Assert.assertEquals(3 + 6 + 9, m.norma1(), 0);
	}
	
	@Test
	public void testNormaInfinito() {
		Assert.assertEquals(7 + 8 + 9, m.normaInfinito(), 0);
	}
	
	
	@Test
	public void testTransposeMatrix() {
		Matriz transposedM = m.transposeMatrix();
		Assert.assertEquals(new Vector(1,4,7).sumarFila(), transposedM.getVectors().get(0).sumarFila(), 0);
		Assert.assertEquals(new Vector(2,5,8).sumarFila(), transposedM.getVectors().get(1).sumarFila(), 0);
		Assert.assertEquals(new Vector(3,6,9).sumarFila(), transposedM.getVectors().get(2).sumarFila(), 0);
	}
	
	@Test
	public void testMultiplyMatrix() {
		Matriz multipliedM = m.multiplyMatrix(m);
		Assert.assertEquals(new Vector(30,36,42).sumarFila(), multipliedM.getVectors().get(0).sumarFila(), 0);
	}
	
	@Test
	public void testMultiplyValue() {
		Matriz multipliedM = m.multiply(2);
		Assert.assertEquals(new Vector(2,4,6).sumarFila(), multipliedM.getVectors().get(0).sumarFila(), 0);
	}
	
	@Test
	public void testMatrixL() {
		Matriz matrixL = m.matrixL();
		Assert.assertEquals(new Vector(0,0,0).sumarFila(), matrixL.getVectors().get(0).sumarFila(), 0);
		Assert.assertEquals(new Vector(4,0,0).sumarFila(), matrixL.getVectors().get(1).sumarFila(), 0);
		Assert.assertEquals(new Vector(7,8,0).sumarFila(), matrixL.getVectors().get(2).sumarFila(), 0);
	}
	
	@Test
	public void testMatrixD() {
		Matriz matrixD = m.matrixD();
		Assert.assertEquals(new Vector(1,0,0).sumarFila(), matrixD.getVectors().get(0).sumarFila(), 0);
		Assert.assertEquals(new Vector(0,5,0).sumarFila(), matrixD.getVectors().get(1).sumarFila(), 0);
		Assert.assertEquals(new Vector(0,0,9).sumarFila(), matrixD.getVectors().get(2).sumarFila(), 0);
	}
	
	@Test
	public void testMatrixU() {
		Matriz matrixU = m.matrixU();
		Assert.assertEquals(new Vector(0,2,3).sumarFila(), matrixU.getVectors().get(0).sumarFila(), 0);
		Assert.assertEquals(new Vector(0,0,6).sumarFila(), matrixU.getVectors().get(1).sumarFila(), 0);
		Assert.assertEquals(new Vector(0,0,0).sumarFila(), matrixU.getVectors().get(2).sumarFila(), 0);
	}
	
	@Test
	public void testMultiplyVector() {
		Vector multipliedVector = m.multiplyVector(v1);		
		Assert.assertEquals(new Vector(1+4+9,4+10+18,7+16+27).sumarFilaAbs(), multipliedVector.sumarFila(), 0);
	}
}
