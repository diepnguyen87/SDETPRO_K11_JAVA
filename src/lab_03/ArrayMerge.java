package lab_03;

public class ArrayMerge {

    public static void main(String[] args) {
        int[] arr1 = {6, 7, 11, 30, 55, 100, 201};
        int[] arr2 = {2, 5, 8, 23, 45, 47, 48, 99, 199};
        int[] arr3 = new int[arr1.length + arr2.length];
        int nextIndexArr3 = 0;
        int currentK = 0;

        for (int i = 0; i < arr1.length; i++) {
            for (int k = currentK; k < arr2.length; ++k) {
                if (arr1[i] > arr2[k]) {
                    arr3[nextIndexArr3++] = arr2[k];
                    if (k == arr2.length - 1) {
                        arr3[nextIndexArr3] = arr1[i];
                    }
                    continue;
                }
                arr3[nextIndexArr3++] = arr1[i];
                currentK = k;
                if (k == arr2.length - 1) {
                    arr3[nextIndexArr3] = arr2[k];
                }
                break;
            }
        }

        for (int item : arr3) {
            System.out.printf("%d, ", item);
        }
    }
}
