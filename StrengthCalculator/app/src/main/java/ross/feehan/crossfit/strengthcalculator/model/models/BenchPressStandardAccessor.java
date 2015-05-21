package ross.feehan.crossfit.strengthcalculator.model.models;

import android.content.Context;

import ross.feehan.crossfit.strengthcalculator.model.modelInterfaces.BenchPressStandardAccessorInterface;
import ross.feehan.crossfit.strengthcalculator.model.objects.BenchPressStandard;
import ross.feehan.crossfit.strengthcalculator.model.realmDatabaseCursors.BenchPressStandardRealmDBCursor;

/**
 * Created by Ross Feehan on 30/04/2015.
 * Copyright Ross Feehan
 */
public class BenchPressStandardAccessor {

    private Context ctx;
    private UserAccessor userAccessor;

    public BenchPressStandardAccessor(Context ctx, UserAccessor userAccessor){
        this.ctx = ctx;
        this.userAccessor = userAccessor;
    }

    public void getAllBenchPressStandards(BenchPressStandardAccessorInterface accessorInterface){

        accessorInterface.receiveAllBenchPressStandards(
                BenchPressStandardRealmDBCursor.getAllBenchPressStandards(ctx));
    }

    public int getEliteWeightBasedOnUsersWeightSexAndPreferedUnits(){

        //get the users weight
        double usersWeight = userAccessor.getUserWeight();

        //get users sex
        String sex = userAccessor.getUsersSex();

        //get the users preferd units of weight
        String preferedUnits = userAccessor.getUserPreferedUnits();

        //get the elite weight based on the users weight
        int eliteWeight = BenchPressStandardRealmDBCursor.getEliteWeightBasedOnUserWeightPreferdUnitsAndSex(ctx,
                (int)usersWeight, sex, preferedUnits);

        //return the elite weight
        return eliteWeight;
    }

    public BenchPressStandard getBenchPressStandardBasedOnUsersWeightSexAndPreferedUnits(){

        //get the users weight
        double usersWeight = userAccessor.getUserWeight();

        //get users sex
        String sex = userAccessor.getUsersSex();

        //get the users preferd units of weight
        String preferedUnits = userAccessor.getUserPreferedUnits();

        BenchPressStandard benchPressStandard = BenchPressStandardRealmDBCursor.getBenchPressStandardForUsersWeightSexAndPreferedUnits(
                ctx, (int)usersWeight, sex, preferedUnits);

        return benchPressStandard;

    }

}
