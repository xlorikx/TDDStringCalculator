package com.deiev.stringcalculator;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeClass
    public void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void whenEmptyStringReturnZero() throws Exception {
        assertResultForString("", 0);
    }

    @Test
    public void whenSingleNumberReturnIt() throws Exception {
        assertResultForString("777", 777);
    }

    @Test
    public void whenTwoNumbersReturnTheirSum() throws Exception {
        assertResultForString("2,5", 7);
    }

    @Test
    public void whenMoreThanTwoNumbersReturnTheirSum() throws Exception {
        assertResultForString("1,2,3,5", 11);
    }

    @Test
    public void allowNewLineSymbolAsSeparator() throws Exception {
        assertResultForString("1\n2,3", 6);
    }

    private void assertResultForString(String input, int expected) {
        int result = stringCalculator.add(input);
        assertEquals(result, expected);
    }
}
