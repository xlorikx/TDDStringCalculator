package com.deiev.stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

class StringCalculator {

    private static final String separators = "[\n|,]";
    private static final Pattern patternForCustomSeparator = Pattern.compile("^(//(.)\n).*$");

    int add(String stringNumbers) {
        List<Integer> numbers = Collections.emptyList();

        if (isNotBlank(stringNumbers)) {
            numbers = parseNumbers(stringNumbers);
        }

        return sum(numbers);
    }

    private List<Integer> parseNumbers(String numbers) {
        String separator = separators;
        Matcher customSeparatorMatcher = patternForCustomSeparator.matcher(numbers);

        if (customSeparatorMatcher.matches()) {
            separator = Pattern.quote(customSeparatorMatcher.group(2));
            numbers = numbers.substring(customSeparatorMatcher.group(1).length());
        }

        List<String> separated = Arrays.asList(numbers.split(separator));
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
