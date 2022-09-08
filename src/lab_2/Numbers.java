package lab_2;

import java.util.Scanner;

public class Numbers {

    private static Scanner scanner = new Scanner(System.in);

    public boolean isEvenNumber(int num){
        if (num % 2 == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Numbers numbers = new Numbers();
        System.out.print("Please enter a random integer: ");
        int num = scanner.nextInt();
        if (numbers.isEvenNumber(num)){
            System.out.printf("%d is an even number\t", num);
        }else{
            System.out.printf("%d is odd number\t", num);
        }

    }
}
