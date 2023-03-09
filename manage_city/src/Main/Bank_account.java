package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Bank_account extends JFrame  {
    ArrayList<Transaction> transactions=new ArrayList<>();
    private double inventory;
    private Person person_account;
    private String user_name;
    private String user_password;
    private double remaining_time;
    boolean isEnd=false;
    public Bank_account(double inventory,Person person_account,String user_name,String user_password) throws InterruptedException {
        this.inventory=inventory;
        this.person_account=person_account;
        this.user_name=user_name;
        this.user_password=user_password;

        //____________________________________//
        this.setTitle("FINANCIAL MANAGEMENT");
        this.setSize(800,800);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new GridLayout(1,2));
        //_______________________________//

        JPanel north=new JPanel();
        JPanel south=new JPanel();
        FlowLayout flowLayout=new FlowLayout();
        north.setLayout(flowLayout);
        flowLayout.setAlignment(FlowLayout.CENTER);
        BorderLayout borderLayout=new BorderLayout();
        south.setLayout(borderLayout);
        JLabel jLabel1=new JLabel();
        jLabel1.setText("TOTAL BUDGET");
        JLabel jLabel2=new JLabel();
        jLabel2.setText("TOTAL INVESTMENT");
        JTextField jTextField1=new JFormattedTextField();
        JTextField jTextField2=new JFormattedTextField();
        north.add(jLabel1);
        north.add(jTextField1);
        north.add(jLabel2);
        north.add(jTextField2);
        DefaultListModel dlm=new DefaultListModel();
        JList<String> jList_south=new JList<>(dlm);
        JScrollPane jsp=new JScrollPane(jList_south);
        jsp.setSize(400,300);
        south.add(jsp,BorderLayout.CENTER);
        this.getContentPane().add(north);
        this.getContentPane().add(south);

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        isEnd=false;
                        Thread.sleep(60000);
                        isEnd=true;
                        dlm.addElement("amount of transaction :"+amount_profit()+"\t user name: "+user_name);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    setInventory(getInventory()+amount_profit());
                    transactions.add(new Transaction(amount_profit(),type_transaction.PROFIT));
                }
            }
        });
        t1.start();
        Thread ty=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    while (isEnd == false) {

                    }
                    dlm.addElement("amount of transaction :"+amount_profit()+"\t user name: "+user_name);
                }

            }
        });
        ty.start();
        Thread t9=new Thread(new Runnable() {
            @Override
            public void run() {
                setVisible(true);
            }
        });
        t9.start();
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                while (true){
                    jLabel1.setText(String.valueOf(Country.IRCountry.budget));
                    jLabel2.setText(String.valueOf(Country.calculate_total_money_invested()));

                    //dlm.addElement("amount of transaction :"+amount_profit()+"\t user name: "+user_name);

                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {

                    jLabel1.setText(String.valueOf(Country.IRCountry.budget));
                    jLabel2.setText(String.valueOf(Country.calculate_total_money_invested()));
                    //dlm.addElement("amount of transaction :"+amount_profit()+"\t user name: "+user_name);

            }
        });
    }


    //______________________________//

    public void setInventory(double inventory) {
        this.inventory = inventory;
    }

    public void setPerson_account(Person person_account) {
        this.person_account = person_account;
    }

    public void setRemaining_time(double remaining_time) {
        this.remaining_time = remaining_time;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    //_______________________________//

    public double getInventory() {
        return inventory;
    }

    public double getRemaining_time() {
        return remaining_time;
    }

    public Person getPerson_account() {
        return person_account;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_password() {
        return user_password;
    }
    //_______________________________//


    public void new_transaction(type_transaction type,double amount_transaction){
        Transaction new_transaction=new Transaction(amount_transaction,type);
        transactions.add(new_transaction);
    }
    public double amount_profit(){
        return this.inventory*18/100;
    }
    public void deposit(double deposit){
        this.inventory+=deposit;
        System.out.println("deposit is successfully");
    }
    public void withdraw(double withdraw){
        this.inventory-=withdraw;
        System.out.println("withdraw is successfully");
    }

    public void show_transaction(){
        for(Transaction t:this.transactions){
            t.print_transaction_info();
        }
    }
}
