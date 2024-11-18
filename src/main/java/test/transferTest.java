package test;

import static org.junit.jupiter.api.Assertions.*; 
import bank.FeesCalculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class transfer_asn2 {
    FeesCalculator calculator = new FeesCalculator();
    
    @BeforeEach
    void setup() {
    }
    
	//Whitebox Testing, the basis paths have 16 different tests 
	@Test
    void testStudentTransferUnder10000FromLowToLow() {
        int transferAmt = 9000;
        int fromAmt = 90000;
        int toAmt = 90000;
        double expectedFee = 0.001 * transferAmt;
        assertEquals(expectedFee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, true));
    }

    @Test
    void testStudentTransferUnder10000FromLowToOver() {
    	int transferAmt = 9000;
    	int fromAmt = 90000;
    	int toAmt = 101000;
        double expectedFee = 0.0005 * transferAmt;
        assertEquals(expectedFee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, true));
    }

    @Test
    void testStudentTransferUnder10000FromOverToLow() {
    	int transferAmt = 9000;
    	int fromAmt = 110000;
    	int toAmt = 90000;
        double expectedFee = 0.005 * transferAmt;
        assertEquals(expectedFee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, true));
    }

    @Test
    void testStudentTransferUnder10000FromOverToOver() {
    	int transferAmt = 9000;
    	int fromAmt = 110000;
    	int toAmt = 101000;
        double expectedFee = 0.0025 * transferAmt;
        assertEquals(expectedFee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, true));
    }

    @Test
    void testStudentTransferOver10000FromLowToLow() {
    	int transferAmt = 11000;
    	int fromAmt = 90000;
    	int toAmt = 90000;
        double expectedFee = 0.0005 * transferAmt;
        assertEquals(expectedFee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, true));
    }

    @Test
    void testStudentTransferOver10000FromLowToOver() {
    	int transferAmt = 11000;
    	int fromAmt = 90000;
    	int toAmt = 101000;
        double expectedFee = 0.00025 * transferAmt;
        assertEquals(expectedFee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, true));
    }

    @Test
    void testStudentTransferOver10000FromOverToLow() {
    	int transferAmt = 11000;
    	int fromAmt = 110000;
    	int toAmt = 90000;
        double expectedFee = 0.0025 * transferAmt;
        assertEquals(expectedFee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, true));
    }

    @Test
    void testStudentTransferOver10000FromOverToOver() {
    	int transferAmt = 11000;
    	int fromAmt = 110000;
    	int toAmt = 101000;
        double expectedFee = 0.00125 * transferAmt;
        assertEquals(expectedFee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, true));
    }

    @Test
    void testNonStudentTransferUnder10000FromLowToLow() {
    	int transferAmt = 9000;
    	int fromAmt = 90000;
    	int toAmt = 90000;
        double expectedFee = 0.002 * transferAmt;
        assertEquals(expectedFee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, false));
    }

    @Test
    void testNonStudentTransferUnder10000FromLowToOver() {
    	int transferAmt = 9000;
    	int fromAmt = 90000;
    	int toAmt = 101000;
        double expectedFee = 0.001 * transferAmt;
        assertEquals(expectedFee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, false));
    }

    @Test
    void testNonStudentTransferUnder10000FromOverToLow() {
    	int transferAmt = 9000;
    	int fromAmt = 110000;
    	int toAmt = 90000;
        double expectedFee = 0.01 * transferAmt;
        assertEquals(expectedFee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, false));
    }

    @Test
    void testNonStudentTransferUnder10000FromOverToOver() {
    	int transferAmt = 9000;
    	int fromAmt = 110000;
    	int toAmt = 101000;
        double expectedFee = 0.005 * transferAmt;
        assertEquals(expectedFee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, false));
    }

    @Test
    void testNonStudentTransferOver10000FromLowToLow() {
    	int transferAmt = 11000;
    	int fromAmt = 90000;
    	int toAmt = 90000;
        double expectedFee = 0.001 * transferAmt;
        assertEquals(expectedFee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, false));
    }

    @Test
    void testNonStudentTransferOver10000FromLowToOver() {
    	int transferAmt = 11000;
    	int fromAmt = 90000;
    	int toAmt = 101000;
        double expectedFee = 0.0005 * transferAmt;
        assertEquals(expectedFee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, false));
    }

    @Test
    void testNonStudentTransferOver10000FromOverToLow() {
    	int transferAmt = 11000;
    	int fromAmt = 110000;
    	int toAmt = 90000;
        double expectedFee = 0.005 * transferAmt;
        assertEquals(expectedFee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, false));
    }

    @Test
    void testNonStudentTransferOver10000FromOverToOver() {
        int transferAmt = 11000;
        int fromAmt = 110000;
        int toAmt = 101000;
        double expectedFee = 0.0055 * transferAmt;
        assertEquals(expectedFee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, false));
    }
}
