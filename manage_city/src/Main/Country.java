package Main;
import Main.Exeption.Not_Exist_CityException;

import java.io.Serializable;
import java.util.Scanner;
import java.util.ArrayList;


public class Country implements Serializable {
    public static ArrayList<City> cities=new ArrayList<>();
    int population;
    int budget;
    transient Scanner sc=new Scanner(System.in);
    //_______________________Setter_______________________//

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
    //_______________________getter_______________________//


    public int getBudget() {
        return budget;
    }

    public int getPopulation() {
        return population;
    }
    //_______________________constructor_______________________//
    public Country(int population,int budget){
        setBudget(budget);
        setPopulation(population);
    }
    public static Country IRCountry=new Country(26,10000);

    public void newCity(){
        System.out.println("please enter the name of city :");
        String city_name=sc.next();

        cities.add(new City(0,10000,city_name));
        this.budget+=10000;
        System.out.println("your city create successfully!");
    }
    public static City get_search_City(ArrayList<City> city_List,String city_Name){
        for(int i=0;i<city_List.size();i++){
            if(city_List.get(i).getCity_name().equals(city_Name)){
                return city_List.get(i);
            }
        }
        throw new Not_Exist_CityException();
    }

    public static double calculate_total_money_invested(){
        double total=0;
        for(int i=0;i<Country.cities.size();i++){
            total+=Country.cities.get(i).calculate_total_bank_balance();
        }
        return total;
    }

}
