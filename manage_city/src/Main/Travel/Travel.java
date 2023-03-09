package Main.Travel;

import Main.Buildings.Terminal;
import Main.Person;
import Main.Vehicles.Vehicle;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.Serializable;
import java.util.ArrayList;

public class Travel  implements  Comparable, Serializable {
    private Terminal terminal_destination;
    private Terminal terminal_origin;
    public ArrayList<Person> passenger=new ArrayList<>();
    private Person driver;
    private Vehicle travel_vehicle;
    private int travel_ID;
    private int travel_price;
    private String travel_date;
    //_________________________setter________________________//

    public void setDriver(Person driver) {
        this.driver = driver;
    }

    public void setTerminal_destination(Terminal terminal_destination) {
        this.terminal_destination = terminal_destination;
    }

    public void setTerminal_origin(Terminal terminal_origin) {
        this.terminal_origin = terminal_origin;
    }

    public void setTravel_date(String travel_date) {
        this.travel_date = travel_date;
    }

    public void setTravel_ID(int travel_ID) {
        this.travel_ID = travel_ID;
    }

    public void setTravel_price(int travel_price) {
        this.travel_price = travel_price;
    }

    public void setTravel_vehicle(Vehicle travel_vehicle) {
        this.travel_vehicle = travel_vehicle;
    }
    //___________________________getter___________________________//


    public int getTravel_ID() {
        return travel_ID;
    }

    public int getTravel_price() {
        return travel_price;
    }

    public Person getDriver() {
        return driver;
    }

    public String getTravel_date() {
        return travel_date;
    }

    public Terminal getTerminal_destination() {
        return terminal_destination;
    }

    public Terminal getTerminal_origin() {
        return terminal_origin;
    }

    public Vehicle getTravel_vehicle() {
        return travel_vehicle;
    }

    public ArrayList<Person> getPassenger() {
        return passenger;
    }

    //_________________constructor____________________//
    public Travel(Terminal terminal_origin, Terminal terminal_destination, ArrayList<Person> passengers, Person driver, Vehicle travel_vehicle,int travel_ID,String travel_date){
        this.travel_price=travel_price;
        this.travel_date=travel_date;
        this.driver=driver;
        this.travel_ID=travel_ID;
        this.passenger=passengers;
        this.terminal_destination=terminal_destination;
        this.terminal_origin=terminal_origin;
        this.travel_vehicle=travel_vehicle;
    }
    @Override
    public int compareTo(Object travel) {
        Travel travel1=(Travel) travel;

        if(this.travel_date.compareTo(travel1.travel_date)==1){
            return 1;
        }
        else if(this.travel_date.compareTo(travel1.travel_date)==-1){
            return -1;
        }
        else{
            if(this.travel_price>travel1.travel_price){
                return 1;
            }
            else if(this.travel_price<travel1.travel_price){
                return -1;
            }
            else {
                return 0;
            }
        }

    }
    public void print_travel_info(){
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% TRAVEL INFORMATION %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println();
        System.out.println("_________________________________ TRAVEL PRICE _____________________________________");

        System.out.println("DATE: "+this.travel_date);
        System.out.println("____________________________________ TRAVEL PRICE _____________________________________");
        System.out.println("TRAVEL PRICE: "+this.travel_price);
        System.out.println("______________________________________ TRAVEL ID _____________________________________");

        System.out.println("TRAVEL ID: "+this.travel_ID);
        System.out.println("____________________________________ DRIVER ______________________________________");

        this.driver.printInfo();
        System.out.println("**************************************** PASSENGER *************************************");

        for(Person p:passenger){

            System.out.println("name : "+p.getName()+"   family : "+p.getFamilyName()+" gender : "+p.getGender());
            System.out.println("__________________________________________________________________________________");

        }
        System.out.println("*************************************************************************************");

        System.out.println("____________________________________ VEHICLE ___________________________________");

        this.travel_vehicle.printInfo();
        System.out.println("_____________________________________ ORIGIN TRAVEL ___________________________________");
        this.terminal_origin.printInfo();
        System.out.println("_____________________________________ DESTINATION TRAVEL ___________________________________");
        this.terminal_destination.printInfo();
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    }
}
