package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import bank.FeesCalculator;
import java.util.Calendar;

class WithdrawalTest {
	//The below 5 tests are checking the balance boundaries for non-students 
	@Test
	void testNonStudentLower() { //This test is for the lower bounds of non-students
		FeesCalculator calc = new FeesCalculator(); 
		int fee = calc.calculateWithdrawalFee(10000, 999, false, Calendar.MONDAY); //Since the balance is <1000, it should return 0.3% of 10000
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
		int fee = calc.calculateWithdrawalFee(10000, 5001, false, Calendar.MONDAY); //Since the balance is >=5000, it should return 0 fee
		assertEquals(0, fee); 
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
    	 double expectedFee = withdrawalAmount * 0.001;  // 0.1% of the withdrawal fee should be given if its a weekend
         assertEquals(expectedFee, calc.calculateWithdrawalFee(withdrawalAmount, 1000, true, 1)); // Sunday 
         assertEquals(expectedFee, calc.calculateWithdrawalFee(withdrawalAmount, 1000, true, 7)); // Saturday 
     }

}
