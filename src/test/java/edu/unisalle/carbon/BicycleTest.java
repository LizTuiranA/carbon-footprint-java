package edu.unisalle.carbon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BicycleTest {

    @Test
    void shouldReturnZeroForNonElectricBicycle() {
        Bicycle bicycle = new Bicycle("Trek", "Ruta", 2000, false);

        assertEquals(0.0, bicycle.getCarbonFootprint(), 0.0001);
    }

    @Test
    void shouldCalculateFootprintForElectricBicycle() {
        Bicycle bicycle = new Bicycle("Giant", "Urbana", 3000, true);
        double expected = (3000 * 0.01) * 0.4;

        assertEquals(expected, bicycle.getCarbonFootprint(), 0.0001);
    }
}
