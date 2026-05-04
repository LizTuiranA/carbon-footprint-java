package edu.unisalle.carbon;

public class Bicycle implements CarbonFootprint {
    private final String brand;
    private final String type;
    private final double annualKilometers;
    private final boolean electric;

    public Bicycle(String brand, String type, double annualKilometers, boolean electric) {
        if (brand == null || brand.isBlank()) {
            throw new IllegalArgumentException("brand must not be blank");
        }
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("type must not be blank");
        }
        if (annualKilometers < 0) {
            throw new IllegalArgumentException("annualKilometers must be zero or positive");
        }
        this.brand = brand;
        this.type = type;
        this.annualKilometers = annualKilometers;
        this.electric = electric;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public double getAnnualKilometers() {
        return annualKilometers;
    }

    public boolean isElectric() {
        return electric;
    }

    @Override
    public double getCarbonFootprint() {
        if (!electric) {
            return 0.0;
        }
        double annualKwh = annualKilometers * 0.01;
        return annualKwh * 0.4;
    }

    @Override
    public String getDescription() {
        return String.format("Bicycle[brand=%s, type=%s, annualKm=%.2f, electric=%s]",
                brand, type, annualKilometers, electric);
    }
}
