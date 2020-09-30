package lab2;

import java.util.Scanner;

public class Age {
    public static void main(String []args) {
        int num = 0;
        String name = "";

        Scanner in = new Scanner(System.in);
        System.out.print("Enter your age (a postive integer): ");
        
        try {
            String inputNum = in.nextLine();

            if(checkInt(inputNum) == true) {
                num = Integer.parseInt(inputNum);
            } else {
                System.out.println("Age must be in between 0 to 120; exiting program.");
                System.exit(0);
            }
        } catch(Exception e) {
            System.out.println("Invalid input; exiting program.");
            System.exit(0);
        }
        
        System.out.print("Enter your name: ");

        try {
            String inputName = in.nextLine();

            if (checkString(inputName)) {
                name = inputName;
                System.out.println(name + " is " + num + " years old." );
            } else {
                System.out.println("Name must only contain letters, spaces, and dashes; exiting program.");
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("Invalid input; exiting program.");
            System.exit(0);
        }

        in.close();
    }

    // Check string validity
    public static boolean checkString(String inputName) {
        if (!inputName.matches("^[-a-zA-Z ]+$")) {
            return false;
        }
        return true;
    }

    // Check integer validity
    public static boolean checkInt(String inputNum) {
        int parsedNum = Integer.parseInt(inputNum);

        if (!inputNum.matches("^[0-9]+$")) {
            return false;
        } else if(!(0 <= parsedNum && parsedNum <= 120)) {
            return false;
        }
        
        return true ;
    }
}
