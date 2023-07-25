

import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Staff extends Employee {

    private double pay;
    private final double percentageRaise = 0.1;




    public Staff(){

    }
    public Staff( String first_Name, String last_Name, String gender, String Birthdate, long national_ID,String address,String EmploymentDate) throws ParseException{
        super(first_Name,last_Name,gender,Birthdate,national_ID,address,EmploymentDate);
        pay = 1000;
        setDateEmployed(EmploymentDate);
    }

    public int MonthsEmployed(){
        long DifferenceInMilliSeconds = new Date().getTime() - getDateEmployed().getTime();
        long DifferenceInMonths = TimeUnit.MILLISECONDS.toDays(DifferenceInMilliSeconds)/30;
        return (int)DifferenceInMonths;
    }

    

    public void payCalculator() {
        double maxPay = 7500;
        if (MonthsEmployed()%6==0 && MonthsEmployed()!=0){
            this.pay = pay + (MonthsEmployed()/6*pay*percentageRaise);
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
        String s="";
        s+= super.toString() + "\nJob: Staff\n----------------------------------------------------" ;
        return s;
        
    }

    

    
    
    
}
