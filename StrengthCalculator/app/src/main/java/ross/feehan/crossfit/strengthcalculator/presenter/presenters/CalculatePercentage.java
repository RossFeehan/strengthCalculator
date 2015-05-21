package ross.feehan.crossfit.strengthcalculator.presenter.presenters;

import java.text.DecimalFormat;

/**
 * Created by Ross Feehan on 20/05/2015.
 * Copyright Ross Feehan
 */
public class CalculatePercentage {


    public static double calculatePercentage(double oneRepMax, double eliteWeight){

        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        double difference = oneRepMax/eliteWeight;

        return Double.parseDouble(decimalFormat.format(difference));

    }
}
