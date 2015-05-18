package ross.feehan.crossfit.strengthcalculator.view;



import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import ross.feehan.crossfit.strengthcalculator.R;
import ross.feehan.crossfit.strengthcalculator.presenter.presenterInterfaces.CreateUserInterface;
import ross.feehan.crossfit.strengthcalculator.presenter.presenters.CreateUser;
import ross.feehan.crossfit.strengthcalculator.view.widgets.CustomActionButtonView;

/**
 * Created by Ross Feehan on 05/05/2015.
 * Copyright Ross Feehan
 */
public class SetUpUserDetails_Activity extends ActionBarActivity implements CreateUserInterface  {

    private Context ctx;
    @InjectView(R.id.lbsRBTN) RadioButton lbsRadioBTN;
    @InjectView(R.id.kgsRBTN)RadioButton kgsRadioBTN;
    @InjectView(R.id.maleRBTN)RadioButton maleRadioBTN;
    @InjectView(R.id.femaleRBTN) RadioButton femaleRadioBTN;
    @InjectView(R.id.nextBTN)RelativeLayout nextBtn;
    @Inject CreateUser createUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_up_user_activity);

        this.ctx = this;
        ButterKnife.inject(this);

        //For Dependency Injection
        ((StrengthCalculatorApplication)getApplication()).getObjectGraph().inject(this);

        setUpActionButton();

    }

    @OnClick(R.id.lbsRBTN)
    public void onLbsRadioBTNClicked(){
        //make the kgs radio btn not clicked
        kgsRadioBTN.setChecked(false);

        //set units to lbs
        createUser.setUserWeightToLbs();
    }

    @OnClick(R.id.kgsRBTN)
    public void onKgsRadioBTNClicked(){
        //make the Lbs radio btn not clicked
        lbsRadioBTN.setChecked(false);

        //set units to kgs
        createUser.setUserWeightToKgs();
    }
    @OnClick(R.id.maleRBTN)
    public void onMaleRadioBTNClicked(){
        //make the female radio btn not clicked
        femaleRadioBTN.setChecked(false);

        //set sex to male
        createUser.setUserAsMale();
    }

    @OnClick(R.id.femaleRBTN)
    public void onFemaleRadioBTNClicked(){
        //make the male radio btn not clicked
        maleRadioBTN.setChecked(false);

        //set sex to female
        createUser.setUserAsFemale();
    }

    @OnClick(R.id.customActionBTNLayout)
    public void onNextBTNClicked(){

        createUser.createUser(this);
    }

    private void setUpActionButton(){
        CustomActionButtonView nextBTN = new CustomActionButtonView(nextBtn);
        nextBTN.actionButtonImageView.setBackgroundResource(R.mipmap.ic_keyboard_arrow_right_white_36dp);
    }

    //INTERFACE METHODS

    @Override
    public void userSexNotSetError() {
        Toast.makeText(ctx, "Please select your sex", Toast.LENGTH_LONG).show();
    }

    @Override
    public void userMeasurementUnitsNotSet() {
        Toast.makeText(ctx, "Please select weight units", Toast.LENGTH_LONG).show();
    }

    @Override
    public void userCreated() {
        //open main activity
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        overridePendingTransition(R.anim.activity_slide_left_onto_screen, R.anim.activity_slide_left_off_screen);
    }
}
