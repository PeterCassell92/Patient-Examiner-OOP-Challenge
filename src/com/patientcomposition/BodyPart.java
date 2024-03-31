package com.patientcomposition;

import com.optionbehaviour.ActionOption;

/**
 * A base class used to model Body Parts (organs)
 */
public class BodyPart {
    private String name;
    private String condition;

    private ActionOption[] organActionOptions;

    public BodyPart(String name, String condition) {
        this.name = name;
        this.condition = condition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public ActionOption[] getActionOptions() {
        return organActionOptions;
    }

    public void setActionOptions(ActionOption[] actionOptions) {
        this.organActionOptions = actionOptions;
    }

    public String getAdditionalInfo (){
        return null;
    }
}
