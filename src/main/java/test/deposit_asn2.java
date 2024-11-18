package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bank.FeesCalculator;

class deposit_asn2 {

	final int AMOUNT_1 = 11000; //ensure all returns are integer values to ensure testing consistency 
	final int AMOUNT_2 = 10000;
	final int AMOUNT_3 = 60000;
	
	//test are numbered according to paths outlined in table. First row is p1, 2nd p2 and so on.
	
	@Test
	void test_1() {
		FeesCalculator calc = new FeesCalculator();
		int dep_interest = calc.calculateDepositInterest(AMOUNT_1, 100001, true);
		assertEquals(110, dep_interest);
	}
	
	@Test
	void test_2() {
		FeesCalculator calc = new FeesCalculator();
		int dep_interest = calc.calculateDepositInterest(AMOUNT_1, 1, true);
		assertEquals(55, dep_interest);
	}
	
	@Test
	void test_3() {
		FeesCalculator calc = new FeesCalculator();
		int dep_interest = calc.calculateDepositInterest(AMOUNT_2, 500001, true);
		assertEquals(50, dep_interest);
	}
	
	@Test
	void test_4() {
		FeesCalculator calc = new FeesCalculator();
		int dep_interest = calc.calculateDepositInterest(AMOUNT_2, 1, true);
		assertEquals(20, dep_interest);
	}
	
	@Test
	void test_5() {
		FeesCalculator calc = new FeesCalculator();
		int dep_interest = calc.calculateDepositInterest(AMOUNT_3, 600000, false);
		assertEquals(600, dep_interest);
	}
	
	@Test
	void test_6() {
		FeesCalculator calc = new FeesCalculator();
		int dep_interest = calc.calculateDepositInterest(AMOUNT_3, 1, false);
		assertEquals(300, dep_interest);
	}
	
	@Test
	void test_7() {
		FeesCalculator calc = new FeesCalculator();
		int dep_interest = calc.calculateDepositInterest(AMOUNT_1, 1000001, false);
		assertEquals(55, dep_interest);
	}
	
	@Test
	void test_8() {
		FeesCalculator calc = new FeesCalculator();
		int dep_interest = calc.calculateDepositInterest(AMOUNT_1, 1, false);
		assertEquals(0, dep_interest);
	}

}
