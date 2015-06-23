package ross.feehan.crossfit.strengthcalculator.presenter.presenters;


import ross.feehan.crossfit.strengthcalculator.model.models.UserAccessor;

/**
 * Created by Ross Feehan on 20/05/2015.
 * Copyright Ross Feehan
 */
public class UserDetails{

    public UserAccessor userAccessor;

    public UserDetails(UserAccessor userAccessor){
        this.userAccessor = userAccessor;
    }

    public String getUserPreferedUnits(){
        return userAccessor.getUserPreferedUnits();
    }
}
