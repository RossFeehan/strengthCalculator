package ross.feehan.crossfit.strengthcalculator.model.realmDatabaseCursors;

import android.content.Context;

import io.realm.Realm;
import ross.feehan.crossfit.strengthcalculator.model.objects.DeadLiftStandard;
import ross.feehan.crossfit.strengthcalculator.model.objects.SquatStandard;

/**
 * Created by Ross Feehan on 29/04/2015.
 * Copyright Ross Feehan
 */
public class DeadLiftStandardRealmDBCursor {

    public static void createDeadLiftStandard(Context ctx, DeadLiftStandard deadLiftStandard){

        Realm realm = Realm.getInstance(ctx);

        realm.beginTransaction();
        realm.copyToRealm(deadLiftStandard);
        realm.commitTransaction();
    }
}
