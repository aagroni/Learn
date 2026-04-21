package Car_Engine;

public class Car extends Vehicle{

    public Car(Engine engine, String brand, String model) {
        super(engine, brand, model);
    }

    @Override
    void drive() {
        System.out.println("Driving this car: "+ getBrand() + " " + getModel()+ " - " + getEngine().startEngine()+ " - " + getEngine().stopEngine());
    }

    @Override
    public String toString() {
        return getBrand() + " - " + getModel();
    }
}
