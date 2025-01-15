package software.ulpgc.moneycalculator.model;

public record Money(double amount, Currency currency) {
    @Override
    public String toString() {
        return String.format("%.2f %s", amount, currency);
    }
}
