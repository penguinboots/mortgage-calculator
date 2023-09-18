import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int principal = (int) readNumber("Principal: ");
        double annualRate = readNumber("Annual Rate: ");
        byte years = (byte) readNumber("Period (Years): ");

        var mortgage1 = new Mortgage(principal, annualRate, years);

        mortgage1.generateMortgage();
        mortgage1.generateSchedule();
    }
    public static double readNumber(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextDouble();
    }
}