package Main.Exeption;

import java.io.Serializable;

public class Not_Exist_CityException extends RuntimeException implements Serializable {
    public Not_Exist_CityException(String massage){
        super(massage);
    }
    public Not_Exist_CityException(){
        super("ERROR : NOT EXIST THIS CITY/FIRST CREATE IT!");
    }

}
