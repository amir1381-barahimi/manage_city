package Main.Buildings;

import Main.City;
import Main.Country;
import Main.Exeption.*;
import Main.Person;
import Main.Travel.Travel;
import Main.Travel.Travelable;
import Main.Vehicles.City_Bus;
import Main.Vehicles.Vehicle;
import Main.Country.*;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.*;

abstract public class Terminal implements Travelable , Serializable {

    PassengerExeption p=new PassengerExeption();
    private int build_Cost;
    private String name;
    private String city_Name;
    private String address;
    private double area;
    private int vehicle_Number;
    public ArrayList<Person> person_List = new ArrayList<Person>();
    public ArrayList<Travel> input_travel_list=new ArrayList<>();
    public ArrayList<Travel> output_travel_list=new ArrayList<>();
    transient Scanner sc=new Scanner(System.in);
    //___________________setter___________________//

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setBuild_Cost(int build_Cost) {
        this.build_Cost = build_Cost;
    }

    public void setCity_Name(String city_Name) {
        this.city_Name = city_Name;
    }

    public void setVehicle_Number(int vehicle_Number) {
        this.vehicle_Number = vehicle_Number;
    }
    //___________________getter___________________//


    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public int getBuild_Cost() {
        return build_Cost;
    }

    public int getVehicle_Number() {
        return vehicle_Number;
    }

    public String getAddress() {
        return address;
    }

    public String getCity_Name() {
        return city_Name;
    }
    //___________________constructor___________________//
    public Terminal(int build_Cost,int vehicle_Number,String name,String city_Name,String address,double area){
        setAddress(address);
        setArea(area);
        setBuild_Cost(build_Cost);
        setCity_Name(city_Name);
        setName(name);
        setVehicle_Number(vehicle_Number);
    }
    //__________________________________________________//
    abstract public void printInfo();
    //___________________________________________________//
    public void new_travel(Terminal origin, Terminal destination, ArrayList<Person> passengers, Person driver, Vehicle travel_vehicle){
        System.out.println("please enter the travel ID: ");
        int travel_ID=sc.nextInt();
        System.out.println("please enter the travel date: ");
        String travel_date=sc.next();
        Travel new_travel=new Travel(origin, destination,  passengers,  driver,  travel_vehicle, travel_ID,  travel_date);
        new_travel.setTravel_price(origin.calculated_travel_price(new_travel));
        throw_Driver_Exist(driver,new_travel);
        throw_City_domestic_travelException(origin,destination);
        throw_Similar_terminalException(origin,destination);
        City city_temp=Country.get_search_City(Country.cities,origin.city_Name);
        add_all_pass(passengers,new_travel,origin);
        City city_temp2=Country.get_search_City(Country.cities,destination.city_Name);
        throw_destination_Exist_terminal(destination,city_temp2.terminal);
        throw_origin_Exist_terminal(origin,city_temp.terminal);
        throw_not_match_terminal(origin,destination);

        origin.output_travel_list.add(new_travel);
        destination.input_travel_list.add(new_travel);
        destination.person_List.add(origin.person_List.remove(origin.person_List.indexOf(driver)));
        city_temp2.person.add(driver);
        if(origin instanceof Airport){
            Airport origin_airport=(Airport) origin;
            Airport destination_airport=(Airport) destination;
            destination_airport.vehicle_List.add(origin_airport.vehicle_List.remove(origin_airport.vehicle_List.indexOf(travel_vehicle)));
            //destination_airport.person_List.addAll(origin_airport.person_List);
            city_temp2.person.addAll(new_travel.passenger);
            city_temp.setMoney(calculated_travel_price(new_travel)+city_temp.getMoney());
            city_temp2.setPopulation(passengers.size());
            Country.IRCountry.setBudget(calculated_travel_price(new_travel)+Country.IRCountry.getBudget());
        }
        if(origin instanceof Bus_Terminal){
            Bus_Terminal origin_Bus_Terminal=(Bus_Terminal) origin;
            Bus_Terminal destination_Bus_Terminal=(Bus_Terminal) destination;
            destination_Bus_Terminal.vehicle_List.add(origin_Bus_Terminal.vehicle_List.remove(origin_Bus_Terminal.vehicle_List.indexOf(travel_vehicle)));
            destination_Bus_Terminal.person_List.addAll(origin_Bus_Terminal.person_List);
            city_temp.setMoney(calculated_travel_price(new_travel)+city_temp.getMoney());
            city_temp2.setPopulation(passengers.size());
            Country.IRCountry.setBudget(calculated_travel_price(new_travel)+Country.IRCountry.getBudget());
        }
    }
    public boolean condition_add_passenger(Person person_pass,ArrayList<Terminal> terminal_list){
        for(int i=0;i<terminal_list.size();i++){
            for(int j=0;j<terminal_list.get(i).person_List.size();j++){
                if(terminal_list.get(i).person_List.get(j)==person_pass){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean condition_passenger(Person person,Terminal terminal){
        for(int i=0;i<terminal.person_List.size();i++){
            if(terminal.person_List.contains(person)){
                return false;
            }
        }
        return true;
    }
    public void add_passenger(Person person_passenger,Travel travel,ArrayList<Terminal> origin_terminal_list){
        if(condition_add_passenger(person_passenger,origin_terminal_list)){
            travel.passenger.add(person_passenger);
        }
        else{
            throw new PassengerExeption();
        }
    }
    public void add_pass(Person person,Travel travel,Terminal terminal){
        if(!condition_passenger(person,terminal)) {
            travel.passenger.remove(person);
        }
    }
    public void add_all_pass(ArrayList<Person> pass,Travel travel,Terminal terminal){
        for(int i=0;i<pass.size();i++){
            add_pass(pass.get(i),travel,terminal);
        }
    }
    public void addAllPassenger(ArrayList<Person> person_List,Travel travel,ArrayList<Terminal> origin_terminal_list){
        for(int i=0;i<person_List.size();i++){
            add_passenger(person_List.get(i),travel,origin_terminal_list);
        }
    }
    public void sort_travel(ArrayList<Travel> travels){
        Collections.sort(travels);
    }
    public int calculated_travel_price(Travel travel){
        return (travel.passenger.size()*travel.getTravel_vehicle().getPrice())/10;
    }
    public void travels_history(){
        this.sort_travel(this.output_travel_list);
        System.out.println("INPUT TRAVEL IN THIS TERMINAL : ");
        for(int i=0;i<this.input_travel_list.size();i++){
            System.out.println(i+1+")"+this.input_travel_list.get(i));
        }
        System.out.println("__________________________________");
        System.out.println("OUTPUT TRAVEL IN THIS TERMINAL : ");
        for(int i=0;i<this.output_travel_list.size();i++){
           this.output_travel_list.get(i).print_travel_info();
        }
    }
    public void throw_Driver_Exist(Person driver,Travel travel){
        if(!person_List.contains(driver)) {
            throw new Driver_Exist();
        }
    }
    public void throw_not_match_terminal(Terminal origin,Terminal destination){
        if(!(origin.getClass()==destination.getClass())){
            throw new Invalid_Input_output_Terminal();
        }
    }
    public void throw_destination_Exist_terminal(Terminal destination,ArrayList<Terminal> terminal_list){
        boolean n=false;
        for(int i=0;i<terminal_list.size();i++){
            if(destination==terminal_list.get(i)){
                n=true;
            }
        }
        if(n==true){
            n=true;
        }else{
            throw new Destination_Exist_terminal();
        }
    }
    public void throw_origin_Exist_terminal(Terminal origin,ArrayList<Terminal> terminal_list){
        boolean n=false;
        for(int i=0;i<terminal_list.size();i++){
            if(origin==terminal_list.get(i)){
                n=true;
            }
        }
        if(n==true){
            n=true;
        }else{
            throw new Origin_Exist_terminal();
        }
    }
    public void throw_City_domestic_travelException(Terminal origin,Terminal destination){
        if(origin.city_Name.equals(destination.city_Name)){
            throw new City_domestic_teravelExeption();
        }
    }
    public void throw_Similar_terminalException(Terminal origin,Terminal destination){
        if(origin==destination){
            throw new Similar_terminalException();
        }
    }
    public void throw_passenger_exception(Person person,Terminal origin){
        for(int i=0;i<origin.person_List.size();i++){
            if(origin.person_List.contains(person)){
                throw new PassengerExeption();
            }
        }
    }



}
