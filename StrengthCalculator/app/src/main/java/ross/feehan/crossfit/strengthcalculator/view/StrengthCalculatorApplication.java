package ross.feehan.crossfit.strengthcalculator.view;

import android.app.Application;
import android.content.res.Configuration;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import dagger.ObjectGraph;
import ross.feehan.crossfit.strengthcalculator.model.models.modelDIModule;
import ross.feehan.crossfit.strengthcalculator.presenter.presenters.PresenterDIModule;
import ross.feehan.crossfit.strengthcalculator.presenter.presenters.CreateDatabase;

/**
 * Created by Ross Feehan on 30/04/2015.
 * Copyright Ross Feehan
 */
public class StrengthCalculatorApplication extends Application{

    @Inject CreateDatabase createDatabase;
    private ObjectGraph objectGraph;

    @Override
    public void onCreate(){
        super.onCreate();

        objectGraph = ObjectGraph.create(getModules().toArray());
        objectGraph.inject(this);
        createDatabase.createDatabase();
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
}
