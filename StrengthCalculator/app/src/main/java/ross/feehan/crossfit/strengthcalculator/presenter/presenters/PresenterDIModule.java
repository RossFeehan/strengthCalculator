package ross.feehan.crossfit.strengthcalculator.presenter.presenters;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ross.feehan.crossfit.strengthcalculator.model.models.BenchPressStandardAccessor;
import ross.feehan.crossfit.strengthcalculator.model.models.CreateDatabase;
import ross.feehan.crossfit.strengthcalculator.model.models.UserAccessor;
import ross.feehan.crossfit.strengthcalculator.view.StrengthCalculatorApplication;

/**
 * Created by Ross Feehan on 30/04/2015.
 * Copyright Ross Feehan
 */
@Module(injects = {StrengthCalculatorApplication.class},
        complete = false)
public class PresenterDIModule {

    private CheckAndCreateDatabaseIfNeeded checkAndCreateDatabaseIfNeeded;
    private CheckForUser checkForUser;
    private Context ctx;

    public PresenterDIModule(Context context){
        this.ctx = context;
    }

    @Provides @Singleton
    public CheckAndCreateDatabaseIfNeeded provideCreateDatabase(BenchPressStandardAccessor benchPressStandardAccessor,
                                                  CreateDatabase createDatabase){

        return checkAndCreateDatabaseIfNeeded = new CheckAndCreateDatabaseIfNeeded(ctx,
                benchPressStandardAccessor, createDatabase);
    }

    @Provides @Singleton
    public CheckForUser provideCheckForUser(UserAccessor userAccessor){
         return checkForUser = new CheckForUser(ctx, userAccessor);
    }
}
