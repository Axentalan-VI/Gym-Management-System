

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;
import java.util.Date;

public abstract class People {

    SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
    private String First_Name;
    private String Last_Name;
    private String Gender;
    private String Birthdate;
    private Date DateOfBirth;
    private long National_ID;
    private String Address;

    public People() {

 
    }

    public People(String first_Name, String last_Name, String gender, String Birthdate, long national_ID,String address) throws ParseException {
        setFirst_Name(first_Name);
        setLast_Name(last_Name);
        setGender(gender);
        setDateOfBirth(Birthdate);
        setNational_ID(national_ID);
        setAddress(address);
    }

    
    public void setFirst_Name(String first_Name) {
        this.First_Name = first_Name;
    }

    public void setLast_Name(String last_Name) {
        this.Last_Name = last_Name;
    }

    public void setGender(String gender) {
        if ( gender == "Male" || gender =="Female"){
            this.Gender = gender;
        }else{
            setGender("Male");
        }
    }

    public void setNational_ID(long national_ID) {
        this.National_ID = national_ID;
    }

    public void setDateOfBirth(String Birthdate) throws ParseException {
        this.DateOfBirth = formatDate.parse(Birthdate);
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public String getGender() {
        return Gender;
    }

    public int ageCalculator(){
        long DifferenceInMilliSeconds = new Date().getTime() - DateOfBirth.getTime();
        long DifferenceInYears = TimeUnit.MILLISECONDS.toDays(DifferenceInMilliSeconds)/365;
        return (int)DifferenceInYears;

    }

    public long getNational_ID() {
        return National_ID;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

   
    public String getAddress() {
        return Address;
    }


}
