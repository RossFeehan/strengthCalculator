package ross.feehan.crossfit.strengthcalculator.viewTests;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ross.feehan.crossfit.strengthcalculator.R;
import ross.feehan.crossfit.strengthcalculator.view.NewCalculations_Activity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasFocus;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

/**
 * Created by Ross Feehan on 07/05/2015.
 * Copyright Ross Feehan
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class NewCalculations_ActivityTests {

    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule(NewCalculations_Activity.class);

    //Test to check that everything is displayed correctly on screen when opened
    @Test
    public void checkInitialLayout(){

        //both Edit Texts are visible
        onView(withId(R.id.repsET)).check(matches(isDisplayed()));
        onView(withId(R.id.weightET)).check(matches(isDisplayed()));

        //that the resp Edit Text has focus
        onView(withId(R.id.repsET)).check(matches(hasFocus()));

        //all text views relating to Edit Texts are hidden
        onView(withId(R.id.repsTV)).check(matches(not(isDisplayed())));
        onView(withId(R.id.forTV)).check(matches(not(isDisplayed())));
        onView(withId(R.id.weightTV)).check(matches(not(isDisplayed())));
    }

    @Test
    public void checkTextViewsDisplayWhenWeightETHasFocus(){

        //when weight Edit Text has focus
        onView(withId(R.id.weightET)).perform(click()).check(matches(hasFocus()));

        //the text views are displayed
        onView(withId(R.id.repsTV)).check(matches(isDisplayed()));
        onView(withId(R.id.forTV)).check(matches(isDisplayed()));

        //the weight unit is not displayed
        onView(withId(R.id.weightTV)).check(matches(not(isDisplayed())));
    }

    @Test
    public void enterTextIntoWeightEt(){

        final int WEIGHTTEXT = 60;

        //click the weight Edit Text
        onView(withId(R.id.weightET)).perform(click()).check(matches(hasFocus()));
        //enter text into weight Edit Text
        onView(withId(R.id.weightET)).perform(typeText(String.valueOf(WEIGHTTEXT)));

        //click the reps Edit Text so weight Edit Text loses focus
        onView(withId(R.id.repsET)).perform(click());

        //check to see the weight unit text is now visible
        onView(withId(R.id.weightTV)).check(matches(isDisplayed()));
    }
}
