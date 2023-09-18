import java.text.NumberFormat;

public class Mortgage {
    final byte MONTHS_IN_YEAR = 12;
    final byte PERCENT = 100;

    private int principal;
    private double annualRate;
    private byte years;

    public Mortgage(int principal, double annualRate, byte years) {
        setPrincipal(principal);
        setAnnualRate(annualRate);
        setYears(years);
    }

    private void setYears(byte years) {
        if (years > 0 && years <= 35) {
            this.years = years;
        } else {
            throw new IllegalArgumentException("Period must be between 0 and 35 years.");
        }
    }

    private void setAnnualRate(double annualRate) {
        if (annualRate > 0 && annualRate <= 10) {
            this.annualRate = annualRate;
        } else {
            throw new IllegalArgumentException("Annual Rate must be between 0 and 10.");
        }
    }

    private void setPrincipal(int principal) {
        if (principal > 1_000 && principal <= 10_000_000) {
            this.principal = principal;
        } else {
            throw new IllegalArgumentException("Principal must be between 1,000 and 10,000,000.");
        }
    }

    public double calculateMortgage() {
        double monthlyRate = annualRate / MONTHS_IN_YEAR / PERCENT;
        int payments = years * MONTHS_IN_YEAR;

        double mathPower = Math.pow(1 + monthlyRate, payments);

        return principal * (monthlyRate * mathPower / (mathPower - 1));
    }

    private double calculateBalance(short paymentsMade) {
        int payments = years * MONTHS_IN_YEAR;
        double monthlyRate = annualRate / MONTHS_IN_YEAR / PERCENT;

        return principal * (Math.pow(1 + monthlyRate, payments) - Math.pow(1 + monthlyRate, paymentsMade)) / (Math.pow(1 + monthlyRate, payments) - 1);
    }

    public void generateMortgage() {
        double mortgage = this.calculateMortgage();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Monthly payment: " + formattedMortgage);
    }

    public void generateSchedule() {
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("--------");
        System.out.println("\nBalance at:");
        for (short month = 0; month <= years * MONTHS_IN_YEAR; month+=12) {
            double balance = this.calculateBalance(month);
            System.out.println(month/MONTHS_IN_YEAR + " year(s): " + NumberFormat.getCurrencyInstance().format(balance));
        }
    }

}
