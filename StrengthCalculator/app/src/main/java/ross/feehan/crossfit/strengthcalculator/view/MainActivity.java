package ross.feehan.crossfit.strengthcalculator.view;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import ross.feehan.crossfit.strengthcalculator.R;
import ross.feehan.crossfit.strengthcalculator.view.widgets.CustomActionButtonView;

/**
 * Created by Ross Feehan on 30/04/2015.
 * Copyright Ross Feehan
 */
public class MainActivity extends ActionBarActivity{

    private Context ctx;
    @InjectView(R.id.mainActivityActionBTN)RelativeLayout mainActivityActionBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.ctx = this;
        ButterKnife.inject(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        setUpActionButton();

    }

    @OnClick(R.id.customActionBTNLayout)
    public void onNextBTNClicked(){
        Intent intent = new Intent(this, NewCalculations_Activity.class);
        startActivity(intent);

    }

    private void setUpActionButton(){

        CustomActionButtonView mainActivityActionBTNView = new CustomActionButtonView(mainActivityActionBTN);
        mainActivityActionBTNView.actionButtonImageView.setBackgroundResource(R.mipmap.ic_add_white_36dp);
    }

}
