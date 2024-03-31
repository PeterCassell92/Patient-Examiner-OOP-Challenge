package com.patientexaminer;

import com.optionbehaviour.ActionOption;
import com.optionbehaviour.OptionSelector;
import com.patientcomposition.BodyPart;
import com.patientcomposition.Patient;

import java.util.Arrays;
import java.util.Scanner;

/** The class responsible for providing a UI to the user for examining/interacting with a patient
 */
public class PatientExaminer {
    private final Patient patient;

    final private String[] stages = { "Organ Select", "Organ Action Select" };

    private int currentStageIndex = 0;

    private OptionSelector optionSelector;

    private BodyPart currentOrgan;

    public BodyPart getCurrentOrgan() {
        return currentOrgan;
    }

    public void setCurrentOrgan(BodyPart currentOrgan) {
        this.currentOrgan = currentOrgan;
    }

    public int getCurrentStageIndex() {
        return currentStageIndex;
    }

    public void setCurrentStageIndex(int currentStageIndex) {
        this.currentStageIndex = currentStageIndex;
    }

    public OptionSelector getOptionSelector() {
        return optionSelector;
    }

    public void setOptionSelector(OptionSelector optionSelector) {
        this.optionSelector = optionSelector;
    }

    public PatientExaminer(Patient patient) {
        this.patient = patient;
        Scanner userInput = new Scanner(System.in);
        this.optionSelector = new OptionSelector(userInput, null);
    }

    public void nextStage(){
        if(this.getCurrentStageIndex() + 1 < this.stages.length ) {
            this.setCurrentStageIndex(this.getCurrentStageIndex() + 1);
        }
    }

    public void previousStage(){
        this.setCurrentStageIndex(this.getCurrentStageIndex() - 1);
    }

    public ActionOption[] getOrgansActionOptions(){
        BodyPart[] bodyParts = this.patient.getBodyParts();
        ActionOption[] actionOptions = Arrays.stream(bodyParts)
                .map( bp -> new ActionOption(bp.getName(), () -> {
                    this.setCurrentOrgan(bp);
                    this.nextStage();
                } ))
                .toArray(ActionOption[]::new);
        return actionOptions;
    }

    public void chooseFromOrgansList(){
        System.out.println("Choose an Organ:");

        ActionOption[] organListOptions = getOrgansActionOptions();
        ActionOption[] allListOptions = new ActionOption[organListOptions.length + 1];
        // Copy organListOptions to allListOptions
        System.arraycopy(organListOptions, 0, allListOptions, 0, organListOptions.length);

        // Add the "Back" option to allListOptions
        allListOptions[organListOptions.length] = new ActionOption("Quit", () -> {
            this.setCurrentOrgan(null);
            this.previousStage();
        });


        //Set the organ list to the option selector
        this.optionSelector.setOptions(allListOptions);
        this.optionSelector.promptSelectAndRunSelectedAction();
    }

    public void chooseFromOrganActionsList(){
        System.out.println("Choose an Action:");

        ActionOption[] organActionListOptions = this.currentOrgan.getActionOptions();

        ActionOption[] allListOptions = new ActionOption[organActionListOptions.length + 1];
        // Copy organListOptions to allListOptions
        System.arraycopy(organActionListOptions, 0, allListOptions, 0, organActionListOptions.length);

        // Add the "Back" option to allListOptions
        allListOptions[organActionListOptions.length] = new ActionOption("Back", () -> {} );

        //Set the actions list to the option selector
        this.optionSelector.setOptions(allListOptions);
        this.optionSelector.promptSelectAndRunSelectedAction();
        //in this case always go to previous stage
        this.previousStage();
    }

    public void run(){

        System.out.println("Name: " + this.patient.getName());
        System.out.println("Age: " + this.patient.getAge());

        //The main "game loop"
        while(currentStageIndex != -1){
            this.performStage();
        }

        System.out.println("DONE");
    }

    public void performStage(){
        if(this.currentStageIndex == 0){
            this.chooseFromOrgansList();
        } else if (this.currentStageIndex == 1 && this.currentOrgan!=null) {
            System.out.printf("Name: %s%n", this.currentOrgan.getName());
            System.out.printf("Medical Condition: %s%n", this.currentOrgan.getCondition());

            if(this.currentOrgan.getAdditionalInfo() != null){
                System.out.printf("%s%n", this.currentOrgan.getAdditionalInfo());

            }
            System.out.printf("%n");

            if(this.currentOrgan.getActionOptions() != null) {
                this.chooseFromOrganActionsList();
            } else {
                this.previousStage();
            }
        }
    }
}
