package Main;

import Main.Buildings.Terminal;
import Main.Exeption.Not_match_JobsException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import static Main.Gender.MAN;

public class Person implements Serializable {
    private String name;
    private String familyName;
    private int birth_Year;
    private String birth_Place;
    private Jobs job;
    private Gender gender;
    private int amount_Salary;

    //______________________________setter__________________________________//
    public void setAmount_Salary(int amount_Salary) {
        this.amount_Salary = amount_Salary;
    }

    public void setBirth_Place(String birth_Place) {
        this.birth_Place = birth_Place;
    }

    public void setBirth_Year(int birth_Year) {
        this.birth_Year = birth_Year;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setJob(Jobs job) {
        this.job = job;
    }

    public void setName(String name) {
        this.name = name;
    }

    //________________________________getter_______________________________________//
    public Gender getGender() {
        return gender;
    }

    public int getAmount_Salary() {
        return amount_Salary;
    }

    public int getBirth_Year() {
        return birth_Year;
    }

    public Jobs getJob() {
        return job;
    }

    public String getBirth_Place() {
        return birth_Place;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getName() {
        return name;
    }

    //___________________constructor_________________//
    public Person(String name, String familyName, String birth_Place, int birth_Year, int amount_Salary, Gender gender, Jobs job) {
        setAmount_Salary(amount_Salary);
        setBirth_Place(birth_Place);
        setGender(gender);
        setJob(job);
        setName(name);
        setFamilyName(familyName);
        setBirth_Year(birth_Year);
    }
    public void printInfo(){
        System.out.println("________________________ information _______________________");
        System.out.println("information about person!");
        System.out.println("the name of this person is: "+this.getName());
        System.out.println("the family name of this person is: "+this.getFamilyName());
        System.out.println("the birth place of this person is: "+this.getBirth_Place());
        System.out.println("the birth year of this person is: "+this.getBirth_Year());
        System.out.println("the job of this person is: "+this.getJob());
        System.out.println("the gender of this person is: "+this.getGender());
        System.out.println("__________the amount of salary of this person is: "+this.getAmount_Salary()+"__________");
    }



    public static Person get_Search_person(ArrayList<Person> person_list, Jobs job_people){
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<person_list.size();i++){
            if(person_list.get(i).job.equals(job_people)){
                System.out.println(i+")");
                person_list.get(i).printInfo();
            }
        }

        System.out.println("________________________________________________");
        System.out.println("please enter the number of people that you want: ");
        int num=sc.nextInt();
        if(person_list.get(num).job.equals(job_people))
            return person_list.get(num);
        else{
            throw new Not_match_JobsException();
        }
    }
    public static Person get_search_person_city(City MyCity){
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<MyCity.person.size();i++){
                System.out.println(i+")");
                MyCity.person.get(i).printInfo();
        }

        System.out.println("________________________________________________");
        System.out.println("please enter the number of people that you want: ");
        int num=sc.nextInt();
        return MyCity.person.get(num);
    }
    static public Person get_search_Person_passenger(City MyCity){
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<MyCity.person.size();i++){

                System.out.println(i+")");
                MyCity.person.get(i).printInfo();
        }

        System.out.println("________________________________________________");
        System.out.println("please enter the number of people that you want: ");
        int num=sc.nextInt();

        return MyCity.person.get(num);
    }

}
