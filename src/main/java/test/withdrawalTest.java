package test;
import java.util.Calendar; 
import static org.junit.jupiter.api.Assertions.*;
import bank.FeesCalculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class withdrawalTest {
    FeesCalculator calculator;
  //The below 5 tests are checking the balance boundaries for non-students 
  	@Test
  	void testNonStudentLower() { //This test is for the lower bounds of non-students
  		FeesCalculator calc = new FeesCalculator(); 
  		int fee = calc.calculateWithdrawalFee(10000, 100, false, Calendar.MONDAY); //Since the balance is <1000, it should return 0.3% of 10000
  		assertEquals(30, fee); //The expected value is 30, which it compares to the value of fee
  	}
  	
  	@Test
  	void testNonStudent1000() { //This test is for non-students with balances of exactly 1000
  		FeesCalculator calc = new FeesCalculator(); 
  		int fee = calc.calculateWithdrawalFee(10000, 1000, false, Calendar.MONDAY); //Since the balance is >=1000 && <5000, it should return 0.1% of 10000
  		assertEquals(10, fee); 
  	}
  	
  	@Test
  	void testNonStudentMiddle() { //This test is for non-students with balances >1000 && <5000
  		FeesCalculator calc = new FeesCalculator(); 
  		int fee = calc.calculateWithdrawalFee(10000, 2000, false, Calendar.MONDAY); //Since the balance is >=1000 && <5000, it should return 0.1% of 10000
  		assertEquals(10, fee); 
  	}
  	
  	@Test
  	void testNonStudent5000() { //This test is for non-students with balances of exactly 5000
  		FeesCalculator calc = new FeesCalculator(); 
  		int fee = calc.calculateWithdrawalFee(10000, 5000, false, Calendar.MONDAY); //Since the balance is >=5000, it should return 0 fee
  		assertEquals(0, fee); 
  	}
  	
  	@Test
  	void testNonStudentUpper() { //This test is for the upper bounds (>5000) of non-students 
  		FeesCalculator calc = new FeesCalculator(); 
  		int fee = calc.calculateWithdrawalFee(10000, 7000, false, Calendar.MONDAY); //Since the balance is >=5000, it should return 0 fee
  		assertEquals(0, fee); 
  	}
  	
	//Since this is robust analysis, have also included a test with negative balance (which would be out of the expected range)
	@Test
	void testNonStudentNegative() {
		FeesCalculator calc = new FeesCalculator(); 
		int fee = calc.calculateWithdrawalFee(10000, -10, false, Calendar.MONDAY);
		assertEquals(30, fee); //Since negative numbers are below 1000, it would be expected that the output should still be 0.3% of the amount withdrawn
	}

  	
  	//The 2 tests below are for the student 
  	 private int withdrawalAmount = 200;
  	 FeesCalculator calc = new FeesCalculator(); 

	@Test
	void withdrawalStudentWeekdayTest() {
		for (int i = 2; i < 7; i++) { // Monday to Friday
			assertEquals(0.1, calc.calculateWithdrawalFee(withdrawalAmount, 1000, true, i));
		}
	}

	@Test
	void withdrawalStudentWeekendTest() {
		double expectedFee = withdrawalAmount * 0.001; // 0.1% of the withdrawal fee should be given if its a												// weekend
		assertEquals(expectedFee, calc.calculateWithdrawalFee(withdrawalAmount, 1000, true, 1)); // Sunday
		assertEquals(expectedFee, calc.calculateWithdrawalFee(withdrawalAmount, 1000, true, 7)); // Saturday
	}

}