package ross.feehan.crossfit.strengthcalculator.presenter.presenterInterfaces;

/**
 * Created by Ross Feehan on 30/04/2015.
 * Copyright Ross Feehan
 */
public interface CheckAndCreateDatabaseIfNeededInterface {

    public void databaseCreated();

    public void databaseAlreadyCreated();

    public void databaseFailedToBeCreated();
}
