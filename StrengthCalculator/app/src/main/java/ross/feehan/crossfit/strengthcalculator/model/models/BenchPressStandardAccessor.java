package ross.feehan.crossfit.strengthcalculator.model.models;

import android.content.Context;

import ross.feehan.crossfit.strengthcalculator.model.modelInterfaces.BenchPressStandardAccessorInterface;
import ross.feehan.crossfit.strengthcalculator.model.realmDatabaseCursors.BenchPressStandardRealmDBCursor;

/**
 * Created by Ross Feehan on 30/04/2015.
 * Copyright Ross Feehan
 */
public class BenchPressStandardAccessor {

    private Context ctx;

    public BenchPressStandardAccessor(Context ctx){
        this.ctx = ctx;
    }

    public void getAllBenchPressStandards(BenchPressStandardAccessorInterface accessorInterface){

        accessorInterface.receiveAllBenchPressStandards(
                BenchPressStandardRealmDBCursor.getAllBenchPressStandards(ctx));
    }

    public void getEliteWeightBasedOnUsersWeight(){

        //get the users weight

        //get the elite weight based on the users weight

        //return the elite weight
    }

}
