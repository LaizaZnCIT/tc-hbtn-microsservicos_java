package com.example.calculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

public class CalculatorTest {
	
	Calculator calculator;
	 	@BeforeEach
	 	void setUp() {
	 		calculator = new Calculator();
	 	}
	 	
		@Test
	    void sumTest() {
	        assertEquals(calculator.sum(5.0, 4.0), 9.0);
	    }

	    @Test
	    public void numbersNullSumTest() {
	       NullPointerException exception = assertThrows(NullPointerException.class, () -> {
	    	   calculator.sum(null, null);
	       }, "Número 1 e número 2 são obrigatórios.");
	       
	       assertEquals("Número 1 e número 2 são obrigatórios.", exception.getMessage());
	    }

	    @Test
	    void subTest() {
	       assertEquals(calculator.sub(10.0, 2.0), 8.0);
	    }

	    @Test
	    void divideTest() {
	       assertEquals(calculator.divide(10.0, 2.0), 5.0);
	    }

	    @Test
	    public void divisionByZeroTest() {
	    	ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
	    		calculator.divide(9.0, 0.0);
	    	}, "Divisão por zero não é permitido.");
	    	
	    	assertEquals("Divisão por zero não é permitido.", exception.getMessage());
	    }

	    @Test
	    void factorialTest() {
	        assertEquals(calculator.factorial(5), 120);
	    }

	    @Test
	    void integerToBinaryTest() {
	       assertEquals(calculator.integerToBinary(5), 101);
	    }

	    @Test
	    void integerToHexadecimalTest() {
	       assertEquals(calculator.integerToHexadecimal(16), "10");
	    }

	    @Test
	    void calculeDayBetweenDateTest() {
	       assertEquals(calculator.calculeDayBetweenDate(LocalDate.of(2008, 05, 8),LocalDate.of(2008, 05, 01)), -7);
	    }
}
