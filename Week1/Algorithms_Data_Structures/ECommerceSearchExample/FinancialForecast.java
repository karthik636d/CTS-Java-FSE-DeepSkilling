public class FinancialForecast {

    public static double forecast(double amount, double growthRate, int years) {

        // Base Case
        if (years == 0) {
            return amount;
        }

        return forecast(amount * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {

        double currentAmount = 10000;
        double growthRate = 0.10; // 10%
        int years = 5;

        double futureValue = forecast(currentAmount, growthRate, years);

        System.out.println("Future Value: " + futureValue);
    }
}
