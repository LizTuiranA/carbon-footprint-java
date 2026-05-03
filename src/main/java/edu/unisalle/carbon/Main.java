package edu.unisalle.carbon;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<CarbonFootprint> footprintItems = new ArrayList<>();

        footprintItems.add(new Building("Campus Biblioteca", 12000, 900));
        footprintItems.add(new Car("Toyota", "Corolla", 15000, 14));
        footprintItems.add(new Bicycle("GW", "Montana", 1800, false));
        footprintItems.add(new Bicycle("Specialized", "Urbana", 2200, true));

        for (CarbonFootprint item : footprintItems) {
            System.out.printf("%s -> %.2f kg CO2e/year%n",
                    item.getDescription(), item.getCarbonFootprint());
        }

        CarbonFootprintFileManager fileManager = new CarbonFootprintFileManager();
        fileManager.saveResults(footprintItems, Path.of("data", "carbon_footprint_results.txt"));
    }
}
