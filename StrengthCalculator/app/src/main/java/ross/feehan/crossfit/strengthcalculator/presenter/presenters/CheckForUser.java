package ross.feehan.crossfit.strengthcalculator.presenter.presenters;

import android.content.Context;

import ross.feehan.crossfit.strengthcalculator.model.models.UserAccessor;
import ross.feehan.crossfit.strengthcalculator.model.objects.User;
import ross.feehan.crossfit.strengthcalculator.presenter.presenterInterfaces.CheckForUserInterface;

/**
 * Created by Ross Feehan on 05/05/2015.
 * Copyright Ross Feehan
 */
public class CheckForUser {

    private Context ctx;
    private UserAccessor userAccessor;

    public CheckForUser(Context ctx, UserAccessor userAccessor){
        this.ctx = ctx;
        this.userAccessor = userAccessor;
    }

    public void isUserCreated(CheckForUserInterface checkForUserInterface){

        User userDetails = userAccessor.getUserDetails();

        if(userDetails != null){
            checkForUserInterface.receiveIsUserCreated(true);
        }
        else{
            checkForUserInterface.receiveIsUserCreated(false);
        }
    }
}
