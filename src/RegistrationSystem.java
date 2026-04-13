import java.util.Scanner;

public class RegistrationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = "";
        String password = "";
        String phone = "";
        boolean validUsername = false;
        boolean validPassword = false;
        boolean validPhone = false;

        //Create an empty object first
        Login loginSystem = new Login();
        
        System.out.println("---Registration---");
        
        //Username creation
        while (!validUsername) {
            System.out.print("Enter username (must contain '_' and max of 5 characters): ");
            username = scanner.nextLine();
            if (loginSystem.checkUserName(username)) {
                System.out.println("Username successfully captured.\n");
                validUsername = true;
            } 
            else {
                System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.\n");
            }
        }

        //Password creation
        while (!validPassword) {
            System.out.print("Enter password (must have at least 8 characters, have at least 1 upper case letter and 1 special character): ");
            password = scanner.nextLine();
            if (loginSystem.checkPasswordComplexity(password)) {
                System.out.println("Password successfully captured.\n");
                validPassword = true;
            } 
            else {
                System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.\n");
            }
        }

        //Phone Number input
        String phoneRegex = "^(\\+27|27|0)[6-8][0-9]{8}$";
        while (!validPhone) {
            System.out.print("Enter SA phone number (e.g., 0712345678 or +27712345678: ");
            phone = scanner.nextLine().replaceAll("\\s+", "");
            if (phone.matches(phoneRegex)) {
                System.out.println("Phone number successfully captured!\n");
                validPhone = true;
            } else {
                System.out.println("Invalid format.\n");
            }
        }

        // Register the user (This triggers the Setters inside the Login class)
        String registerResult = loginSystem.registerUser(username, password, phone);
        System.out.println(registerResult);

        // Testing Login
        if (registerResult.contains("successfully")) {
            boolean isLoggedIn = false;
            System.out.println("\n---Testing Login---");

            while (!isLoggedIn) {
                System.out.print("Enter username to login: ");
                String loginUser = scanner.nextLine();
                System.out.print("Enter password to login: ");
                String loginPass = scanner.nextLine();

                isLoggedIn = loginSystem.loginUser(loginUser, loginPass);
                System.out.println(loginSystem.returnLoginStatus(isLoggedIn));
            }
        }
        scanner.close();
    }
}

