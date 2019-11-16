package me.choi.demospring51resourceloader;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EventValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Event.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"title","notempty","Empty title is not allowed");
//        Event event = (Event) target;
//        if (event.getTitle() == null)
//            errors.reject();
    }
}
