import static org.junit.Assert.*;
import org.junit.Test;

public class TrainTest {
    // Engine Tests
    @Test
    public void testEngineConstructor() {
        Engine engine = new Engine (FuelType.ELECTRIC, 80.0, 100);
        assertEquals(FuelType.ELECTRIC, engine.getFuelType());
        assertEquals(80.0, engine.getCurrentFuel(), 0.001);
        assertEquals(100, engine.getMaxFuel(), 0.001);
    }

    @Test
    public void testEngineGo() {
        Engine engine = new Engine(FuelType.ELECTRIC, 80.0, 100);
        assertTrue(engine.go());
        assertEquals(75.0, engine.getCurrentFuel(), 0.001);
    }

    // Car Tests
    @Test
    public void testCarAddPassenger() {
        Car car = new Car(2);
        Passenger passenger = new Passenger("Maria");
        assertTrue(car.addPassenger(passenger));
        assertEquals(1, car.seatsRemaining());
        System.out.println("Passenger has been added. Amount of seats remaining: " + car.seatsRemaining());
    }

    @Test
    public void testCarRemovePassenger() {
        Car car = new Car(2);
        Passenger passenger = new Passenger("Sandra");
        car.addPassenger(passenger);
        assertTrue(car.removePassenger(passenger));
        assertEquals(2, car.seatsRemaining());
        System.out.println("Passenger has been removed. Amount of seats remaining: " + car.seatsRemaining());
    }

    // Passenger Tests
    @Test
    public void testPassengerBoardCarWithSpace() {
        Car car = new Car(2);
        Passenger passenger = new Passenger("Maame");
        assertTrue(passenger.boardCar(car));
        System.out.println(passenger.getName() + " has boarded the car.");
    }

    @Test
    public void testPassengerBoardCarFull() {
        Car car = new Car(1);
        Passenger passenger1 = new Passenger("Dana");
        Passenger passenger2 = new Passenger("Aline");
        passenger1.boardCar(car);
        assertFalse(passenger2.boardCar(car));
        System.out.println(passenger2.getName() + " was not able to board the car. Car is full.");
    }

    // Train Tests
    @Test
    public void testTrainConstructor() {
        Train train = new Train(FuelType.ELECTRIC, 100, 50, 3, 2);
        assertNotNull(train.getEngine());
        assertEquals(6, train.getMaxCapacity());
        System.out.println("Train has a capacity of " + train.getMaxCapacity());
    }

    @Test
    public void testTrainPassengerCount() {
        Train train = new Train(FuelType.ELECTRIC, 100, 50, 2, 2);
        Passenger passenger1 = new Passenger("Maame");
        Passenger passenger2 = new Passenger("Milka");
        train.getCar(0).addPassenger(passenger1);
        train.getCar(1).addPassenger(passenger2);
        assertEquals(2, train.seatsRemaining());
        System.out.println("Passengers have boarded. Updated available seats: " + train.seatsRemaining());
    }

    @Test
    public void testTrainGetCar() {
        Train train = new Train(FuelType.ELECTRIC, 100, 50, 2, 2);
        assertNotNull(train.getCar(1));
        assertNull(train.getCar(2));
    }

    @Test
    public void testTrainPrintManifest() {
        Train train = new Train(FuelType.ELECTRIC, 100, 50, 2, 2);
        Passenger passenger1 = new Passenger("Dana");
        Passenger passenger2 = new Passenger("Aline");
        train.getCar(0).addPassenger(passenger1);
        train.getCar(1).addPassenger(passenger2);
        train.printManifest();
    }
    
}
