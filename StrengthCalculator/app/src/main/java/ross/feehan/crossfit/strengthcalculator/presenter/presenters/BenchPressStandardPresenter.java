package ross.feehan.crossfit.strengthcalculator.presenter.presenters;

import ross.feehan.crossfit.strengthcalculator.model.models.BenchPressStandardAccessor;
import ross.feehan.crossfit.strengthcalculator.model.objects.BenchPressStandard;

/**
 * Created by Ross Feehan on 21/05/2015.
 * Copyright Ross Feehan
 */

public class BenchPressStandardPresenter {

    private BenchPressStandardAccessor benchPressStandardAccessor;

    public BenchPressStandardPresenter(BenchPressStandardAccessor benchPressStandardAccessor){

        this.benchPressStandardAccessor = benchPressStandardAccessor;
    }

    public  int getBenchPressEliteWeightForUsersWeight(){
        int eliteWeight = benchPressStandardAccessor.getEliteWeightBasedOnUsersWeightSexAndPreferedUnits();

        return eliteWeight;
    }

    public BenchPressStandard getBenchPressStandardBasedOnUserDetails(){

        BenchPressStandard benchPressStandard = benchPressStandardAccessor.getBenchPressStandardBasedOnUsersWeightSexAndPreferedUnits();

        return benchPressStandard;
    }
}
