package Main.Buildings;

import Main.City;
import Main.Vehicles.Marine_Vehicles;
import com.sun.istack.internal.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Shipping_Port extends Terminal implements Serializable {
    public ArrayList<Marine_Vehicles> vehicle_List = new ArrayList<Marine_Vehicles>();
    private int number_Docks;
    //_______________setter___________________//

    public void setNumber_Docks(int number_Docks) {
        this.number_Docks = number_Docks;
    }
    //_______________getter___________________//


    public int getNumber_Docks() {
        return number_Docks;
    }
    //_______________constructor___________________//
    public Shipping_Port(int vehicle_Number,String name,String address,double area,int number_Docks,String city_name){
        super(400,vehicle_Number,name,city_name,address,area);
        setNumber_Docks(number_Docks);
    }
    //__________________________________________________//
    @Override
    public void printInfo(){
        System.out.println("______________________information_____________________");
        System.out.println("the information about terminal!");
        System.out.println("the terminal is shipping port!");
        System.out.println("the name of shipping port is : "+this.getName());
        System.out.println("the dock number of shipping port is : "+this.number_Docks);
        System.out.println("the city name of shipping port is : "+this.getCity_Name());
        System.out.println("the address of shipping port is : "+this.getAddress());
        System.out.println("the amount of area of shipping port is : "+this.getArea());
        System.out.println("the vehicle number of shipping port is : "+this.getVehicle_Number());
        System.out.println("_________ the cost of shipping port is : "+this.getBuild_Cost()+" _________");
    }



    public static Terminal get_search_ShippingPort(City MyCity){
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<MyCity.terminal.size();i++){
            if(MyCity.terminal.get(i).getClass()==Shipping_Port.class){
                System.out.println(i+")");
                MyCity.terminal.get(i).printInfo();
            }
        }
        System.out.println("please enter the number of intended Shipping Port : ");
        int num=sc.nextInt();
        return MyCity.terminal.get(num);

        //System.out.println("no Shipping Port made!\n ***(please first build a Shipping Port)***");
        //return null;
    }


}
