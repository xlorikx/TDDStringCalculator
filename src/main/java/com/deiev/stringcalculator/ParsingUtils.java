package com.deiev.stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

        return Arrays.stream(numbers.split(separator)).map(Integer::parseInt).collect(Collectors.toList());
    }
}
