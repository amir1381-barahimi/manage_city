package Main.Vehicles;

//import Main.Buildings.Building;
import Main.Buildings.Airport;
import Main.Buildings.Terminal;
import Main.Person;

import java.io.Serializable;
import java.util.ArrayList;

//class Person{
//    String name;
//    String familyName;
//    int birth_Year;
//    String birth_Place;
//    Jobs job;
//}
abstract public class Vehicle implements Serializable {
    private int price;
    private int capacity;
    private String company_Name;
    private int vehicle_ID;
    //____________________________setter_______________________//
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setCompany_Name(String company_Name) {
        this.company_Name = company_Name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setVehicle_ID(int vehicle_ID) {
        this.vehicle_ID = vehicle_ID;
    }
    //____________________________getter____________________________//
    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    public int getVehicle_ID() {
        return vehicle_ID;
    }

    public String getCompany_Name() {
        return company_Name;
    }
    //___________________constructor_________________//
    public Vehicle(int price,String company_Name,int vehicle_ID,int capacity){
        this.price=price;
        this.capacity=capacity;
        this.vehicle_ID=vehicle_ID;
        this.company_Name=company_Name;
    }
    //_______________________________________________________//
    public abstract void printInfo();
}

//public class City{
//    int population;
//    int money;
//    ArrayList<Person> person=new ArrayList<Person>();
//    ArrayList<Building.Hotel> hotel=new ArrayList<Building.Hotel>();
//    ArrayList<Terminal> terminal=new ArrayList<Terminal>();
//}

