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

        List<String> separatedDigitsAsString = Arrays.asList(numbers.split(separator));
        List<Integer> result = new ArrayList<>(separatedDigitsAsString.size());

        for (String s : separatedDigitsAsString) {
            result.add(Integer.parseInt(s));
        }

        return result;
    }
}
