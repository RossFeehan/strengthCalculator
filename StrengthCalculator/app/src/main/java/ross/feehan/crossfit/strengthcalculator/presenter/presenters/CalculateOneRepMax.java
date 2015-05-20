package ross.feehan.crossfit.strengthcalculator.presenter.presenters;


/**
 * Created by Ross Feehan on 20/05/2015.
 * Copyright Ross Feehan
 */
public class CalculateOneRepMax {

    private final static int ONEREPMAXFORMULAREPS = 1;
    private final static double ONEREPMAXFORMULAADDITION = 0.0333;

    public static int calculateOneRepMax(int reps, int weight){

        //calculation
        double oneRepMaxAsDouble = weight * (ONEREPMAXFORMULAREPS + ONEREPMAXFORMULAADDITION * reps);

        return (int)oneRepMaxAsDouble;

    }
}
