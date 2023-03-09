package Main.Buildings;

import Main.City;
import Main.Vehicles.City_Bus;
//import com.sun.istack.internal.NotNull;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Bus_Terminal extends Terminal implements Serializable {
    public ArrayList<City_Bus> vehicle_List = new ArrayList<City_Bus>();
    //_____________________constructor_______________________//
    public Bus_Terminal(int vehicle_Number,String name,String address,double area,String city_name){
        super(100,vehicle_Number,name,city_name,address,area);
    }
    //__________________________________________________//
    @Override
    public void printInfo(){
        System.out.println("______________________information_____________________");
        System.out.println("the information about terminal!");
        System.out.println("the terminal is bus station!");
        System.out.println("the name of bus station is : "+this.getName());
        //System.out.println("the  number of input rail of railway station is : "+this.number_inputRails);
        //System.out.println("the  number of output rail of railway station is : "+this.number_outputRails);
        System.out.println("the city name of bus station is : "+this.getCity_Name());
        System.out.println("the address of bus station is : "+this.getAddress());
        System.out.println("the amount of area of bus station is : "+this.getArea());
        System.out.println("the vehicle number of bus station is : "+this.getVehicle_Number());
        System.out.println("_________ the cost of bus station is : "+this.getBuild_Cost()+" _________");
    }



    public static Terminal get_search_bus_terminal(City MyCity){
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<MyCity.terminal.size();i++){
            if(MyCity.terminal.get(i).getClass()==Bus_Terminal.class){
                System.out.println(i+")");
                MyCity.terminal.get(i).printInfo();
            }
        }
        System.out.println("please enter the number of intended bus terminal : ");
        int num=sc.nextInt();
        return MyCity.terminal.get(num);

        //System.out.println("no bus terminal made!\n ***(please first build a bus terminal)***");
        //return null;
    }

}
