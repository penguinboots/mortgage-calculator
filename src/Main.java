public class Main {
    public static void main(String[] args) {

        int principal = (int) Console.readNumber("Principal: ", 1_000, 10_000_000);
        double annualRate = Console.readNumber("Annual Rate: ", 1, 10);
        byte years = (byte) Console.readNumber("Period (Years): ", 1, 35);

        var mortgage1 = new Mortgage(principal, annualRate, years);

        mortgage1.generateMortgage();
        mortgage1.generateSchedule();
    }
}