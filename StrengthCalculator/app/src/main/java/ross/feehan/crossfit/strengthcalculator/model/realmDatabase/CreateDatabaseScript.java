package ross.feehan.crossfit.strengthcalculator.model.realmDatabase;

import android.content.Context;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

import ross.feehan.crossfit.strengthcalculator.model.objects.BenchPressStandard;
import ross.feehan.crossfit.strengthcalculator.model.objects.DeadLiftStandard;
import ross.feehan.crossfit.strengthcalculator.model.objects.OverHeadPressStandard;
import ross.feehan.crossfit.strengthcalculator.model.objects.SquatStandard;

/**
 * Created by Ross Feehan on 29/04/2015.
 * Copyright Ross Feehan
 */
public class CreateDatabaseScript {

    private final static String FILENAME = "strengthstandards.json";

    public CreateDatabaseScript(){

    }

    public boolean createDatabase(Context ctx){

        boolean created = false;
        JSONArray json = loadJsonFileFromAssets(ctx);

        try{
            //loop through and get all the standards
            for(int i = 0; i<json.length(); i++){
                JSONObject standards = json.getJSONObject(i);

                //retrieve and save the bench press standards
                JSONArray benchPressStandard = standards.getJSONArray("BenchPressStandard");
                createBenchPressRows(ctx, benchPressStandard);

                //retrieve and save the squat standards
                JSONArray squatStandard = standards.getJSONArray("SquatStandard");
                createSquatRows(ctx, squatStandard);

                //retrieve and save the DeadLift standards
                JSONArray deadliftStandard = standards.getJSONArray("DeadLiftStandard");
                createDeadLiftRows(ctx, squatStandard);

                //retrieve and save the OverHeadPress standards
                JSONArray overHeadPressStandard = standards.getJSONArray("OverHeadPressStandard");
                createOverHeadPressRows(ctx, squatStandard);

                //test check to see if realm is created with data
                BenchPressStandardRealmDBCursor.emailRealm(ctx);

            }
        }catch(JSONException e) {
            e.printStackTrace();
            return created;
        }
        return created = true;
    }

    private void createBenchPressRows(Context ctx, JSONArray holderArray) throws JSONException{

        Gson gson = new Gson();
            //loop through all the bench press standards and save to RealmDB
            for(int i = 0; i<holderArray.length(); i++){
                BenchPressStandardRealmDBCursor.createBenchPressStandard(ctx,
                        gson.fromJson(holderArray.getJSONObject(i).toString(), BenchPressStandard.class));
            }
    }

    private void createSquatRows(Context ctx, JSONArray holderArray) throws JSONException{

        Gson gson = new Gson();
        //loop through all the bench press standards and save to RealmDB
        for(int i = 0; i<holderArray.length(); i++){
            SquatStandardRealmDBCursor.createSquatStandard(ctx,
                    gson.fromJson(holderArray.getJSONObject(i).toString(), SquatStandard.class));
        }
    }

    private void createDeadLiftRows(Context ctx, JSONArray holderArray) throws JSONException {

        Gson gson = new Gson();
        //loop through all the bench press standards and save to RealmDB
        for (int i = 0; i < holderArray.length(); i++) {
            DeadLiftStandardRealmDBCursor.createDeadLiftStandard(ctx,
                    gson.fromJson(holderArray.getJSONObject(i).toString(), DeadLiftStandard.class));
        }
    }

    private void createOverHeadPressRows(Context ctx, JSONArray holderArray) throws JSONException {

        Gson gson = new Gson();
        //loop through all the bench press standards and save to RealmDB
        for (int i = 0; i < holderArray.length(); i++) {
            OverHeadPressRealmDBCursor.createOverHeadPressStandard(ctx,
                    gson.fromJson(holderArray.getJSONObject(i).toString(), OverHeadPressStandard.class));
        }
    }

    private JSONArray loadJsonFileFromAssets(Context ctx){

        JSONArray jsonArray = null;

        try{
            InputStream is = ctx.getAssets().open(FILENAME);
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();

            jsonArray = new JSONArray(new String(buffer, "UTF-8"));

        }catch(IOException e){
            e.printStackTrace();
            return jsonArray;
        }catch(JSONException e){
            e.printStackTrace();
            return jsonArray;
        }

        return jsonArray;
    }
}
