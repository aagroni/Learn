package Car_Engine;

public class ElectricEngine implements Engine{

    @Override
    public String startEngine() {
        return "Starting Electric Engine";
    }

    @Override
    public String stopEngine() {
        return "Stopping Electric Engine";
    }
}
