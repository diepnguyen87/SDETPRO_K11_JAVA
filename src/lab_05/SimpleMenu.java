package lab_05;

import java.util.*;

public class SimpleMenu {

    public static void main(String[] args) {
        List<Integer> numberList = new ArrayList<>();

        showMenu();
        int option = enterOption();
        do {
            switch (option) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.print("Enter a number to add into list: ");
                    int number = getNumberFromKeyboard();
                    addNumbersIntoArrayList(numberList, number);
                    break;
                case 2:
                    printNumbersInList(numberList);
                    break;
                case 3:
                    getMaximumNumberInList(numberList);
                    break;
                case 4:
                    getMinimumNumberInList(numberList);
                    break;
                case 5:
                    System.out.print("Enter a number to search: ");
                    int searchNumber = getNumberFromKeyboard();
                    searchNumberInList(numberList, searchNumber);
                    break;
                default:
                    System.out.println("Wrong option. Please enter again!");
                    break;
            }
            showMenu();
            option = enterOption();
        } while (option != 0);

    }

    public static void showMenu() {
        System.out.println("=====MENU======");
        System.out.println("0. Exit");
        System.out.println("1. Add number into ArrayList");
        System.out.println("2. Print numbers");
        System.out.println("3. Get maximum number");
        System.out.println("4. Get minimum number");
        System.out.println("5. Search number");
    }

    public static int enterOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your option: ");
        int option = scanner.nextInt();
        return option;
    }

    private static int getNumberFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        return number;
    }

    private static void addNumbersIntoArrayList(List<Integer> list, int number) {

        while (true) {
            list.add(number);
            System.out.print("Do you wanna continue? ");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.next().toUpperCase();
            switch (answer) {
                case "N":
                    return;
                case "Y":
                default:
                    System.out.print("Enter a number to add into list: ");
                    number = getNumberFromKeyboard();
                    continue;
            }
        }
    }

    private static void printNumbersInList(List<Integer> list) {
        System.out.println(list);
    }

    private static void getMaximumNumberInList(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        List<Integer> sortedList = new ArrayList<>(set);
        int maximumNumber = sortedList.get(sortedList.size()-1);
        System.out.println("===> Maximum number into current list: " + maximumNumber);
    }

    private static void getMinimumNumberInList(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        List<Integer> sortedList = new ArrayList<>(set);
        int minimumNumber = sortedList.get(0);
        System.out.println("===> Minimum number into current list: " + minimumNumber);
    }

    private static void searchNumberInList(List<Integer> list, int number) {

        while (true) {
            int index = list.indexOf(number);
            System.out.printf("Position of %d is at index: %d\n", number, index);
            System.out.print("Do you wanna continue? ");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.next().toUpperCase();
            switch (answer) {
                case "N":
                    return;
                case "Y":
                default:
                    System.out.print("Enter a number to search: ");
                    number = getNumberFromKeyboard();
                    continue;
            }
        }
    }
}