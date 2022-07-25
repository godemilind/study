package com.iocs.spring.beans.crud.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class TitleValidator implements ConstraintValidator<Title,String> {

    List<String> titles = Arrays.asList("Java","Spring",".net","Struts","Hibernate");


    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return titles.contains(s);
    }
}
