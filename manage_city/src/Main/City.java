package Main;

//import Main.Buildings;
import Main.Buildings.Hotel;
import Main.Buildings.Terminal;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.Serializable;
import java.util.ArrayList;

public class City implements Serializable {
    private int population;
    private int money=10000;
    private String city_name;
    public ArrayList<Bank> banks=new ArrayList<>();
    public ArrayList<Person> person=new ArrayList<Person>();
    public ArrayList<Hotel> hotel=new ArrayList<Hotel>();
    public ArrayList<Main.Buildings.Terminal> terminal=new ArrayList<Terminal>();
    //_______________________setter____________________//
    public void setPopulation(int population){
        this.population=population;
    }
    public void setMoney(int money){
        this.money=money;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    //_____________________getter____________________//
    public int getPopulation(){
        return this.population;
    }
    public ArrayList<Person> getPerson() {
        return person;
    }
    public int getMoney(){
        return this.money;
    }
    public String getCity_name() {
        return city_name;
    }

    //___________________constructor_________________//
    public City(int population, int money,String city_name){
        setPopulation(population);
        setMoney(money);
        setCity_name(city_name);
    }
    public void print_city_info(){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ CITY INFO @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("________________________________________________________________________________");
        System.out.println("# CITY NAME : "+this.getCity_name());
        System.out.println("________________________________________________________________________________");

        System.out.println("# CITY BUDGET : "+this.getMoney());
        System.out.println("________________________________________________________________________________");

        System.out.println("# POPULATION : "+this.getPopulation());
        System.out.println("________________________________________________________________________________");

        System.out.println("# CITY TERMINALS : ");
        for(Terminal t:this.terminal){
            t.printInfo();
        }
        System.out.println("________________________________________________________________________________");

        System.out.println("# CITY HOTEL : ");
        for(Hotel h:this.hotel){
            h.printInfo();
        }
        System.out.println("________________________________________________________________________________");

        System.out.println("# PEOPLE : ");
        for(Person p:this.person){
            p.printInfo();
        }
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    }
    public double calculate_total_bank_balance(){
        double total=0;
        for(int i=0;i<this.banks.size();i++){
            total+=this.banks.get(i).calculate_bank_balance();
        }
        return total;
    }

    //private static City myCity=new City(26,10000,"zoran");

//    //public static City getMyCity() {
//        return myCity;
//    }
}
