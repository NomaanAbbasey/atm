package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import atm.ATM;
import atm.Session;
import banking.Money;
import banking.exceptions.*;

class atm_session {
	
	ATM atm_test = new ATM(0, "London", "CIBC", null);
	Money test_money = new Money(100);
	
	@Test
	void test_1() {
		Session test_session = new Session(atm_test, 4567, "12345", 3, 0, 1, test_money);
		assertDoesNotThrow(() -> test_session.performSession());
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

}
