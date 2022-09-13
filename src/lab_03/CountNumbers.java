package lab_03;

import java.util.function.DoubleFunction;

public class CountNumbers {

    public static void main(String[] args) {
       int[] arr = {100, 1 , 55, 30, 201, 6, 7, 11};
       int numOfOdd = 0;
       int numOfEven = 0;
       for(int index : arr){
           if(index % 2 == 0){
               ++numOfEven;
               continue;
           }
           ++numOfOdd;
       }
        System.out.printf("Num of odd number: %d\n", numOfOdd);
        System.out.printf("Num of even number: %d\n", numOfEven);
    }
}
