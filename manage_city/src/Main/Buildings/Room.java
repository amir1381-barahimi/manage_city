package Main.Buildings;

import Main.City;

import java.io.Serializable;
import java.util.Scanner;

public class Room  implements Serializable {
    private int ID_Room;
    private int cost;
    private double area_Room;
    private int number_Bed;
    transient Scanner sc=new Scanner(System.in);
    //_____________________setter_________________//

    public void setArea_Room(double area_Room) {
        this.area_Room = area_Room;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setID_Room(int ID_Room) {
        this.ID_Room = ID_Room;
    }

    public void setNumber_Bed(int number_Bed) {
        this.number_Bed = number_Bed;
    }
    //_____________________getter_________________//


    public double getArea_Room() {
        return area_Room;
    }

    public int getCost() {
        return cost;
    }

    public int getID_Room() {
        return ID_Room;
    }

    public int getNumber_Bed() {
        return number_Bed;
    }
    //_____________________constructor_________________//
    public Room(int number_Bed,int ID_Room,double area_Room){
        setArea_Room(area_Room);
        setID_Room(ID_Room);
        setCost(70);
        setNumber_Bed(number_Bed);
    }
    //____________________________________________//
    public void printInfo(){
        System.out.println("______________________information_____________________");
        System.out.println("the information about rooms of hotel!");
        System.out.println("the ID of room is : "+this.ID_Room);
        System.out.println("the amount area of room is : "+this.area_Room);
        System.out.println("the bed number of room is : "+this.number_Bed);
        //System.out.println("the room number of room is : "+this.);
        //System.out.println("the star number of room is : "+this.number_Star);
        System.out.println("__________ the cost of room is : "+this.cost+" __________");
    }




}
