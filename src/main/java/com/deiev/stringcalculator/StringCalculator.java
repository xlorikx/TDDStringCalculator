package com.deiev.stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

class StringCalculator {

    private static final String separators = "[\n|,]";

    int add(String stringNumbers) {
        List<Integer> numbers = Collections.emptyList();

        if (isNotBlank(stringNumbers)) {
            numbers = parseNumbers(stringNumbers);
        }

        return sum(numbers);
    }

    private List<Integer> parseNumbers(String numbers) {
        List<String> separated = Arrays.asList(numbers.split(separators));
        List<Integer> result = new ArrayList<>(separated.size());

        for (String s : separated) {
            result.add(Integer.parseInt(s));
        }

        return result;
    }

    private int sum(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}
