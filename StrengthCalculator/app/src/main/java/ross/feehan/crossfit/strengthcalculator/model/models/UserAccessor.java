package ross.feehan.crossfit.strengthcalculator.model.models;

import android.content.Context;

import ross.feehan.crossfit.strengthcalculator.model.objects.User;
import ross.feehan.crossfit.strengthcalculator.model.realmDatabaseCursors.UserRealmDBCursor;

/**
 * Created by Ross Feehan on 05/05/2015.
 * Copyright Ross Feehan
 */
public class UserAccessor {

    private Context ctx;

    public UserAccessor(Context ctx){
        this.ctx = ctx;
    }

    public User getUserDetails(){
        User user = null;

       return user = UserRealmDBCursor.getUserDetails(ctx);
    }

    public void saveUserDetails(User user){

        UserRealmDBCursor.setUserDetails(ctx, user);
    }
}
