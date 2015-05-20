package ross.feehan.crossfit.strengthcalculator.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import ross.feehan.crossfit.strengthcalculator.R;
import ross.feehan.crossfit.strengthcalculator.view.widgets.CustomActionButtonView;
import ross.feehan.crossfit.strengthcalculator.view.widgets.StrengthCardView;

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
    private ArrayList<RelativeLayout> repLayouts = new ArrayList<RelativeLayout>();

    //bench press card view view
    @InjectView (R.id.benchPressCV)CardView benchPressCV;

    //action button layouts
    StrengthCardView benchPressCardView;
    @InjectView(R.id.includeActionButton)RelativeLayout firstActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_calculations_layout);

        this.ctx = this;
        ButterKnife.inject(this);

        setUpActionButton();
        setUpCardViews();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        createViewArrayLists();
        buttonClicks();

    }

    private void createViewArrayLists(){

        //TODO USE VIEW LISTS FROM BUTTERKNIFE INSTEAD OF SETTING UP THESE ARRAYS
        //weight edit texts
        weightEditTexts.add(benchPressCardView.weightET);

        //reps text views
        repsTextViews.add(benchPressCardView.repsTV);

        //for how many text views
        forTextViews.add(benchPressCardView.forHowManyTV);

        //weight text views
        weightTextViews.add(benchPressCardView.weightTV);

        //one rep max layouts
        repLayouts.add(benchPressCardView.oneRepMaxLayout);

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
                        hideKeyboard();

                        displayOneRepMaxLayout(repLayouts.get(iAsFinal));

                        //save strength details to database here straight away
                    }

                    return true;
                }
            });
        }

    }

    private void displayOneRepMaxLayout(RelativeLayout oneRepMaxLayout){

        /*benchPressCardView.progressBar.setBackgroundColor(Color.parseColor("#E0E0E0"));
        benchPressCardView.progressBar.setProgressColor(Color.parseColor("#0d47a1"));*/

        benchPressCardView.progressBar.setMaximumPercentage(0.53f);

        Animation anim = AnimationUtils.loadAnimation(ctx, R.anim.one_rep_max_fade_in);
        oneRepMaxLayout.setAnimation(anim);

        oneRepMaxLayout.setVisibility(View.VISIBLE);

    }

    private void hideKeyboard() {
        // Check if no view has focus:
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager inputManager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    private void setUpActionButton(){
        CustomActionButtonView actionBTN = new CustomActionButtonView(firstActionButton);
        actionBTN.actionButtonImageView.setBackgroundResource(R.mipmap.ic_save_white_36dp);


    }

    private void setUpCardViews(){

        benchPressCardView = new StrengthCardView(benchPressCV);


    }
}
