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
		Assert.assertEquals(24, m.norma1());
	}
	

}
