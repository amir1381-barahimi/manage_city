package Main;

import java.io.Serializable;
import java.util.ArrayList;

public class Help_country implements Serializable {
    public int budget;
    public int population;
    public ArrayList<City> cities=new ArrayList<>();
}
