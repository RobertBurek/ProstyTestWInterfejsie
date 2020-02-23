package programator.api;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public interface Vehicle {
    String start();

    public static final Predicate<Vehicle> FILTER_CARS = vehicle -> vehicle instanceof Car;
    public static final Predicate<Vehicle> FILTER_BOAT = vehicle -> vehicle instanceof Boat;
    public static final Predicate<Vehicle> FILTER_PLANES = new Predicate<Vehicle>() {
        @Override
        public boolean test(Vehicle vehicle) {
            return vehicle instanceof Plane;
        }
    };


    static List<Vehicle> filterList(List<Vehicle> list, Predicate<Vehicle> predicate) {

        return list.stream().peek(new Consumer<Vehicle>() {
            @Override
            public void accept(Vehicle vehicle) {
                System.out.println(vehicle);
            }
        })
//                .map(new Function<Vehicle, Object>() {
//            @Override
//            public Object apply(Vehicle vehicle) {
//                return null;
//            }
//        })
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
