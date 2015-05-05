package ross.feehan.crossfit.strengthcalculator.model.objects;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ross.feehan.crossfit.strengthcalculator.presenter.presenters.CheckAndCreateDatabaseIfNeeded;
import ross.feehan.crossfit.strengthcalculator.presenter.presenters.CreateUser;
import ross.feehan.crossfit.strengthcalculator.view.SetUpUserDetails_Activity;

/**
 * Created by Ross Feehan on 05/05/2015.
 * Copyright Ross Feehan
 */

@Module(injects = {CreateUser.class},
        library = true)
public class ObjectDIModules {

    private User user;

    @Provides @Singleton
    public User provideUserObject(){
        return user = new User();
    }
}
