package ross.feehan.crossfit.strengthcalculator.modelTests;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import ross.feehan.crossfit.strengthcalculator.model.objects.BenchPressStandard;
import ross.feehan.crossfit.strengthcalculator.model.realmDatabaseCursors.BenchPressStandardRealmDBCursor;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Ross Feehan on 21/05/2015.
 * Copyright Ross Feehan
 */

@RunWith(AndroidJUnit4.class)
@SmallTest
public class BenchPressStandardRealmDBCursorTests {


    /*Tests for getEliteWeightBasedOnUserWeightPreferdUnitsAndSex*/

    //The test gives a weight that is between 2 rows for a male KG
    @Test
    public void getEliteWeightBasedOnUsersWeightMaleKG(){
        int result = BenchPressStandardRealmDBCursor
                .getEliteWeightBasedOnUserWeightPreferdUnitsAndSex(InstrumentationRegistry.getTargetContext(),
                        89, "Male", "KG");
        assertThat(result, is(equalTo(157)));
    }

    //The test gives a weight that is between 2 rows for a male KG
    @Test
    public void secondGetEliteWeightBasedOnUsersWeightMaleKG(){
        int result = BenchPressStandardRealmDBCursor
                .getEliteWeightBasedOnUserWeightPreferdUnitsAndSex(InstrumentationRegistry.getTargetContext(),
                        68, "Male", "KG");
        assertThat(result, is(equalTo(132)));
    }

    //The test gives a weight that is between 2 rows for a male lbs
    @Test
    public void getEliteWeightBasedOnUsersWeightMaleLbs(){
        int result = BenchPressStandardRealmDBCursor
                .getEliteWeightBasedOnUserWeightPreferdUnitsAndSex(InstrumentationRegistry.getTargetContext(),
                        185, "Male", "LBS");
        assertThat(result, is(equalTo(343)));
    }

    //The test gives a weight that is between 2 rows for a male lbs
    @Test
    public void secondGetEliteWeightBasedOnUsersWeightMaleLbs(){
        int result = BenchPressStandardRealmDBCursor
                .getEliteWeightBasedOnUserWeightPreferdUnitsAndSex(InstrumentationRegistry.getTargetContext(),
                        135, "Male", "LBS");
        assertThat(result, is(equalTo(260)));
    }

    //The test gives a weight that is between 2 rows for a female KG
    @Test
    public void getEliteWeightBasedOnUsersWeightFemaleKG(){
        int result = BenchPressStandardRealmDBCursor
                .getEliteWeightBasedOnUserWeightPreferdUnitsAndSex(InstrumentationRegistry.getTargetContext(),
                        50, "Female", "KG");
        assertThat(result, is(equalTo(57)));
    }

    //The test gives a weight that is between 2 rows for a female KG
    @Test
    public void secondGetEliteWeightBasedOnUsersWeightFemaleKG(){
        int result = BenchPressStandardRealmDBCursor
                .getEliteWeightBasedOnUserWeightPreferdUnitsAndSex(InstrumentationRegistry.getTargetContext(),
                        80, "Female", "KG");
        assertThat(result, is(equalTo(85)));
    }

    //The test gives a weight that is between 2 rows for a Female lbs
    @Test
    public void getEliteWeightBasedOnUsersWeightFemaleLbs(){
        int result = BenchPressStandardRealmDBCursor
                .getEliteWeightBasedOnUserWeightPreferdUnitsAndSex(InstrumentationRegistry.getTargetContext(),
                        125, "Female", "LBS");
        assertThat(result, is(equalTo(142)));
    }

    //The test gives a weight that is between 2 rows for a Female lbs
    @Test
    public void secondGetEliteWeightBasedOnUsersWeightFemaleLbs(){
        int result = BenchPressStandardRealmDBCursor
                .getEliteWeightBasedOnUserWeightPreferdUnitsAndSex(InstrumentationRegistry.getTargetContext(),
                        170, "Female", "LBS");
        assertThat(result, is(equalTo(183)));
    }

    //This test gives a weight that is exactly a weight in a row for a male KG
    @Test
    public void enterAWeightThatIsEqualToARowGetEliteWeightBasedOnUsersWeightMaleKG(){
        int result = BenchPressStandardRealmDBCursor
                .getEliteWeightBasedOnUserWeightPreferdUnitsAndSex(InstrumentationRegistry.getTargetContext(),
                        150, "Male", "KG");
        assertThat(result, is(equalTo(192)));
    }

    //This test gives a weight that is exactly a weight in a row for a male lbs
    @Test
    public void enterAWeightThatIsEqualToARowGetEliteWeightBasedOnUsersWeightMaleLbs(){
        int result = BenchPressStandardRealmDBCursor
                .getEliteWeightBasedOnUserWeightPreferdUnitsAndSex(InstrumentationRegistry.getTargetContext(),
                        220, "Male", "LBS");
        assertThat(result, is(equalTo(381)));
    }

    //This test gives a weight that is exactly a weight in a row for a female KG
    @Test
    public void enterAWeightThatIsEqualToARowGetEliteWeightBasedOnUsersWeightFemaleKG(){
        int result = BenchPressStandardRealmDBCursor
                .getEliteWeightBasedOnUserWeightPreferdUnitsAndSex(InstrumentationRegistry.getTargetContext(),
                        60, "Female", "KG");
        assertThat(result, is(equalTo(67)));
    }

    //This test gives a weight that is exactly a weight in a row for a female lbs
    @Test
    public void enterAWeightThatIsEqualToARowGetEliteWeightBasedOnUsersWeightFemaleLbs(){
        int result = BenchPressStandardRealmDBCursor
                .getEliteWeightBasedOnUserWeightPreferdUnitsAndSex(InstrumentationRegistry.getTargetContext(),
                        114, "Female", "LBS");
        assertThat(result, is(equalTo(133)));
    }

    //This test is an edge case that gives a weight higher than stored in the DB for a male KG
    @Test
    public void enterAGreaterWeightThanIsStoredToGetEliteWeightMaleKG(){
        int result = BenchPressStandardRealmDBCursor
                .getEliteWeightBasedOnUserWeightPreferdUnitsAndSex(InstrumentationRegistry.getTargetContext(),
                        155, "Male", "KG");
        assertThat(result, is(equalTo(192)));
    }

    //This test is an edge case that gives a weight higher than stored in the DB for a male LBS
    @Test
    public void enterAGreaterWeightThanIsStoredToGetEliteWeightMaleLbs(){
        int result = BenchPressStandardRealmDBCursor
                .getEliteWeightBasedOnUserWeightPreferdUnitsAndSex(InstrumentationRegistry.getTargetContext(),
                        325, "Male", "LBS");
        assertThat(result, is(equalTo(425)));
    }

    //This test is an edge case that gives a weight higher than stored in the DB for a female KG
    @Test
    public void enterAGreaterWeightThanIsStoredToGetEliteWeightFemaleKG(){
        int result = BenchPressStandardRealmDBCursor
                .getEliteWeightBasedOnUserWeightPreferdUnitsAndSex(InstrumentationRegistry.getTargetContext(),
                        96, "Female", "KG");
        assertThat(result, is(equalTo(100)));
    }

    //This test is an edge case that gives a weight higher than stored in the DB for a male LBS
    @Test
    public void enterAGreaterWeightThanIsStoredToGetEliteWeightFemaleLbs(){
        int result = BenchPressStandardRealmDBCursor
                .getEliteWeightBasedOnUserWeightPreferdUnitsAndSex(InstrumentationRegistry.getTargetContext(),
                        200, "Female", "LBS");
        assertThat(result, is(equalTo(217)));
    }

    //This test is an edge case that gives a weight lower than is stored in the DB for a male KG
    @Test
    public void enterLessWeightThanIsStoredToGetEliteWeightMaleKG(){
        int result = BenchPressStandardRealmDBCursor
                .getEliteWeightBasedOnUserWeightPreferdUnitsAndSex(InstrumentationRegistry.getTargetContext(),
                        50, "Male", "KG");
        assertThat(result, is(equalTo(100)));
    }

    //This test is an edge case that gives a weight lower than is stored in the DB for a male lbs
    @Test
    public void enterLessWeightThanIsStoredToGetEliteWeightMalelBS(){
        int result = BenchPressStandardRealmDBCursor
                .getEliteWeightBasedOnUserWeightPreferdUnitsAndSex(InstrumentationRegistry.getTargetContext(),
                        110, "Male", "LBS");
        assertThat(result, is(equalTo(222)));
    }

    //This test is an edge case that gives a weight lower than is stored in the DB for a female KG
    @Test
    public void enterLessWeightThanIsStoredToGetEliteWeightFemaleKG(){
        int result = BenchPressStandardRealmDBCursor
                .getEliteWeightBasedOnUserWeightPreferdUnitsAndSex(InstrumentationRegistry.getTargetContext(),
                        40, "Female", "KG");
        assertThat(result, is(equalTo(52)));
    }

    //This test is an edge case that gives a weight lower than is stored in the DB for a female lbs
    @Test
    public void enterLessWeightThanIsStoredToGetEliteWeightFemalelBS(){
        int result = BenchPressStandardRealmDBCursor
                .getEliteWeightBasedOnUserWeightPreferdUnitsAndSex(InstrumentationRegistry.getTargetContext(),
                        95, "Female", "LBS");
        assertThat(result, is(equalTo(116)));
    }

    /*Tests for getFirstBenchPressStandardBasedOnSexAndPreferedUnits*/

    //Tests that the first row returned for a male and KG is correct
    @Test
    public void getFirstBenchPressStandardForMaleKG(){

        BenchPressStandard result = BenchPressStandardRealmDBCursor
                                    .getFirstBenchPressStandardBasedOnSexAndPreferedUnits(
                                            InstrumentationRegistry.getTargetContext(), "Male", "KG");
        assertThat(result.getBodyWeight(), is(equalTo(52)));
    }

    //Tests that the first row returned for a female and KG is correct
    @Test
    public void getFirstBenchPressStandardForFemaleKG(){
        BenchPressStandard result = BenchPressStandardRealmDBCursor
                .getFirstBenchPressStandardBasedOnSexAndPreferedUnits(
                        InstrumentationRegistry.getTargetContext(), "Female", "KG");
        assertThat(result.getBodyWeight(), is(equalTo(44)));
    }

    //Tests that the first row returned for a male and LBS is correct
    @Test
    public void getFirstBenchPressStandardForMaleLbs(){

        BenchPressStandard result = BenchPressStandardRealmDBCursor
                .getFirstBenchPressStandardBasedOnSexAndPreferedUnits(
                        InstrumentationRegistry.getTargetContext(), "Male", "LBS");
        assertThat(result.getBodyWeight(), is(equalTo(114)));
    }

    //Tests that the first row returned for a female and Lbs is correct
    @Test
    public void getFirstBenchPressStandardForFemaleLbs(){
        BenchPressStandard result = BenchPressStandardRealmDBCursor
                .getFirstBenchPressStandardBasedOnSexAndPreferedUnits(
                        InstrumentationRegistry.getTargetContext(), "Female", "LBS");
        assertThat(result.getBodyWeight(), is(equalTo(97)));
    }

    /*Tests for getBenchPressStandardForUsersWeightSexAndPreferedUnits*/

    //The test gives a weight that is between 2 rows for a male KG
    @Test
    public void getBenchPressStandardForMaleKG(){
        BenchPressStandard result = BenchPressStandardRealmDBCursor.getBenchPressStandardForUsersWeightSexAndPreferedUnits(
                InstrumentationRegistry.getTargetContext(), 108, "Male", "KG");
        assertThat(result.getBodyWeight(), is(equalTo(100)));
    }

    //The test gives a weight that is between 2 rows for a male LBS
    @Test
    public void getBenchPressStandardForMaleLbs(){
        BenchPressStandard result = BenchPressStandardRealmDBCursor.getBenchPressStandardForUsersWeightSexAndPreferedUnits(
                InstrumentationRegistry.getTargetContext(), 230, "Male", "LBS");
        assertThat(result.getBodyWeight(), is(equalTo(220)));
    }

    //The test gives a weight that is between 2 rows for a female KG
    @Test
    public void getBenchPressStandardForFemaleKGS(){
        BenchPressStandard result = BenchPressStandardRealmDBCursor.getBenchPressStandardForUsersWeightSexAndPreferedUnits(
                InstrumentationRegistry.getTargetContext(), 55, "Female", "KG");
        assertThat(result.getBodyWeight(), is(equalTo(52)));
    }

    //The test gives a weight that is between 2 rows for a female LBS
    @Test
    public void getBenchPressStandardForFemaleLBS(){
        BenchPressStandard result = BenchPressStandardRealmDBCursor.getBenchPressStandardForUsersWeightSexAndPreferedUnits(
                InstrumentationRegistry.getTargetContext(),  170, "Female", "LBS");
        assertThat(result.getBodyWeight(), is(equalTo(165)));
    }

    //This test gives a weight that is exactly a weight in a row for a male KG
    @Test
    public void getBenchPressStandardForMaleExactKG(){
        BenchPressStandard result = BenchPressStandardRealmDBCursor.getBenchPressStandardForUsersWeightSexAndPreferedUnits(
                InstrumentationRegistry.getTargetContext(),  67, "Male", "KG");
        assertThat(result.getBodyWeight(), is(equalTo(67)));
    }

    //This test gives a weight that is exactly a weight in a row for a male LBS
    @Test
    public void getBenchPressStandardForMaleExactLbs(){
        BenchPressStandard result = BenchPressStandardRealmDBCursor.getBenchPressStandardForUsersWeightSexAndPreferedUnits(
                InstrumentationRegistry.getTargetContext(),  165, "Male", "LBS");
        assertThat(result.getBodyWeight(), is(equalTo(165)));
    }

    //This test gives a weight that is exactly a weight in a row for a Female KG
    @Test
    public void getBenchPressStandardForFemaleExactKG(){
        BenchPressStandard result = BenchPressStandardRealmDBCursor.getBenchPressStandardForUsersWeightSexAndPreferedUnits(
                InstrumentationRegistry.getTargetContext(),  75, "Female", "KG");
        assertThat(result.getBodyWeight(), is(equalTo(75)));
    }

    //This test gives a weight that is exactly a weight in a row for a Female LBS
    @Test
    public void getBenchPressStandardForFemaleExactLbs(){
        BenchPressStandard result = BenchPressStandardRealmDBCursor.getBenchPressStandardForUsersWeightSexAndPreferedUnits(
                InstrumentationRegistry.getTargetContext(),  123, "Female", "LBS");
        assertThat(result.getBodyWeight(), is(equalTo(123)));
    }

    //This test is an edge case that gives a weight higher than stored in the DB for a male KG
    @Test
    public void getBenchPressStandardForMaleHigherKG(){
        BenchPressStandard result = BenchPressStandardRealmDBCursor.getBenchPressStandardForUsersWeightSexAndPreferedUnits(
                InstrumentationRegistry.getTargetContext(),  155, "Male", "KG");
        assertThat(result.getBodyWeight(), is(equalTo(150)));
    }

    //This test is an edge case that gives a weight higher than stored in the DB for a male LBS
    @Test
    public void getBenchPressStandardForMaleHigherLbs(){
        BenchPressStandard result = BenchPressStandardRealmDBCursor.getBenchPressStandardForUsersWeightSexAndPreferedUnits(
                InstrumentationRegistry.getTargetContext(),   325, "Male", "LBS");
        assertThat(result.getBodyWeight(), is(equalTo(320)));
    }

    //This test is an edge case that gives a weight higher than stored in the DB for a female KG
    @Test
    public void getBenchPressStandardForFemaleHigherKG(){
        BenchPressStandard result = BenchPressStandardRealmDBCursor.getBenchPressStandardForUsersWeightSexAndPreferedUnits(
                InstrumentationRegistry.getTargetContext(),  97, "Female", "KG");
        assertThat(result.getBodyWeight(), is(equalTo(95)));
    }

    //This test is an edge case that gives a weight higher than stored in the DB for a female LBS
    @Test
    public void getBenchPressStandardForFemaleHigherLbs(){
        BenchPressStandard result = BenchPressStandardRealmDBCursor.getBenchPressStandardForUsersWeightSexAndPreferedUnits(
                InstrumentationRegistry.getTargetContext(),   200, "Female", "LBS");
        assertThat(result.getBodyWeight(), is(equalTo(199)));
    }

    //This test is an edge case that gives a weight lower than is stored in the DB for a male KG
    @Test
    public void getBenchPressStandardForMaleLowerKG(){
        BenchPressStandard result = BenchPressStandardRealmDBCursor.getBenchPressStandardForUsersWeightSexAndPreferedUnits(
                InstrumentationRegistry.getTargetContext(),  50, "Male", "KG");
        assertThat(result.getBodyWeight(), is(equalTo(52)));
    }

    //This test is an edge case that gives a weight lower than is stored in the DB for a male lbs
    @Test
    public void getBenchPressStandardForMaleLowerLBS(){
        BenchPressStandard result = BenchPressStandardRealmDBCursor.getBenchPressStandardForUsersWeightSexAndPreferedUnits(
                InstrumentationRegistry.getTargetContext(),  110, "Male", "LBS");
        assertThat(result.getBodyWeight(), is(equalTo(114)));
    }

    //This test is an edge case that gives a weight lower than is stored in the DB for a female KG
    @Test
    public void getBenchPressStandardForFemaleLowerKG(){
        BenchPressStandard result = BenchPressStandardRealmDBCursor.getBenchPressStandardForUsersWeightSexAndPreferedUnits(
                InstrumentationRegistry.getTargetContext(),   40, "Female", "KG");
        assertThat(result.getBodyWeight(), is(equalTo(44)));
    }

    //This test is an edge case that gives a weight lower than is stored in the DB for a female lbs
    @Test
    public void getBenchPressStandardForFemaleLowerLBS(){
        BenchPressStandard result = BenchPressStandardRealmDBCursor.getBenchPressStandardForUsersWeightSexAndPreferedUnits(
                InstrumentationRegistry.getTargetContext(),   95, "Female", "LBS");
        assertThat(result.getBodyWeight(), is(equalTo(97)));
    }
}
