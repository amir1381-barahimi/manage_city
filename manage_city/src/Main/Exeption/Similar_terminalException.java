package Main.Exeption;

import java.io.Serializable;

public class Similar_terminalException extends Invalid_Travel implements Serializable {
    public Similar_terminalException(String massage){
        super(massage);
    }
    public Similar_terminalException(){
        super("ERROR : CAN NOT DESTINATION TERMINAL AND ORIGIN TERMINAL WERE SIMILAR !");
    }
}
