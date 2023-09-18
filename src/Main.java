public class Main {
    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Principal: ", 1_000, 10_000_000);
        double annualRate = Console.readNumber("Annual Rate: ", 1, 10);
        byte years = (byte) Console.readNumber("Period (Years): ", 1, 35);

        var calculator = new MortgageCalculator(principal, annualRate, years);

        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printSchedule();
    }
}