package ross.feehan.crossfit.strengthcalculator.model.realmDatabaseCursors;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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

    public static ArrayList<BenchPressStandard> getAllBenchPressStandards(Context ctx){

        ArrayList<BenchPressStandard> benchPressStandards = null;

        Realm realm = Realm.getInstance(ctx);

        RealmQuery query = realm.where(BenchPressStandard.class);

        RealmResults<BenchPressStandard> results = query.findAll();

        if(results.size() > 0){
            benchPressStandards = new ArrayList<BenchPressStandard>();
            for(BenchPressStandard benchPressStandard : results){
                benchPressStandards.add(benchPressStandard);
            }
        }

        return benchPressStandards;
    }

    public static int getEliteWeightBasedOnUserWeight(Context ctx, int usersWeight){

        Realm realm = Realm.getInstance(ctx);

        RealmQuery query = realm.where(BenchPressStandard.class)
                                .lessThan("bodyWeight", usersWeight);

        RealmResults<BenchPressStandard> results = query.findAll();

        //get the last result in the RealmResults
        BenchPressStandard benchPressStandard = results.last();

        return benchPressStandard.getElite();
    }


}
