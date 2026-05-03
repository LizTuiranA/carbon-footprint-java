package edu.unisalle.carbon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BuildingTest {

    @Test
    void shouldCalculateCarbonFootprintCorrectly() {
        Building building = new Building("Edificio A", 1000, 100);
        double expected = 1000 * 0.4 + 100 * 2.0;

        assertEquals(expected, building.getCarbonFootprint(), 0.0001);
    }

    @Test
    void shouldReturnNonEmptyDescription() {
        Building building = new Building("Edificio B", 500, 50);

        assertFalse(building.getDescription().isBlank());
    }
}
