import java.util.Scanner;

public class result {
    public static void main(String[] args) {
        int pythonMarks,dbmsMarks,osMarks,webtechMarks,adsMarks,misMarks;
        float percent;
        char grade;
        String remark = "Pass";
        Scanner myObj = new Scanner(System.in);

        System.out.println("\n---Welcome to the Student Result Portal---");
        System.out.print("Enter the marks in Python : ");
        pythonMarks = myObj.nextInt();

        System.out.print("Enter the marks in DBMS : ");
        dbmsMarks = myObj.nextInt();

        System.out.print("Enter the marks in OS : ");
        osMarks = myObj.nextInt();

        System.out.print("Enter the marks in Web-Technology : ");
        webtechMarks = myObj.nextInt();

        System.out.print("Enter the marks in ADS : ");
        adsMarks = myObj.nextInt();

        System.out.print("Enter the marks in MIS : ");
        misMarks = myObj.nextInt();

        percent = (pythonMarks + dbmsMarks + osMarks + webtechMarks + adsMarks + misMarks)/6.0f;
        System.out.println("Your Percentage : " + Math.round(percent*100)/100f);

        if (percent >= 91){
        grade = 'A';            
        }
        else if (81 <= percent && percent < 91) {
        grade = 'B';
        }
        else if (71 <= percent && percent < 81) {
        grade = 'C';
        }
        else if (61 <= percent && percent < 71) {
        grade = 'D';
        }
        else if (51 <= percent && percent < 61) {
        grade = 'E';
        }
        else if (41 <= percent && percent < 51) {
        grade = 'F';
        }
        else {
        grade = 'G';
        remark="Fail";
        }

        System.out.println("Your Grade is : " + grade);
        System.out.println("Remark : " + remark);
    }
}
