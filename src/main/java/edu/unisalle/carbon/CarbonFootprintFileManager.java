package edu.unisalle.carbon;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class CarbonFootprintFileManager {

    public void saveResults(List<CarbonFootprint> items, Path outputPath) {
        try {
            Path parent = outputPath.getParent();
            if (parent != null) {
                Files.createDirectories(parent);
            }

            try (var writer = Files.newBufferedWriter(
                    outputPath,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING,
                    StandardOpenOption.WRITE)) {
                for (CarbonFootprint item : items) {
                    writer.write(item.getDescription() + " -> "
                            + String.format("%.2f kg CO2e/year", item.getCarbonFootprint()));
                    writer.newLine();
                }
            }
        } catch (IOException exception) {
            System.err.println("Error while saving carbon footprint file: " + exception.getMessage());
        }
    }
}
