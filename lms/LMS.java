package lms;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LMS implements Serializable {
    private static final long serialVersionUID = 1L;

    List<Book> books = new ArrayList<>();
    private List<BorrowedBook> borrowedBooks = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean removeBook(Book book) {
        return books.remove(book);
    }

    public boolean borrowBook(Book book, Student student) {
        if (books.contains(book)) {
            borrowedBooks.add(new BorrowedBook(book, student));
            books.remove(book);
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book) {
        for (BorrowedBook borrowedBook : borrowedBooks) {
            if (borrowedBook.getBook().equals(book)) {
                borrowedBooks.remove(borrowedBook);
                books.add(book);
                return true;
            }
        }
        return false;
    }

    public void saveState(String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(books);
            oos.writeObject(borrowedBooks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadState(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            books = (List<Book>) ois.readObject();
            borrowedBooks = (List<BorrowedBook>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
