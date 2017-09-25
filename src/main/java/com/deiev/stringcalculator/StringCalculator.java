package com.deiev.stringcalculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.deiev.stringcalculator.ParsingUtils.parseNumbers;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

class StringCalculator {

    int add(String stringNumbers) {
        List<Integer> numbers = Collections.emptyList();

        if (isNotBlank(stringNumbers)) {
            numbers = parseNumbers(stringNumbers);
        }

        checkForNegatives(numbers);
        numbers = filterBigNumbers(numbers);

        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    private static void checkForNegatives(List<Integer> result) {
        List<Integer> negatives = new ArrayList<>();

        for (Integer number : result) {
            if (number < 0) {
                negatives.add(number);
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers are forbidden: " + negatives);
        }
    }

    private List<Integer> filterBigNumbers(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : numbers) {
            if (number <= 1000) {
                result.add(number);
            }
        }
        return result;
    }
}
