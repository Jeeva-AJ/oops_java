package library.books;
public class Book {
    private String title;
    private String author;
    private boolean available = true;
    private String av;
	
	
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrow() {
        available = false;
    }

    public void returnBook() {
        available = true;
    }
    

    public void displayDetails() {
        if(available == true){
            av = "Available";
        }else{
            av = "Not Available";
        }
        System.out.println("Title: " + title + "\n Author: " + author + "\n Available: " + av );
    }
}


