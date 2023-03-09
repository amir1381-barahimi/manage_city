package Main;

import Main.Exeption.Invalid_account_bank;

import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank implements Serializable {
    City bank_city;
    ArrayList<Bank_account> accounts=new ArrayList<>();
    private String bank_name;
    private double money_circulation;
    private int number_active_account;
    //_____________________________________//

    public void setAccounts(ArrayList<Bank_account> accounts) {
        this.accounts = accounts;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public void setMoney_circulation(double money_circulation) {
        this.money_circulation = money_circulation;
    }

    public void setNumber_active_account(int number_active_account) {
        this.number_active_account = number_active_account;
    }
    //_____________________________________//


    public double getMoney_circulation() {
        return money_circulation;
    }

    public int getNumber_active_account() {
        return number_active_account;
    }

    public String getBank_name() {
        return bank_name;
    }
    //_____________________________________//

    Bank(String bank_name,City bank_city){
        this.bank_name=bank_name;
        this.money_circulation=calculate_bank_balance();
        this.number_active_account=number_active_account();
        this.bank_city=bank_city;
    }
    //_____________________________________//
    public static void new_bank(City bank_city){
        Scanner sc=new Scanner(System.in);
        System.out.println("please enter the bank name");
        String bank_name=sc.next();
        Bank new_bank=new Bank(bank_name,bank_city);
        bank_city.banks.add(new_bank);
        System.out.println("the bank created successfully");
    }
    public static Bank get_search_bank(City bank_city){
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<bank_city.banks.size();i++){
            System.out.println(i+")");
            bank_city.banks.get(i).print_bank_info();
        }
        System.out.println("please enter the number of intended bank: ");
        return bank_city.banks.get(sc.nextInt());
    }
    public void print_bank_info(){
        System.out.println("_____________ bank "+this.bank_name+" _____________");
        System.out.println("city of bank :"+ this.bank_city.getCity_name());
        System.out.println("number of bank account :"+ this.accounts.size());
        System.out.println("number of  active bank account :"+ this.number_active_account());
        System.out.println("amount of money in circulation :"+ this.calculate_bank_balance());
        System.out.println("___________________________________________________");
    }
    public int number_active_account(){
        int count=0;
        for (Bank_account b:this.accounts){
            if(b.getInventory()!=0){
                count++;
            }
        }
        return count;
    }
    public double calculate_bank_balance(){
        double total_balance=0;
        for (int i=0;i<this.accounts.size();i++){
            total_balance+=this.accounts.get(i).getInventory();
        }
        return total_balance;
    }
    public void update(){
        setMoney_circulation(calculate_bank_balance());
        setNumber_active_account(number_active_account());
    }
    public void new_bank_account() throws InterruptedException {
        Scanner sc=new Scanner(System.in);
        Person person_account=Person.get_search_person_city(bank_city);
        System.out.println("please enter the user name: ");
        String user_name=sc.next();
        System.out.println("please enter the user password: ");

        String user_password=sc.next();
        System.out.println("please enter primary deposit: ");

        double inventory=sc.nextDouble();

        Bank_account new_bank_account=new Bank_account(inventory,person_account,user_name,user_password);
        this.accounts.add(new_bank_account);
        update();
    }

    public  Bank_account login_account() throws Invalid_account_bank {
        Scanner sc=new Scanner(System.in);

        System.out.println("please enter the  user name: ");
        String user_name=sc.next();
        System.out.println("please enter the password");
        String user_password=sc.next();
        for(int i=0;i<this.accounts.size();i++){
            if(this.accounts.get(i).getUser_name().equals(user_name)){
                if(this.accounts.get(i).getUser_password().equals(user_password)){
                    return this.accounts.get(i);
                }
                else{
                    throw new Invalid_account_bank();
                }
            }
        }
        System.out.println("this account with this user name is not exist");
        return null;
    }

}
