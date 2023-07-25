import java.text.SimpleDateFormat;

import java.util.Date;

public abstract class People2 {

    SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
    private String First_Name;
    private String Last_Name;
    private char Gender;
    private String Birthdate;
    private Date DateOfBirth;
    private long National_ID;
    private String Address;
    private String phonenumber;
    private String email;

    public People2() {

    }

    public People2(String first_Name, String last_Name, char gender, String Birthdate, long national_ID, String address,
            String email, String phonenumber)  {
        setFirst_Name(first_Name);
        setLast_Name(last_Name);
        setGender(gender);
        setBirthdate(Birthdate);
        setNational_ID(national_ID);
        setAddress(address);
        setEmail(email);
        setPhonenumber(phonenumber);
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void getProgram(int level) {

    }

    public void setFirst_Name(String first_Name) {
        this.First_Name = first_Name;
    }

    public void setLast_Name(String last_Name) {
        this.Last_Name = last_Name;
    }

    public void setGender(char gender) {
        if (gender == 'M' || gender == 'm') {
            this.Gender = gender;
        } else if (gender == 'F' || gender == 'f') {
            this.Gender = gender;
        } else {
            setGender('m');
        }

    }

    public void setNational_ID(long national_ID) {
        this.National_ID = national_ID;
    }

    public void setDateOfBirth(Date Birthdate) {
        this.DateOfBirth = Birthdate;
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

    public char getGender() {
        return Gender;
    }

    /*public int ageCalculator() {
        long DifferenceInMilliSeconds = new Date().getTime() - DateOfBirth.getTime();
        long DifferenceInYears = TimeUnit.MILLISECONDS.toDays(DifferenceInMilliSeconds) / 365;
        return (int) DifferenceInYears;

    }*/

    public long getNational_ID() {
        return National_ID;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public String getAddress() {
        return Address;
    }

    public String getBirthdate() {
        return Birthdate;
    }

    public void setBirthdate(String birthdate) {
        Birthdate = birthdate;
    }

}
