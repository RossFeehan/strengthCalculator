package ross.feehan.crossfit.strengthcalculator.view;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ross.feehan.crossfit.strengthcalculator.R;

/**
 * Created by Ross Feehan on 30/04/2015.
 * Copyright Ross Feehan
 */
public class MainActivity extends ActionBarActivity{

    private Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.ctx = this;
        ButterKnife.inject(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

    }

    @OnClick(R.id.addBTN)
    public void onNextBTNClicked(){
        Intent intent = new Intent(this, NewCalculations_Activity.class);
        startActivity(intent);

    }

}
