package lab_13;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookManagementController {

    private String filePath = System.getProperty("user.dir") + "/src/lab_13/Data/Books.txt";
    private static final String SEPARATOR = " - ";
    private static List<Book> bookList;

    public WRITING_RESULT addNewBook(Book newBook) {

        try (
                FileOutputStream output = new FileOutputStream(filePath, true);
                OutputStreamWriter writer = new OutputStreamWriter(output);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
        ) {
            String dataLine = "\n" + newBook.getISBN() + SEPARATOR + newBook.getTitle() + SEPARATOR
                    + newBook.getAuthor() + SEPARATOR + newBook.getYear();
            bufferedWriter.write(dataLine);

        } catch (IOException e) {
            e.printStackTrace();
            return WRITING_RESULT.FAILED_TO_WRITING;
        }
        return WRITING_RESULT.SUCCEED;
    }

    public Book findBook(String findISBN) {
        bookList = getBooksList();
        for (Book book : bookList) {
            String currentISBN = book.getISBN();
            if (currentISBN.equals(findISBN)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> getBooksList() {
        bookList = new ArrayList<>();
        FileInputStream input = null;
        try {
            input = new FileInputStream(filePath);
            InputStreamReader reader = new InputStreamReader(input);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String dataLine = bufferedReader.readLine();
            while (dataLine != null) {
                String[] currentBook = dataLine.split(SEPARATOR);
                String ISBN = currentBook[0];
                String title = currentBook[1];
                String author = currentBook[2];
                int year = Integer.parseInt(currentBook[3]);
                Book book = new Book(ISBN, title, author, year);
                bookList.add(book);
                dataLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public WRITING_RESULT updateBookByField(String isbn, BookFields bf, String value) {
        Book updateBook = findBook(isbn);
        if (updateBook == null) {
            return WRITING_RESULT.ISBN_NOT_EXIST;
        }
        switch (bf) {
            case TITLE:
                updateBook.setTitle(value);
                break;
            case AUTHOR:
                updateBook.setAuthor(value);
                break;
            case YEAR:
                updateBook.setYear(Integer.parseInt(value));
                break;
        }
        return writeBookListIntoFile(bookList);
    }

    public WRITING_RESULT updateBookByAll(String updateISBN, String newTitle, String newAuthor, int newYear) {
        Book updateBook = findBook(updateISBN);
        if (updateBook == null) {
            return WRITING_RESULT.ISBN_NOT_EXIST;
        }
        updateBook.setTitle(newTitle);
        updateBook.setAuthor(newAuthor);
        updateBook.setYear(newYear);

        return writeBookListIntoFile(bookList);
    }

    private WRITING_RESULT writeBookListIntoFile(List<Book> bookList) {
        try (
                FileOutputStream output = new FileOutputStream(filePath);
                OutputStreamWriter writer = new OutputStreamWriter(output);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
        ) {

            for (Book book : bookList) {
                String dataLine = book.getISBN() + SEPARATOR + book.getTitle() + SEPARATOR
                        + book.getAuthor() + SEPARATOR + book.getYear();
                bufferedWriter.write(dataLine);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return WRITING_RESULT.FAILED_TO_WRITING;
        }
        return WRITING_RESULT.SUCCEED;
    }

    public WRITING_RESULT deleteBook(String deletedISBN) {
        Book deletedBook = findBook(deletedISBN);
        if (deletedBook == null) {
            return WRITING_RESULT.ISBN_NOT_EXIST;
        }
        bookList.remove(deletedBook);
        return writeBookListIntoFile(bookList);
    }

    public void printBookList(List<Book> bookList) {
        for (int i = 0; i < bookList.size(); i++) {
            System.out.printf("Book %02d: %s\n", i + 1, bookList.get(i).getTitle());
            System.out.println("\tISBN: " + bookList.get(i).getISBN());
            System.out.println("\tAuthor: " + bookList.get(i).getAuthor());
            System.out.println("\tYear: " + bookList.get(i).getYear());
        }
    }
}
