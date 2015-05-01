package ross.feehan.crossfit.strengthcalculator.model.objects;

import io.realm.RealmObject;

/**
 * Created by Ross Feehan on 01/05/2015.
 * Copyright Ross Feehan
 */
public class User extends RealmObject {

    private String preferedUnits, sex;

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

    //GETTERS
    public String getPreferedUnits() {
        return preferedUnits;
    }

    public String getSex() {
        return sex;
    }
}
