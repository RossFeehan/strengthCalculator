package ross.feehan.crossfit.strengthcalculator.viewTests;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ross.feehan.crossfit.strengthcalculator.R;
import ross.feehan.crossfit.strengthcalculator.view.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Ross Feehan on 06/05/2015.
 * Copyright Ross Feehan
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivity_Tests {

    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void checkIntialLayout(){
        onView(withId(R.id.toolbar_main)).check(matches(isDisplayed()));
        onView(withId(R.id.addBTN)).check(matches(isDisplayed()));
    }
}
