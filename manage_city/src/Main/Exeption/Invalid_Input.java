package Main.Exeption;

import java.awt.*;
import java.io.Serializable;

public class Invalid_Input extends RuntimeException implements Serializable {
    public Invalid_Input(String massage){
        super(massage);
    }
    public Invalid_Input(){
        super("ERROR : THE INPUT THAT YOU ENTERED IS INVALID !");
    }
}
