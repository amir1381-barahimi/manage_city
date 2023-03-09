package Main.Vehicles;

import Main.Buildings.Shipping_Port;

import java.io.Serializable;

abstract public class Marine_Vehicles extends Vehicle implements Serializable {
    private String fuel_type;
    private int min_depth;
    //____________________setter____________________//

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    public void setMin_depth(int min_depth) {
        this.min_depth = min_depth;
    }
    //________________________getter_________________________//

    public int getMin_depth() {
        return min_depth;
    }

    public String getFuel_type() {
        return fuel_type;
    }
    //____________________constructor_____________________//
    Marine_Vehicles(int price,String company_Name,int vehicle_ID,int capacity,int min_depth,String fuel_type){
        super(price,company_Name,vehicle_ID,capacity);
        setFuel_type(fuel_type);
        setMin_depth(min_depth);
    }
    //_____________________________________________//
    public abstract void printInfo();

}
