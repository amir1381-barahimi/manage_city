package Main.Travel;

import Main.Buildings.Terminal;
import Main.Person;
import Main.Vehicles.Vehicle;

import java.io.Serializable;
import java.util.ArrayList;

public interface Travelable extends Serializable {
    public void new_travel(Terminal origin, Terminal destination, ArrayList<Person> passengers, Person driver, Vehicle travel_vehicle);
    public void sort_travel(ArrayList<Travel> travels);
    public int calculated_travel_price(Travel travel);
    public void travels_history();
}
