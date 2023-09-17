import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    static final byte MONTHS_IN_YEAR = 12;
    static final byte PERCENT = 100;

    public static void main(String[] args) {
        int principal = (int) readNumber("Principal: ", 1000, 1_000_000);
        double annualRate = readNumber("Annual Rate: ", 1, 50);
        byte years = (byte) readNumber("Period (Years): ", 1, 50);

        double mortgage = calculateMortgage(principal, annualRate, years);
        System.out.println("MORTGAGE");
        System.out.println("--------");
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Monthly payment: " + formattedMortgage);

        System.out.println("PAYMENT SCHEDULE");
        System.out.println("--------");
        System.out.println("\nBalance at:");
        for (short month = 0; month <= years * MONTHS_IN_YEAR; month+=12) {
            double balance = calculateBalance(principal, annualRate, years, month);
            System.out.println(month/MONTHS_IN_YEAR + " year(s): " + NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double calculateMortgage(int principal, double annualRate, int years) {
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

    public static double calculateBalance(int principal, double annualRate, byte years, short paymentsMade) {
        int payments = years * MONTHS_IN_YEAR;
        double monthlyRate = annualRate / MONTHS_IN_YEAR / PERCENT;

        return principal
                * (Math.pow(1 + monthlyRate, payments) - Math.pow(1 + monthlyRate, paymentsMade))
                / (Math.pow(1 + monthlyRate, payments) - 1);
    }
}