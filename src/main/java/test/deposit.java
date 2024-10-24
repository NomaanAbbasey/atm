package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bank.FeesCalculator;

class deposit {

	FeesCalculator test_calc = new FeesCalculator();
	
	@Test
	void case1() {
		assertEquals(0f, test_calc.calculateDepositInterest(40, 450, true));	
	}
	
	@Test
	void case2() {
		assertEquals(0.025f, test_calc.calculateDepositInterest(40, 550, true));	
	}
	
	@Test
	void case3() {
		assertEquals(0f, test_calc.calculateDepositInterest(40, 450, true));	
	}
	
	@Test
	void case4() {
		assertEquals(0f, test_calc.calculateDepositInterest(40, 450, true));	
	}
	
	@Test
	void case5() {
		assertEquals(0f, test_calc.calculateDepositInterest(40, 450, true));	
	}
	
	@Test
	void case6() {
		assertEquals(0f, test_calc.calculateDepositInterest(40, 450, true));	
	}
	
	@Test
	void case7() {
		assertEquals(0f, test_calc.calculateDepositInterest(40, 450, true));	
	}
	
	@Test
	void case8() {
		assertEquals(0f, test_calc.calculateDepositInterest(40, 450, true));	
	}
	
	@Test
	void case9() {
		assertEquals(0f, test_calc.calculateDepositInterest(40, 450, true));	
	}
	
	@Test
	void case10() {
		assertEquals(0f, test_calc.calculateDepositInterest(40, 450, true));	
	}
	
	@Test
	void case11() {
		assertEquals(0f, test_calc.calculateDepositInterest(40, 450, true));	
	}
	
	@Test
	void case12() {
		assertEquals(0f, test_calc.calculateDepositInterest(40, 450, true));	
	}
	
	@Test
	void case13() {
		assertEquals(0f, test_calc.calculateDepositInterest(40, 450, true));	
	}
	
	@Test
	void case14() {
		assertEquals(0f, test_calc.calculateDepositInterest(40, 450, true));	
	}
	
	@Test
	void case15() {
		assertEquals(0f, test_calc.calculateDepositInterest(40, 450, true));	
	}
	
	@Test
	void case16() {
		assertEquals(0f, test_calc.calculateDepositInterest(40, 450, true));	
	}

}
