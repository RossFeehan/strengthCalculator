package ross.feehan.crossfit.strengthcalculator.view;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import ross.feehan.crossfit.strengthcalculator.R;
import ross.feehan.crossfit.strengthcalculator.model.realmDatabase.CreateDatabaseScript;


public class MainActivity extends ActionBarActivity {

    private Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.ctx = this;

        CreateDatabaseScript createDatabase = new CreateDatabaseScript();
        createDatabase.createDatabase(ctx);
    }




}
