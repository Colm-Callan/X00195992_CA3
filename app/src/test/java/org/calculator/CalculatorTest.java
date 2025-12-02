package org.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class CalculatorTest {
    Calculator calc = new Calculator();

    @Test void testAdd() { assertEquals(5, calc.add(2, 3)); }
    @Test void testSubtract() { assertEquals(1, calc.subtract(3, 2)); }
    @Test void testMultiply() { assertEquals(6, calc.multiply(2, 3)); }
    @Test void testDivide() { assertEquals(2.0, calc.divide(6, 3)); }
    @Test void testDivideByZero() { 
        assertThrows(ArithmeticException.class, () -> calc.divide(5, 0)); 
    }
        @Test void testSquare() {
        assertEquals(16, calc.square(4));
        assertEquals(9, calc.square(3));
    }
}
class CalculatorMainTest {

    @Test
    void main_printsExpectedResults() {
        // this is used to capture System.out
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));
        try {
            // Act
            Calculator.main(new String[0]);

            // This will only work if a=9, b=3 in main
            String output = out.toString();
            assertTrue(output.contains("add: 12"), "Expected 'add: 12'");
            assertTrue(output.contains("subtract: 6"), "Expected 'subtract: 6'");
            assertTrue(output.contains("multiply: 27"), "Expected 'multiply: 27'");
            assertTrue(output.contains("divide: 3.0"), "Expected 'divide: 3.0'");
        } finally {
            // Restore
            System.setOut(originalOut);
        }
    }
}