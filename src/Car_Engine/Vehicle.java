package Car_Engine;

public abstract class Vehicle {
    private Engine engine;
    private String brand;
    private String model;
    abstract void drive();

    public Vehicle(Engine engine, String brand, String model) {
        this.engine = engine;
        this.brand = brand;
        this.model = model;
    }
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
