package com.patientcomposition;

import java.util.Date;
import java.time.LocalDate;
import java.time.Period;

/**
 * A basic patient class
 * A full patient model would require many more fields and functions.
 */
public class Patient {
    private String name;
    private Date dateOfBirth;
    private BodyPart[] bodyParts;

    public Patient(String name, Date dateOfBirth, BodyPart[] bodyParts) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.bodyParts = bodyParts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        LocalDate today = LocalDate.now();
        LocalDate birthday = dateOfBirth.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        return Period.between(birthday, today).getYears();
    }

    public BodyPart[] getBodyParts() {
        return bodyParts;
    }

    public void setBodyParts(BodyPart[] bodyParts) {
        this.bodyParts = bodyParts;
    }
}
