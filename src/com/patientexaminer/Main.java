package com.patientexaminer;
import java.text.ParseException;

import com.patientcomposition.*;
import ukDateParser.DateParse;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ParseException {


        //The setup stage.
        Patient patient = new Patient(
                "Tom",
                DateParse.parseDate("03/06/1988"),
                new BodyPart[]{
                        new Eye("Left Eye", "Normal", "Blue", true),
                        new Eye("Right Eye", "Normal", "Blue", true),
                        new Heart("Heart", "Fine", 65),
                        new Stomach("Stomach", "Good", true),
                        new Skin("Skin", "Burnt")
                });

        //Create the game instance and run the main game loop
        PatientExaminer program = new PatientExaminer(patient);
        program.run();
    }
}