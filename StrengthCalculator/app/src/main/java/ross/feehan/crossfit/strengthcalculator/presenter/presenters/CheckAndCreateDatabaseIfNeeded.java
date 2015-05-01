package ross.feehan.crossfit.strengthcalculator.presenter.presenters;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

import javax.inject.Inject;

import ross.feehan.crossfit.strengthcalculator.model.modelInterfaces.BenchPressStandardAccessorInterface;
import ross.feehan.crossfit.strengthcalculator.model.modelInterfaces.CreateDatabaseInterface;
import ross.feehan.crossfit.strengthcalculator.model.models.BenchPressStandardAccessor;
import ross.feehan.crossfit.strengthcalculator.model.models.CreateDatabase;
import ross.feehan.crossfit.strengthcalculator.model.objects.BenchPressStandard;
import ross.feehan.crossfit.strengthcalculator.presenter.presenterInterfaces.CheckAndCreateDatabaseIfNeededInterface;

/**
 * Created by Ross Feehan on 30/04/2015.
 * Copyright Ross Feehan
 */
public class CheckAndCreateDatabaseIfNeeded implements BenchPressStandardAccessorInterface, CreateDatabaseInterface {

    private Context ctx;
    @Inject BenchPressStandardAccessor benchPressStandardAccessor;
    @Inject CreateDatabase createDatabase;
    private CheckAndCreateDatabaseIfNeededInterface checkDatabaseInterface;


    public CheckAndCreateDatabaseIfNeeded(Context ctx, BenchPressStandardAccessor benchPressStandardAccessor,
                                    CreateDatabase createDatabase){
        this.ctx = ctx;
        this.benchPressStandardAccessor = benchPressStandardAccessor;
        this.createDatabase = createDatabase;
    }

    public void createDatabase(CheckAndCreateDatabaseIfNeededInterface checkDatabaseInterface) {

        this.checkDatabaseInterface = checkDatabaseInterface;
        //get all bench press standards, they will be returned to the BenchPressStandardAccessorInterface
        //method in the below INTERFACES section.
        benchPressStandardAccessor.GetAllBenchPressStandards(this);
    }

    @Override
    public void receiveAllBenchPressStandards(ArrayList<BenchPressStandard> benchPressStandards) {
        if(benchPressStandards != null){
            //return that the database is created through interface method
            checkDatabaseInterface.databaseAlreadyCreated();
        }
        else{
            //create database
            createDatabase.createDatabase(this);
        }
    }

    @Override
    public void wasDatabaseCreated(boolean wasCreated) {
        if(wasCreated){
            //call back through interface here
            checkDatabaseInterface.databaseCreated();
        }
        else{
            //call back through interface goes here
            checkDatabaseInterface.databaseFailedToBeCreated();
        }

    }
}