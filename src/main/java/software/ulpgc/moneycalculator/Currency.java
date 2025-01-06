package software.ulpgc.moneycalculator;

public record Currency(String code, Double rate) {
    @Override
    public String toString() {
        return code;
    }
}
