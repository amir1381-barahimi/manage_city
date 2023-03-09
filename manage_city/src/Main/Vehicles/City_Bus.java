package Main.Vehicles;

import Main.Buildings.Airport;
import Main.Buildings.Bus_Terminal;
import Main.City;
import com.sun.istack.internal.NotNull;

import java.io.Serializable;
import java.util.Scanner;

public class City_Bus extends Land_Vehicles implements Serializable {
    private Chair_level level;
    private Speed speed;
    private Type_Bus type;
    //Scanner sc=new Scanner(System.in);
    //___________________setter________________________//

    public void setLevel(Chair_level level) {
        this.level = level;
    }

    public void setType(Type_Bus type) {
        this.type = type;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }
    //___________________getter________________________//


    public Chair_level getLevel() {
        return level;
    }

    public Speed getSpeed() {
        return speed;
    }

    public Type_Bus getType() {
        return type;
    }
    //___________________constructor________________________//
    public City_Bus( String company_Name, int vehicle_ID, int capacity,String color,int fuel_Capacity,int fuel_Consumption){
        super(30,company_Name,vehicle_ID,capacity,color,32,4,fuel_Capacity,fuel_Consumption);
        setLevel(Chair_level.GRADE2);
        setSpeed(Speed.SLOW);
        setType(Type_Bus.PUBLIC);
    }
    //_________________________________________________//
    @Override
    public void printInfo(){
        System.out.println("________________________ information _______________________");
        System.out.println("information about vehicle!");
        System.out.println("the vehicle is city bus!");
        System.out.println("the ID of vehicle is: "+this.getVehicle_ID());
        System.out.println("the chair level of bus is: "+this.level);
        System.out.println("the speed of bus is: "+this.speed);
        System.out.println("the Fuel Consumption of bus is: "+this.getFuel_Consumption());
        System.out.println("the capacity of bus is: "+this.getCapacity());
        System.out.println("the Fuel Capacity of bus is: "+this.getFuel_Capacity());
        System.out.println("the Company Name of bus is: "+this.getCompany_Name());
        System.out.println("the color of bus is: "+this.getColor());
        System.out.println("the chair number of bus is: "+this.getNumber_chair());
        System.out.println("the type of bus is: "+this.type);
        System.out.println("the wheel number of bus is: "+this.getWheel_Number());
        System.out.println("__________ the price of train is: "+this.getPrice()+" __________");
    }
    public static Vehicle get_search_City_bus(Bus_Terminal bus_terminal){
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<bus_terminal.vehicle_List.size();i++){
            System.out.println(i+") :");
            bus_terminal.vehicle_List.get(i).printInfo();
        }
        System.out.println("please enter the number of intended Vehicle : ");
        int num=sc.nextInt();
        return bus_terminal.vehicle_List.get(num);

    }


}
