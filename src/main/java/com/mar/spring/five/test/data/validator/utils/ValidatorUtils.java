package com.mar.spring.five.test.data.validator.utils;

import lombok.experimental.UtilityClass;
import org.springframework.validation.Errors;

import static java.util.Objects.isNull;

@UtilityClass
public class ValidatorUtils {

    public static void validObj(Object str, String filedName, Errors errors) {
        if (isNull(str)) {
            errors.rejectValue(filedName, filedName + "isNull");
        }
    }

    public static void validString(String str, String filedName, Errors errors) {
        if (isNull(str)) {
            errors.rejectValue(filedName, filedName + "isNull");
            return;
        }
        if (str.isEmpty()) {
            errors.rejectValue(filedName, filedName + "isEmpty");
        }
    }

}
