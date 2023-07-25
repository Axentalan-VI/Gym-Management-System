

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;
import java.util.Date;


public abstract class Employee extends People implements Comparable<Employee>
                                                ,Serializable{

    

    

    private SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
    private Date DateEmployed;
    private double pay;


    

    public Employee(){ 

    }

    /**
     * 
     * @param first_Name
     * @param last_Name
     * @param gender
     * @param Birthdate
     * @param national_ID
     * @param address
     * @param EmploymentDate
     * @throws ParseException
     */

    public Employee( String first_Name, String last_Name, String gender, String Birthdate, long national_ID,String address,String EmploymentDate) throws ParseException{
        super(first_Name,last_Name,gender,Birthdate,national_ID,address);
        setDateEmployed(EmploymentDate);
        
    }

    /**
     * Converts the string input ( Employment Date ) into Date object type using Parse method.
     * throw ParseException used to bypass Exception cuased by parsing from string to date
     * @param EmploymentDate
     * @throws ParseException
     */

    public void setDateEmployed(String EmploymentDate) throws ParseException{
        this.DateEmployed = dateformat.parse(EmploymentDate);

    }

    /**
     *  Calculates months between the date of employment and the current date
     * @return
     */

    public int MonthsEmployed(){ 
        long DifferenceInMilliSeconds = new Date().getTime() - getDateEmployed().getTime();
        long DifferenceInMonths = TimeUnit.MILLISECONDS.toDays(DifferenceInMilliSeconds)/30;
        return (int)DifferenceInMonths;
    }

    /**
     * calculates years employed by dividing the value of MonthsEmployed() by 12
     * @return
     */

    public int YearsEmployed(){
        long DifferenceInYears = MonthsEmployed()/12;
        return (int)DifferenceInYears;
    }


    public abstract void payCalculator();

    /**
     * returns the date of employment in date format 
     * @return
     */
    public Date getDateEmployed() {
        return DateEmployed;
    }

    public double getPay() {
        return pay;
    }

   
    @Override
    public int compareTo(Employee o) {
        if (this.DateEmployed.before(o.DateEmployed)){
            return -1;
        }else if( this.DateEmployed.after(o.DateEmployed)){
            return 1;
        }else{
            return 0;
        }
    }

    /**
     * 
     * @param o
     * @param type
     * @return
     */
    public int compareTo(Employee o, String type) {

        if ( type == "pay"){
            if (this.getPay()>o.getPay()){
                return 1;
            }else if( this.getPay()<o.getPay()){
                return -1;
            }else{
                return 0;
            }
        }else if( type == "Date of Birth"){
            if (this.getDateOfBirth().after(o.getDateOfBirth())){
                return 1;
            }else if( this.getDateOfBirth().before(o.getDateOfBirth())){
                return -1;
            }else{
                return 0;

            }

        }else{
            return 0;
        }

    }


    public String toString(){
        String s = "";
        s+= "--------------------------------------------------\nFull name: " + getFirst_Name() + " " + getLast_Name() + "\nGender: " + getGender() +"\nID: " + getNational_ID()  +"\nAddress: " 
        + getAddress() + "\nBirth Date: " + getDateOfBirth() + "\tDate Employed: " + getDateEmployed()+"\nPay: " + getPay();
        return s;
    }

    

    

   

    

    
}
