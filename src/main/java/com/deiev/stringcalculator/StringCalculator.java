package com.deiev.stringcalculator;

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

        return sum(numbers);
    }

    private int sum(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}
