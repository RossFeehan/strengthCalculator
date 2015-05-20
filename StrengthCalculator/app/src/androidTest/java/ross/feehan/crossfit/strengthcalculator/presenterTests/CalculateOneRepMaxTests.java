package ross.feehan.crossfit.strengthcalculator.presenterTests;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import ross.feehan.crossfit.strengthcalculator.presenter.presenters.CalculateOneRepMax;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Ross Feehan on 20/05/2015.
 * Copyright Ross Feehan
 */

@RunWith(AndroidJUnit4.class)
@SmallTest
public class CalculateOneRepMaxTests {

    @Test
    public void calculateOneRepMaxTest(){
        int result = CalculateOneRepMax.calculateOneRepMax(10, 70);
        assertThat(result, is(equalTo(93)));
    }

    @Test
    public void secondCalculateOneRepMaxTest(){
        int result = CalculateOneRepMax.calculateOneRepMax(10, 100);
        assertThat(result, is(equalTo(133)));
    }
}
