package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import EquationProcessor.Vector;

public class VectorTest {

	@Test
	// Vector (1, 2, 3) compared in position 0 should be false
	public void testVector123v1() {
		Vector vec = new Vector(1, 2, 3);

		Assert.assertFalse(vec.compare(0));
	}

	@Test
	// Vector (1, 2, 3) compared in position 1 should be false
	public void testVector123v2() {
		Vector vec = new Vector(1, 2, 3);

		Assert.assertFalse(vec.compare(1));
	}

	@Test
	// Vector (1, 2, 3) compared in position 2 should be false
	public void testVector123v3() {
		Vector vec = new Vector(1, 2, 3);

		Assert.assertFalse(vec.compare(2));
	}

	@Test
	// Vector (1, 2, 100) compared in position 2 should be true
	public void testVector12100() {
		Vector vec = new Vector(1, 2, 100);

		Assert.assertTrue(vec.compare(2));
	}
	
	@Test
	public void testSumarFila() {
		Vector vec = new Vector(1, 9);
		Assert.assertEquals(10, vec.sumarFila());
	}
}
