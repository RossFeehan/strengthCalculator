package ross.feehan.crossfit.strengthcalculator.presenter.presenters;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ross.feehan.crossfit.strengthcalculator.model.models.BenchPressStandardAccessor;
import ross.feehan.crossfit.strengthcalculator.presenter.presenters.CreateDatabase;
import ross.feehan.crossfit.strengthcalculator.view.StrengthCalculatorApplication;

/**
 * Created by Ross Feehan on 30/04/2015.
 * Copyright Ross Feehan
 */
@Module(injects = {StrengthCalculatorApplication.class},
        complete = false)
public class PresenterDIModule {

    private CreateDatabase createDatabase;
    private Context ctx;

    public PresenterDIModule(Context context){
        this.ctx = context;
    }

    @Provides @Singleton
    public CreateDatabase provideCreateDatabase(BenchPressStandardAccessor benchPressStandardAccessor){

        return createDatabase = new CreateDatabase(ctx, benchPressStandardAccessor);
    }
}
