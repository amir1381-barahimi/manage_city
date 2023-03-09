package Main.Exeption;

public class Invalid_account_bank extends RuntimeException{
    public Invalid_account_bank(String massage){
        super(massage);
    }
    public Invalid_account_bank(){
        super("ERROR : THE PASSWORD IS WRONG !");
    }
}
