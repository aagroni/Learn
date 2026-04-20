package Car_Engine;

public class PetrolEngine implements Engine{

    @Override
    public String startEngine() {
        //System.out.println("Starting Petrol Engine");
        return "Starting Petrol Engine";
    }

    @Override
    public String stopEngine() {
       // System.out.println("Stopping Petrol Engine");
        return "Stopping Petrol Engine";
    }

    @Override
    public Engine getEngineType() {
        return this;
    }
}
