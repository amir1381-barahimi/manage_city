package Main.Exeption;

import java.io.Serializable;

public class Cancel_Travel extends RuntimeException implements Serializable {
    public Cancel_Travel(String massage){
        super(massage);
    }
    public Cancel_Travel(){
        super("ERROR : YOUR TRAVEL CANCELED !");
    }
}
