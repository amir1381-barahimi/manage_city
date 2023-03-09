package Main.Exeption;

import java.io.Serializable;

public class Driver_Exist extends Cancel_Travel implements Serializable {
    public Driver_Exist(String massage){
        super(massage);
    }
    public Driver_Exist(){
        super("ERROR : THE DRIVER THAT YOU SELECT FOR THIS TRAVEL NOT EXIST IN ORIGIN CITY !");
    }
}
