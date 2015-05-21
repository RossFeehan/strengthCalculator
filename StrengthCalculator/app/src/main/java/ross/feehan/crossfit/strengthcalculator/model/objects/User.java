package ross.feehan.crossfit.strengthcalculator.model.objects;

import io.realm.RealmObject;

/**
 * Created by Ross Feehan on 01/05/2015.
 * Copyright Ross Feehan
 */
public class User extends RealmObject {

    private String preferedUnits, sex;
    private double weight;
    public final static String SEXMALE = "Male", SEXFEMALE = "Female",
            KGUNIT = "KG", LBSUNIT = "LBS";

    //CONSTRUCTORS
    public User(){

    }

    //SETTERS
    public void setPreferedUnits(String preferedUnits) {
        this.preferedUnits = preferedUnits;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    //GETTERS
    public String getPreferedUnits() {
        return preferedUnits;
    }

    public String getSex() {
        return sex;
    }

    public double getWeight() {
        return weight;
    }
}
