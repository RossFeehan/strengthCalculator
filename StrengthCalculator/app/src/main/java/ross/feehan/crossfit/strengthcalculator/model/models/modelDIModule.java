package ross.feehan.crossfit.strengthcalculator.model.models;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ross.feehan.crossfit.strengthcalculator.model.models.BenchPressStandardAccessor;
import ross.feehan.crossfit.strengthcalculator.presenter.presenters.CreateDatabase;

/**
 * Created by Ross Feehan on 30/04/2015.
 * Copyright Ross Feehan
 */

@Module(injects = {CreateDatabase.class})
public class modelDIModule {

    private BenchPressStandardAccessor benchPressStandardAccessor;

    public modelDIModule(Context ctx){
        benchPressStandardAccessor = new BenchPressStandardAccessor(ctx);
    }

    @Provides @Singleton
    public BenchPressStandardAccessor provideBenchPressStandardAccessor(){
        return benchPressStandardAccessor;
    }

}
