package ross.feehan.crossfit.strengthcalculator.model.realmDatabaseCursors;

import android.content.Context;

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

    public static int getEliteWeightBasedOnUserWeightPreferdUnitsAndSex(Context ctx, int usersWeight, String userSex,
                                                                        String preferedUnits){

        BenchPressStandard benchPressStandard;

        Realm realm = Realm.getInstance(ctx);

        RealmQuery query = realm.where(BenchPressStandard.class)
                                .lessThanOrEqualTo("bodyWeight", usersWeight)
                                .beginsWith("sex", userSex)
                                .beginsWith("unitOfWeight", preferedUnits);

        RealmResults<BenchPressStandard> results = query.findAll();

        if(results.size() > 0){
            //get the last result in the RealmResults
            benchPressStandard = results.last();
        }
        else{
            benchPressStandard = getFirstBenchPressStandardBasedOnSexAndPreferedUnits(ctx, userSex, preferedUnits);
        }

        return benchPressStandard.getElite();
    }

    public static BenchPressStandard getFirstBenchPressStandardBasedOnSexAndPreferedUnits(Context ctx, String sex,
                                                                                          String preferdUnits){

        Realm realm = Realm.getInstance(ctx);

        RealmQuery query = realm.where(BenchPressStandard.class)
                                .beginsWith("sex", sex)
                                .beginsWith("unitOfWeight", preferdUnits);

        BenchPressStandard benchPressStandard = (BenchPressStandard) query.findFirst();

        return benchPressStandard;

    }

    public static BenchPressStandard getBenchPressStandardForUsersWeightSexAndPreferedUnits(Context ctx,
                        int weight, String sex, String preferedUnits){

        BenchPressStandard benchPressStandard;

        Realm realm = Realm.getInstance(ctx);

        RealmQuery query = realm.where(BenchPressStandard.class)
                .lessThanOrEqualTo("bodyWeight", weight)
                .beginsWith("sex", sex)
                .beginsWith("unitOfWeight", preferedUnits);

        RealmResults<BenchPressStandard> results = query.findAll();

        if(results.size() > 0){
            //get the last result in the RealmResults
            benchPressStandard = results.last();
        }
        else {
            benchPressStandard = getFirstBenchPressStandardBasedOnSexAndPreferedUnits(ctx, sex, preferedUnits);
        }

        return benchPressStandard;
    }


}
