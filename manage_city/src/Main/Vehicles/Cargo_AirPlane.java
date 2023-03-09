package Main.Vehicles;

import Main.Buildings.Airport;
import Main.Buildings.Terminal;
import Main.City;
import com.sun.istack.internal.NotNull;

import java.io.Serializable;
import java.util.Scanner;

public class Cargo_AirPlane extends Air_Vehicles implements Serializable {
    private int total_Portable_Weight;
    //____________________setter____________________//
    public void setTotal_Portable_Weight(int total_Portable_Weight) {
        this.total_Portable_Weight = total_Portable_Weight;
    }
    //________________________getter_________________________//
    public int getTotal_Portable_Weight() {
        return total_Portable_Weight;
    }
    //____________________constructor_____________________//
    public Cargo_AirPlane( String company_Name, int vehicle_ID, int capacity,int band_Length,int max_Fly_Height)
    {
       super(200,company_Name,vehicle_ID,capacity,band_Length,max_Fly_Height);
       setTotal_Portable_Weight(200000);
    }
    //____________________________________________________//
    @Override
    public void printInfo(){
        System.out.println("________________________ information _______________________");
        System.out.println("information about vehicle!");
        System.out.println("the vehicle is cargo aircraft!");
        System.out.println("the ID of vehicle is: "+this.getVehicle_ID());
        System.out.println("the minimum of band length of airplane is: "+this.getBand_Length());
        System.out.println("the maximum of fly height of airplane is: "+this.getMax_Fly_Height());
        System.out.println("the total portable weight of airplane is: "+this.total_Portable_Weight);
        System.out.println("the capacity of airplane is: "+this.getCapacity());
        //System.out.println("the minimum depth of airplane can exist in is: "+this.getMin_depth());
        System.out.println("the Company Name of airplane is: "+this.getCompany_Name());
        //System.out.println("the Fuel type of airplane is: "+this.getFuel_type());
        //System.out.println("the number of crew of airplane is: "+this.number_Crew);
        System.out.println("__________ the price of airplane is: "+this.getPrice()+" __________");
    }



}
