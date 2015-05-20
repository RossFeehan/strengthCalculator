package ross.feehan.crossfit.strengthcalculator.presenter.presenters;

/**
 * Created by Ross Feehan on 20/05/2015.
 * Copyright Ross Feehan
 */
public class CalculatePercentage {

    private final static int PERCENTAGECALCULATION = 100;

    public static int calculatePercentage(double firstNumber, double secondNumber){

        double difference = firstNumber/secondNumber;

        double result = difference*PERCENTAGECALCULATION;

        return (int)result;
    }
}
