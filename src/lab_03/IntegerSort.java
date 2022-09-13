package lab_03;

public class IntegerSort {

    public static void main(String[] args) {
        int[] arr = {100, 1, 55, 30, 201, 6, 7, 11};

        for (int i = 0; i < arr.length - 1; i++) {
            for (int k = i + 1; k < arr.length; k++) {
                if (arr[k] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[k];
                    arr[k] = temp;
                }
            }
        }

        for (int item : arr) {
            System.out.printf("%d, ", item);
        }
    }
}
