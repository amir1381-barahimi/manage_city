package Main.com.example.crusades;
import Main.*;
import Main.Buildings.*;
import Main.City.*;
import Main.Exeption.*;
import Main.Vehicles.*;
import Main.Country.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Crusades implements Serializable{

    transient static Scanner sc=new Scanner(System.in);

    public Crusades() throws IOException {
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File f=new File("save.txt");
        FileInputStream fis=new FileInputStream(f);
        FileOutputStream fo=new FileOutputStream(f,false);
        ObjectOutputStream obn=new ObjectOutputStream(fo);
        ObjectInputStream bis=new ObjectInputStream(fis);
        Writer w=new FileWriter(f.getName());



        if(f.length()>0){
            //f.createNewFile();
            try {
                Help_country h;
                if((h=(Help_country) bis.readObject())!=null) {
                    Country.IRCountry = change_to_Country(h);
                }

            }catch (Exception e){

                e.printStackTrace();
            }

        }
        Person[] personArray=new Person[26];

        personArray[0]=new Person("reza","hamidi","tehran",1380,60,Gender.MAN,Jobs.SAILOR);
        personArray[1]=new Person("reza","shayan","tehran",1370,60,Gender.MAN,Jobs.SAILOR);
        personArray[2]=new Person("sara","jelvani","kerman",1367,60,Gender.WOMAN,Jobs.SAILOR);
        personArray[3]=new Person("mohsen","jamshidi","mashhad",1378,60,Gender.MAN,Jobs.SAILOR);
        personArray[4]=new Person("amir","ebrahimi","zanjan",1359,70,Gender.MAN,Jobs.PILOT);
        personArray[5]=new Person("kian","naderi","tehran",1376,70,Gender.MAN,Jobs.PILOT);
        personArray[6]=new Person("hossein","fatemi","isfahan",1371,70,Gender.MAN,Jobs.PILOT);
        personArray[7]=new Person("jamshid","rezaiee","mashhad",1364,70,Gender.WOMAN,Jobs.PILOT);
        personArray[8]=new Person("siavash","mosaiebi","tehran",1376,30,Gender.MAN,Jobs.BUS_DRIVER);
        personArray[9]=new Person("alireza","same","tehran",1355,30,Gender.MAN,Jobs.BUS_DRIVER);
        personArray[10]=new Person("mammad","afshari","isfahan",1369,30,Gender.MAN,Jobs.BUS_DRIVER);
        personArray[11]=new Person("simin","shamsaiee","isfahan",1377,30,Gender.WOMAN,Jobs.BUS_DRIVER);
        personArray[12]=new Person("saynaz","barahimi","ghazvin",1367,50,Gender.WOMAN,Jobs.LOCOMOTIVE_DRIVER);
        personArray[13]=new Person("hamid","bahrami","rasht",1360,50,Gender.MAN,Jobs.LOCOMOTIVE_DRIVER);
        personArray[14]=new Person("hadi","tavoosi","shahreza",1370,50,Gender.MAN,Jobs.LOCOMOTIVE_DRIVER);
        personArray[15]=new Person("paria","gholami","mashhad",1359,30,Gender.WOMAN,Jobs.CREW);
        personArray[16]=new Person("pooya","tanha","zanjan",1366,30,Gender.MAN,Jobs.CREW);
        personArray[17]=new Person("davood","jam","tabriz",1365,30,Gender.MAN,Jobs.CREW);
        personArray[18]=new Person("amir ali","sazesh","moghan",1368,30,Gender.MAN,Jobs.CREW);
        personArray[19]=new Person("heshmat","kazemaini","neishaboor",1381,30,Gender.MAN,Jobs.CREW);
        personArray[20]=new Person("amin","saberi","tehran",1357,30,Gender.MAN,Jobs.CREW);
        personArray[21]=new Person("amir hossein","mohamadi","mashhad",1348,30,Gender.MAN,Jobs.CREW);
        personArray[22]=new Person("zahra","rafeiee","tehran",1365,30,Gender.WOMAN,Jobs.CREW);
        personArray[23]=new Person("shamsi","hemat","isfahan",1375,30,Gender.WOMAN,Jobs.CREW);
        personArray[24]=new Person("firooz","karimi","boshehr",1372,30,Gender.MAN,Jobs.CREW);
        personArray[25]=new Person("donya","jahanbakhsh","dezfool",1364,30,Gender.WOMAN,Jobs.CREW);
        //personArray[26]=new Person("taher","ferdos","tehran",1379,30,Gender.MAN,Jobs.CREW);
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        City capital=new City(26,10000,"tehran");
        Country.cities.add(capital);
        for(int i=0;i<personArray.length;i++){
            capital.person.add(personArray[i]);
        }
        //________________________________________________________________//
        boolean b1=true;
        boolean b2=true;
        boolean b3=true;
        boolean b4=true;
        P1:
        while (b1){
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@  MENU  @@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("1) CREATE NEW CITY ");
            System.out.println("2) LOG IN CITIES ");
            System.out.println("3) CITY INFORMATION ");
            System.out.println("4) TOTAL COUNTRY BUDGET ");
            System.out.println("5) TOTAL MONEY INVESTED ");
            System.out.println("6) FINANCIAL MANAGEMENT ");
            System.out.println("7) EXIT ");
            int decision1=sc.nextInt();
            int decision2;
            int decision3;
            int decision4;
            switch (decision1){
                case 1:{
                    try {
                        Country.IRCountry.newCity();
                    }catch (RuntimeException RE){
                        System.out.println("Error : "+RE.getMessage());
                    }
                    break;
                }
                case 2:{
                    try {
                        System.out.println("please enter name of the city that you want to log in it :");
                        String city_name = sc.next();
                        City city_temp = Country.get_search_City(Country.cities, city_name);
                        switch_case_menu(city_temp);
                    }catch (RuntimeException | InterruptedException RE){
                        System.out.println("Error : "+RE.getMessage());
                    }
                    break;
                }
                case 3:{
                    try {
                        P2:
                        while (b2) {
                            System.out.println("1) ALL THE CITY INFORMATION ");
                            System.out.println("2) ONE CITY INFORMATION ");
                            System.out.println("3) BACK ");
                            decision2 = sc.nextInt();
                            switch (decision2) {
                                case 1: {
                                    for (City c : Country.cities) {
                                        c.print_city_info();
                                    }
                                    break;
                                }
                                case 2: {
                                    System.out.println("please enter the name of city that you want to seen its information :");
                                    String city_name = sc.next();
                                    Country.get_search_City(Country.cities, city_name).print_city_info();
                                    break;
                                }
                                case 3: {
                                    break P2;
                                }
                            }

                        }
                    }catch (RuntimeException RE){
                        System.out.println("Error : "+RE.getMessage());
                    }
                    break;
                }
                case 4:{
                    System.out.println(Country.IRCountry.getBudget());;
                    break ;
                }
                case 5:{
                    System.out.println(Country.calculate_total_money_invested());
                    break ;
                }
                case 6:{


                    Thread t1=new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Bank_account b=new Bank_account(124,null,"w","w");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    t1.start();
                    break ;
                }
                case 7:{
                    //System.out.println("a");
                    Help_country help_country=change(Country.IRCountry);
                    obn.flush();
                    //obn.reset();
                    obn.writeObject(help_country);
                    //System.out.println("b");
                    //obn.writeObject(new Object());
                    w.append(null);

                    obn.close();
                    fis.close();
                    bis.close();
                    fo.close();
                    w.close();
                    break P1;
                }
            }

        }

    }
    //__________________________ Switch Case __________________________///
    public static void switch_case_menu(City MyCity) throws Invalid_account_bank, InterruptedException {
        System.out.println("%%%%%%%%%%%%%%%%   welcome to "+ MyCity.getCity_name()   +"   %%%%%%%%%%%%%%%%");
        Scanner sc=new Scanner(System.in);




        boolean a1=true;
        boolean a2=true;
        boolean a3=true;
        boolean a4=true;
        boolean a5=true;
        boolean a6=true;
        boolean a7=true;
        boolean a8=true;
        boolean a9=true;
        boolean g1=true;


        l12:
        while (a1){
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@  CITY MENU  @@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("1) BUILD");
            System.out.println("2) BUY");
            System.out.println("3) RECRUITMENT");
            System.out.println("4) SHOW INFORMATION");
            System.out.println("5) NEW TRAVEL");
            System.out.println("6) SHOW TRAVEL INFORMATION");
            System.out.println("7) BANK");
            System.out.println("8) BACK");
            int decision1=sc.nextInt();
            int decision2;
            int decision3;
            int decision4;
            int decision5;
            int decision6;
            int decision7;
            int decision8;
            int decision9;
            int decision10;
            int decision11;




            switch (decision1) {
                case 1: {
                    l2:
                    while (a2) {
                        System.out.println("__________________________________________________");
                        System.out.println("1) BUILD TERMINAL");
                        System.out.println("2) BUILD HOTEL");
                        System.out.println("3) BUILD ROOM");
                        System.out.println("4) BACK");
                        decision2=sc.nextInt();
                        switch (decision2){
                            case 1:{
                                l1:
                                while (a3){
                                    System.out.println("1) BUILD AIRPORT");
                                    System.out.println("2) BUILD SHIPPING PORT");
                                    System.out.println("3) BUILD BUS STATION");
                                    System.out.println("4) BUILD RAILWAY STATION");
                                    System.out.println("5) BACK");
                                    decision3=sc.nextInt();
                                    switch (decision3){
                                        case 1:{

                                            try {
                                                Build_Airport(MyCity.terminal, MyCity);
                                            }catch (RuntimeException RE){
                                                System.out.println("Build Error: "+RE.getMessage());
                                            }
                                            break;
                                        }
                                        case 2:{
                                            try {
                                                Build_ShippingPort(MyCity.terminal, MyCity);
                                            }catch (RuntimeException RE){
                                                System.out.println("Build Error: "+RE.getMessage());
                                            }
                                            break;
                                        }
                                        case 3:{
                                            try {
                                                Build_BusStation(MyCity.terminal, MyCity);
                                            }catch (RuntimeException RE){
                                                System.out.println("Build Error: "+RE.getMessage());
                                            }
                                            break;
                                        }
                                        case 4:{
                                            try {
                                                Build_RailwayStation(MyCity.terminal, MyCity);
                                            }catch (RuntimeException RE){
                                                System.out.println("Build Error: "+RE.getMessage());
                                            }
                                            break;

                                        }
                                        case 5:{
                                            break l1;
                                        }
                                    }

                                }
                                break;
                            }
                            case 2:{
                                try {
                                    Build_Hotel(MyCity.hotel, MyCity);
                                }catch (RuntimeException RE){
                                    System.out.println("Build Error: "+RE.getMessage());
                                }
                                break;
                            }
                            case 3:{
                                try {
                                    Hotel hotel_temp;
                                    hotel_temp = Hotel.get_Search_hotel(MyCity);
                                    Build_Room(hotel_temp.room_List, hotel_temp, MyCity);
                                }catch (RuntimeException RE){
                                    System.out.println("Build Error: "+RE.getMessage());
                                }
                                break;
                            }
                            case 4:{
                                break l2;
                            }



                        }

                    }
                    break;
                }
                case 2:{
                    l3:
                    while (a4){
                        System.out.println("1) BUY TRAVEL AIRPLANE");
                        System.out.println("2) BUY CARGO AIRPLANE");
                        System.out.println("3) BUY SHIP");
                        System.out.println("4) BUY BOAT");
                        System.out.println("5) BUY CITY BUS");
                        System.out.println("6) BUY CITY TRAIN");
                        System.out.println("7) BACK");
                        decision4=sc.nextInt();
                        switch (decision4){
                            case 1:{
                                try {
                                    Airport airport_temp;
                                    airport_temp = (Airport) Airport.get_search_Airport(MyCity);
                                    buy_Travel_airplane(airport_temp.vehicle_List, airport_temp, MyCity);
                                }catch (RuntimeException RE){
                                    System.out.println("Buy Error : "+RE.getMessage());
                                }
                                break;
                            }
                            case 2:{
                                try {
                                    Airport airport_temp;
                                    airport_temp = (Airport) Airport.get_search_Airport(MyCity);
                                    buy_Cargo_airplane(airport_temp.vehicle_List, airport_temp, MyCity);
                                }catch (RuntimeException RE){
                                    System.out.println("Buy Error : "+RE.getMessage());
                                }
                                break;
                            }
                            case 3:{
                                try {
                                    Shipping_Port shipping_port_temp;
                                    shipping_port_temp = (Shipping_Port) Shipping_Port.get_search_ShippingPort(MyCity);
                                    buy_Ship(shipping_port_temp.vehicle_List, shipping_port_temp, MyCity);
                                }catch (RuntimeException RE){
                                    System.out.println("Buy Error : "+RE.getMessage());
                                }
                                break;
                            }
                            case 4:{
                                try {
                                    Shipping_Port shipping_port_temp;
                                    shipping_port_temp = (Shipping_Port) Shipping_Port.get_search_ShippingPort(MyCity);
                                    buy_Boat(shipping_port_temp.vehicle_List, shipping_port_temp, MyCity);
                                }catch (RuntimeException RE){
                                    System.out.println("Buy Error : "+RE.getMessage());
                                }
                                break;
                            }
                            case 5:{
                                try {
                                    Bus_Terminal bus_terminal_Temp;
                                    bus_terminal_Temp = (Bus_Terminal) Bus_Terminal.get_search_bus_terminal(MyCity);
                                    buy_CityBus(bus_terminal_Temp.vehicle_List, bus_terminal_Temp, MyCity);
                                }catch (RuntimeException RE){
                                    System.out.println("Buy Error : "+RE.getMessage());
                                }
                                break;
                            }
                            case 6:{
                                try {
                                    RailWay_Station railWay_station_temp;
                                    railWay_station_temp = (RailWay_Station) RailWay_Station.get_Search_railway_station(MyCity);
                                    buy_CityTrain(railWay_station_temp.train_List, railWay_station_temp, MyCity);
                                }catch (RuntimeException RE){
                                    System.out.println("Buy Error : "+RE.getMessage());
                                }
                                break;
                            }
                            case 7:{
                                break l3;
                            }
                        }

                    }
                    break;
                }
                case 3:{
                    l4:
                    while (a5) {
                        System.out.println("please enter the job for recruitment :");
                        System.out.println("_________________ jobs _______________");
                        System.out.println("1) SAILOR");
                        System.out.println("2) PILOT");
                        System.out.println("3) BUS DRIVER");
                        System.out.println("4) LOCOMOTIVE DRIVER");
                        System.out.println("5) CREW");
                        System.out.println("6) BACK");
                        decision5=sc.nextInt();
                        switch (decision5) {
                            case 1:{
                                try {
                                    Person person_temp = Person.get_Search_person(MyCity.person, Jobs.SAILOR);
                                    Terminal terminal_temp = Shipping_Port.get_search_ShippingPort(MyCity);
                                    recruitment(person_temp, terminal_temp, MyCity);
                                }catch (RuntimeException RE){
                                    System.out.println("Recruitment Error: "+RE.getMessage());
                                }
                                break;
                            }
                            case 2:{
                                try {
                                    Person person_temp = Person.get_Search_person(MyCity.person, Jobs.PILOT);
                                    Terminal terminal_temp = Airport.get_search_Airport(MyCity);
                                    recruitment(person_temp, terminal_temp, MyCity);
                                }catch (RuntimeException RE){
                                    System.out.println("Recruitment Error: "+RE.getMessage());
                                }
                                break;
                            }
                            case 3:{
                                try {
                                    Person person_temp = Person.get_Search_person(MyCity.person, Jobs.BUS_DRIVER);
                                    Terminal terminal_temp = Bus_Terminal.get_search_bus_terminal(MyCity);
                                    recruitment(person_temp, terminal_temp, MyCity);
                                }catch (RuntimeException RE){
                                    System.out.println("Recruitment Error: "+RE.getMessage());
                                }
                                break;
                            }
                            case 4:{
                                try {
                                    Person person_temp = Person.get_Search_person(MyCity.person, Jobs.LOCOMOTIVE_DRIVER);
                                    Terminal terminal_temp = RailWay_Station.get_Search_railway_station(MyCity);
                                    recruitment(person_temp, terminal_temp, MyCity);
                                }catch (RuntimeException RE){
                                    System.out.println("Recruitment Error: "+RE.getMessage());
                                }
                                break;
                            }
                            case 5:{
                                try {
                                    Person person_temp = Person.get_Search_person(MyCity.person, Jobs.CREW);
                                    Terminal terminal_temp = Airport.get_search_Airport(MyCity);
                                    recruitment(person_temp, terminal_temp, MyCity);
                                }catch (RuntimeException RE){
                                    System.out.println("Recruitment Error: "+RE.getMessage());
                                }
                                break;
                            }
                            case 6:{
                                break l4;
                            }
                        }
                    }

                    break;
                }
                case 4:{
                    l5:
                    while (a6) {
                        System.out.println("1) TERMINAL INFORMATION");
                        System.out.println("2) HOTEL INFORMATION");
                        System.out.println("3) BACK");

                        decision6 = sc.nextInt();
                        switch (decision6){
                            case 1:{
                                l6:
                                while (a7){
                                    System.out.println("1) AIRPORT INFORMATION");
                                    System.out.println("2) SHIPPING PORT INFORMATION");
                                    System.out.println("3) BUS STATION INFORMATION");
                                    System.out.println("4) RAIL STATION INFORMATION");
                                    System.out.println("5) BACK");
                                    decision7=sc.nextInt();
                                    switch (decision7){
                                        case 1:{
                                            try {
                                                Airport airport_temp;
                                                airport_temp = (Airport) Airport.get_search_Airport(MyCity);
                                                l7:
                                                while (a8) {
                                                    System.out.println("1) VEHICLE INFORMATION");
                                                    System.out.println("2) MANPOWER INFORMATION");
                                                    System.out.println("3) BACK");
                                                    decision8 = sc.nextInt();
                                                    switch (decision8) {
                                                        case 1: {
                                                            for (Vehicle v : airport_temp.vehicle_List) {
                                                                System.out.println("__________________VEHICLE INFORMATION_______________________");
                                                                if (v.getClass() == Travel_AirPlane.class) {
                                                                    ((Travel_AirPlane) v).printInfo();
                                                                } else {
                                                                    ((Cargo_AirPlane) v).printInfo();
                                                                }
                                                            }
                                                            break;
                                                        }
                                                        case 2: {
                                                            for (Person p : airport_temp.person_List) {
                                                                System.out.println("______________________MANPOWER INFORMATION______________________");
                                                                p.printInfo();
                                                            }
                                                            break;
                                                        }
                                                        case 3: {
                                                            break l7;
                                                        }
                                                    }

                                                }
                                            }catch (RuntimeException RE){
                                                System.out.println("Error: "+RE.getMessage());
                                            }
                                            break;
                                        }
                                        case 2:{
                                            try {
                                                Shipping_Port ShippingPort_temp;
                                                ShippingPort_temp = (Shipping_Port) Shipping_Port.get_search_ShippingPort(MyCity);
                                                l8:
                                                while (a9) {
                                                    System.out.println("1) VEHICLE INFORMATION");
                                                    System.out.println("2) MANPOWER INFORMATION");
                                                    System.out.println("3) BACK");
                                                    decision9 = sc.nextInt();
                                                    switch (decision9) {
                                                        case 1: {
                                                            for (Vehicle v : ShippingPort_temp.vehicle_List) {
                                                                System.out.println("__________________VEHICLE INFORMATION_______________________");
                                                                if (v.getClass() == Ship.class) {
                                                                    ((Ship) v).printInfo();
                                                                } else {
                                                                    ((Boat) v).printInfo();
                                                                }
                                                            }
                                                            break;
                                                        }
                                                        case 2: {
                                                            for (Person p : ShippingPort_temp.person_List) {
                                                                System.out.println("______________________MANPOWER INFORMATION______________________");
                                                                p.printInfo();
                                                            }
                                                            break;
                                                        }
                                                        case 3: {
                                                            break l8;
                                                        }
                                                    }

                                                }
                                            }catch (RuntimeException RE){
                                                System.out.println("Error : "+RE.getMessage());
                                            }
                                            break ;
                                        }
                                        case 3:{
                                            try {
                                                Bus_Terminal BusTerminal_temp;
                                                BusTerminal_temp = (Bus_Terminal) Bus_Terminal.get_search_bus_terminal(MyCity);
                                                l9:
                                                while (a1) {
                                                    System.out.println("1) VEHICLE INFORMATION");
                                                    System.out.println("2) MANPOWER INFORMATION");
                                                    System.out.println("3) BACK");
                                                    decision1 = sc.nextInt();
                                                    switch (decision1) {
                                                        case 1: {
                                                            for (Vehicle v : BusTerminal_temp.vehicle_List) {
                                                                System.out.println("__________________VEHICLE INFORMATION_______________________");
                                                                ((City_Bus) v).printInfo();
                                                            }
                                                            break;
                                                        }
                                                        case 2: {
                                                            for (Person p : BusTerminal_temp.person_List) {
                                                                System.out.println("______________________MANPOWER INFORMATION______________________");
                                                                p.printInfo();
                                                            }
                                                            break;
                                                        }
                                                        case 3: {
                                                            break l9;
                                                        }
                                                    }

                                                }
                                            }catch (RuntimeException RE){
                                                System.out.println("Error : "+RE.getMessage());
                                            }
                                            break ;
                                        }
                                        case 4:{
                                            try {
                                                RailWay_Station RailwayStation_temp;
                                                RailwayStation_temp = (RailWay_Station) RailWay_Station.get_Search_railway_station(MyCity);
                                                l10:
                                                while (a1) {
                                                    System.out.println("1) VEHICLE INFORMATION");
                                                    System.out.println("2) MANPOWER INFORMATION");
                                                    System.out.println("3) BACK");
                                                    decision1 = sc.nextInt();
                                                    switch (decision1) {
                                                        case 1: {
                                                            for (Vehicle v : RailwayStation_temp.train_List) {
                                                                System.out.println("__________________VEHICLE INFORMATION_______________________");
                                                                ((City_Train) v).printInfo();
                                                            }
                                                            break;
                                                        }
                                                        case 2: {
                                                            for (Person p : RailwayStation_temp.person_List) {
                                                                System.out.println("______________________MANPOWER INFORMATION______________________");
                                                                p.printInfo();
                                                            }
                                                            break;
                                                        }
                                                        case 3: {
                                                            break l10;
                                                        }
                                                    }

                                                }
                                            }catch (RuntimeException RE){
                                                System.out.println("Error : "+RE.getMessage());
                                            }
                                            break ;
                                        }
                                        case 5:{
                                            break l6;
                                        }
                                    }
                                }
                                break;
                            }
                            case 2:{
                                try {
                                    Hotel hotel_tmp;
                                    hotel_tmp = Hotel.get_Search_hotel(MyCity);
                                    l11:
                                    while (a2) {
                                        System.out.println("1) ROOM INFORMATION");
                                        System.out.println("2) HOTEL INFORMATION");
                                        System.out.println("3) BACK");
                                        decision2 = sc.nextInt();
                                        switch (decision2) {
                                            case 1: {
                                                for (Room r : hotel_tmp.room_List) {
                                                    System.out.println("_____________________________ ROOM INFORMATION _______________________");
                                                    r.printInfo();
                                                }
                                                break;
                                            }
                                            case 2: {
                                                System.out.println("__________________________ HOTEL INFORMATION _________________________");
                                                hotel_tmp.printInfo();
                                                break;
                                            }
                                            case 3: {
                                                break l11;
                                            }
                                        }
                                    }
                                }catch (RuntimeException RE){
                                    System.out.println("Error : "+RE.getMessage());
                                }
                                break;
                            }
                            case 3:{
                                break l5;
                            }
                        }
                    }
                    break ;
                }
                case 5:{
                    try {
                        //System.out.println("please enter the name of the origin city: ");
                        //String origin_name_city = sc.next();
                        //City origin_temp = Country.get_search_City(Country.cities, origin_name_city);
                        System.out.println("please enter the name of the destination city: ");
                        String destination_name_city = sc.next();
                        City destination_temp = Country.get_search_City(Country.cities, destination_name_city);
                        ArrayList<Person> passenger_list = new ArrayList<Person>();

                        M1:
                        do {
                            System.out.println("1) ADD PASSENGERS");

                            decision10 = sc.nextInt();
                            if (decision10 == 1) {
                                passenger_list.add(Person.get_search_Person_passenger(MyCity));
                            }
                            System.out.println("2) BACK TO CREATE TRAVEL");
                            System.out.println("3) CONTINUE ADDING PASSENGERS");
                            decision11 = sc.nextInt();
                            if (decision11 == 2) {
                                break M1;
                            }
                        } while (g1);

                        System.out.println("1) AIR TRAVEL");
                        System.out.println("2) ROAD TRAVEL");
                        decision2 = sc.nextInt();
                        if (decision2 == 1) {
                            try {
                                Airport airport_origin_temp = (Airport) Airport.get_search_Airport(MyCity);
                                Airport airport_destination_temp = (Airport) Airport.get_search_Airport(destination_temp);
                                Vehicle vehicle_travel = Travel_AirPlane.get_search_Travel_airPlane(airport_origin_temp);
                                Person driver = Person.get_Search_person(airport_origin_temp.person_List, Jobs.PILOT);
                                airport_origin_temp.new_travel(airport_origin_temp, airport_destination_temp, passenger_list, driver, vehicle_travel);
                                System.out.println("the travel create successfully !");
                            } catch (Similar_terminalException stx) {
                                System.out.println("unsuccessful travel :" + stx.getMessage());
                            } catch (Quorum q) {
                                System.out.println("unsuccessful travel :" + q.getMessage());

                            } catch (PassengerExeption pe) {
                                System.out.println("unsuccessful travel :" + pe.getMessage());

                            } catch (Origin_Exist_terminal oet) {
                                System.out.println("unsuccessful travel :" + oet.getMessage());

                            } catch (Invalid_Input_output_Terminal iiot) {
                                System.out.println("unsuccessful travel :" + iiot.getMessage());

                            } catch (Driver_Exist de) {
                                System.out.println("unsuccessful travel :" + de.getMessage());

                            } catch (Destination_Exist_terminal det) {
                                System.out.println("unsuccessful travel :" + det.getMessage());

                            } catch (City_domestic_teravelExeption cdt) {
                                System.out.println("unsuccessful travel :" + cdt.getMessage());
                            }
                        } else {
                            try {
                                Bus_Terminal bus_terminal_origin_temp = (Bus_Terminal) Bus_Terminal.get_search_bus_terminal(MyCity);
                                Bus_Terminal bus_terminal_destination_temp = (Bus_Terminal) Bus_Terminal.get_search_bus_terminal(destination_temp);
                                Vehicle vehicle_travel = City_Bus.get_search_City_bus(bus_terminal_origin_temp);
                                Person driver = Person.get_Search_person(bus_terminal_origin_temp.person_List, Jobs.BUS_DRIVER);
                                bus_terminal_origin_temp.new_travel(bus_terminal_origin_temp, bus_terminal_destination_temp, passenger_list, driver, vehicle_travel);
                                System.out.println("the travel create successfully !");

                            } catch (Similar_terminalException stx) {
                                System.out.println("unsuccessful travel :" + stx.getMessage());
                            } catch (Quorum q) {
                                System.out.println("unsuccessful travel :" + q.getMessage());

                            } catch (PassengerExeption pe) {
                                System.out.println("unsuccessful travel :" + pe.getMessage());

                            } catch (Origin_Exist_terminal oet) {
                                System.out.println("unsuccessful travel :" + oet.getMessage());

                            } catch (Invalid_Input_output_Terminal iiot) {
                                System.out.println("unsuccessful travel :" + iiot.getMessage());

                            } catch (Driver_Exist de) {
                                System.out.println("unsuccessful travel :" + de.getMessage());

                            } catch (Destination_Exist_terminal det) {
                                System.out.println("unsuccessful travel :" + det.getMessage());

                            } catch (City_domestic_teravelExeption cdt) {
                                System.out.println("unsuccessful travel :" + cdt.getMessage());
                            }
                        }
                        passenger_list = new ArrayList<>();
                    }catch (RuntimeException RE){
                        System.out.println("unsuccessful travel :"+RE.getMessage());
                        RE.printStackTrace();
                    }
                    break ;
                }
                case 6:{
                    try {
                        P4:
                        while (a6) {
                            System.out.println("1) AIR TRAVEL");
                            System.out.println("2) ROAD TRAVEL");
                            System.out.println("3) BACK");
                            decision1 = sc.nextInt();
                            switch (decision1) {
                                case 1: {
                                    Airport airport_temp = (Airport) Airport.get_search_Airport(MyCity);
                                    airport_temp.travels_history();
                                    break;
                                }
                                case 2: {
                                    Bus_Terminal bus_terminal_temp = (Bus_Terminal) Bus_Terminal.get_search_bus_terminal(MyCity);
                                    bus_terminal_temp.travels_history();
                                    break;
                                }
                                case 3: {
                                    break P4;
                                }
                            }
                        }
                    }catch (RuntimeException RE){
                        System.out.println("Error : "+RE.getMessage());
                    }
                    break ;
                }

                case 7:{
                    O1:
                    while (true){
                        System.out.println("1) CREATE NEW BANK");
                        System.out.println("2) LOGIN TO BANK");
                        System.out.println("3) BACK");
                        switch (sc.nextInt()){
                            case 1:{
                                Bank.new_bank(MyCity);
                                break ;
                            }
                            case 2:{
                                Bank temp=Bank.get_search_bank(MyCity);
                                K1:
                                while (true){
                                    System.out.println("1) OPEN AN ACCOUNT");
                                    System.out.println("2) LOGIN TO BANK ACCOUNT");
                                    System.out.println("3) BANK INFO");
                                    System.out.println("4) BACK");

                                    switch (sc.nextInt()){
                                        case 1:{
                                            temp.new_bank_account();
                                            break ;
                                        }
                                        case 2:{
                                            Bank_account bank_account_temp=temp.login_account();
                                            Q1:
                                            while (true){
                                                System.out.println("1) DEPOSIT");
                                                System.out.println("2) WITHDRAW");
                                                System.out.println("3) SEE THE TRANSACTIONS");
                                                System.out.println("4) BACK");

                                                switch (sc.nextInt()){
                                                    case 1:{
                                                        System.out.println("please enter the amount of deposit");
                                                        bank_account_temp.deposit(sc.nextDouble());
                                                        break ;
                                                    }
                                                    case 2:{
                                                        System.out.println("please enter the amount of withdraw");

                                                        bank_account_temp.withdraw(sc.nextDouble());
                                                        break ;
                                                    }
                                                    case 3:{
                                                        bank_account_temp.show_transaction();
                                                        break ;
                                                    }
                                                    case 4:{
                                                        break Q1;
                                                    }
                                                }
                                            }

                                            break ;
                                        }
                                        case 3:{
                                            temp.print_bank_info();
                                            break ;
                                        }
                                        case 4:{
                                            break K1;
                                        }
                                    }
                                }
                                break ;
                            }
                            case 3:{
                                break O1;
                            }
                        }
                    }
                    break ;
                }
                case 8:{
                    break l12;
                }



            }
        }

    }



    //____________________________________________________________//
    public static Help_country change(Country country){
        Help_country hcountry=new Help_country();
        hcountry.cities.addAll(Country.cities);
        hcountry.budget=country.getBudget();
        hcountry.population=country.getPopulation();
        return hcountry;
    }
    public static Country change_to_Country(Help_country help_country){
        Country MyCountry=new Country(0,0);
        MyCountry.setBudget(help_country.budget);
        MyCountry.setPopulation(help_country.population);
        Country.cities.clear();
        Country.cities.addAll(help_country.cities);
        return MyCountry;
    }
    //_________________________ build _____________________________//
    public static void   Build_Airport(ArrayList<Terminal> build_list,City MyCity){
        Scanner sc=new Scanner(System.in);
        if(MyCity.getMoney()>=700) {
            System.out.println("*************************************************************************");
            System.out.println("enter vehicle number of airport: ");
            int vehicle_Number = sc.nextInt();
            System.out.println("enter name of airport: ");
            String name = sc.next();
            //System.out.println("enter city name of airport: ");
            //String city_Name=sc.next();
            System.out.println("enter address of airport: ");
            String address = sc.next();
            System.out.println("enter amount of area of airport: ");
            double area = sc.nextDouble();
            System.out.println("enter number of runway of airport: ");
            int runway_number = sc.nextInt();


            MyCity.terminal.add( new Airport(vehicle_Number, name, address, area, runway_number,MyCity.getCity_name()));
            System.out.println("the airport build successfully!");
            MyCity.setMoney(MyCity.getMoney() - build_list.get(build_list.size()-1).getBuild_Cost());

            System.out.println("the amount of money left : " +MyCity.getMoney());
        }
        else {
            System.out.println("your money is not enough! ! !");
        }
    }
    //___________________________________________________________________________//
    public static void Build_ShippingPort(ArrayList<Terminal> build_list,City MyCity){
        Scanner sc=new Scanner(System.in);
        if(MyCity.getMoney()>=400) {
            System.out.println("*************************************************************************");
            System.out.println("enter vehicle number of shipping port: ");
            int vehicle_Number = sc.nextInt();
            System.out.println("enter name of shipping port: ");
            String name = sc.next();
            System.out.println("enter address of shipping port: ");
            String address = sc.next();
            System.out.println("enter amount of area of shipping port: ");
            double area = sc.nextDouble();
            System.out.println("enter number of docks of shipping port: ");
            int docks_number = sc.nextInt();
            MyCity.terminal.add( new Shipping_Port(vehicle_Number, name, address, area, docks_number,MyCity.getCity_name()));
            System.out.println("the shipping port build successfully!");
            MyCity.setMoney(MyCity.getMoney() - build_list.get(build_list.size()-1).getBuild_Cost());
            System.out.println("the amount of money left : " + MyCity.getMoney());

        }
        else{
            System.out.println("your money is not enough! ! !");
        }
    }

    //__________________________________________________________________________//

    public static void Build_BusStation(ArrayList<Terminal> build_list,City MyCity){
        Scanner sc=new Scanner(System.in);
        if(MyCity.getMoney()>=100) {
            System.out.println("*************************************************************************");
            System.out.println("enter vehicle number of Bus station: ");
            int vehicle_Number = sc.nextInt();
            System.out.println("enter name of Bus station: ");
            String name = sc.next();
            //System.out.println("enter city name of Bus station: ");
            //String city_Name=sc.next();
            System.out.println("enter address of Bus station: ");
            String address = sc.next();
            System.out.println("enter amount of area of Bus station: ");
            double area = sc.nextDouble();
            MyCity.terminal.add(new Bus_Terminal(vehicle_Number, name, address, area,MyCity.getCity_name()));
            System.out.println("the Bus station build successfully!");
            MyCity.setMoney(MyCity.getMoney() - build_list.get(build_list.size()-1).getBuild_Cost());
            System.out.println("the amount of money left : " + MyCity.getMoney());

        }
        else{
            System.out.println("your money is not enough! ! !");
        }
    }

    //_________________________________________________________________________//

    public static void Build_RailwayStation(ArrayList<Terminal> build_list,City MyCity){
        Scanner sc=new Scanner(System.in);
        if(MyCity.getMoney()>=500) {
            System.out.println("*************************************************************************");
            System.out.println("enter vehicle number of railway station: ");
            int vehicle_Number = sc.nextInt();
            System.out.println("enter name of railway station: ");
            String name = sc.next();
            //System.out.println("enter city name of railway station: ");
            //String city_Name=sc.next();
            System.out.println("enter address of railway station: ");
            String address = sc.next();
            System.out.println("enter amount of area of railway station: ");
            double area = sc.nextDouble();
            System.out.println("enter number of inputRail of railway station: ");
            int number_outputRails= sc.nextInt();
            System.out.println("enter number of outputRail of railway station: ");
            int number_inputRails=sc.nextInt();
            MyCity.terminal.add( new RailWay_Station(vehicle_Number, name, address, area, number_inputRails,number_outputRails,MyCity.getCity_name()));
            System.out.println("the railway station build successfully!");
            MyCity.setMoney(MyCity.getMoney() - build_list.get(build_list.size()-1).getBuild_Cost());
            System.out.println("the amount of money left : " + MyCity.getMoney());

        }
        else{
            System.out.println("your money is not enough! ! !");

        }
    }

    //______________________________________________________________//

    public static void Build_Hotel(ArrayList<Hotel> hotel_list,City MyCity){
        Scanner sc=new Scanner(System.in);
        if(MyCity.getMoney()>=600) {
            System.out.println("*************************************************************************");
            System.out.println("enter stars number of hotel: ");
            int stars_Number = sc.nextInt();
            System.out.println("enter name of hotel: ");
            String name = sc.next();
            System.out.println("enter address of hotel: ");
            String address = sc.next();
            System.out.println("enter room number of hotel: ");
            int room_number = sc.nextInt();
            MyCity.hotel.add(new Hotel(name,address ,room_number ,stars_Number));
            System.out.println("the hotel build successfully!");
            MyCity.setMoney(MyCity.getMoney() - hotel_list.get(hotel_list.size()-1).getBuild_Cost());
            System.out.println("the amount of money left : " + MyCity.getMoney());

        }
        else{
            System.out.println("your money is not enough! ! !");

        }
    }

    //___________________________________________________________________//

    public static void Build_Room(ArrayList<Room> room_list,Hotel hotel,City MyCity){
        Scanner sc=new Scanner(System.in);
        if(MyCity.getMoney()>=70) {
            System.out.println("*************************************************************************");
            System.out.println("enter Room ID : ");
            int room_ID = sc.nextInt();
            System.out.println("enter bed number of room: ");
            int bed_number= sc.nextInt();
            System.out.println("enter area of room: ");
            int area = sc.nextInt();

            hotel.room_List.add(new Room(bed_number,area,room_ID));
            System.out.println("the room build successfully!");
            MyCity.setMoney(MyCity.getMoney() - room_list.get(room_list.size()-1).getCost());
            System.out.println("the amount of money left : " + MyCity.getMoney());

        }
        else{
            System.out.println("your money is not enough! ! !");

        }
    }

    //_______________________________buy______________________________//

    public static void buy_Travel_airplane(ArrayList<Air_Vehicles> vehicle_list, Airport airport,City MyCity){
        Scanner sc=new Scanner(System.in);
        if(MyCity.getMoney()>=300){
            System.out.println("*************************************************************************");
            System.out.println("enter the vehicle ID of travel airplane: ");
            int vehicleID=sc.nextInt();
            System.out.println("enter the company name of travel airplane: ");
            String company_name=sc.next();
            System.out.println("enter the capacity of travel airplane: ");
            int capacity=sc.nextInt();
            System.out.println("enter the minimum the required band length of travel airplane: ");
            int band_length=sc.nextInt();
            System.out.println("enter the maximum fly height of travel airplane: ");
            int flyHeight=sc.nextInt();

            airport.vehicle_List.add(new Travel_AirPlane(company_name,vehicleID,capacity,band_length,flyHeight));
            System.out.println("the travel airplane buy successfully!");
            MyCity.setMoney(MyCity.getMoney() - vehicle_list.get(vehicle_list.size()-1).getPrice());
            System.out.println("the amount of money left : " +MyCity.getMoney());

        }
        else {
            System.out.println("your money is not enough! ! !");

        }
    }

    //_____________________________________________________________________//

    public static void buy_Cargo_airplane(ArrayList<Air_Vehicles> vehicle_list,Airport airport,City MyCity){
        Scanner sc=new Scanner(System.in);
        if(MyCity.getMoney()>=200){
            System.out.println("*************************************************************************");
            System.out.println("enter the vehicle ID of cargo airplane: ");
            int vehicleID=sc.nextInt();
            System.out.println("enter the company name of cargo airplane: ");
            String company_name=sc.next();
            System.out.println("enter the capacity of cargo airplane: ");
            int capacity=sc.nextInt();
            System.out.println("enter the minimum the required band length of cargo airplane: ");
            int band_length=sc.nextInt();
            System.out.println("enter the maximum fly height of cargo airplane: ");
            int flyHeight=sc.nextInt();

            airport.vehicle_List.add(new Cargo_AirPlane(company_name,vehicleID,capacity,band_length,flyHeight));
            System.out.println("the cargo airplane buy successfully!");
            MyCity.setMoney(MyCity.getMoney() - vehicle_list.get(vehicle_list.size()-1).getPrice());
            System.out.println("the amount of money left : " +MyCity.getMoney());

        }
        else {
            System.out.println("your money is not enough! ! !");

        }
    }

    //____________________________________________________________________//

    public static void buy_Ship(ArrayList<Marine_Vehicles> vehicle_list, Shipping_Port shipping_port,City MyCity){
        Scanner sc=new Scanner(System.in);
        if(MyCity.getMoney()>=400){
            System.out.println("*************************************************************************");
            System.out.println("enter the vehicle ID of Ship: ");
            int vehicleID=sc.nextInt();
            System.out.println("enter the company name of Ship: ");
            String company_name=sc.next();
            System.out.println("enter the capacity of Ship: ");
            int capacity=sc.nextInt();
            System.out.println("enter the minimum the required depth of Ship: ");
            int min_depth=sc.nextInt();
            System.out.println("enter the fuel type of Ship: ");
            String fuelType=sc.next();
            System.out.println("enter fuel capacity of Ship: ");
            int fuel_capacity=sc.nextInt();

            shipping_port.vehicle_List.add(new Ship(company_name,vehicleID,capacity,fuelType,min_depth,fuel_capacity));
            System.out.println("the Ship buy successfully!");
            MyCity.setMoney(MyCity.getMoney() - vehicle_list.get(vehicle_list.size()-1).getPrice());
            System.out.println("the amount of money left : " +MyCity.getMoney());

        }
        else {
            System.out.println("your money is not enough! ! !");

        }
    }

    //___________________________________________________________________//

    public static void buy_Boat(ArrayList<Marine_Vehicles> vehicle_list, Shipping_Port shipping_port,City MyCity){
        Scanner sc=new Scanner(System.in);
        if(MyCity.getMoney()>=100){
            System.out.println("*************************************************************************");
            System.out.println("enter the vehicle ID of Boat: ");
            int vehicleID=sc.nextInt();
            System.out.println("enter the company name of Boat: ");
            String company_name=sc.next();
            System.out.println("enter the capacity of Boat: ");
            int capacity=sc.nextInt();
            System.out.println("enter the minimum the required depth of Boat: ");
            int min_depth=sc.nextInt();
            System.out.println("enter the fuel type of Boat: ");
            String fuelType=sc.next();
            System.out.println("enter fuel capacity of Boat: ");
            int fuel_capacity=sc.nextInt();

            shipping_port.vehicle_List.add(new Boat(company_name,vehicleID,capacity,fuelType,min_depth,fuel_capacity));
            System.out.println("the Boat buy successfully!");
            MyCity.setMoney(MyCity.getMoney() - vehicle_list.get(vehicle_list.size()-1).getPrice());
            System.out.println("the amount of money left : " +MyCity.getMoney());

        }
        else {
            System.out.println("your money is not enough! ! !");

        }
    }

    //________________________________________________________________//

    public static void buy_CityBus(ArrayList<City_Bus> vehicle_list, Bus_Terminal bus_terminal,City MyCity){
        Scanner sc=new Scanner(System.in);
        if(MyCity.getMoney()>=30){
            System.out.println("*************************************************************************");
            System.out.println("enter the vehicle ID of city bus: ");
            int vehicleID=sc.nextInt();
            System.out.println("enter the company name of city bus: ");
            String company_name=sc.next();
            System.out.println("enter the color of city bus: ");
            String color=sc.next();
            System.out.println("enter the capacity of city bus: ");
            int capacity=sc.nextInt();
            System.out.println("enter the fuel capacity of city bus: ");
            int fuel_capacity=sc.nextInt();
            System.out.println("enter the fuel Consumption of city bus: ");
            int fuel_consumption=sc.nextInt();

            bus_terminal.vehicle_List.add(new City_Bus(company_name,vehicleID,capacity,color,fuel_capacity,fuel_consumption));
            System.out.println("the city bus buy successfully!");
            MyCity.setMoney(MyCity.getMoney() - vehicle_list.get(vehicle_list.size()-1).getPrice());
            System.out.println("the amount of money left : " +MyCity.getMoney());

        }
        else {
            System.out.println("your money is not enough! ! !");

        }
    }

    //_____________________________________________________________________//

    public static void buy_CityTrain(ArrayList<City_Train> vehicle_list, RailWay_Station railWay_station,City MyCity){
        Scanner sc=new Scanner(System.in);
        if(MyCity.getMoney()>=200){
            System.out.println("*************************************************************************");
            System.out.println("enter the vehicle ID of city train: ");
            int vehicleID=sc.nextInt();
            System.out.println("enter the company name of city train: ");
            String company_name=sc.next();
            System.out.println("enter the color of city train: ");
            String color=sc.next();
            System.out.println("enter the capacity of city train: ");
            int capacity=sc.nextInt();
            System.out.println("enter the fuel capacity of city train: ");
            int fuel_capacity=sc.nextInt();
            System.out.println("enter the fuel Consumption of city train: ");
            int fuel_consumption=sc.nextInt();

            railWay_station.train_List.add(new City_Train(company_name,vehicleID,capacity,color,fuel_capacity,fuel_consumption));
            System.out.println("the train buy successfully!");
            MyCity.setMoney(MyCity.getMoney() - vehicle_list.get(vehicle_list.size()-1).getPrice());
            System.out.println("the amount of money left : " +MyCity.getMoney());

        }
        else {
            System.out.println("your money is not enough! ! !");

        }
    }

    //__________________________recruitment ______________________________//

    public static void recruitment(Person person, Terminal terminal,City MyCity){
        if(MyCity.getMoney()>=person.getAmount_Salary()) {
            terminal.person_List.add(person);
            System.out.println("recruitment is successfully!");
            MyCity.setMoney(MyCity.getMoney() - person.getAmount_Salary());
            System.out.println("the amount of money left : " +MyCity.getMoney());
        }
        else {
            System.out.println("your money is not enough! ! !");
        }
    }

}
