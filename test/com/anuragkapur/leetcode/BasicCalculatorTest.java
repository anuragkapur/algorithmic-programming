package com.anuragkapur.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class BasicCalculatorTest {

    BasicCalculator calculator = new BasicCalculator();

    @Test
    public void testCalculate1() throws Exception {
        assertEquals(0, calculator.calculate(null));
    }

    @Test
    public void testCalculate2() throws Exception {
        assertEquals(1, calculator.calculate("1"));
    }

    @Test
    public void testCalculate3() throws Exception {
        assertEquals(2, calculator.calculate("1 + 1"));
    }

    @Test
    public void testCalculate4() throws Exception {
        assertEquals(3, calculator.calculate("2-1+2"));
    }

    @Test
    public void testCalculate5() throws Exception {
        assertEquals(23, calculator.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}