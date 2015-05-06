package ross.feehan.crossfit.strengthcalculator.model.models;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;

import ross.feehan.crossfit.strengthcalculator.model.modelInterfaces.CreateDatabaseInterface;
import ross.feehan.crossfit.strengthcalculator.model.realmDatabaseCursors.CreateDatabaseScript;

/**
 * Created by Ross Feehan on 30/04/2015.
 * Copyright Ross Feehan
 */
public class CreateDatabase {

    private Context ctx;
    private final static String FILENAME = "strengthstandards.json";

    public CreateDatabase(Context ctx){
        this.ctx = ctx;
    }

    public void createDatabase(CreateDatabaseInterface createDatabaseInterface){

        createDatabaseInterface.wasDatabaseCreated(CreateDatabaseScript.createDatabase
                (ctx, loadJsonFileFromAssets()));
    }

    private JSONArray loadJsonFileFromAssets(){

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
