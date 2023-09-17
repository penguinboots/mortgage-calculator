import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        double annualRate = scanner.nextDouble();
        double monthlyRate = annualRate / MONTHS_IN_YEAR / PERCENT;

        System.out.print("Period (Years): ");
        byte years = scanner.nextByte();
        int payments = years * MONTHS_IN_YEAR;

        double mathPower = Math.pow(1 + monthlyRate, payments);
        double mortgage = principal * ( monthlyRate * mathPower  / (mathPower - 1) );
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Monthly payment: " + formattedMortgage);

    }
}