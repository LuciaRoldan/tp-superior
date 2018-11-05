package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import EquationProcessor.*;

public class MatrixTest {
	Vector v1 = new Vector(1, 2, 3);
	Vector v2 = new Vector(4, 5, 6);
	Vector v3 = new Vector(7, 8, 9);

	Matrix m = new Matrix(3, 3, v1, v2, v3);

	@Test
	// m should not be row diagonals
	public void test() {
		Assert.assertFalse(m.rowDominant());
	}
	
	@Test
	public void testNorma1() {
		Assert.assertEquals(3 + 6 + 9, m.norma1());
	}
	
	@Test
	public void testNormaInfinito() {
		Assert.assertEquals(7 + 8 + 9, m.normaInfinito());
	}
	
	
	@Test
	public void testTransposeMatrix() {
		Matrix transposedM = m.transposeMatrix();
		Assert.assertEquals(new Vector(1,4,7).sumarFila(), transposedM.getVectors().get(0).sumarFila());
		Assert.assertEquals(new Vector(2,5,8).sumarFila(), transposedM.getVectors().get(1).sumarFila());
		Assert.assertEquals(new Vector(3,6,9).sumarFila(), transposedM.getVectors().get(2).sumarFila());
	}
	
	@Test
	public void testMultiplyMatrix() {
		Matrix multipliedM = m.multiplyMatrix(m);
		Assert.assertEquals(new Vector(30,36,42).sumarFila(), multipliedM.getVectors().get(0).sumarFila());
	}
}
