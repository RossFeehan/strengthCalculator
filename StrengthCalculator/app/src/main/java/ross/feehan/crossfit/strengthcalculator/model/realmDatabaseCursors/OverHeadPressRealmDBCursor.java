package ross.feehan.crossfit.strengthcalculator.model.realmDatabaseCursors;

import android.content.Context;

import io.realm.Realm;
import ross.feehan.crossfit.strengthcalculator.model.objects.OverHeadPressStandard;

/**
 * Created by Ross Feehan on 30/04/2015.
 * Copyright Ross Feehan
 */
public class OverHeadPressRealmDBCursor{

    public static void createOverHeadPressStandard(Context ctx, OverHeadPressStandard overHeadPressStandard){

        Realm realm = Realm.getInstance(ctx);

        realm.beginTransaction();
        realm.copyToRealm(overHeadPressStandard);
        realm.commitTransaction();
    }
}
