
import java.util.Scanner;

class Student {

    String name;
    int sem;
    int roll_no;
    int marks;

    void setData(String name, int sem, int roll_no, int marks) {
        this.name = name;
        this.sem = sem;
        this.roll_no = roll_no;
        this.marks = marks;
    }

    void getData() {
        System.out.println("Name = " + this.name);
        System.out.println("Semester = " + this.sem);
        System.out.println("Roll no. = " + this.roll_no);
        System.out.println("Marks = " + this.marks);
    }
}

public class StudentClass {

    public static void main(String[] args) {
        Scanner myobj = new Scanner(System.in);

        System.out.println("\n<--- Creating object s1 ---> ");
        Student s1 = new Student();
        System.out.println("Object s1 created....");
        System.out.print("Enter the name of the Student : ");
        String name = myobj.next();
        System.out.print("Enter the semester of the Student : ");
        int sem = myobj.nextInt();
        System.out.print("Enter the roll_no of the Student : ");
        int roll_no = myobj.nextInt();
        System.out.print("Enter the marks of the Student : ");
        int marks = myobj.nextInt();
        
        s1.setData(name, sem, roll_no, marks);
        System.out.println("Object s1 initialized....");
        
        System.out.println("\nPrinting object s1....");
        s1.getData();
        
        
        System.out.println("\n<--- Creating object s2 --->");
        Student s2 = new Student();
        System.out.println("Object s2 created....");
        System.out.print("Enter the name of the Student : ");
        String name1 = myobj.next();
        System.out.print("Enter the semester of the Student : ");
        int sem1 = myobj.nextInt();
        System.out.print("Enter the roll_no of the Student : ");
        int roll_no1 = myobj.nextInt();
        System.out.print("Enter the marks of the Student : ");
        int marks1 = myobj.nextInt();

        s2.setData(name1, sem1, roll_no1, marks1);
        System.out.println("Object s2 initialized....");
        
        System.out.println("\nPrinting object s2....");
        s2.getData();
    }
}