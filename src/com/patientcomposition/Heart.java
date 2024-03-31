package com.patientcomposition;

import com.optionbehaviour.ActionOption;

import java.util.Scanner;

public class Heart extends BodyPart {
    private int heartRate;

    public Heart(String name, String condition, int heartRate) {
        super(name, condition);
        this.heartRate = heartRate;

        this.setActionOptions(new ActionOption[]{
                new ActionOption("Modify Heart Rate", () -> {
                    modifyHeartRate();
                })
        });
    }

    public void modifyHeartRate() {
        System.out.println("Enter a new heart rate");
        Scanner input = new Scanner(System.in);
        int newRate = input.nextInt();
        this.setHeartRate(newRate);
        System.out.println("Heart Rate is now: " + newRate);
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    @Override
    public String getAdditionalInfo() {
        return "Heart  rate: " + this.heartRate;
    }
}
