package Car_Engine;

public class Car extends Vehicle{

    Engine engine;
    public Car(Engine engine, String brand, String model) {
        this.engine = engine;
        this.setBrand(brand);
        this.setModel(model);
    }

    @Override
    void drive() {
        System.out.println("Driving this car: "+ getBrand() + " " + getModel()+ " - " + engine.startEngine()+ " - " + engine.stopEngine());
    }

    @Override
    public String toString() {
        return getBrand() + " - " + getModel();
    }

}
