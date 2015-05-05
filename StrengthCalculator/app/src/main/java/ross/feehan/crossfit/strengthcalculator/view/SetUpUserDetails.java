package ross.feehan.crossfit.strengthcalculator.view;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.RadioButton;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import ross.feehan.crossfit.strengthcalculator.R;
import ross.feehan.crossfit.strengthcalculator.model.objects.User;

/**
 * Created by Ross Feehan on 05/05/2015.
 * Copyright Ross Feehan
 */
public class SetUpUserDetails extends Activity {

    private Context ctx;
    @InjectView(R.id.lbsRBTN) RadioButton lbsRadioBTN;
    @InjectView(R.id.kgsRBTN)RadioButton kgsRadioBTN;
    @InjectView(R.id.maleRBTN)RadioButton maleRadioBTN;
    @InjectView(R.id.femaleRBTN) RadioButton femaleRadioBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_up_user_activity);

        this.ctx = this;
        ButterKnife.inject(this);

        ActionBar actionBar = getActionBar();

        if(actionBar != null){
            actionBar.hide();
        }

    }

    @OnClick(R.id.lbsRBTN)
    public void onLbsRadioBTNClicked(){
        //make the kgs radio btn not clicked
        kgsRadioBTN.setChecked(false);

        //call business logic here
    }

    @OnClick(R.id.kgsRBTN)
    public void onKgsRadioBTNClicked(){
        //make the Lbs radio btn not clicked
        lbsRadioBTN.setChecked(false);

        //call business logic here
    }
    @OnClick(R.id.maleRBTN)
    public void onMaleRadioBTNClicked(){
        //make the female radio btn not clicked
        femaleRadioBTN.setChecked(false);

        //call business logic here
    }

    @OnClick(R.id.femaleRBTN)
    public void onFemaleRadioBTNClicked(){
        //make the male radio btn not clicked
        maleRadioBTN.setChecked(false);

        //call business logic here
    }




}
