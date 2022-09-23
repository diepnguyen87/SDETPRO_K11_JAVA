package lab_06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringExercises {

    public static void main(String[] args) {
        //Lab 6.1
        System.out.println("=== START LAB 1 ===");
        String input = "2hrs and 5 minutes";
        int totalMinutes = calculateTotalMinutes(input);
        System.out.println("Total minutes: " + totalMinutes);

        //Lab 6.2
        System.out.println("=== START LAB 2 ===");
        String myPassword = "password123";
        boolean result = comparePassword(myPassword);
        if(result == true){
            System.out.println("Welcome to my home page");
        }else{
            System.out.println("Wrong password 3 times! No more time to try.");
        }

        //Lab 6.3
        System.out.println("=== START LAB 3 ===");
        String myStr = "12345nabc678";
        int myIntegerString = getIntegerFromString(myStr);
        System.out.println("My integer string is: " + myIntegerString);

        //Lab 6.4
        System.out.println("=== START LAB 4 ===");
        String url = "https://google.com";
        List<String> urlElementsList = getElementsInUrl(url);
        System.out.println(urlElementsList);
    }

    public static int calculateTotalMinutes(String input){
        int hrsIndex = input.indexOf("hrs");
        int minutesIndex = input.indexOf("minutes");
        int hours = Integer.valueOf(input.substring(0, hrsIndex));
        int minutes = Integer.valueOf(input.substring(minutesIndex-2, minutesIndex-1));
        int total = (hours*60) + minutes;
        return total;
    }

    public static boolean comparePassword(String myPassword){
        boolean result = false;
        int count = 1;
        while(count <= 3){
            System.out.print("Enter your password: ");
            Scanner scanner = new Scanner(System.in);
            String password = scanner.next();
            if(password.equals(myPassword)){
                result = true;
            }

            if(count == 3){
                break;
            }
            System.out.println("Wrong password! Please try again.");
            ++count;
        }
        return result;
    }

    public static int getIntegerFromString(String myStr){
        String myIntegerString = "";

        char[] myStrArray = myStr.toCharArray();
        for (char value : myStrArray) {
            if(Character.isDigit(value)){
                myIntegerString = myIntegerString.concat(String.valueOf(value));
            }
        }
        return Integer.valueOf(myIntegerString);
    }

    public static List<String> getElementsInUrl(String url){
        List<String> urlElementsList = new ArrayList<>();
        String protocalElement = url.split("://")[0];
        urlElementsList.add(protocalElement);

        String domainElements = url.split("://")[1];
        String[] domainElementsArray = domainElements.split("\\.");

        for (String item : domainElementsArray) {
            urlElementsList.add(item);
        }
        return urlElementsList;
    }
}
