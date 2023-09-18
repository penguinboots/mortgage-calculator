public class MortgageCalculator {
    public final static byte MONTHS_IN_YEAR = 12;
    public final static byte PERCENT = 100;

    private int principal;
    private double annualRate;
    private byte years;

    public MortgageCalculator(int principal, double annualRate, byte years) {
        this.principal = principal;
        this.annualRate = annualRate;
        this.years = years;
    }

    public double calculateMortgage() {
        double monthlyRate = getMonthlyRate();
        int payments = getNumberOfPayments();

        double mathPower = Math.pow(1 + monthlyRate, payments);

        return principal * (monthlyRate * mathPower / (mathPower - 1));
    }

    public double calculateBalance(short paymentsMade) {
        int payments = getNumberOfPayments();
        double monthlyRate = getMonthlyRate();

        return principal * (Math.pow(1 + monthlyRate, payments) - Math.pow(1 + monthlyRate, paymentsMade)) / (Math.pow(1 + monthlyRate, payments) - 1);
    }

    private int getNumberOfPayments() {
        return years * MONTHS_IN_YEAR;
    }

    private double getMonthlyRate() {
        return annualRate / MONTHS_IN_YEAR / PERCENT;
    }

    public short getYears() {
        return years;
    }
}
