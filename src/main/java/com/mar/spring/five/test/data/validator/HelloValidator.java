package com.mar.spring.five.test.data.validator;

import com.mar.spring.five.test.data.entity.Hello;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static com.mar.spring.five.test.data.validator.utils.ValidatorUtils.validObj;
import static com.mar.spring.five.test.data.validator.utils.ValidatorUtils.validString;

@Component
public class HelloValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Hello.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Hello obj = (Hello) target;
        validObj(obj, "obj", errors);
        validString(obj.getUserName(), "userName", errors);
        validString(obj.getMsg(), "msg", errors);
        validObj(obj.getSendDate(), "sendDate", errors);
    }

}
