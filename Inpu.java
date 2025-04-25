package library.inpus;

public class Inpu {

    private String inbook;
    private String inauth;

    public Inpu(String inbook, String inauth) {
        this.inbook = inbook;
        this.inauth = inauth;
    }

    public void DisplayInbook() {
        System.out.println("Thank you for Enrolling New Books");
        System.out.println("Book Name : " + inbook);
        System.out.println("Author : " + inauth);
    }
}
