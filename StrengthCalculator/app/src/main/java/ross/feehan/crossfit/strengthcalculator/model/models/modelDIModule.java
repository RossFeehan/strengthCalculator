package ross.feehan.crossfit.strengthcalculator.model.models;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ross.feehan.crossfit.strengthcalculator.model.realmDatabaseCursors.CreateDatabaseScript;
import ross.feehan.crossfit.strengthcalculator.presenter.presenters.BenchPressStandardPresenter;
import ross.feehan.crossfit.strengthcalculator.presenter.presenters.CheckAndCreateDatabaseIfNeeded;
import ross.feehan.crossfit.strengthcalculator.presenter.presenters.CreateUser;
import ross.feehan.crossfit.strengthcalculator.presenter.presenters.UserDetails;

/**
 * Created by Ross Feehan on 30/04/2015.
 * Copyright Ross Feehan
 */

@Module(injects = {CheckAndCreateDatabaseIfNeeded.class, CreateUser.class, UserDetails.class,
                    BenchPressStandardPresenter.class},
        library = true,
        complete = false)
public class modelDIModule {

    private Context ctx;
    private BenchPressStandardAccessor benchPressStandardAccessor;
    private CreateDatabase createDatabase;
    private UserAccessor userAccessor;

    public modelDIModule(Context ctx) {
        this.ctx = ctx;
        createDatabase = new CreateDatabase(ctx);
        userAccessor = new UserAccessor(ctx);
    }

    @Provides @Singleton
    public BenchPressStandardAccessor provideBenchPressStandardAccessor(UserAccessor userAccessor){
        return benchPressStandardAccessor = new BenchPressStandardAccessor(ctx, userAccessor);

    }

    @Provides @Singleton
    public CreateDatabase provideCreateDatabase(){
        return createDatabase;
    }

    @Provides @Singleton
    public UserAccessor provideUserAccessor(){
        return userAccessor;
    }

}
