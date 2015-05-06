package ross.feehan.crossfit.strengthcalculator.viewTests;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ross.feehan.crossfit.strengthcalculator.R;
import ross.feehan.crossfit.strengthcalculator.view.SetUpUserDetails_Activity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isNotChecked;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Ross Feehan on 06/05/2015.
 * Copyright Ross Feehan
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class SetUpUserDetails_Activity_Tests {

    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule(SetUpUserDetails_Activity.class);

    //Test to check that everything is displayed correctly on screen when opened
    @Test
    public void checkInitialLayout(){

        onView(withId(R.id.lbsRBTN)).check(matches(isDisplayed()));
        onView(withId(R.id.kgsRBTN)).check(matches(isDisplayed()));
        onView(withId(R.id.maleRBTN)).check(matches(isDisplayed()));
        onView(withId(R.id.femaleRBTN)).check(matches(isDisplayed()));
        onView(withId(R.id.nextBTN)).check(matches(isDisplayed()));

    }

    //test that when lbsRBTN is clicked it becomes checked
    //and kgsRBTN becomes un-checked
    @Test
    public void onLbsRBTNClicked(){
        onView(withId(R.id.lbsRBTN)).perform(click()).check(matches(isChecked()));
        onView(withId(R.id.kgsRBTN)).check(matches(isNotChecked()));
    }

    //test that when kgsRBTN is clicked it becomes checked
    //and lbsRBTN becomes un-checked
    @Test
    public void onKgsRBTNClicked(){
        onView(withId(R.id.kgsRBTN)).perform(click()).check(matches(isChecked()));
        onView(withId(R.id.lbsRBTN)).check(matches(isNotChecked()));
    }

    //test that when maleRBTN is clicked it becomes checked
    //and femaleRBTN becomes un-checked
    @Test
    public void onMaleRBTNClicked(){
        onView(withId(R.id.maleRBTN)).perform(click()).check(matches(isChecked()));
        onView(withId(R.id.femaleRBTN)).check(matches(isNotChecked()));
    }

    //test that when femaleRBTN is clicked it becomes checked
    //and maleRBTN becomes un-checked
    @Test
    public void onFemaleRBTNClicked(){
        onView(withId(R.id.femaleRBTN)).perform(click()).check(matches(isChecked()));
        onView(withId(R.id.maleRBTN)).check(matches(isNotChecked()));
    }
}
