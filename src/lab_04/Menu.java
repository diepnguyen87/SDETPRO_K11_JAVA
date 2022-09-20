package lab_04;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Menu {

    public static void main(String[] args) {
        Set<int[]> arrays = new HashSet<int[]>();
        int numOfArrays = 2;

        for (int i = 0; i < numOfArrays; i++) {
            System.out.printf("=== START DECLARE ARRAY %d ===\n", (i+1));
            int[] arr = createArray();
            arrays.add(arr);
            System.out.printf("=== END DECLARE ARRAY %d ===\n", (i+1));
        }

        //mergeArray(arrays.)
    }

    public static int[] createArray(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length of array: ");
        int numOfElements = scanner.nextInt();
        int[] arr = new int[numOfElements];

        for (int index = 0; index < numOfElements; index++) {
            System.out.printf("Element %d: ", (index+1));
            int nElement = scanner.nextInt();
            arr[index] = nElement;
        }
        return arr;
    }

    public static int[] mergeArray(int[] arr1, int[] arr2) {
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
        return arr3;
    }
}
