package com.patientcomposition;

import com.optionbehaviour.ActionOption;

import java.util.Scanner;

public class Stomach extends BodyPart {
    private Boolean hungry;

    public Stomach(String name, String condition, Boolean hungry) {
        super(name, condition);
        this.hungry = hungry;

        this.setActionOptions(new ActionOption[]{
                new ActionOption("Digest", this::digest)
        });
    }

    public Boolean getHungry() {
        return hungry;
    }

    public void setHungry(Boolean hungry) {
        this.hungry = hungry;
    }

    public void digest(){
        System.out.println("Digesting has begun");
    }

    @Override
    public String getAdditionalInfo() {
        if(this.hungry){
            return "Needs to be fed";
        }
        return null;
    }
}
