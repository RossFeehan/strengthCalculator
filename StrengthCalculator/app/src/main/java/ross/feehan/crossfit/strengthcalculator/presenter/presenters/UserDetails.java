package ross.feehan.crossfit.strengthcalculator.presenter.presenters;

import android.content.Context;

import ross.feehan.crossfit.strengthcalculator.model.models.UserAccessor;

/**
 * Created by Ross Feehan on 20/05/2015.
 * Copyright Ross Feehan
 */
public class UserDetails{

    public Context ctx;
    public UserAccessor userAccessor;

    public UserDetails(Context ctx, UserAccessor userAccessor){
        this.ctx = ctx;
        this.userAccessor = userAccessor;
    }

    public String getUserPreferedUnits(){
        return userAccessor.getUserPreferedUnits();
    }
}
