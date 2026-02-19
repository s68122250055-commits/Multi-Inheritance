public class Battery {
    private double percentage;

    public Battery(double percentage) {
        this.percentage = percentage;
    }

    public void drain(double amount) {
        percentage -= amount;
        if (percentage < 0) percentage = 0;
    }

    public void charge(double amount) {
        percentage += amount;
        if (percentage > 100) percentage = 100;
    }

    public double getPercentage() {
        return percentage;
    }
}