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

    @Test
    public void checkThatAllCardLayoutsAreDisplayed(){

        onView(withId(R.id.benchPressCV)).check(matches(isDisplayed()));
    }

    //Test to check that everything is displayed correctly in Bench Press Card View
    /*@Test
    public void checkBenchPressCardView(){

        //both Edit Texts are visible
        onView(withId(R.id.benchPressRepsET)).check(matches(isDisplayed()));
        onView(withId(R.id.benchPressWeightET)).check(matches(isDisplayed()));

        //that the resp Edit Text has focus
        onView(withId(R.id.benchPressRepsET)).check(matches(hasFocus()));

        //all text views relating to Edit Texts are hidden
        onView(withId(R.id.benchPressRepsTV)).check(matches(not(isDisplayed())));
        onView(withId(R.id.benchPressForTV)).check(matches(not(isDisplayed())));
        onView(withId(R.id.benchPressWeightTV)).check(matches(not(isDisplayed())));
    }*/

    //Test to check that everything is displayed correctly in squat Card View
   /* @Test
    public void checkSquatCardView(){

        //both Edit Texts are visible
        onView(withId(R.id.squatRepsET)).check(matches(isDisplayed()));
        onView(withId(R.id.squatWeightET)).check(matches(isDisplayed()));

        //all text views relating to Edit Texts are hidden
        onView(withId(R.id.squatRepsTV)).check(matches(not(isDisplayed())));
        onView(withId(R.id.squatForTV)).check(matches(not(isDisplayed())));
        onView(withId(R.id.squatWeightTV)).check(matches(not(isDisplayed())));
    }*/

    //Test to check that everything is displayed correctly in deadLift Card View
    /*@Test
    public void checkDeadLiftCardView(){

        //both Edit Texts are visible
        onView(withId(R.id.deadLiftRepsET)).check(matches(isDisplayed()));
        onView(withId(R.id.deadLiftWeightET)).check(matches(isDisplayed()));

        //all text views relating to Edit Texts are hidden
        onView(withId(R.id.deadLiftRepsTV)).check(matches(not(isDisplayed())));
        onView(withId(R.id.deadLiftForTV)).check(matches(not(isDisplayed())));
        onView(withId(R.id.deadLiftWeightTV)).check(matches(not(isDisplayed())));
    }*/

    //Test to check that everything is displayed correctly in over Head Press Card View
    /*@Test
    public void checkOverHeadPressCardView(){

        //both Edit Texts are visible
        onView(withId(R.id.overHeadPressRepsET)).check(matches(isDisplayed()));
        onView(withId(R.id.overHeadPressWeightET)).check(matches(isDisplayed()));

        //all text views relating to Edit Texts are hidden
        onView(withId(R.id.overHeadPressRepsTV)).check(matches(not(isDisplayed())));
        onView(withId(R.id.overHeadPressForTV)).check(matches(not(isDisplayed())));
        onView(withId(R.id.overHeadPressWeightTV)).check(matches(not(isDisplayed())));
    }
*/
    //test for when Bench Press Weight Edit Text has focus
    /*@Test
    public void checkTextViewsDisplayWhenBenchPressWeightETHasFocus(){

        //when weight Edit Text has focus
        onView(withId(R.id.benchPressWeightET)).perform(click()).check(matches(hasFocus()));

        //the text views are displayed
        onView(withId(R.id.benchPressRepsTV)).check(matches(isDisplayed()));
        onView(withId(R.id.benchPressForTV)).check(matches(isDisplayed()));

        //the weight unit is not displayed
        onView(withId(R.id.benchPressWeightTV)).check(matches(not(isDisplayed())));
    }*/

    //test for when Squat Weight Edit Text has focus
   /* @Test
    public void checkTextViewsDisplayWhenSquatWeightETHasFocus(){

        //when weight Edit Text has focus
        onView(withId(R.id.squatWeightET)).perform(click()).check(matches(hasFocus()));

        //the text views are displayed
        onView(withId(R.id.squatRepsTV)).check(matches(isDisplayed()));
        onView(withId(R.id.squatForTV)).check(matches(isDisplayed()));

        //the weight unit is not displayed
        onView(withId(R.id.squatWeightTV)).check(matches(not(isDisplayed())));
    }*/

    //test for when Dead lift Weight Edit Text has focus
   /* @Test
    public void checkTextViewsDisplayWhenDeadLiftWeightETHasFocus(){

        //when weight Edit Text has focus
        onView(withId(R.id.deadLiftWeightET)).perform(click()).check(matches(hasFocus()));

        //the text views are displayed
        onView(withId(R.id.deadLiftRepsTV)).check(matches(isDisplayed()));
        onView(withId(R.id.deadLiftForTV)).check(matches(isDisplayed()));

        //the weight unit is not displayed
        onView(withId(R.id.deadLiftWeightTV)).check(matches(not(isDisplayed())));
    }*/

    //test for when Over Head Press Weight Edit Text has focus
    /*@Test
    public void checkTextViewsDisplayWhenOverHeadPressWeightETHasFocus(){

        //when weight Edit Text has focus
        onView(withId(R.id.overHeadPressWeightET)).perform(click()).check(matches(hasFocus()));

        //the text views are displayed
        onView(withId(R.id.overHeadPressRepsTV)).check(matches(isDisplayed()));
        onView(withId(R.id.overHeadPressForTV)).check(matches(isDisplayed()));

        //the weight unit is not displayed
        onView(withId(R.id.overHeadPressWeightTV)).check(matches(not(isDisplayed())));
    }*/

    //test to check that weight tv is displayed after something is entered into weight edit text
    //in bench press card view
    /*@Test
    public void enterTextIntoBenchPressWeightEt(){

        final int WEIGHTTEXT = 60;

        //click the weight Edit Text
        onView(withId(R.id.benchPressWeightET)).perform(click()).check(matches(hasFocus()));
        //enter text into weight Edit Text
        onView(withId(R.id.benchPressWeightET)).perform(typeText(String.valueOf(WEIGHTTEXT)));

        //check to see the weight unit text is now visible
        onView(withId(R.id.benchPressWeightTV)).check(matches(isDisplayed()));
    }*/

    //test to check that weight tv is displayed after something is entered into weight edit text
    //in squat card view
    /*@Test
    public void enterTextIntoSquatWeightEt(){

        final int WEIGHTTEXT = 60;

        //click the weight Edit Text
        onView(withId(R.id.squatWeightET)).perform(click()).check(matches(hasFocus()));
        //enter text into weight Edit Text
        onView(withId(R.id.squatWeightET)).perform(typeText(String.valueOf(WEIGHTTEXT)));

        //check to see the weight unit text is now visible
        onView(withId(R.id.squatWeightTV)).check(matches(isDisplayed()));
    }*/

    //test to check that weight tv is displayed after something is entered into weight edit text
    //in Dead Lift card view
    /*@Test
    public void enterTextIntoDeadLiftWeightEt(){

        final int WEIGHTTEXT = 60;

        //click the weight Edit Text
        onView(withId(R.id.deadLiftWeightET)).perform(click()).check(matches(hasFocus()));
        //enter text into weight Edit Text
        onView(withId(R.id.deadLiftWeightET)).perform(typeText(String.valueOf(WEIGHTTEXT)));

        //check to see the weight unit text is now visible
        onView(withId(R.id.deadLiftWeightTV)).check(matches(isDisplayed()));
    }*/

    //test to check that weight tv is displayed after something is entered into weight edit text
    //in Over Head Press card view
    /*@Test
    public void enterTextIntoOverHeadPressWeightEt(){

        final int WEIGHTTEXT = 60;

        //click the weight Edit Text
        onView(withId(R.id.overHeadPressWeightET)).perform(click()).check(matches(hasFocus()));
        //enter text into weight Edit Text
        onView(withId(R.id.overHeadPressWeightET)).perform(typeText(String.valueOf(WEIGHTTEXT)));

        //check to see the weight unit text is now visible
        onView(withId(R.id.overHeadPressWeightTV)).check(matches(isDisplayed()));
    }*/
}
