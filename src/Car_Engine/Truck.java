package Car_Engine;

public class Truck extends Vehicle implements Serviceable{


    public Truck(Engine engine, String brand, String model) {
        super(engine, brand, model);
    }

    @Override
    void drive() {
        System.out.println("Driving this Truck: "+ getBrand() + " " + getModel()+ " - " + getEngine().startEngine()+ " - " + getEngine().stopEngine());
    }

    @Override
    public String toString() {
        return getBrand() + " - " + getModel();
    }

    @Override
    public void service() {
        System.out.println("Doing Service for the Truck: " + this);
    }
}
