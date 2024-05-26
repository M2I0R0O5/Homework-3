package lms;

import java.util.Scanner;

public class LMSTester {
    public static void main(String[] args) {
        LMS iliauniLibrary = new LMS();

        Book lor = new Book("Lord of the Rings", "Tolkien");
        Book oop = new Book("OOP", "Paata Gogisvhili");
        iliauniLibrary.addBook(lor);
        iliauniLibrary.addBook(oop);

        System.out.println("Books in library after adding:");
        for (Book book : iliauniLibrary.books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }

        Student gocha = new Student("Gocha", "Gegeshidze", "dfasdf");
        iliauniLibrary.borrowBook(lor, gocha);

        Student maka = new Student("Maka", "Lobjanidze", "3421325");
        iliauniLibrary.borrowBook(oop, maka);

        System.out.println("Books in library after borrowing:");
        for (Book book : iliauniLibrary.books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }

        iliauniLibrary.saveState("libraryState.txt");


        System.out.println("Press Enter to exit...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        scanner.close();
    }
}


