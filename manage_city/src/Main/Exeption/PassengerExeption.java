package Main.Exeption;

import java.io.Serializable;

public class PassengerExeption extends Invalid_Travel implements Serializable {
    public PassengerExeption(String massage){
        super(massage);
    }
    public PassengerExeption(){
        super("ERROR : THE PASSENGER THAT YOU SELECTED FOR THIS TRAVEL WORK IN ORIGIN CITY AND YOU CAN NOT MOVE THAT PERSON !");
    }
}
