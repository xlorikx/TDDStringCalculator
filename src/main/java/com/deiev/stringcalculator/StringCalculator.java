package com.deiev.stringcalculator;

import static org.apache.commons.lang3.StringUtils.chomp;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

class StringCalculator {

    int add(String numbers) {
        int result = 0;

        if (isNotBlank(numbers)) {
            if (numbers.contains(",")) {
                for (String digit : numbers.split(",")) {
                    result += Integer.parseInt(digit);
                }
            } else result = Integer.valueOf(numbers);
        }

        return result;
    }
}
