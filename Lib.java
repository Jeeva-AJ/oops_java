package app;

import java.io.*;
import java.util.*;
import library.books.Book;
import library.inpus.Inpu;
import library.transactions.Transaction;
import library.users.Student;

public class Lib {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Log In : \n 1.Admin \n 2.Student");
        int lg = sc.nextInt();
        sc.nextLine();
        switch (lg) {
            case 1: {
                System.out.println("Enter Username : ");
                String ue = sc.nextLine();
                System.out.println("Enter password : ");
                String ps = sc.nextLine();
                String che = ue + "/" + ps;
                boolean got = false;
                try (BufferedReader reader = new BufferedReader(new FileReader("admindatabase.txt"))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (line.contains(che)) {
                            got = true;
                            break;
                        }
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: ");
                } catch (IOException e) {
                    System.out.println("An I/O error occurred: ");
                }
                if (got) {
                    System.out.println("You are successfully Logged In :)");
                    System.out.println("would you like to add new book to library ?? \n 1.Yes \n 2.no");
                    int qt = sc.nextInt();
                    sc.nextLine();
                    switch (qt) {
                        case 1: {
                            System.out.println("Enter Name of the Book : ");
                            String bb = sc.nextLine();
                            System.out.println("Author of the Book : ");
                            String au = sc.nextLine();
                            Inpu in = new Inpu(bb, au);
                            try (FileWriter ww = new FileWriter("booksdatabase.txt", true)) {
                                String ll = (bb + "/" + au);
                                ww.write("\n" + ll);
                                in.DisplayInbook();
                                break;
                            } catch (FileNotFoundException e) {
                                System.out.println("File not found: ");
                            } catch (IOException e) {
                                System.out.println("An I/O error occurred: ");
                            }

                        }
                        case 2: {
                            System.out.println("Thank you for your visit");
                            break;
                        }
                    }
                } else {
                    System.out.println("Incorrect Password");
                }
                break;
            }
            case 2: {
                System.out.println("New User : 1.Sign up");
                System.out.println("Alreasy have an Account : 2.Log in");
                int dd = sc.nextInt();
                switch (dd) {
                    case 1: {
                        sc.nextLine();
                        System.out.print("Enter a Username: \n");
                        String ee = sc.nextLine();
                        // Waits for input

                        System.out.print("Create a Strong Password: \n");
                        String ff = sc.nextLine();
                        String gg = (ee + "/" + ff);
                        try (FileWriter writer = new FileWriter("database.txt", true)) {
                            writer.write("\n" + gg);
                            System.out.println("Congratulations you are successfully Signed up!!!");
                            System.out.println("Again Run the code and try Logging In");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case 2: {
                        sc.nextLine();
                        System.out.println("Enter UserName : ");
                        String u = sc.nextLine();
                        System.out.println("Enter Password : ");
                        String ps = sc.nextLine();
                        Student student1 = new Student(u, ps);
                        String che = (u + "/" + ps);
                        boolean got = false;
                        try (BufferedReader reader = new BufferedReader(new FileReader("database.txt"))) {
                            String line;
                            while ((line = reader.readLine()) != null) {
                                if (line.contains(che)) {
                                    got = true;
                                    break;
                                }
                            }
                        } catch (FileNotFoundException e) {
                            System.out.println("File not found: ");
                        } catch (IOException e) {
                            System.out.println("An I/O error occurred: ");
                        }
                        if (got) {
                            System.out.println("You are successfully Logged In :)");
                            System.out.println("Welcome to the Library \n Enter your choice : \n 1.Borrow book \n 2.Return borrowed book");
                            int cn = sc.nextInt();
                            sc.nextLine();
                            switch (cn) {
                                case 1: {
                                    System.out.println("Enter Name of the Book :");
                                    String bb1 = sc.nextLine();
                                    System.out.println("Enter author of the Book");
                                    String au1 = sc.nextLine();
                                    String km = (bb1 + "/" + au1);
                                    boolean nnn = false;
                                    try (BufferedReader reader = new BufferedReader(new FileReader("booksdatabase.txt"))) {
                                        String line;
                                        while ((line = reader.readLine()) != null) {
                                            if (line.contains(km)) {
                                                nnn = true;
                                                break;
                                            }
                                        }
                                    } catch (FileNotFoundException e) {
                                        System.out.println("File not found: ");
                                    } catch (IOException e) {
                                        System.out.println("An I/O error occurred: ");
                                    }
                                    if (nnn) {
                                        Book book1 = new Book(bb1, au1);
                                        Transaction transaction = new Transaction();
                                        transaction.issueBook(book1, student1);
                                    } else {
                                        System.out.println("Invalid Input!!!");
                                        System.out.println("Enter the Details Correctly");
                                    }
                                    break;
                                }
                                case 2: {
                                    System.out.println("Enter Name of the Book :");
                                    String bb2 = sc.nextLine();
                                    System.out.println("Enter author of the Book");
                                    String au2 = sc.nextLine();
                                    Book book1 = new Book(bb2, au2);
                                    Transaction transaction = new Transaction();
                                    transaction.returnBook(book1);
                                    break;
                                }
                            }
                        } else {
                            System.out.println("Invalid Username or Roll Number");
                        }
                        break;
                    }
                }
            }
        }
    }
}
