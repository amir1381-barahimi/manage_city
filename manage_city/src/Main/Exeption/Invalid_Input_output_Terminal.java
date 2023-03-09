package Main.Exeption;

import java.io.Serializable;

public class Invalid_Input_output_Terminal extends Invalid_Travel implements Serializable {
    public Invalid_Input_output_Terminal(String massage){
        super(massage);
    }
    public Invalid_Input_output_Terminal(){
        super("ERROR : INPUT OR OUTPUT TERMINAL DO NOT MATCH !");
    }
}
