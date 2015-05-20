package ross.feehan.crossfit.strengthcalculator.view.widgets;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import ross.feehan.crossfit.strengthcalculator.R;

/**
 * Created by Ross Feehan on 18/05/2015.
 * Copyright Ross Feehan
 */
public class CustomActionButtonView {

    @InjectView(R.id.actionBTNIV)public ImageView actionButtonImageView;

    public CustomActionButtonView(View view) {

        ButterKnife.inject(this, view);
    }
}
