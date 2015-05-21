package ross.feehan.crossfit.strengthcalculator.view;

import android.content.Context;
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

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import ross.feehan.crossfit.strengthcalculator.R;
import ross.feehan.crossfit.strengthcalculator.model.objects.BenchPressStandard;
import ross.feehan.crossfit.strengthcalculator.presenter.presenters.BenchPressStandardPresenter;
import ross.feehan.crossfit.strengthcalculator.presenter.presenters.CalculateOneRepMax;
import ross.feehan.crossfit.strengthcalculator.presenter.presenters.CalculatePercentage;
import ross.feehan.crossfit.strengthcalculator.presenter.presenters.UserDetails;
import ross.feehan.crossfit.strengthcalculator.view.widgets.CustomActionButtonView;
import ross.feehan.crossfit.strengthcalculator.view.widgets.CustomProgress;
import ross.feehan.crossfit.strengthcalculator.view.widgets.StrengthCardView;

/**
 * Created by Ross Feehan on 06/05/2015.
 * Copyright Ross Feehan
 */
public class NewCalculations_Activity extends ActionBarActivity{

    private Context ctx;
    private ArrayList<StrengthCardView> cardViews = new ArrayList<StrengthCardView>();
    private String userPreferedUnits;

    //bench press card view view
    @InjectView (R.id.benchPressCV)CardView benchPressCV;

    //action button layouts
    StrengthCardView benchPressCardView;
    @InjectView(R.id.includeActionButton)RelativeLayout firstActionButton;

    //Dependency Injection
    @Inject UserDetails userDetails;
    @Inject BenchPressStandardPresenter benchPressStandardPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_calculations_layout);

        this.ctx = this;
        ButterKnife.inject(this);

        setUpCardViews();
        createViewArrayLists();
        buttonClicks();

    }

    //The lists that will be acted on when the user interacts with relevant CardView
    private void createViewArrayLists(){

        //weight edit texts
        cardViews.add(benchPressCardView);

    }

    private void buttonClicks(){

        //loop through each card view and set up the click events
        for(final StrengthCardView cardView : cardViews){

            //cardView = the card we are currently on.

            EditText weightET = cardView.weightET;

            //display the "reps for" txt views when the weight edit text gets the focus
            weightET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {
                        cardView.repsTV.setVisibility(View.VISIBLE);
                        cardView.forHowManyTV.setVisibility(View.VISIBLE);

                    }
                }
            });

            //Display the KGs after the weight Edit Text once the user starts typing
            weightET.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                   cardView.weightTV.setText(userPreferedUnits);
                   cardView.weightTV.setVisibility(View.VISIBLE);
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });

            //Dismiss the soft keyboard and get the 1RM once the user has finished typing.
            weightET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if (actionId == EditorInfo.IME_ACTION_DONE) {
                        hideKeyboard();

                        getAndDisplayOneRepMax(cardView.oneRepMaxTV, cardView.repsET, cardView.weightET);
                        displayOneRepMaxOnProgressBar(cardView.progressBar,cardView.repsET, cardView.weightET);
                        displayStandardsOnProgessBar(cardView.beginnerWeightTV, cardView.noviceWeightTV,
                                                cardView.skilledWeightTV, cardView.eliteWeightTV);

                        displayOneRepMaxLayout(cardView.oneRepMaxLayout);

                        //save strength details to database here straight away
                    }

                    return true;
                }
            });
        }

    }

    private void displayOneRepMaxLayout(RelativeLayout oneRepMaxLayout){

        Animation anim = AnimationUtils.loadAnimation(ctx, R.anim.one_rep_max_fade_in);
        oneRepMaxLayout.setAnimation(anim);

        oneRepMaxLayout.setVisibility(View.VISIBLE);

    }

    private boolean getAndDisplayOneRepMax(TextView oneRepMaxTextView, EditText repsET, EditText weightET){

        int reps = Integer.parseInt(repsET.getText().toString());
        int weight = Integer.parseInt(weightET.getText().toString());

        oneRepMaxTextView.setText(String.valueOf(CalculateOneRepMax.calculateOneRepMax(
                        reps, weight))+" "+userPreferedUnits);

        return true;

    }

    private void displayOneRepMaxOnProgressBar(CustomProgress progressBar,EditText repsET, EditText weightET){

        int reps = Integer.parseInt(repsET.getText().toString());
        int weight = Integer.parseInt(weightET.getText().toString());

        int oneRepMax = CalculateOneRepMax.calculateOneRepMax(reps, weight);

        int eliteWeight = benchPressStandardPresenter.getBenchPressEliteWeightForUsersWeight();

        double percentage = CalculatePercentage.calculatePercentage(oneRepMax, eliteWeight);

        progressBar.setMaximumPercentage((float)percentage);

    }

    private void displayStandardsOnProgessBar(TextView beginnerWeightTV, TextView noviceWeightTV,
                                               TextView skilledWeightTV, TextView eliteWeightTV){

        BenchPressStandard benchPressStandard = benchPressStandardPresenter.getBenchPressStandardBasedOnUserDetails();

        beginnerWeightTV.setText(String.valueOf(benchPressStandard.getUntrained())+userPreferedUnits);
        noviceWeightTV.setText(String.valueOf(benchPressStandard.getNovice())+userPreferedUnits);
        skilledWeightTV.setText(String.valueOf(benchPressStandard.getAdvanced())+ userPreferedUnits);
        eliteWeightTV.setText(String.valueOf(benchPressStandard.getElite())+ " + " + userPreferedUnits);

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

    //ACTIVITY LIFECYCLE METHODS
    @Override
    protected void onStart(){
        super.onStart();

        //For Dependency Injection
        ((StrengthCalculatorApplication)getApplication()).getObjectGraph().inject(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        setUpActionButton();

        userPreferedUnits = userDetails.getUserPreferedUnits();

    }

    @Override
    protected void onResume(){
        super.onResume();
    }
}
