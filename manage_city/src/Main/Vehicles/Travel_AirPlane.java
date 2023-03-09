package Main.Vehicles;

import Main.Buildings.Airport;
import Main.Buildings.Terminal;
import Main.City;
import com.sun.istack.internal.NotNull;

import java.awt.*;
import java.io.Serializable;
import java.util.Scanner;

public class Travel_AirPlane extends Air_Vehicles implements Serializable {
    private int number_Crew;
    private Chair_level level;
    //Scanner sc=new Scanner(System.in);
    //____________________setter_________________________//

    public void setLevel(Chair_level level) {
        this.level = level;
    }

    public void setNumber_Crew(int number_Crew) {
        this.number_Crew = number_Crew;
    }
    //____________________getter_________________________//
    public int getNumber_Crew() {
        return number_Crew;
    }

    public Chair_level getLevel() {
        return level;
    }
    //____________________constructor_________________________//
    public Travel_AirPlane( String company_Name, int vehicle_ID, int capacity,int band_Length,int max_Fly_Height){
        super(300,company_Name,vehicle_ID,capacity,band_Length,max_Fly_Height);
        setLevel(Chair_level.GRADE2);
        setNumber_Crew(4);
    }
    //____________________________________________________//
    @Override
    public void printInfo(){
        System.out.println("________________________ information _______________________");
        System.out.println("information about vehicle!");
        System.out.println("the vehicle is passenger aircraft!");
        System.out.println("the ID of vehicle is: "+this.getVehicle_ID());
        System.out.println("the minimum of band length of airplane is: "+this.getBand_Length());
        System.out.println("the maximum of fly height of airplane is: "+this.getMax_Fly_Height());
        System.out.println("the chair level of airplane is: "+this.level);
        System.out.println("the capacity of airplane is: "+this.getCapacity());
        //System.out.println("the minimum depth of airplane can exist in is: "+this.getMin_depth());
        System.out.println("the Company Name of airplane is: "+this.getCompany_Name());
        //System.out.println("the Fuel type of airplane is: "+this.getFuel_type());
        System.out.println("the number of crew of airplane is: "+this.number_Crew);
        System.out.println("__________ the price of airplane is: "+this.getPrice()+" __________");
    }
    public static Vehicle get_search_Travel_airPlane(Airport airport){
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<airport.vehicle_List.size();i++){
            System.out.println(i+") :");
            airport.vehicle_List.get(i).printInfo();
        }
        System.out.println("please enter the number of intended Vehicle : ");
        int num=sc.nextInt();
        return airport.vehicle_List.get(num);

    }

}
