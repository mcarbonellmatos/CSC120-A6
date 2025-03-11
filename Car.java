import java.util.ArrayList;
public class Car {
    private final ArrayList<Passenger> passengers;
    private final int maxCapacity;



    public Car(int maxCapacity){
        this.maxCapacity = maxCapacity;
        this.passengers = new ArrayList<>();
    }


    public int getCapacity(){
        return maxCapacity;
    }

    
    public int seatsRemaining(){
        return maxCapacity  - passengers.size();
    }

   
    public Boolean addPassenger(Passenger p){
        if (seatsRemaining() > 0){
            passengers.add(p);
            return true;
        }
        return false;
    }

    
    public Boolean removePassenger(Passenger p){
        if (passengers.contains(p)){
            passengers.remove(p);
            return true;
        }
        return false;
    }


    public void printManifest(){
        if (passengers.isEmpty()){
            System.out.println("This car is empty.");
        } else{
            System.out.println("Current passengers: ");
            for (Passenger p : passengers){
                System.out.println(p.getName());
            }
        }
    }
}


