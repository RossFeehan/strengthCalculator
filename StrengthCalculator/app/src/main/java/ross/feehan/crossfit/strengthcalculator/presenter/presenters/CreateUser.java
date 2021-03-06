package ross.feehan.crossfit.strengthcalculator.presenter.presenters;

import android.content.Context;

import ross.feehan.crossfit.strengthcalculator.model.models.CreateDatabase;
import ross.feehan.crossfit.strengthcalculator.model.models.UserAccessor;
import ross.feehan.crossfit.strengthcalculator.model.objects.User;
import ross.feehan.crossfit.strengthcalculator.presenter.presenterInterfaces.CreateUserInterface;

/**
 * Created by Ross Feehan on 05/05/2015.
 * Copyright Ross Feehan
 */
public class CreateUser {

    private Context ctx;
    private User newUserDetails;
    private UserAccessor userAccessor;

    public CreateUser(Context ctx, User user, UserAccessor userAccessor){
        this.ctx = ctx;
        this.newUserDetails = user;
        this.userAccessor = userAccessor;
    }


    public void setUserAsMale(){
        newUserDetails.setSex(User.SEXMALE);
    }

    public void setUserAsFemale(){
        newUserDetails.setSex(User.SEXFEMALE);
    }

    public void setUserWeightToLbs(){
        newUserDetails.setPreferedUnits(User.LBSUNIT);
    }

    public void setUserWeightToKgs(){
        newUserDetails.setPreferedUnits(User.KGUNIT);
    }

    public void createUser(CreateUserInterface createUserInterface, double weight){

        newUserDetails.setWeight(weight);

        if(newUserDetails.getPreferedUnits() == null){
            createUserInterface.userMeasurementUnitsNotSet();
        }
        else if(newUserDetails.getSex() == null){
            createUserInterface.userSexNotSetError();
        }
        else{
            //create user in Realm DB
            userAccessor.saveUserDetails(newUserDetails);
            createUserInterface.userCreated();
        }
    }
}
