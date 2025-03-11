public class Engine implements EngineRequirements{
    //Attributes
    private final FuelType fuel;
    private double currentFuelLevel;
    private final double maxFuelLevel;

    /**
     * Constructor for Engine
     * @param fuel Engine's fuel type
     * @param currentFuelLevel currentFuelLevel Engine's current fuel level
     * @param maxFueLevel maxFuelLevel Engine's max fuel level
     */
    public Engine(FuelType fuel, double currentFuelLevel, double maxFuelLevel){
        this.fuel = fuel;
        this.currentFuelLevel = currentFuelLevel;
        this.maxFuelLevel = maxFuelLevel;
    }

    @Override
    public FuelType getFuelType() {
        return this.fuel;
    }

    @Override
    public double getMaxFuel(){
        return maxFuelLevel;
    }

    @Override
    public double getCurrentFuel(){
        return currentFuelLevel;
    }

    @Override
    public void refuel(){
        currentFuelLevel = maxFuelLevel;
        System.out.println("Engine was refueled. Current fuel level: " + currentFuelLevel);

    }

    @Override
    public Boolean go(){
        double fuelConsumption = 5;
        if (currentFuelLevel > 0){
            currentFuelLevel -= fuelConsumption;
            if (currentFuelLevel < 0){
                currentFuelLevel = 0;
            }
            System.out.println("The engine is on. Remaining fuel: " + currentFuelLevel);
            return true;
        } else{
            System.out.println("The engine is out of fuel.");
            return false;
        }
    } 

    @Override
    public String toString() {
        return ("Engine has fuel type: " + this.fuel + " current fuel level: " + this.currentFuelLevel + " and max fuel level: " + this.maxFuelLevel); 
    }

    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 80., 100.); 
        System.out.println(myEngine);

        Engine myOtherEngine = new Engine(FuelType.STEAM, 50., 100.);
        System.out.println(myOtherEngine);

        Train myTrain = new Train(FuelType.ELECTRIC, 100, 50, 2, 3);
        System.out.println("Train's Engine: " + myTrain.getEngine());

        Passenger passenger1 = new Passenger("Lisa");
        Passenger passenger2 = new Passenger("Sara");
        Passenger passenger3 = new Passenger("Mia");

        System.out.println("Train:");
        System.out.println("Max capacity: " + myTrain.getMaxCapacity());
        System.out.println("Remaining seats: " + myTrain.seatsRemaining());

        passenger1.boardCar (myTrain.getCar(0));
        passenger2.boardCar (myTrain.getCar(1));
        passenger3.boardCar (myTrain.getCar(1));

        System.out.println("Passenger Manifest:");
        myTrain.printManifest();

        System.out.println("Passengers getting off the train:");
        passenger1.getOffCar(myTrain.getCar(0));
        passenger2.getOffCar(myTrain.getCar(1));
        System.out.println(passenger1.getName() + " got off the train.");
        System.out.println(passenger2.getName() + " got off the train.");

        System.out.println("Updated manifest: ");
        myTrain.printManifest();

        System.out.println("Remaining seats: " + myTrain.seatsRemaining());

        while (myEngine.go()){

        }

        myEngine.refuel();
        myEngine.go();

        
    }

}