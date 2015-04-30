package ross.feehan.crossfit.strengthcalculator.model.objects;

import io.realm.RealmObject;

/**
 * Created by Ross Feehan on 29/04/2015.
 * Copyright Ross Feehan
 */
public class DeadLiftStandard extends RealmObject {

    private int bodyWeight, untrained, novice, intermediate, advanced, elite;
    private String sex, unitOfWeight;
    public final static String SEXMALE = "Male", SEXFEMALE = "Female",
            KGUNIT = "KG", LBSUNIT = "LBS";

    //CONSTRUCTORS
    public DeadLiftStandard(){

    }

    //SETTERS
    public void setBodyWeight(int bodyWeight) {
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

    public void setUnitOfWeight(String unitOfWeight) {
        this.unitOfWeight = unitOfWeight;
    }

    //GETTERS
    public int getBodyWeight() {
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

    public String getUnitOfWeight() {
        return unitOfWeight;
    }
}
