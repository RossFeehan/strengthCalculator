package ross.feehan.crossfit.strengthcalculator.presenter.presenters;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

import javax.inject.Inject;

import ross.feehan.crossfit.strengthcalculator.model.modelInterfaces.BenchPressStandardAccessorInterface;
import ross.feehan.crossfit.strengthcalculator.model.models.BenchPressStandardAccessor;
import ross.feehan.crossfit.strengthcalculator.model.objects.BenchPressStandard;

/**
 * Created by Ross Feehan on 30/04/2015.
 * Copyright Ross Feehan
 */
public class CreateDatabase implements BenchPressStandardAccessorInterface{

    private Context ctx;
    @Inject BenchPressStandardAccessor benchPressStandardAccessor;


    public CreateDatabase(Context ctx, BenchPressStandardAccessor benchPressStandardAccessor){
        this.ctx = ctx;
        this.benchPressStandardAccessor = benchPressStandardAccessor;
    }

    public void createDatabase() {

        //get all bench press standards, they will be returned to the BenchPressStandardAccessorInterface
        //method in the below INTERFACES section.
        benchPressStandardAccessor.GetAllBenchPressStandards(this);
    }

    @Override
    public void receiveAllBenchPressStandards(ArrayList<BenchPressStandard> benchPressStandards) {
        if(benchPressStandards != null){
            //return that the database is created through interface method
            Toast.makeText(ctx, "DB Created",Toast.LENGTH_LONG).show();
        }
        else{
            //create database
            Toast.makeText(ctx, "DB Needs to be made", Toast.LENGTH_LONG).show();
        }
    }
}
