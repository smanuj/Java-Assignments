package com.valtech.training.assignments;

import static org.junit.Assert.*;

import org.junit.Test;

public class PassStrengthCheckerTest {

	@Test
	public void testLStrength() {

		String a = "abcdefgh";
		PassStrengthChecker psc = new PassStrengthChecker();
		assertEquals(5, psc.passwordStrength(a));

	}

	@Test
	public void testUStrength() {

		String a = "ABCDEFGH";
		PassStrengthChecker psc = new PassStrengthChecker();
		assertEquals(5, psc.passwordStrength(a));

	}

	@Test
	public void testNStrength() {

		String a = "123456789";
		PassStrengthChecker psc = new PassStrengthChecker();
		assertEquals(13, psc.passwordStrength(a));

	}

	@Test
	public void testSStrength() {

		String a = "!@#$%^&*";
		PassStrengthChecker psc = new PassStrengthChecker();
		assertEquals(19, psc.passwordStrength(a));

	}

	@Test
	public void testStrength() {

		String a = "!@#$%^&*!!!!!!";
		PassStrengthChecker psc = new PassStrengthChecker();
		int b = psc.passwordStrength(a);
		System.out.println(psc.strength(b));

	}

}
