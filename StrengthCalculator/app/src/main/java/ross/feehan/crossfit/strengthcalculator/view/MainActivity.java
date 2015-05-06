package ross.feehan.crossfit.strengthcalculator.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import java.io.File;
import java.io.IOException;

import io.realm.Realm;
import ross.feehan.crossfit.strengthcalculator.R;

/**
 * Created by Ross Feehan on 30/04/2015.
 * Copyright Ross Feehan
 */
public class MainActivity extends Activity{

    private Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.ctx = this;

    }

}
