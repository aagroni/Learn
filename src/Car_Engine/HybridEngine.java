package Car_Engine;

public class HybridEngine implements Engine {
    @Override
    public String startEngine() {
        return "Starting Hybrid Engine";
    }

    @Override
    public String stopEngine() {
        return "Stopping Hybrid Engine";
    }
}
