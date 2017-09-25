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
        String emptyString = "";
        int result = stringCalculator.add(emptyString);
        assertEquals(result, 0);
    }

    @Test
    public void whenSingleNumberReturnIt() throws Exception {
        String stringNumberValue = "777";
        int intNumberValue = 777;
        int result = stringCalculator.add(stringNumberValue);
        assertEquals(result, intNumberValue);
    }

    @Test
    public void whenTwoNumbersReturnTheirSum() throws Exception {
        String twoComaSeparatedNumbers = "2,5";
        int intSumOfNumbers = 7;
        int result = stringCalculator.add(twoComaSeparatedNumbers);
        assertEquals(result, intSumOfNumbers);
    }
}
