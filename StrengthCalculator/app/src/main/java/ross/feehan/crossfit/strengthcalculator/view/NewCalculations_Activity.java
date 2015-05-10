package ross.feehan.crossfit.strengthcalculator.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import ross.feehan.crossfit.strengthcalculator.R;

/**
 * Created by Ross Feehan on 06/05/2015.
 * Copyright Ross Feehan
 */
public class NewCalculations_Activity extends ActionBarActivity{

    private Context ctx;
    private ArrayList<EditText> weightEditTexts = new ArrayList<EditText>();
    private ArrayList<TextView> repsTextViews = new ArrayList<TextView>();
    private ArrayList<TextView> forTextViews = new ArrayList<TextView>();
    private ArrayList<TextView> weightTextViews = new ArrayList<TextView>();

    //bench press card view views
    @InjectView(R.id.benchPressRepsET)EditText benchPressRepsET;
    @InjectView(R.id.benchPressWeightET)EditText benchPressWeightET;
    @InjectView(R.id.benchPressRepsTV)TextView benchPressRepsTV;
    @InjectView(R.id.benchPressForTV)TextView benchPressForHowManyTV;
    @InjectView(R.id.benchPressWeightTV)TextView benchPressWeightTV;

    //squat card view views
    @InjectView(R.id.squatRepsET)EditText squatRepsET;
    @InjectView(R.id.squatWeightET)EditText squatWeightET;
    @InjectView(R.id.squatRepsTV)TextView squatRepsTV;
    @InjectView(R.id.squatForTV)TextView squatForHowManyTV;
    @InjectView(R.id.squatWeightTV)TextView squatWeightTV;

    //deadLift card view views
    @InjectView(R.id.deadLiftRepsET)EditText deadLiftRepsET;
    @InjectView(R.id.deadLiftWeightET)EditText deadLiftWeightET;
    @InjectView(R.id.deadLiftRepsTV)TextView deadLiftRepsTV;
    @InjectView(R.id.deadLiftForTV)TextView deadLiftForHowManyTV;
    @InjectView(R.id.deadLiftWeightTV)TextView deadLiftWeightTV;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_calculations_layout);

        this.ctx = this;

        ButterKnife.inject(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        createViewArrayLists();
        buttonClicks();
    }

    private void createViewArrayLists(){

        //weight edit texts
        weightEditTexts.add(benchPressWeightET);
        weightEditTexts.add(squatWeightET);
        weightEditTexts.add(deadLiftWeightET);

        //reps text views
        repsTextViews.add(benchPressRepsTV);
        repsTextViews.add(squatRepsTV);
        repsTextViews.add(deadLiftRepsTV);

        //for how many text views
        forTextViews.add(benchPressForHowManyTV);
        forTextViews.add(squatForHowManyTV);
        forTextViews.add(deadLiftForHowManyTV);

        //weight text views
        weightTextViews.add(benchPressWeightTV);
        weightTextViews.add(squatWeightTV);
        weightTextViews.add(deadLiftWeightTV);

    }

    private void buttonClicks(){

        for(int i = 0; i< weightEditTexts.size(); i++){

            EditText editTextView = weightEditTexts.get(i);
            final int iAsFinal = i;

            //display the "reps for" txt views when the weight edit text gets the focus
            editTextView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(hasFocus){
                        repsTextViews.get(iAsFinal).setVisibility(View.VISIBLE);
                        forTextViews.get(iAsFinal).setVisibility(View.VISIBLE);

                    }
                }
            });

            //Display the KGs after the weight Edit Text once the user starts typing
            editTextView.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    weightTextViews.get(iAsFinal).setVisibility(View.VISIBLE);
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });

            //Dismiss the soft keyboard and get the 1RM once the user has finished typing.
            editTextView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if (actionId == EditorInfo.IME_ACTION_DONE) {
                        Toast.makeText(ctx, "GET 1RM", Toast.LENGTH_SHORT).show();
                        hideKeyboard();
                    }

                    return true;
                }
            });
        }

    }

    private void hideKeyboard() {
        // Check if no view has focus:
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager inputManager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
