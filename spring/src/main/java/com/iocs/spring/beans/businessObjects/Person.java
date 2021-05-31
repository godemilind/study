package com.iocs.spring.beans.businessObjects;

import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class Person {

    @NonNull
    private String firstName;

    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
