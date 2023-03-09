package Main.Vehicles;

import Main.Buildings.Airport;
import Main.Buildings.Shipping_Port;
import Main.City;
import com.sun.istack.internal.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Ship extends Marine_Vehicles implements Serializable {
    private Type_Ship type;
    private int crew_Number;
    private int total_Portable_Weight;
    private int fuel_Capacity;
    //public ArrayList<Marine_Vehicles> vehicle_List = new ArrayList<Marine_Vehicles>();
    //__________________setter___________________//
    public void setType(Type_Ship type) {
        this.type = type;
    }

    public void setCrew_Number(int crew_Number) {
        this.crew_Number = crew_Number;
    }

    public void setTotal_Portable_Weight(int total_Portable_Weight) {
        this.total_Portable_Weight = total_Portable_Weight;
    }

    public void setFuel_Capacity(int fuel_Capacity) {
        this.fuel_Capacity = fuel_Capacity;
    }
    //______________________getter____________________//

    public Type_Ship getType() {
        return type;
    }

    public int getFuel_Capacity() {
        return fuel_Capacity;
    }

    public int getCrew_Number() {
        return crew_Number;
    }

    public int getTotal_Portable_Weight() {
        return total_Portable_Weight;
    }
    //______________constructor___________________//
    public Ship(String company_Name,int vehicle_ID,int capacity,String fuel_Type,int min_depth,int fuel_Capacity){
        super(400, company_Name,vehicle_ID,capacity,min_depth,fuel_Type);
        setCrew_Number(3);
        setFuel_Capacity(fuel_Capacity);
        setType(Type_Ship.COMMERCIAL);
        setTotal_Portable_Weight(1000000);
    }
    //_______________________________________________//
    @Override
    public void printInfo(){
        System.out.println("________________________ information _______________________");
        System.out.println("information about vehicle!");
        System.out.println("the vehicle is ship!");
        System.out.println("the ID of vehicle is: "+this.getVehicle_ID());
        System.out.println("the type of ship is: "+this.type);
        System.out.println("the total portable weight of ship is: "+this.total_Portable_Weight);
        System.out.println("the fuel capacity of ship is: "+this.fuel_Capacity);
        System.out.println("the capacity of ship is: "+this.getCapacity());
        System.out.println("the minimum depth of ship can exist in is: "+this.getMin_depth());
        System.out.println("the Company Name of ship is: "+this.getCompany_Name());
        System.out.println("the Fuel type of ship is: "+this.getFuel_type());
        System.out.println("the number of crew of ship is: "+this.crew_Number);
        System.out.println("__________ the price of ship is: "+this.getPrice()+" __________");
    }


}
