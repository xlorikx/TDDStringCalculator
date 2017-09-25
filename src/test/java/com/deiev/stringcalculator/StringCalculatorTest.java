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
    public void whenEmptyStringReturnZero() {
        String emptyString = "";
        int result = stringCalculator.add(emptyString);
        assertEquals(result, 0);
    }
}
