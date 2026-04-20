package Car_Engine;

public class ElectricEngine implements Engine{

    @Override
    public String startEngine() {
        //System.out.println("Starting Electric Engine");
        return "Starting Electric Engine";
    }

    @Override
    public String stopEngine() {
        //System.out.println("Stopping Electric Engine");
        return "Stopping Electric Engine";
    }

    @Override
    public Engine getEngineType() {
        return this;
    }
}
