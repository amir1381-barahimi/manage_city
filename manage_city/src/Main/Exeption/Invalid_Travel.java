package Main.Exeption;

import java.io.Serializable;

public class Invalid_Travel extends RuntimeException implements Serializable {
    public Invalid_Travel(String massage){
        super(massage);
    }
    public Invalid_Travel(){
        super("ERROR : YOUR TRAVEL IS INVALID !");
    }
}
