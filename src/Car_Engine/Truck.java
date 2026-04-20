package Car_Engine;

public class Truck extends Vehicle{

    Engine engineType;
    public Truck(Engine engineType,String brand, String model){
        this.engineType = engineType;
        this.setBrand(brand);
        this.setModel(model);
    }
    @Override
    void drive() {
        System.out.println("Driving this Truck: "+ getBrand() + " " + getModel()+ " - " + engineType.startEngine()+ " - " + engineType.stopEngine());
    }
}
