package ross.feehan.crossfit.strengthcalculator.view;

import android.app.Application;
import android.content.Intent;
import android.content.res.Configuration;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import dagger.ObjectGraph;
import ross.feehan.crossfit.strengthcalculator.model.models.modelDIModule;
import ross.feehan.crossfit.strengthcalculator.model.objects.ObjectDIModules;
import ross.feehan.crossfit.strengthcalculator.presenter.presenterInterfaces.CheckAndCreateDatabaseIfNeededInterface;
import ross.feehan.crossfit.strengthcalculator.presenter.presenterInterfaces.CheckForUserInterface;
import ross.feehan.crossfit.strengthcalculator.presenter.presenters.CheckForUser;
import ross.feehan.crossfit.strengthcalculator.presenter.presenters.PresenterDIModules;
import ross.feehan.crossfit.strengthcalculator.presenter.presenters.CheckAndCreateDatabaseIfNeeded;

/**
 * Created by Ross Feehan on 30/04/2015.
 * Copyright Ross Feehan
 */
public class StrengthCalculatorApplication extends Application implements CheckAndCreateDatabaseIfNeededInterface,
        CheckForUserInterface{

    @Inject CheckAndCreateDatabaseIfNeeded createDatabase;
    @Inject CheckForUser checkForUser;
    private ObjectGraph objectGraph;

    @Override
    public void onCreate(){
        super.onCreate();

        objectGraph = ObjectGraph.create(getModules().toArray());
        objectGraph.inject(this);
        createDatabase.createDatabase(this);
    }

    private List<Object> getModules(){
        return Arrays.<Object>asList(new modelDIModule(this), new PresenterDIModules(this),
                new ObjectDIModules());
    }

    public ObjectGraph getObjectGraph(){
        return objectGraph;
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
        //check for user
        checkForUser.isUserCreated(this);
    }

    @Override
    public void databaseAlreadyCreated() {
        //check for user
        checkForUser.isUserCreated(this);
    }

    @Override
    public void databaseFailedToBeCreated() {
        Toast.makeText(this, "Database failed to be created", Toast.LENGTH_LONG).show();
        //display error message
    }

    @Override
    public void receiveIsUserCreated(boolean isUserCreated) {
        if(!isUserCreated){
            Intent intent = new Intent(this, SetUpUserDetails_Activity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        }
    }
}
