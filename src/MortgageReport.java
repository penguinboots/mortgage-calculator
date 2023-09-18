import java.text.NumberFormat;

public class MortgageReport {

    private final NumberFormat currency;
    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String formattedMortgage = currency.format(mortgage);
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly payment: " + formattedMortgage);
    }

    public void printSchedule() {
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("--------");
        for (double balance : calculator.getRemainingBalances())
            System.out.println(currency.format(balance));
    }
}
