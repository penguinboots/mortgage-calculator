import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        int principal;
        double monthlyRate;
        int payments;

        while (true) {
            System.out.print("Principal: ");
            principal = scanner.nextInt();
            if (principal <= 0) {
                System.out.println("Enter a valid amount.");
                continue;
            }
            break;
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            double annualRate = scanner.nextDouble();
            if (annualRate <= 0) {
                System.out.println("Enter a valid rate.");
                continue;
            }
            monthlyRate = annualRate / MONTHS_IN_YEAR / PERCENT;
            break;
        }

        while (true) {
            System.out.print("Period (Years): ");
            byte years = scanner.nextByte();
            if (years < 1 || years > 40) {
                System.out.println("Enter a valid period.");
                continue;
            }
            payments = years * MONTHS_IN_YEAR;
            break;
        }

        double mathPower = Math.pow(1 + monthlyRate, payments);
        double mortgage = principal * (monthlyRate * mathPower / (mathPower - 1));
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Monthly payment: " + formattedMortgage);

    }
}