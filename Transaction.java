package library.transactions;
import library.books.Book;
import library.users.Student;

public class Transaction {
    public void issueBook(Book b, Student s) {
        if (b.isAvailable()) {
            b.borrow();
            System.out.println("Book issued to:");
            s.displayInfo();
        } else {
            System.out.println("Book is currently not available.");
        }
    }

    public void returnBook(Book book) {
        book.returnBook();
        System.out.println("Book has been returned.");
    }
}

