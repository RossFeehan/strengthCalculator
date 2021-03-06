package ross.feehan.crossfit.strengthcalculator.presenter.presenters;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ross.feehan.crossfit.strengthcalculator.model.models.BenchPressStandardAccessor;
import ross.feehan.crossfit.strengthcalculator.model.models.CreateDatabase;
import ross.feehan.crossfit.strengthcalculator.model.models.UserAccessor;
import ross.feehan.crossfit.strengthcalculator.model.objects.User;
import ross.feehan.crossfit.strengthcalculator.view.NewCalculations_Activity;
import ross.feehan.crossfit.strengthcalculator.view.SetUpUserDetails_Activity;
import ross.feehan.crossfit.strengthcalculator.view.StrengthCalculatorApplication;

/**
 * Created by Ross Feehan on 30/04/2015.
 * Copyright Ross Feehan
 */
@Module(injects = {StrengthCalculatorApplication.class, SetUpUserDetails_Activity.class,
                    NewCalculations_Activity.class},
        complete = false,
        library = true)
public class PresenterDIModules {

    private CheckAndCreateDatabaseIfNeeded checkAndCreateDatabaseIfNeeded;
    private CheckForUser checkForUser;
    private CreateUser createUser;
    private UserDetails userDetails;
    private Context ctx;

    public PresenterDIModules(Context context){
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

    @Provides @Singleton
    public CreateUser provideCreateUser(User user, UserAccessor userAccessor){
        return createUser = new CreateUser(ctx, user, userAccessor);
    }

    @Provides @Singleton
    public UserDetails provideUserDetails(UserAccessor userAccessor){
        return userDetails = new UserDetails(ctx, userAccessor);
    }
}
