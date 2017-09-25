package com.deiev.stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

class StringCalculator {

    int add(String stringNumbers) {
        List<Integer> numbers = Collections.emptyList();

        if (isNotBlank(stringNumbers)) {
            numbers = parseNumbers(stringNumbers);
        }

        return sum(numbers);
    }

    private List<Integer> parseNumbers(String numbers) {
        List<String> separated = Arrays.asList(numbers.split(","));
        List<Integer> result = new ArrayList<>(separated.size());

        for (String s : separated) {
            result.add(Integer.parseInt(s));
        }

        return result;
    }

    private int sum(List<Integer> terms) {
        int sum = 0;
        for (Integer term : terms) {
            sum += term;
        }
        return sum;
    }
}
