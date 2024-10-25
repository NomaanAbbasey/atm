package test;

import static org.junit.jupiter.api.Assertions.*;
import bank.FeesCalculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class transferTest {
    FeesCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new FeesCalculator();
    }

    @AfterEach
    void tearDown() {
        calculator = null; // Clean up after each test
    }

	@Test
	void transferStudentTestsCase1() {
		// Less than $200, student and the account money is coming from less than $2000 and going to less than $1000
		assertEquals(0.19, calculator.calculateTransferFee(190, 1990, 990, true)); // 0.1% fee
	}
	
	@Test
	void transferStudentTestsCase2() {
		// Less than $200, student and the account money is coming from less than $2000 and going to greater than $1000
		assertEquals(0.095, calculator.calculateTransferFee(190, 1990, 1010, true)); // 0.05% fee
	}
	
	@Test
	void transferStudentTestsCase3() {
		// Less than $200, student
		assertEquals(0.5, calculator.calculateTransferFee(200, 1500, 2000, true)); // 0.25% for ≥ 200, mixed balances
	}

	@Test
	void transferStudentHighAmountTestsCase1() {
		// $200 or more, student and the account money is coming from more than $2000 and going to less than $1000
		assertEquals(0.5, calculator.calculateTransferFee(200, 2500, 900, true)); // 0.25% fee for higher amount
	}
	
	@Test
	void transferStudentHighAmountTestsCase2() {
		// $200 or more, student and the account money is coming from less than $2000 and going to greater than $1000
		assertEquals(0.25, calculator.calculateTransferFee(200, 2500, 1200, true)); // 0.125% for high balances
	}

	@Test
	void transferNotStudentTests() {
		// Less than $100, non-student and the account money is coming from less than $4000 and going to greater than $2000
		assertEquals(0.18, calculator.calculateTransferFee(90, 3900, 1800, false)); // 0.2% of 90																					// low "to" balance
	}
	
	@Test
	void transferNotStudentTestsCase2() {
		// Less than $100, non-student
		assertEquals(0.9, calculator.calculateTransferFee(90, 4500, 1000, false)); // 1% of 90 for high "from" balance,																			// low "to" balance
	}

	@Test
	void transferNotStudentHighAmountTestsCase1() {
		// $100 or more, non-student
		assertEquals(0.2, calculator.calculateTransferFee(100, 1500, 800, false)); // 0.2% for "from" low, "to" low
	}
	
	@Test
	void transferNotStudentHighAmountTestsCase2() {
		// $100 or more, non-student
		assertEquals(0.1, calculator.calculateTransferFee(100, 1500, 1200, false)); // 0.1% for "from" low, "to" high
	}
	
	@Test
	void transferNotStudentHighAmountTestsCase3() {
		// $100 or more, non-student	
		assertEquals(0.5, calculator.calculateTransferFee(100, 2000, 900, false)); // 0.5% for "from" high, "to" low
	}
	
	@Test
	void transferNotStudentHighAmountTestsCase4() {
		// $100 or more, non-student
		assertEquals(0.25, calculator.calculateTransferFee(100, 2500, 1500, false)); // 0.25% for high balances
	}

	@Test
	void transferNonStudentBoundaryTests() {
		// Edge cases
		assertEquals(0.18, calculator.calculateTransferFee(90, 3999, 1999, false)); // Just below the high balance cutoff
	}
	
	@Test
	void transferNonStudentBoundaryTestsCase2() {
		// Edge cases
		assertEquals(0.9, calculator.calculateTransferFee(90, 4000, 999, false)); // Just on the cutoff, should apply																					// high fee
	}
	
	@Test
	void transferNonStudentBoundaryTestsCase3() {
		// Edge cases
		assertEquals(0.0, calculator.calculateTransferFee(200, 5000, 5000, false)); // Test no fee for high balances
	}
}
