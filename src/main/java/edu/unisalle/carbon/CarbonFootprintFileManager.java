package edu.unisalle.carbon;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Objects;

public class CarbonFootprintFileManager {

    public void saveResults(List<CarbonFootprint> items, Path outputPath) {
        Objects.requireNonNull(items, "items must not be null");
        Objects.requireNonNull(outputPath, "outputPath must not be null");

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
            throw new IllegalStateException("Error while saving carbon footprint file", exception);
        }
    }
}
