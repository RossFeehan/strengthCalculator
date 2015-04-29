package ross.feehan.crossfit.strengthcalculator.model.objects;

import io.realm.RealmObject;

/**
 * Created by Ross Feehan on 28/04/2015.
 * Copyright Ross Feehan
 */
public class BenchPressStandard extends RealmObject {


    private double bodyWeight;
    private int untrained, novice, intermediate, advanced, elite;
    private String sex;
    public final static String SEXMALE = "Male", SEXFEMALE = "Female";



    //CONSTRUCTORS
    public BenchPressStandard(){

    }

    //SETTERS
    public void setBodyWeight(double bodyWeight) {
        this.bodyWeight = bodyWeight;
    }

    public void setUntrained(int untrained) {
        this.untrained = untrained;
    }

    public void setNovice(int novice) {
        this.novice = novice;
    }

    public void setIntermediate(int intermediate) {
        this.intermediate = intermediate;
    }

    public void setAdvanced(int advanced) {
        this.advanced = advanced;
    }

    public void setElite(int elite) {
        this.elite = elite;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    //GETTERS
    public double getBodyWeight() {
        return bodyWeight;
    }

    public int getUntrained() {
        return untrained;
    }

    public int getNovice() {
        return novice;
    }

    public int getIntermediate() {
        return intermediate;
    }

    public int getAdvanced() {
        return advanced;
    }

    public int getElite() {
        return elite;
    }

    public String getSex() {
        return sex;
    }
}
