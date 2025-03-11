public class Passenger {
    private final String name;

    public Passenger(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public boolean boardCar(Car c){
        return c.addPassenger(this);
    }

    public boolean getOffCar(Car c){
        return c.removePassenger(this);
    }
}
