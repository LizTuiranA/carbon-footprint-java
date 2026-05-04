package edu.unisalle.carbon;

public class Building implements CarbonFootprint {
    private final String name;
    private final double annualElectricityKwh;
    private final double annualNaturalGasM3;

    public Building(String name, double annualElectricityKwh, double annualNaturalGasM3) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name must not be blank");
        }
        if (annualElectricityKwh < 0) {
            throw new IllegalArgumentException("annualElectricityKwh must be zero or positive");
        }
        if (annualNaturalGasM3 < 0) {
            throw new IllegalArgumentException("annualNaturalGasM3 must be zero or positive");
        }
        this.name = name;
        this.annualElectricityKwh = annualElectricityKwh;
        this.annualNaturalGasM3 = annualNaturalGasM3;
    }

    public String getName() {
        return name;
    }

    public double getAnnualElectricityKwh() {
        return annualElectricityKwh;
    }

    public double getAnnualNaturalGasM3() {
        return annualNaturalGasM3;
    }

    @Override
    public double getCarbonFootprint() {
        return annualElectricityKwh * 0.4 + annualNaturalGasM3 * 2.0;
    }

    @Override
    public String getDescription() {
        return String.format("Building[name=%s, electricity=%.2f kWh, gas=%.2f m3]",
                name, annualElectricityKwh, annualNaturalGasM3);
    }
}
