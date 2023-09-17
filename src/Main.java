import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int principal;
        double annualRate;
        byte years;

        while (true) {
            System.out.print("Principal: ");
            principal = scanner.nextInt();
            if (principal > 0) break;
            System.out.println("Enter a valid amount.");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualRate = scanner.nextDouble();
            if (annualRate > 0) break;
            System.out.println("Enter a valid rate.");
        }

        while (true) {
            System.out.print("Period (Years): ");
            years = scanner.nextByte();
            if (years > 1 && years < 40) break;
            System.out.println("Enter a valid period.");
        }

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
}