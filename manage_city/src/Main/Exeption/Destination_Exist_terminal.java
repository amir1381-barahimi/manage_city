package Main.Exeption;

import java.io.Serializable;

public class Destination_Exist_terminal extends Invalid_Travel implements Serializable {
    public Destination_Exist_terminal(String massage){
        super(massage);
    }
    public Destination_Exist_terminal(){
        super("ERROR : THE DESTINATION TERMINAL IS NOT EXIST !");
    }
}
