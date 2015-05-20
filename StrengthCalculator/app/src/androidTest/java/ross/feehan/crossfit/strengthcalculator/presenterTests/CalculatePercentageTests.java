package ross.feehan.crossfit.strengthcalculator.presenterTests;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import ross.feehan.crossfit.strengthcalculator.presenter.presenters.CalculatePercentage;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Ross Feehan on 20/05/2015.
 * Copyright Ross Feehan
 */

@RunWith(AndroidJUnit4.class)
@SmallTest
public class CalculatePercentageTests {

    @Test
    public void firstCalculatePercentageTest(){
        double result = CalculatePercentage.calculatePercentage(50, 100);
        assertThat(result, is(equalTo(0.5)));
    }

    @Test
    public void secondCalculatePercentageTest(){
        double result = CalculatePercentage.calculatePercentage(104, 164);
        assertThat(result, is(equalTo(.63)));
    }
}
