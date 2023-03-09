package Main;

import java.io.Serializable;

public class Transaction implements Serializable {
    private double amount_transaction;
    private String transaction_time;
    type_transaction type;
    //____________________________________//

    public void setType(type_transaction type) {
        this.type = type;
    }

    public void setAmount_transaction(double amount_transaction) {
        this.amount_transaction = amount_transaction;
    }

    public void setTransaction_time(String transaction_time) {
        this.transaction_time = transaction_time;
    }
    //________________________________//

    public double getAmount_transaction() {
        return amount_transaction;
    }

    public String getTransaction_time() {
        return transaction_time;
    }

    public type_transaction getType() {
        return type;
    }
    //____________________________________________//
    public Transaction(double amount_transaction,type_transaction type){
        this.amount_transaction=amount_transaction;
        this.type=type;
    }
    //_____________________________________//

    public void print_transaction_info(){
        System.out.println("_________________ transaction _________________");
        System.out.println("amount transaction :"+this.amount_transaction);
        System.out.println("date of transaction :"+this.transaction_time);
        System.out.println("type of transaction : "+this.type);
        System.out.println("_______________________________________________");
    }
}
