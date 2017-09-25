package com.deiev.stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ParsingUtils {

    private static final String separators = "[\n|,]";
    private static final Pattern patternForCustomSeparator = Pattern.compile("^(//(.)\n).*$");

    static List<Integer> parseNumbers(String numbers) {
        String separator = separators;
        Matcher customSeparatorMatcher = patternForCustomSeparator.matcher(numbers);

        if (customSeparatorMatcher.matches()) {
            separator = Pattern.quote(customSeparatorMatcher.group(2));
            numbers = numbers.substring(customSeparatorMatcher.group(1).length());
        }

        return mapStringsToIntegers(numbers, separator);
    }

    private static List<Integer> mapStringsToIntegers(String numbers, String separator) {
        List<String> separatedDigitsAsString = Arrays.asList(numbers.split(separator));
        List<Integer> result = new ArrayList<>(separatedDigitsAsString.size());

        for (String s : separatedDigitsAsString) {
            result.add(Integer.valueOf(s));
        }

        checkForNegatives(result);
        return result;
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