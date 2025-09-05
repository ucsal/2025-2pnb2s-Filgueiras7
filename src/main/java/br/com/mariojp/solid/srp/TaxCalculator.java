package br.com.mariojp.solid.srp;

public class TaxCalculator {
    private final double tax;

    public TaxCalculator() {
        String prop = System.getProperty("tax.rate");
        this.tax = prop != null ? Double.parseDouble(prop) : 0.10;
    }

    public TaxCalculator(double tax) {
        this.tax = tax;
    }

    public double calcularImposto(double valor) {
        return valor * tax;
    }

    public double getTax() {
        return tax;
    }
}
