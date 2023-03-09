package Main.Buildings;

import Main.City;
import Main.Vehicles.City_Train;
import com.sun.istack.internal.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class RailWay_Station extends Terminal implements Serializable {
    public ArrayList<City_Train> train_List = new ArrayList<City_Train>();
    private int number_inputRails;
    private int number_outputRails;
    //__________________setter______________________//

    public void setNumber_inputRails(int number_inputRails) {
        this.number_inputRails = number_inputRails;
    }

    public void setNumber_outputRails(int number_outputRails) {
        this.number_outputRails = number_outputRails;
    }
    //__________________getter______________________//


    public int getNumber_inputRails() {
        return number_inputRails;
    }

    public int getNumber_outputRails() {
        return number_outputRails;
    }
    //__________________constructor______________________//
    public RailWay_Station(int vehicle_Number,String name,String address,double area,int number_inputRails,int number_outputRails,String city_name){
        super(500,vehicle_Number,name,city_name,address,area);
        setNumber_inputRails(number_inputRails);
        setNumber_outputRails(number_outputRails);
    }
    //__________________________________________________//
    @Override
    public void printInfo(){
        System.out.println("______________________information_____________________");
        System.out.println("the information about terminal!");
        System.out.println("the terminal is railway station!");
        System.out.println("the name of railway station is : "+this.getName());
        System.out.println("the  number of input rail of railway station is : "+this.number_inputRails);
        System.out.println("the  number of output rail of railway station is : "+this.number_outputRails);
        System.out.println("the city name of railway station is : "+this.getCity_Name());
        System.out.println("the address of railway station is : "+this.getAddress());
        System.out.println("the amount of area of railway station is : "+this.getArea());
        System.out.println("the vehicle number of railway station is : "+this.getVehicle_Number());
        System.out.println("_________ the cost of railway station is : "+this.getBuild_Cost()+" _________");
    }



    public static Terminal get_Search_railway_station(City MyCity){
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<MyCity.terminal.size();i++){
            if(MyCity.terminal.get(i).getClass()==RailWay_Station.class){
                System.out.println(i+")");
                MyCity.terminal.get(i).printInfo();
            }
        }
        System.out.println("please enter the number of intended railway station : ");
        int num=sc.nextInt();

        return MyCity.terminal.get(num);
        //System.out.println("no railway_station made!\n ***(please first build a railway_station)***");
        //return null;
    }


}
