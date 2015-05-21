package ross.feehan.crossfit.strengthcalculator.view.widgets;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import ross.feehan.crossfit.strengthcalculator.R;

/**
 * Created by Ross Feehan on 18/05/2015.
 * Copyright Ross Feehan
 */
public class StrengthCardView {

    @InjectView(R.id.exerciseHeaderTV)public TextView exerciseHeaderTV;
    @InjectView(R.id.repsET)public EditText repsET;
    @InjectView(R.id.repsTV)public TextView repsTV;
    @InjectView(R.id.forHowManyTV)public TextView forHowManyTV;
    @InjectView(R.id.weightET)public EditText weightET;
    @InjectView(R.id.weightTV)public TextView weightTV;
    @InjectView(R.id.oneRepMaxLayout)public RelativeLayout oneRepMaxLayout;
    @InjectView(R.id.progressBar)public CustomProgress progressBar;
    @InjectView(R.id.oneRepMaxTV)public TextView oneRepMaxTV;
    @InjectView(R.id.beginnerWeightTV)public TextView beginnerWeightTV;
    @InjectView(R.id.noviceWeightTV)public TextView noviceWeightTV;
    @InjectView(R.id.skilledWeightTV)public TextView skilledWeightTV;
    @InjectView(R.id.eliteWeightTV)public TextView eliteWeightTV;


    public StrengthCardView(CardView view){

        ButterKnife.inject(this, view);

       progressBar.setProgressBackgroundColor(Color.parseColor("#E0E0E0"));
       progressBar.setProgressColor(Color.parseColor("#0d47a1"));
       progressBar.useRoundedRectangleShape(30f);
    }

    

}
