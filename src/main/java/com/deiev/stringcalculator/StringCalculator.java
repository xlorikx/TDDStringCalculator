package com.deiev.stringcalculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.deiev.stringcalculator.ParsingUtils.parseNumbers;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

class StringCalculator {

    int add(String stringNumbers) {
        List<Integer> numbers = Collections.emptyList();

        if (isNotBlank(stringNumbers)) {
            numbers = parseNumbers(stringNumbers);
        }

        checkForNegatives(numbers);

        numbers = numbers.stream().filter(e -> e <= 1000).collect(Collectors.toList());
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
}
