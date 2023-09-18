import java.text.NumberFormat;

public class MortgageReport {

    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Monthly payment: " + formattedMortgage);
    }

    public void printSchedule() {
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("--------");
        System.out.println("\nBalance at:");
        for (short month = 0; month <= calculator.getYears() * MortgageCalculator.MONTHS_IN_YEAR; month+=12) {
            double balance = calculator.calculateBalance(month);
            System.out.println(month/ MortgageCalculator.MONTHS_IN_YEAR + " year(s): " + NumberFormat.getCurrencyInstance().format(balance));
        }
    }
}
