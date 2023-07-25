

import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Trainer extends Employee {

    private int rating;
    private double pay;
    private final double percentageRaise = 0.1;


    public Trainer(){

    }


    public Trainer( String first_Name, String last_Name, String gender, String Birthdate, long national_ID,String address,String EmploymentDate ) throws ParseException{
        super(first_Name,last_Name,gender,Birthdate,national_ID,address,EmploymentDate);
        pay = 2000;
        setDateEmployed(EmploymentDate);

    }


    public int YearsEmployed(){
        long DifferenceInMilliSeconds = new Date().getTime() - getDateEmployed().getTime();
        long DifferenceInYears = TimeUnit.MILLISECONDS.toDays(DifferenceInMilliSeconds)/365;
        return (int)DifferenceInYears;
    }


    public void payCalculator(){
        double maxPay = 10000;
        if (YearsEmployed()!=0){
            this.pay = pay + (pay*percentageRaise*YearsEmployed());
            if (this.pay>maxPay){
                this.pay = maxPay;
            }
        }
    }

    public double getPay() {
        payCalculator();
        return pay;
    }

    public String toString(){
        String s = "";
        s+=super.toString() + "\nJob: Trainer\n----------------------------------------------------" ;
        return s;
    }

    




    
    



    
}
