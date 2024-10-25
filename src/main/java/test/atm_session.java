package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import atm.ATM;
import atm.Session;
import banking.Money;
import banking.exceptions.*;

class atm_session {
	
	Money test_money = new Money(1);
	ATM atm_test = new ATM(0, "London", "CIBC", null, false, 4567, "12345", 0, 0, 1, test_money);
	
	//pin tests
	
	@Test
	void test_1() {
		Session test_session = new Session(atm_test, 4567, "12345", 3, 0, 1, test_money);
		assertDoesNotThrow(() -> test_session.performSession()); //not try catching this since pin is the first exception to be thrown anyways...
	}
	
	@Test
	void test_2() {
		Session test_session = new Session(atm_test, 4567, "1234", 3, 0, 1, test_money);
		Exception exception = assertThrows(InvalidPINException.class, () -> {
			test_session.performSession();  
        });
	}
	
	@Test
	void test_3() {
		Session test_session = new Session(atm_test, 4567, "123456", 3, 0, 1, test_money);
		Exception exception = assertThrows(InvalidPINException.class, () -> {
			test_session.performSession();  
        });
	}
	
	@Test
	void test_4() {
		Session test_session = new Session(atm_test, 4567, "12a34", 3, 0, 1, test_money);
		Exception exception = assertThrows(InvalidPINException.class, () -> {
			test_session.performSession();  
        });
	}
	
	@Test
	void test_5() {
		Session test_session = new Session(atm_test, 4567, "", 3, 0, 1, test_money);
		Exception exception = assertThrows(InvalidPINException.class, () -> {
			test_session.performSession();  
        });
	}
	
	//withdrawal tests
	
	@Test
	void test_6() {
		//I know this is bad, but im gonna hack at it a bit because im too lazy to make more money objects
		test_money = new Money(100);
		Session test_session = new Session(atm_test, 4567, "123", 0, 0, 1, test_money);
		
		try {
			test_session.performSession();
		}
		catch(InvalidAmountException e) {
			fail("Test 6 Failed: InvalidAmountException was thrown");
		}
		catch(Exception e) {
			//i don't care about the other exceptions
		}
	}
	
	@Test
	void test_7() {
		test_money = new Money(60);
		Session test_session = new Session(atm_test, 4567, "123", 0, 0, 1, test_money);
		try {
			test_session.performSession();
		}
		catch(InvalidAmountException e) {
			fail("Test 7 Failed: InvalidAmountException was thrown");
		}
		catch(Exception e) {
			//i don't care about the other exceptions
		}
	}
	
	@Test
	void test_8() {
		test_money = new Money(45);
		Session test_session = new Session(atm_test, 4567, "123", 0, 0, 1, test_money);
		InvalidAmountException exception = assertThrows(InvalidAmountException.class, () -> {
			test_session.performSession();  
        });
	}
	
	@Test
	void test_9() {
		test_money = new Money(0);
		Session test_session = new Session(atm_test, 4567, "123", 0, 0, 1, test_money);
		try {
			test_session.performSession();
		}
		catch(InvalidAmountException e) {
			
		}
		catch(Exception e) {
			//i don't care about the other exceptions
		}
		
		fail("Test 9 Failed: Didn't catch InvalidAmountException.");
	}
	
	@Test
	void test_10() {
		test_money = new Money(1050);
		Session test_session = new Session(atm_test, 4567, "123", 0, 0, 1, test_money);
		try {
			test_session.performSession();
		}
		catch(InvalidAmountException e) {
			
		}
		catch(Exception e) {
			//i don't care about the other exceptions
		}
		
		fail("Test 10 Failed: Didn't catch InvalidAmountException.");
	}
	
	@Test
	void test_11() {
		test_money = new Money(6000);
		Session test_session = new Session(atm_test, 4567, "123", 0, 0, 1, test_money);
		try {
			test_session.performSession();
		}
		catch(InvalidAmountException e) {
			
		}
		catch(Exception e) {
			//i don't care about the other exceptions
		}
		
		fail("Test 11 Failed: Didn't catch InvalidAmountException.");
	}
	
	//single fault tests
	
	@Test
	void test_12() {
		test_money = new Money(1000);
		Session test_session = new Session(atm_test, 4567, "12345", 0, 0, 1, test_money);
		try {
			test_session.performSession();
		}
		catch(InvalidPINException e) {
			fail("Test 11 Failed: Didn't catch InvalidPINException.");
		}
		catch(InvalidAmountException e) {
			fail("Test 11 Failed: Didn't catch InvalidAmountException.");
		}
		catch(Exception e) {
			//i don't care about the other exceptions like null pointer to simulation so im not going to explicitly assert!
		}
	}
	
	@Test
	void test_13() {
		test_money = new Money(45);
		Session test_session = new Session(atm_test, 4567, "12345", 0, 0, 1, test_money);
		InvalidAmountException exception = assertThrows(InvalidAmountException.class, () -> {
			test_session.performSession();  
        });
	}
	
	@Test
	void test_14() {
		test_money = new Money(100);
		Session test_session = new Session(atm_test, 4567, "123", 0, 0, 1, test_money);
		try {
			test_session.performSession();
		}
		catch(InvalidPINException e) {
		
		}
		catch(InvalidAmountException e) {
			
		}
		catch(Exception e) {
			//i don't care about the other exceptions like null pointer to simulation so im not going to explicitly assert!
		}
		
		fail("Test 14 Failed: Didn't catch InvalidPINException.");
	}

}
