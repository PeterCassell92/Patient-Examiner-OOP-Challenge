package com.patientcomposition;

import com.optionbehaviour.ActionOption;

public class Eye extends BodyPart{
    private String color;
    private boolean isOpen;
    public Eye(String name, String condition, String color, boolean isOpen ) {
        super(name, condition);
        this.color = color;
        this.isOpen = isOpen;

        this.setActionOptions( new ActionOption[]{
            new ActionOption("Close the Eye", this::close),
            new ActionOption("Open the Eye", this::open)
        });
    }

    public void close(){
        if(this.isOpen){
            this.setIsOpen(false);
            System.out.println("Eye closed");
        }
    }
    public void open(){
        if(!this.isOpen){
            this.setIsOpen(true);
            System.out.println("Eye closed");
        }
        System.out.println("Eye opened");
    }

    public String getColor() {
        return color;
    }

    public boolean isisOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    @Override
    public String getAdditionalInfo() {
        return "Color: " + this.color;
    }
}
