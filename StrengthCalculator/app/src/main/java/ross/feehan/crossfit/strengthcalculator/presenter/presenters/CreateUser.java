package ross.feehan.crossfit.strengthcalculator.presenter.presenters;

import android.content.Context;

import ross.feehan.crossfit.strengthcalculator.model.models.CreateDatabase;
import ross.feehan.crossfit.strengthcalculator.model.objects.User;

/**
 * Created by Ross Feehan on 05/05/2015.
 * Copyright Ross Feehan
 */
public class CreateUser {

    private Context ctx;
    private User newUserDetails;

    public CreateUser(Context ctx, User user){
        this.ctx = ctx;
        this.newUserDetails = user;
    }


    public void setUserAsMale(){

        newUserDetails.setSex(User.SEXMALE);

    }

    public void setUserAsFemale(){

    }

    public void setUserWeightToLbs(){

    }

    public void setUserWeightToKgs(){

    }

    public void createUser(){

    }
}
