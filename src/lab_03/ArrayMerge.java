package lab_03;

import java.util.Arrays;

public class ArrayMerge {

    public static void main(String[] args) {
        int[] arr1 = {6, 7, 11, 30, 55, 100, 201};
        int[] arr2 = {2, 5, 8, 23, 45, 47, 48, 99, 199};
        int[] mergedArray = merge2SortedArray_way2(arr1, arr2);
        System.out.println(Arrays.toString(mergedArray));
    }

    public static int[] merge2SortedArray_way2(int[] arr1, int[] arr2) {
        int[] mergedArray = new int[arr1.length + arr2.length];
        int currentIndexArr1 = 0;
        int currentIndexArr2 = 0;
        int currentIndexMergedArray = 0;

        for (currentIndexMergedArray = 0; currentIndexMergedArray < mergedArray.length; currentIndexMergedArray++) {

            if (currentIndexArr1 > arr1.length - 1) {
                mergedArray[currentIndexMergedArray] = arr2[currentIndexArr2];
                continue;
            }
            if (currentIndexArr2 > arr2.length - 1) {
                mergedArray[currentIndexMergedArray] = arr1[currentIndexArr1];
                continue;
            }

            if (arr1[currentIndexArr1] < arr2[currentIndexArr2]) {
                mergedArray[currentIndexMergedArray] = arr1[currentIndexArr1];
                ++currentIndexArr1;
            } else if (arr1[currentIndexArr1] > arr2[currentIndexArr2] ) {
                mergedArray[currentIndexMergedArray] = arr2[currentIndexArr2];
                ++currentIndexArr2;
            }
        }
        return mergedArray;
    }

    public void merge2SortedArray_way1(int[] arr1, int[] arr2) {

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
