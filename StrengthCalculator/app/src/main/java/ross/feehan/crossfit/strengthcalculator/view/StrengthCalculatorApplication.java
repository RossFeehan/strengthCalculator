package ross.feehan.crossfit.strengthcalculator.view;

import android.app.Application;
import android.content.res.Configuration;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import dagger.ObjectGraph;
import ross.feehan.crossfit.strengthcalculator.model.models.modelDIModule;
import ross.feehan.crossfit.strengthcalculator.presenter.presenterInterfaces.CheckAndCreateDatabaseIfNeededInterface;
import ross.feehan.crossfit.strengthcalculator.presenter.presenters.PresenterDIModule;
import ross.feehan.crossfit.strengthcalculator.presenter.presenters.CheckAndCreateDatabaseIfNeeded;

/**
 * Created by Ross Feehan on 30/04/2015.
 * Copyright Ross Feehan
 */
public class StrengthCalculatorApplication extends Application implements CheckAndCreateDatabaseIfNeededInterface{

    @Inject
    CheckAndCreateDatabaseIfNeeded createDatabase;
    private ObjectGraph objectGraph;

    @Override
    public void onCreate(){
        super.onCreate();

        objectGraph = ObjectGraph.create(getModules().toArray());
        objectGraph.inject(this);
        createDatabase.createDatabase(this);
    }

    private List<Object> getModules(){
        return Arrays.<Object>asList(new modelDIModule(this), new PresenterDIModule(this));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory(){
        super.onLowMemory();
    }

    @Override
    public void onTerminate(){
        super.onTerminate();
    }

    //INTERFACE METHODS
    @Override
    public void databaseCreated() {
        Toast.makeText(this, "Database Created", Toast.LENGTH_LONG).show();
    }

    @Override
    public void databaseAlreadyCreated() {
        Toast.makeText(this, "Database Already Created", Toast.LENGTH_LONG).show();
    }

    @Override
    public void databaseFailedToBeCreated() {
        Toast.makeText(this, "Database failed to be created", Toast.LENGTH_LONG).show();
    }
}
