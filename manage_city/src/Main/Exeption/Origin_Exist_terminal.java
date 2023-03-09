package Main.Exeption;

import java.io.Serializable;

public class Origin_Exist_terminal extends Invalid_Travel implements Serializable {
    public Origin_Exist_terminal(String massage){
        super(massage);
    }
    public Origin_Exist_terminal(){
        super("ERROR : THE ORIGIN TERMINAL IS NOT EXIST !");
    }
}
