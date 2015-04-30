package ross.feehan.crossfit.strengthcalculator.model.realmDatabase;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.io.File;
import java.io.IOException;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import ross.feehan.crossfit.strengthcalculator.model.objects.BenchPressStandard;

/**
 * Created by Ross Feehan on 29/04/2015.
 * Copyright Ross Feehan
 */
public class BenchPressStandardRealmDBCursor {

    public static void createBenchPressStandard(Context ctx, BenchPressStandard benchPressStandard){

        Realm realm = Realm.getInstance(ctx);

        realm.beginTransaction();
        realm.copyToRealm(benchPressStandard);
        realm.commitTransaction();
    }

    public static void emailRealm(Context ctx){
        // init realm
        Realm realm = Realm.getInstance(ctx);

        File exportRealmFile = null;
        try {
            // get or create an "export.realm" file
            exportRealmFile = new File(ctx.getExternalCacheDir(), "export.realm");

            // if "export.realm" already exists, delete
            exportRealmFile.delete();

            // copy current realm to "export.realm"
            realm.writeCopyTo(exportRealmFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
        realm.close();

        // init email intent and add export.realm as attachment
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, "ross.feehan@yahoo.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "realm data");
        intent.putExtra(Intent.EXTRA_TEXT, "realm data");
        Uri u = Uri.fromFile(exportRealmFile);
        intent.putExtra(Intent.EXTRA_STREAM, u);

        // start email intent
        ctx.startActivity(Intent.createChooser(intent, "YOUR CHOOSER TITLE"));
    }
}
