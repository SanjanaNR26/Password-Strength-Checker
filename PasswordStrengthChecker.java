/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package passwordstrengthcheckers;

/**
 *
 * @author SANJANA NR
 */
import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();
            
            String strength = checkPasswordStrength(password);
            System.out.println("Password strength: " + strength);
        }
    }

    public static String checkPasswordStrength(String password) {
        int length = password.length();

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (Character.isLowerCase(ch)) {
                hasLower = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (isSpecialCharacter(ch)) {
                hasSpecial = true;
            }
        }

        if (length < 6) {
            return "Very Weak";
        }

        int score = 0;
        if (hasLower) score++;
        if (hasUpper) score++;
        if (hasDigit) score++;
        if (hasSpecial) score++;

        if (length >= 8 && score >= 3) {
            if (length >= 12 && score == 4) {
                return "Very Strong";
            }
            return "Strong";
        } else if (length >= 6 && score >= 2) {
            return "Moderate";
        } else {
            return "Weak";
        }
    }

    private static boolean isSpecialCharacter(char ch) {
        String specialChars = "!@#$%^&*()-_=+[]{}|;:'\",.<>/?`~";
        return specialChars.indexOf(ch) != -1;
    }
}
