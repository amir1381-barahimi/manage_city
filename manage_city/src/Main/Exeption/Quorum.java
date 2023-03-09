package Main.Exeption;

import java.io.Serializable;

public class Quorum extends Cancel_Travel implements Serializable {
    public Quorum(String massage){
        super(massage);
    }
    public Quorum(){
        super("ERROR : THE NUMBER OG PASSENGERS HAS NOT REACHED THE QUORUM !");
    }
}
