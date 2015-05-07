package ross.feehan.crossfit.strengthcalculator.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import ross.feehan.crossfit.strengthcalculator.R;

/**
 * Created by Ross Feehan on 06/05/2015.
 * Copyright Ross Feehan
 */
public class NewCalculations_Activity extends ActionBarActivity{

    private Context ctx;
    @InjectView(R.id.repsET)EditText repsET;
    @InjectView(R.id.weightET)EditText weightET;
    @InjectView(R.id.repsTV)TextView repsTV;
    @InjectView(R.id.forTV)TextView forHowManyTV;
    @InjectView(R.id.weightTV)TextView weightTV;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_calculations_layout);

        this.ctx = this;

        ButterKnife.inject(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        buttonClicks();
    }

    private void buttonClicks(){
        weightET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    repsTV.setVisibility(View.VISIBLE);
                    forHowManyTV.setVisibility(View.VISIBLE);

                }
            }
        });

        weightET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                weightTV.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
