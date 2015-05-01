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

    public void GetAllBenchPressStandards(BenchPressStandardAccessorInterface accessorInterface){

        accessorInterface.receiveAllBenchPressStandards(
                BenchPressStandardRealmDBCursor.getAllBenchPressStandards(ctx));
    }

}
