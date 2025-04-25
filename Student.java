package library.users;
public class Student {
    private String name;
    private String password;

    public Student(String name, String password){
            this.name = name;
            this.password = password;
    }

    public void displayInfo() {
        System.out.println("Student Name: " + name );
    }
}
