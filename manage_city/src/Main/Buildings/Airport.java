package Main.Buildings;

import Main.City;
import Main.Vehicles.Air_Vehicles;
import com.sun.istack.internal.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Airport extends Terminal implements Serializable {
    public ArrayList<Air_Vehicles> vehicle_List = new ArrayList<Air_Vehicles>();
    private int number_Runway;
    private Airport_Type type;
    //___________________setter________________________//

    public void setType(Airport_Type type) {
        this.type = type;
    }

    public void setNumber_Runway(int number_Runway) {
        this.number_Runway = number_Runway;
    }
    //___________________getter________________________//


    public int getNumber_Runway() {
        return number_Runway;
    }

    public Airport_Type getType() {
        return type;
    }
    //_________________constructor____________//
    public Airport(int vehicle_Number,String name,String address,double area,int number_Runway,String city_name){
        super(700,vehicle_Number,name,city_name,address,area);
        setNumber_Runway(number_Runway);
        setType(Airport_Type.True);
    }
    //__________________________________________________//
    @Override
    public void printInfo(){
        System.out.println("______________________information_____________________");
        System.out.println("the information about terminal!");
        System.out.println("the terminal is airport!");
        System.out.println("the name of airport is : "+this.getName());
        System.out.println("the  number of runway of airport is : "+this.number_Runway);
        System.out.println("the  type of airport is : "+this.type);
        System.out.println("the city name of airport is : "+this.getCity_Name());
        System.out.println("the address of airport is : "+this.getAddress());
        System.out.println("the amount of area of airport is : "+this.getArea());
        System.out.println("the vehicle number of airport is : "+this.getVehicle_Number());
        System.out.println("_________ the cost of airport is : "+this.getBuild_Cost()+" _________");
    }



    public static Terminal get_search_Airport(City MyCity) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < MyCity.terminal.size(); i++) {
            if (MyCity.terminal.get(i).getClass() == Airport.class) {
                System.out.println(i + ")");
                MyCity.terminal.get(i).printInfo();
            }
        }
        System.out.println("please enter the number of intended Airport : ");
        int num = sc.nextInt();
        return MyCity.terminal.get(num);

        //System.out.println("no airport made!\n ***(please first build a airport)***");
        //return null;
    }

}
