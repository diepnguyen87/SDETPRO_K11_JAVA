package lab_13;

import java.util.Scanner;

public class BookManagementTest {

    enum FieldType {STRING, INT}

    ;

    private static BookManagementController controller;

    public static void main(String[] args) {
        BookManagementTest test = new BookManagementTest();

        System.out.println("======= Book Management Program (CRUD)============");
        System.out.println("1. New book");
        System.out.println("2. Find a book(ISBN)");
        System.out.println("3. Update a book");
        System.out.println("4. Delete a book");
        System.out.println("5. Print the book list");
        System.out.println("0. Exit");

        System.out.print("Choose your action: ");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        controller = new BookManagementController();

        switch (option) {
            case 0:
                System.exit(0);
                break;
            case 1:
                Book newBook = test.inputNewBook();
                int result = controller.addNewBook(newBook);

                if (result == 1) {
                    System.out.println("SUCCESS - ADD NEW BOOK");
                } else {
                    System.out.println("FAILED - ADD NEW BOOK");
                }
                break;
            case 2:
                String findISBN = test.inputISBN();
                Book findBook = controller.findBook(findISBN);

                if (findBook != null) {
                    System.out.println(findBook);
                } else {
                    System.out.printf("ISBN %s is NOT FOUND", findISBN);
                }
                break;
            case 3:
                String updateISBN = test.inputISBN();
                boolean updateResult = test.updateBookByOptions(updateISBN);
                if (updateResult == true) {
                    System.out.println("UPDATE SUCCESS");
                } else {
                    System.out.println("UPDATE FAILED");
                }
                break;
            case 4:
                break;

        }
    }

    private Book inputNewBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input ISBN: ");
        String ISBN = scanner.nextLine();
        System.out.print("Please input title: ");
        String title = scanner.nextLine();
        System.out.print("Please input author: ");
        String author = scanner.nextLine();
        System.out.print("Please input year: ");
        int year = scanner.nextInt();
        Book newBook = new Book(ISBN, title, author, year);
        return newBook;
    }

    private String inputISBN() {
        System.out.print("Input ISBN need to find: ");
        Scanner scanner = new Scanner(System.in);
        String ISBN = scanner.nextLine();
        return ISBN;
    }

    private boolean updateBookByOptions(String ISBN) {
        String title = "";
        String author = "";
        int year = 0;

        System.out.println("What infos want to update");
        System.out.println("1. Title");
        System.out.println("2. Author");
        System.out.println("3. Year");
        System.out.println("4. All");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your option (1/2/3/4): ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                title = inputField("Title", FieldType.STRING);
                return controller.updateBookByField(ISBN, BookFields.TITLE, title);
            case 2:
                author = inputField("Author", FieldType.STRING);
                return controller.updateBookByField(ISBN, BookFields.AUTHOR, author);
            case 3:
                year = Integer.parseInt(inputField("YEAR", FieldType.INT));
                return controller.updateBookByField(ISBN, BookFields.YEAR, String.valueOf(year));
            case 4:
                title = inputField("Title", FieldType.STRING);
                author = inputField("Author", FieldType.STRING);
                year = Integer.parseInt(inputField("YEAR", FieldType.INT));
                return controller.updateBookByAll(ISBN, title, author, year);
            default:
                System.out.println("Wrong Option! Please try again");
        }
        return false;
    }

    private String inputField(String fieldName, FieldType ft) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Input %s: ", fieldName);
        switch (ft) {
            case STRING:
                String inputString = scanner.nextLine();
                return inputString;
            case INT:
                int inputInteger = scanner.nextInt();
                return String.valueOf(inputInteger);
        }
        return null;
    }
}
