package Car_Engine;

import java.util.ArrayList;
import java.util.List;

public class Main {
     public static void main(String[] args) {

        //declare Engine types
         Engine dieselEngine = new DieselEngine();
         Engine petrolEngine = new PetrolEngine();
         Engine electricEngine = new ElectricEngine();
         Engine hybridEngine = new HybridEngine();

         //create Vehicles with different Engine types
         Vehicle car1 = new Car(dieselEngine,"Volkswagen", "Golf");
         Vehicle car2 = new Car(dieselEngine,"Mercedes Benz", "S Class");
         Vehicle car3 = new Car(petrolEngine,"BMW", "5 Series");
         Vehicle car4 = new Car(electricEngine,"BYD", "Seal");
         Vehicle car5 = new Car(petrolEngine,"Volvo", "XC 90");
         Truck truck1 = new Truck(dieselEngine,"Ford", "Sun");
         Vehicle car6 = new Car(hybridEngine,"Toyota", "RAV4");


         //Add the vehicles in a List
         List<Vehicle> vehicles = new ArrayList<Vehicle>();
         vehicles.add(car1);
         vehicles.add(car2);
         vehicles.add(car3);
         vehicles.add(car4);
         vehicles.add(car5);
         vehicles.add(truck1);
         vehicles.add(car6);

         //Iterating over all vehicles to call the drive() method to demonstrate polymorphism
        for(Vehicle vehicle : vehicles){
            vehicle.drive();
        }

         System.out.println("----------------");
        truck1.service();
     }
}
