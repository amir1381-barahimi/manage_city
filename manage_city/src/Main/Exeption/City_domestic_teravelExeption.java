package Main.Exeption;

import java.awt.*;
import java.io.Serializable;

public class City_domestic_teravelExeption extends Invalid_Travel implements Serializable {
    public City_domestic_teravelExeption(String massage){
        super(massage);
    }
    public City_domestic_teravelExeption(){
        super("ERROR : CAN NOT ORIGIN TERMINAL AND DESTINATION TERMINAL ARE IN A SIMILAR CITY !");
    }
}
