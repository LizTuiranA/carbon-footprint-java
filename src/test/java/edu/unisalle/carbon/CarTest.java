package edu.unisalle.carbon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarTest {

    @Test
    void shouldCalculateCarbonFootprintCorrectly() {
        Car car = new Car("Mazda", "3", 12000, 12);
        double litersConsumed = 12000.0 / 12.0;
        double expected = litersConsumed * 2.31;

        assertEquals(expected, car.getCarbonFootprint(), 0.0001);
    }

    @Test
    void shouldIncludeBrandAndModelInDescription() {
        Car car = new Car("Kia", "Rio", 9000, 15);
        String description = car.getDescription();

        assertTrue(description.contains("Kia"));
        assertTrue(description.contains("Rio"));
    }

    @Test
    void shouldRejectInvalidFuelEfficiency() {
        assertThrows(IllegalArgumentException.class,
                () -> new Car("Mazda", "2", 10000, 0));
    }
}
