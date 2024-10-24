package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bank.FeesCalculator;

class deposit {

	FeesCalculator test_calc = new FeesCalculator();
	
	@Test
	void case1() {
		assertEquals(0.05f, test_calc.calculateDepositInterest(40, 450, true));	
	}
	
	@Test
	void case2() {
		assertEquals(0.025f, test_calc.calculateDepositInterest(40, 550, true));	
	}
	
	@Test
	void case3() {
		assertEquals(0.05f, test_calc.calculateDepositInterest(50, 5500, true));	
	}
	
	@Test
	void case4() {
		assertEquals(0f, test_calc.calculateDepositInterest(50, 5500, true));	
	}
	
	@Test
	void case5() {
		assertEquals(0.08f, test_calc.calculateDepositInterest(260, 3000, false));	
	}
	
	@Test
	void case6() {
		assertEquals(0.04f, test_calc.calculateDepositInterest(260, 2400, false));	
	}
	
	@Test
	void case7() {
		assertEquals(0f, test_calc.calculateDepositInterest(250, 11000, false));	
	}
	
	@Test
	void case8() {
		assertEquals(0.01f, test_calc.calculateDepositInterest(250, 9000, false));	
	}
	
	@Test
	void case9() {
		assertEquals(0.05f, test_calc.calculateDepositInterest(51, 501, true));	
	}
	
	@Test
	void case10() {
		assertEquals(0.025f, test_calc.calculateDepositInterest(51, 499, true));	
	}
	
	@Test
	void case11() {
		assertEquals(0.05f, test_calc.calculateDepositInterest(49, 5001, true));	
	}
	
	@Test
	void case12() {
		assertEquals(0f, test_calc.calculateDepositInterest(49, 4999, true));	
	}
	
	@Test
	void case13() {
		assertEquals(0.08f, test_calc.calculateDepositInterest(251, 2501, false));	
	}
	
	@Test
	void case14() {
		assertEquals(0.04f, test_calc.calculateDepositInterest(251, 2499, false));	
	}
	
	@Test
	void case15() {
		assertEquals(0f, test_calc.calculateDepositInterest(249, 10001, false));	
	}
	
	@Test
	void case16() {
		assertEquals(0.01f, test_calc.calculateDepositInterest(249, 9999, false));	
	}

}
