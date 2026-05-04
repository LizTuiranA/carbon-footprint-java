package edu.unisalle.carbon;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarbonFootprintFileManagerTest {

    @Test
    void shouldCreateFileSuccessfully() {
        CarbonFootprintFileManager fileManager = new CarbonFootprintFileManager();
        Path tempFile = Path.of("data", "test_results_creation.txt");
        List<CarbonFootprint> items = List.of(new Building("Edificio Test", 100, 10));

        fileManager.saveResults(items, tempFile);

        assertTrue(Files.exists(tempFile));
        deleteFile(tempFile);
    }

    @Test
    void shouldWriteNonEmptyFile() throws IOException {
        CarbonFootprintFileManager fileManager = new CarbonFootprintFileManager();
        Path tempFile = Path.of("data", "test_results_content.txt");
        List<CarbonFootprint> items = List.of(new Car("Renault", "Logan", 10000, 13));

        fileManager.saveResults(items, tempFile);

        assertTrue(Files.exists(tempFile));
        String content = Files.readString(tempFile);
        assertTrue(!content.isBlank());
        deleteFile(tempFile);
    }

    @Test
    void shouldRejectNullItems() {
        CarbonFootprintFileManager fileManager = new CarbonFootprintFileManager();

        assertThrows(NullPointerException.class,
                () -> fileManager.saveResults(null, Path.of("data", "test.txt")));
    }

    private void deleteFile(Path file) {
        try {
            Files.deleteIfExists(file);
        } catch (IOException ignored) {
        }
    }
}
