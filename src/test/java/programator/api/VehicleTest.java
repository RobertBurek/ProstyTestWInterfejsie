package programator.api;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VehicleTest {

    @Test
    void shouldReturnCarsOnly_when_FILTER_CARS_predicate_used() {
        //TODO given - tworzymy listę
        List<Vehicle> vehicleList = Arrays.asList(
                new Car(),
                new Car(),
                new Car(),
                new Boat(),
                new Boat(),
                new Boat(),
                new Boat(),
                new Plane(),
                new Plane(),
                new Plane()
        );


        //TODO when - filtrujemy
//        List<Vehicle> resault = Vehicle.filterList(vehicleList, v -> v instanceof Car);
        List<Vehicle> resault = Vehicle.filterList(vehicleList, Vehicle.FILTER_BOAT.or(Vehicle.FILTER_PLANES));

        //TODO then - sprawdzamy ile jest
        assertEquals(7, resault.size());
    }
}