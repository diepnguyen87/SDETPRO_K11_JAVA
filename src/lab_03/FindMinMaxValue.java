package lab_03;

public class FindMinMaxValue {

    public static void main(String[] args) {
        int[] arr = {100, 1, 55, 30, 201, 6, 7, 11};
        int minValue = arr[0];
        int maxValue = arr[0];

        for (int index = 1; index < arr.length; index++) {
            if (arr[index] < minValue) {
                minValue = arr[index];
            }
            if (arr[index] > maxValue) {
                maxValue = arr[index];
            }
        }
        System.out.printf("Min value is: %d\n", minValue);
        System.out.printf("Max value is: %d\n", maxValue);

    }
}
