package ross.feehan.crossfit.strengthcalculator.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import ross.feehan.crossfit.strengthcalculator.R;

/**
 * Created by Ross Feehan on 06/05/2015.
 * Copyright Ross Feehan
 */
public class NewCalculations extends ActionBarActivity{

    private Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_calculations_layout);

        this.ctx = this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
    }
}
