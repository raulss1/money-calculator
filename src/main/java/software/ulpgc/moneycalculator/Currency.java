package software.ulpgc.moneycalculator;

public record Currency(String code, String name, Double rate) {
    @Override
    public String toString() {
        return code + "-" + name;
    }
}
