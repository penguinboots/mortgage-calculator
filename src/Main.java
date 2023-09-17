import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int principal = (int) readNumber("Principal: ", 1000, 1_000_000);
        double annualRate = readNumber("Annual Rate: ", 1, 50);
        byte years = (byte) readNumber("Period (Years) :", 1, 50);

        double mortgage = calculateMortgage(principal, annualRate, years);

        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Monthly payment: " + formattedMortgage);
    }

    public static double calculateMortgage(int principal, double annualRate, int years) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        double monthlyRate = annualRate / MONTHS_IN_YEAR / PERCENT;
        int payments = years * MONTHS_IN_YEAR;

        double mathPower = Math.pow(1 + monthlyRate, payments);

        return principal * (monthlyRate * mathPower / (mathPower - 1));
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max) break;
            System.out.println("Enter a value between " + min + " and " + max + ".");
        }
        return value;
    }
}