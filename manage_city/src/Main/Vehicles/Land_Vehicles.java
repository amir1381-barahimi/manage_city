package Main.Vehicles;

import Main.Buildings.Bus_Terminal;
import Main.Buildings.Terminal;

import java.io.Serializable;

abstract public class Land_Vehicles extends Vehicle implements Serializable {
    private String color;
    private int wheel_Number;
    private int fuel_Consumption;
    private int number_chair;
    private int fuel_Capacity;
    //_______________________setter_______________________//

    public void setColor(String color) {
        this.color = color;
    }

    public void setFuel_Consumption(int fuel_Consumption) {
        this.fuel_Consumption = fuel_Consumption;
    }

    public void setNumber_chair(int number_chair) {
        this.number_chair = number_chair;
    }

    public void setWheel_Number(int wheel_Number) {
        this.wheel_Number = wheel_Number;
    }

    public void setFuel_Capacity(int fuel_Capacity) {
        this.fuel_Capacity = fuel_Capacity;
    }
    //_______________________getter_______________________//


    public int getFuel_Capacity() {
        return fuel_Capacity;
    }

    public int getFuel_Consumption() {
        return fuel_Consumption;
    }

    public String getColor() {
        return color;
    }

    public int getWheel_Number() {
        return wheel_Number;
    }

    public int getNumber_chair() {
        return number_chair;
    }
    //_______________________constructor_______________________//
    public Land_Vehicles(int price, String company_Name, int vehicle_ID, int capacity,String color,int number_chair,int wheel_Number,int fuel_Capacity,int fuel_Consumption){
        super(price,company_Name,vehicle_ID,capacity);
        setColor(color);
        setFuel_Capacity(fuel_Capacity);
        setFuel_Consumption(fuel_Consumption);
        setNumber_chair(number_chair);
        setWheel_Number(wheel_Number);
    }
    //_____________________________________________//
    public abstract void printInfo();

}
