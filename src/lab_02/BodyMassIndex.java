package lab_02;

import java.util.Scanner;

public class BodyMassIndex {

    private static Scanner scanner = new Scanner(System.in);
    private static int weight, heightInCentimet;
    private static float heightInMeter;
    private final float NORMAL_WEIGHT_MIN = 18.5f;
    private final float NORMAL_WEIGHT_MAX = 24.9f;
    private final float OVER_WEIGHT_MIN = 25.0f;
    private final float OVER_WEIGHT_MAX = 29.9f;
    private final float OBESITY = 30;

    public float calculateBMI(int weight, float heightInMeter) {
        return (float) (weight / (Math.pow((heightInMeter), 2)));
    }

    public int getBMILevel(float bmi) {
        int level = 0;

        if (bmi < NORMAL_WEIGHT_MIN) {
            level = 1;
        } else if (bmi < OVER_WEIGHT_MIN) {
            level = 2;
        } else if (bmi < OBESITY) {
            level = 3;
        } else {
            level = 4;
        }
        return level;
    }

    public float getLossOrGainWeight(int bmiLevel, float heightInMeter, int weight) {
        float normalWeightByHeight = 0f;
        if (bmiLevel == 1) {
            normalWeightByHeight = (float) (NORMAL_WEIGHT_MIN * (Math.pow((heightInMeter), 2)));
        } else if (bmiLevel == 2) {
            return 0;
        } else {
            normalWeightByHeight = (float) (NORMAL_WEIGHT_MAX * (Math.pow((heightInMeter), 2)));
        }
        return normalWeightByHeight - weight;
    }

    public float convertCentimetIntoMeter(int heightInCentimet) {
        return (float) heightInCentimet / 100;
    }

    public static void main(String[] args) {
        BodyMassIndex indicator = new BodyMassIndex();

        System.out.print("Please enter your weight (kg): ");
        weight = scanner.nextInt();
        System.out.print("Please enter your height (cm): ");
        heightInCentimet = scanner.nextInt();

        heightInMeter = indicator.convertCentimetIntoMeter(heightInCentimet);

        float bmi = indicator.calculateBMI(weight, heightInMeter);
        int bmiLevel = indicator.getBMILevel(bmi);

        if (bmiLevel == 1) {
            System.out.printf("Your BMI= %.2f\t=> Under weight\n", bmi);
        } else if (bmiLevel == 2) {
            System.out.printf("Your BMI= %.2f\t=> Normal weight\n", bmi);
        } else if (bmiLevel == 3) {
            System.out.printf("Your BMI= %.2f\t=> Over weight\n", bmi);
        } else {
            System.out.printf("Your BMI= %.2f\t=> Obesity\n", bmi);
        }

        float lossOrGainWeight = indicator.getLossOrGainWeight(bmiLevel, heightInMeter, weight);

        if (lossOrGainWeight > 0f) {
            System.out.printf("You need to gain %.2f kg\n", lossOrGainWeight);
        } else if (lossOrGainWeight == 0f) {
            System.out.printf("Your body is perfect");
        } else {
            System.out.printf("You need to loss %.2f kg\n", Math.abs(lossOrGainWeight));
        }

    }
}
