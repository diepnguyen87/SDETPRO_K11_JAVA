package lab_13;

import java.util.List;
import java.util.Scanner;

public class BookManagementTest {

    enum FieldType {STRING, INT}

    ;

    private static BookManagementController controller;

    public static void main(String[] args) {
        BookManagementTest test = new BookManagementTest();
        WRITING_RESULT result = null;
        controller = new BookManagementController();

        boolean loop = true;
        while (loop == true) {
            int option = test.printAndInputBookManagementProgrammScreen();

            switch (option) {
                case 0:
                    System.out.println("=========EXIT BOOK MANAGEMENT PROGRAM========");
                    System.exit(0);
                    loop = false;
                    break;
                case 1:
                    Book newBook = test.inputNewBook();
                    result = controller.addNewBook(newBook);
                    test.processWritingResult(result);
                    break;
                case 2:
                    String findISBN = test.inputISBN();
                    Book findBook = controller.findBook(findISBN);
                    test.processFindingBookResult(findISBN, findBook);
                    break;
                case 3:
                    String updateISBN = test.inputISBN();
                    result = test.updateBookByOptions(updateISBN);
                    test.processWritingResult(result);
                    break;
                case 4:
                    String deletedISBN = test.inputISBN();
                    result = controller.deleteBook(deletedISBN);
                    test.processWritingResult(result);
                    break;
                case 5:
                    List<Book> bookList = controller.getBooksList();
                    controller.printBookList(bookList);
                    break;
                default:
                    System.out.println("Wrong Option! Please enter again");
            }
        }
    }

    private int printAndInputBookManagementProgrammScreen() {
        System.out.println("======= Book Management Program (CRUD)============");
        System.out.println("1. New book");
        System.out.println("2. Find a book(ISBN)");
        System.out.println("3. Update a book");
        System.out.println("4. Delete a book");
        System.out.println("5. Print the book list");
        System.out.println("0. Exit");

        System.out.print("Choose your action (0/1/2/3/4/5): ");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        return option;
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

    private int inputUpdateOptionByISBN() {
        System.out.println("What infos want to update");
        System.out.println("1. Title");
        System.out.println("2. Author");
        System.out.println("3. Year");
        System.out.println("4. All");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your option (1/2/3/4): ");
        int option = scanner.nextInt();
        return option;
    }

    private WRITING_RESULT updateBookByOptions(String ISBN) {
        String title = "";
        String author = "";
        int year = 0;

        WRITING_RESULT result = null;
        int option = inputUpdateOptionByISBN();

        while (result == null) {
            switch (option) {
                case 1:
                    title = inputField("Title", FieldType.STRING);
                    result = controller.updateBookByField(ISBN, BookFields.TITLE, title);
                    break;
                case 2:
                    author = inputField("Author", FieldType.STRING);
                    result = controller.updateBookByField(ISBN, BookFields.AUTHOR, author);
                    break;
                case 3:
                    year = Integer.parseInt(inputField("YEAR", FieldType.INT));
                    result = controller.updateBookByField(ISBN, BookFields.YEAR, String.valueOf(year));
                    break;
                case 4:
                    title = inputField("Title", FieldType.STRING);
                    author = inputField("Author", FieldType.STRING);
                    year = Integer.parseInt(inputField("YEAR", FieldType.INT));
                    result = controller.updateBookByAll(ISBN, title, author, year);
                    break;
                default:
                    System.out.println("Wrong Option! Please try again");
            }
        }

        return result;
    }

    private void processWritingResult(WRITING_RESULT result) {
        switch (result) {
            case SUCCEED:
                System.out.println("WRITING/UPDATE/DELETE COMPLETED");
                break;
            case FAILED_TO_WRITING:
                System.out.println("FAILED TO WRITING/UPDATE/DELETE");
                break;
            case ISBN_NOT_EXIST:
                System.out.println("ISBN NOT EXIST");
                break;
            default:
                System.out.println("NOT DEFINED");
                break;
        }
    }

    private void processFindingBookResult(String findISBN, Book findBook) {
        if (findBook != null) {
            System.out.println(findBook);
        } else {
            System.out.printf("ISBN %s is NOT FOUND\n", findISBN);
        }
    }
}
