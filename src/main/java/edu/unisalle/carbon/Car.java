package edu.unisalle.carbon;

public class Car implements CarbonFootprint {
    private final String brand;
    private final String model;
    private final double annualKilometers;
    private final double fuelEfficiencyKmPerLiter;

    public Car(String brand, String model, double annualKilometers, double fuelEfficiencyKmPerLiter) {
        if (brand == null || brand.isBlank()) {
            throw new IllegalArgumentException("brand must not be blank");
        }
        if (model == null || model.isBlank()) {
            throw new IllegalArgumentException("model must not be blank");
        }
        if (annualKilometers < 0) {
            throw new IllegalArgumentException("annualKilometers must be zero or positive");
        }
        if (fuelEfficiencyKmPerLiter <= 0) {
            throw new IllegalArgumentException("fuelEfficiencyKmPerLiter must be greater than zero");
        }
        this.brand = brand;
        this.model = model;
        this.annualKilometers = annualKilometers;
        this.fuelEfficiencyKmPerLiter = fuelEfficiencyKmPerLiter;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getAnnualKilometers() {
        return annualKilometers;
    }

    public double getFuelEfficiencyKmPerLiter() {
        return fuelEfficiencyKmPerLiter;
    }

    @Override
    public double getCarbonFootprint() {
        double litersConsumed = annualKilometers / fuelEfficiencyKmPerLiter;
        return litersConsumed * 2.31;
    }

    @Override
    public String getDescription() {
        return String.format("Car[brand=%s, model=%s, annualKm=%.2f, efficiency=%.2f km/L]",
                brand, model, annualKilometers, fuelEfficiencyKmPerLiter);
    }
}
