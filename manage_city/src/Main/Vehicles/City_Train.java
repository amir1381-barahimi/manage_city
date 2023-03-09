package Main.Vehicles;

import Main.Buildings.Airport;
import Main.Buildings.RailWay_Station;
import Main.City;
import com.sun.istack.internal.NotNull;

import javax.xml.ws.Service;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class City_Train extends Land_Vehicles implements Serializable {
    ArrayList<Welfare_Service> service = new ArrayList<Welfare_Service>();
    private int star_Number;
    private int cars_Number;
    //_____________________setter_______________________//

    public void setStar_Number(int star_Number) {
        this.star_Number = star_Number;
    }

    public void setCars_Number(int cars_Number) {
        this.cars_Number = cars_Number;
    }
    //_____________________getter_______________________//


    public int getCars_Number() {
        return cars_Number;
    }

    public int getStar_Number() {
        return star_Number;
    }
    //_____________________constructor_______________________//
    public City_Train( String company_Name, int vehicle_ID, int capacity,String color,int fuel_Capacity,int fuel_Consumption){
        super(200,company_Name,vehicle_ID,capacity,color,300,32,fuel_Capacity,fuel_Consumption);
        setCars_Number(8);
        setStar_Number(4);
    }
    //____________________________________________________//
    @Override
    public void printInfo(){
        System.out.println("________________________ information _______________________");
        System.out.println("information about vehicle!");
        System.out.println("the vehicle is city train!");
        System.out.println("the ID of vehicle is: "+this.getVehicle_ID());
        System.out.println("the cars number of train is: "+this.cars_Number);
        System.out.println("the star number of train is: "+this.star_Number);
        System.out.println("the Fuel Consumption of train is: "+this.getFuel_Consumption());
        System.out.println("the capacity of train is: "+this.getCapacity());
        System.out.println("the Fuel Capacity of train is: "+this.getFuel_Capacity());
        System.out.println("the Company Name of train is: "+this.getCompany_Name());
        System.out.println("the color of train is: "+this.getColor());
        System.out.println("the chair number of train is: "+this.getNumber_chair());
        this.printServices();
        System.out.println("__________ the price of train is: "+this.getPrice()+" __________");
    }
    public void printServices(){
        System.out.println("the welfare service is : ");
        for(Welfare_Service s:service){
            System.out.println("_ "+service);
        }
    }


}
