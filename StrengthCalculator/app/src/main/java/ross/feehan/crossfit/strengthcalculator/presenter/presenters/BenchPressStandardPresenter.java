package ross.feehan.crossfit.strengthcalculator.presenter.presenters;

import android.content.Context;

import ross.feehan.crossfit.strengthcalculator.model.models.BenchPressStandardAccessor;

/**
 * Created by Ross Feehan on 21/05/2015.
 * Copyright Ross Feehan
 */

public class BenchPressStandardPresenter {

    private Context ctx;
    private BenchPressStandardAccessor benchPressStandardAccessor;

    public BenchPressStandardPresenter(Context ctx, BenchPressStandardAccessor benchPressStandardAccessor){
        this.ctx = ctx;
        this.benchPressStandardAccessor = benchPressStandardAccessor;
    }

    public  int getBenchPressEliteWeightForUsersWeight(){
        int eliteWeight = benchPressStandardAccessor.getEliteWeightBasedOnUsersWeightSexAndPreferedUnits();

        return eliteWeight;
    }
}
