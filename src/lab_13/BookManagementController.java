package lab_13;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookManagementController {

    private String filePath = System.getProperty("user.dir") + "/src/lab_13/Data/Books.txt";
    private static final String SEPARATOR = " - ";
    private static List<Book> bookList;

    public int addNewBook(Book newBook) {

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
            return 0;
        }
        return 1;
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

    private List<Book> getBooksList() {
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

    public boolean updateBookByField(String isbn, BookFields bf, String value) {
        bookList = getBooksList();
        Book updateBook = findBook(isbn);
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

    public boolean updateBookByAll(String updateISBN, String newTitle, String newAuthor, int newYear) {
        bookList = getBooksList();
        for (int i = 0; i < bookList.size(); i++) {
            Book currentBook = bookList.get(i);
            if (currentBook.getISBN().equals(updateISBN)) {
                currentBook.setTitle(newTitle);
                currentBook.setAuthor(newAuthor);
                currentBook.setYear(newYear);
            }
        }
        return writeBookListIntoFile(bookList);
    }

    private boolean writeBookListIntoFile(List<Book> bookList) {
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
            return false;
        }
        return true;
    }
}
