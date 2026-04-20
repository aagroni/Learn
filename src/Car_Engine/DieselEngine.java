package Car_Engine;

public class DieselEngine implements Engine {
    @Override
    public String startEngine() {
        //System.out.println("Starting DieselEngine");
        return "Starting DieselEngine\"";
    }

    @Override
    public String stopEngine() {
        //System.out.println("Stopping DieselEngine");
        return "Stopping DieselEngine";
    }

    @Override
    public Engine getEngineType() {
        return this;
    }
}
