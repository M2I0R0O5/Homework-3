package lms;

import java.io.Serializable;

public class BorrowedBook implements Serializable {
    private static final long serialVersionUID = 1L;
    private Book book;
    private Student student;

    public BorrowedBook(Book book, Student student) {
        this.book = book;
        this.student = student;
    }

    public Book getBook() {
        return book;
    }

    public Student getStudent() {
        return student;
    }
}
