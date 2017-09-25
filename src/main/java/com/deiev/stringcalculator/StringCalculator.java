package com.deiev.stringcalculator;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

class StringCalculator {

    int add(String s) {
        int result = 0;

        if (isNotBlank(s)) {
            result = Integer.valueOf(s);
        }

        return result;
    }
}
