package Main.Vehicles;

import Main.Buildings.Airport;
import Main.Buildings.Shipping_Port;
import Main.City;
import com.sun.istack.internal.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Boat extends Marine_Vehicles implements Serializable {
    private Type_Ship type;
    private Speed speed;
    private int fuel_Capacity;
    //public ArrayList<Marine_Vehicles> vehicle_List = new ArrayList<Marine_Vehicles>();
    //Scanner sc=new Scanner(System.in);
    //________________________________setter___________________//
    public void setType(Type_Ship type) {
        this.type = type;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    public void setFuel_Capacity(int fuel_Capacity) {
        this.fuel_Capacity = fuel_Capacity;
    }
    //____________________________getter______________________//

    public int getFuel_Capacity() {
        return fuel_Capacity;
    }

    public Speed getSpeed() {
        return speed;
    }

    public Type_Ship getType() {
        return type;
    }
    //___________________constructor_________________//
    public Boat(String company_Name,int vehicle_ID,int capacity,String fuel_Type,int min_depth,int fuel_Capacity){
        super(100, company_Name,vehicle_ID,capacity,min_depth,fuel_Type);
        setFuel_Capacity(fuel_Capacity);
        setSpeed(Speed.MEDIUM);
        setType(Type_Ship.PRIVATE);
    }
    //_______________________________________________________//
    @Override
    public void printInfo(){
        System.out.println("________________________ information _______________________");
        System.out.println("information about vehicle!");
        System.out.println("the vehicle is boat!");
        System.out.println("the ID of vehicle is: "+this.getVehicle_ID());
        System.out.println("the type of boat is: "+this.type);
        System.out.println("the speed of boat is: "+this.speed);
        System.out.println("the fuel capacity of boat is: "+this.fuel_Capacity);
        System.out.println("the capacity of boat is: "+this.getCapacity());
        System.out.println("the minimum depth of boat can exist in is: "+this.getMin_depth());
        System.out.println("the Company Name of boat is: "+this.getCompany_Name());
        System.out.println("the Fuel type of boat is: "+this.getFuel_type());
        System.out.println("__________ the price of boat is: "+this.getPrice()+" __________");
        System.out.println("the capacity of fuel of boat is: "+this.fuel_Capacity);
    }


}
