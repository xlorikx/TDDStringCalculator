package com.deiev.stringcalculator;

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

        List<Integer> negatives = numbers.stream().filter(e -> e <= 0).collect(Collectors.toList());

        if (negatives.size() != 0) {
            throw new IllegalArgumentException("Negative numbers are forbidden: " + negatives);
        }

        return numbers.stream().filter(e -> e <= 1000).mapToInt(Integer::intValue).sum();
    }
}
