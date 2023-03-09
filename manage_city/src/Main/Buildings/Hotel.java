package Main.Buildings;

import Main.City;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Hotel implements Serializable {
    private String name;
    private int number_Star;
    private int build_Cost;
    private String address;
    ArrayList<Hotel_Service> service = new ArrayList<Hotel_Service>();
    private int number_Room;
    public ArrayList<Room> room_List = new ArrayList<Room>();
    //____________________setter_____________________//

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber_Star(int number_Star) {
        this.number_Star = number_Star;
    }

    public void setBuild_Cost(int build_Cost) {
        this.build_Cost = build_Cost;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNumber_Room(int number_Room) {
        this.number_Room = number_Room;
    }
    //____________________getter_____________________//


    public String getAddress() {
        return address;
    }

    public int getBuild_Cost() {
        return build_Cost;
    }

    public String getName() {
        return name;
    }

    public int getNumber_Room() {
        return number_Room;
    }

    public int getNumber_Star() {
        return number_Star;
    }
    //____________________constructor_____________________//
    public Hotel(String name,String address,int number_Room,int number_Star){
        setAddress(address);
        setBuild_Cost(600);
        setName(name);
        setNumber_Room(number_Room);
        setNumber_Star(number_Star);
    }
    //____________________________________________//
    public void printInfo(){
        System.out.println("______________________information_____________________");
        System.out.println("the information about building!");
        System.out.println("the building is hotel!");
        System.out.println("the name of hotel is : "+this.name);
        System.out.println("the address of hotel is : "+this.address);
        System.out.println("the room number of hotel is : "+this.number_Room);
        System.out.println("the star number of hotel is : "+this.number_Star);
        this.printService();
        System.out.println("__________ the cost of hotel is : "+this.build_Cost+" __________");
    }
    public void printService(){
        System.out.println(" the welfare service of hotel is: ");
        for(Hotel_Service hs: service){
            System.out.println(" _"+service);
        }
    }


    public static Hotel get_Search_hotel(City MyCity){
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<MyCity.hotel.size();i++){
                System.out.println(i+")");
                MyCity.hotel.get(i).printInfo();
        }
        System.out.println("please enter the number of intended hotel: ");
        int num=sc.nextInt();
        return MyCity.hotel.get(num);

        //System.out.println("no hotel made! \n ***(please first build a hotel!)***");
        //return null;
    }

}
