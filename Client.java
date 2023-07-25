import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;


public class Client extends People2 implements Comparable<Client> {
    private double BodyFatPercantage;
    private float Height;
    private float weight;
    private Membership membertype;
    private char type;
    private int months = 0;
    private double courses_cost = 0;
    private double membership_cost = 0;
    private double total_cost = 0;
    private int age ;
    private ArrayList<Course>Reserved_Courses=new ArrayList<Course>();
    Date time;
    private double BMI;
    

    public Client() throws ParseException {
        super();

        this.Height = 0;
        this.weight = 0;
        this.type = 'm';
    }

    public ArrayList<Course> getReserved_Courses() {
        return Reserved_Courses;
    }

    public void setReserved_Courses(ArrayList<Course> reserved_Courses) {
        this.Reserved_Courses = reserved_Courses;
    }

    public Client(float Height, float weight, String first_Name, String last_Name, char gender, String dateOfBirth,int age
            ,long national_ID, String address, String email, String membership, int months, String phonenumber)
        {
        super(first_Name, last_Name, gender, dateOfBirth, national_ID, address, email, phonenumber);
        setAge(age);
        setHeight(Height);
        setWeight(weight);
        setMembertype(membership, months);
        setMembership_Cost(membership, months);
        this.BodyFatPercantage = Calc_BodyFatPercantage(getWeight());
        this.BMI = Calc_BMI(getWeight());
    }

    public void setBMI(double bmi) {
        this.BMI = bmi;
    }

    public double getBMI() {
        return BMI;
    }

    public void setBodyFatPercantage(double fat) {
        this.BodyFatPercantage = (fat);
    }

    public Membership getMembertype() {
        return membertype;
    }

    public double getBodyFatPercantage() {
        return BodyFatPercantage;
    }

    public float getHeight() {
        return Height;
    }

    public float getWeight() {
        return weight;
    }

    public char getType() {
        return type;
    }

    public int getMonths() {
        return months;
    }

    public double getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(double total_cost) {
        this.total_cost = total_cost;
    }

    public void calcTotal_cost(double cost) {
        setTotal_cost(getTotal_cost() + cost);

    }

    public double getMembership_cost() {
        return membership_cost;
    }

    public void setMembership_cost(double membership_cost) {
        this.membership_cost = membership_cost;
    }

    public double getCourses_cost() {
        return courses_cost;
    }

    public void setCourses_cost(double courses_cost) {
        this.courses_cost = courses_cost;
    }

    public void calcCourse_cost(double courses_cost) {
        setCourses_cost(courses_cost + getCourses_cost());

    }

    public void setHeight(float Height) {
        this.Height = Height;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setMembertype(String x, int months) {
        if (x == "Premium")
            membertype = new Premium(x, months);
        else if (x == "Standard")
            membertype = new Standard(x, months);
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public void setMembership_Cost(String memberShipType, int months) {
        if (memberShipType == "Premium") {
            setMembertype(memberShipType, months);
            this.setMembership_cost(this.getMembership_cost() + (1000 * months));
        }

        if (memberShipType == "Standard") {
            setMembertype(memberShipType, months);
            this.setMembership_cost(this.getMembership_cost() + (500 * months));
        }

    }

    public double Calc_Bmr() {
        double bmr = 0;
        if (getGender() == 'm' || getGender() == 'M')
            bmr = 88.362 + (13.397 * weight) + (4.799 * Height) - (5.677 * getAge());

        else if (getGender() == 'f' || getGender() == 'F')
            bmr = 447.593 + (9.247 * weight) + (3.098 * Height) - (4.330 * getAge());

        return (int) bmr;
    }

    public double Calc_BMI(double weight) {
        return (weight / (Height * Height / 100)) * 100;
    }

    public double Calc_BodyFatPercantage(double weight) {
        return (1.20 * Calc_BMI(weight)) + (0.23 * age) - 16.2;
    }

    public void Check_Progression(float weight) {
        System.out.println("BODY FAT PERCANTAGE WAS: " + Math.round(getBodyFatPercantage()) + "%" + "\n" + "NOW "
                + Calc_BodyFatPercantage(weight) + "% ");
        if (getBodyFatPercantage() > Calc_BodyFatPercantage(weight)) {
            System.out.println("THIS CLIENT LOST ABOUT:" + (getBodyFatPercantage() - Calc_BodyFatPercantage(weight))
                    + "% OF BODY FAT");
        } else if (getBodyFatPercantage() < Calc_BodyFatPercantage(weight)) {
            System.out.println("THIS CLIENT GAINED ABOUT:" + (Calc_BodyFatPercantage(weight) - getBodyFatPercantage())
                    + "% OF BODY FAT");
        }
        System.out.println("BODY MASS INDEX WAS: " + getBMI() + "%" + "\n" + "NOW " + Calc_BMI(weight) + "% ");
        if (getBMI() > Calc_BMI(weight)) {
            System.out.println("THIS CLIENT LOST ABOUT:" + (getBMI() - Calc_BMI(weight)) + "% OF BODY MASS");
        } else if (getBMI() < Calc_BMI(weight)) {
            System.out.println("THIS CLIENT GAINED ABOUT:" + (Calc_BMI(weight) - getBMI()) + "% OF BODY MASS");
        }

    }

    public void Calc_Calories(int workingoutdays) {
        double Maintain_Calories = 0;
        if (workingoutdays == 0)
            Maintain_Calories = Calc_Bmr() * 1.2;
        else if (workingoutdays >= 1 && workingoutdays < 3)
            Maintain_Calories = Calc_Bmr() * 1.375;
        else if (workingoutdays >= 3 && workingoutdays < 5)
            Maintain_Calories = Calc_Bmr() * 1.55;
        else if (workingoutdays >= 5 && workingoutdays < 6)
            Maintain_Calories = Calc_Bmr() * 1.725;
        else if (workingoutdays >= 6 && workingoutdays <= 7)
            Maintain_Calories = Calc_Bmr() * 1.9;

        System.out.println("This client Maintainance calories is " + (int) Maintain_Calories + "\n"
                + "To lose weight we suggest eating About " + (int) (Maintain_Calories - 500) + "\n"
                + "To gain weight we suggest eating About " + (int) (Maintain_Calories + 500));
        System.out.println(
                "NOTE:To lose weight you must eat less than your maintainance calories,but to gain weight you must eat more than your maintainance calories");

    }

    @Override
    public int compareTo(Client client) {
        if (client.getMembertype().getMembership_ID() < this.getMembertype().getMembership_ID())
            return 1;
        else if (client.getMembertype().getMembership_ID() < this.getMembertype().getMembership_ID())
            return -1;
        else
            return 0;
    }

    public String printCustomerBill() {
        time = new Date();
        String s = time + "\nCourses cost : " + courses_cost + " LE\nMembership cost : " + membership_cost
                + " LE\nTotal cost : " + total_cost + " LE";
        return s;

    }

    public String toString() {
        String s = "CLIENT NAME : " + getFirst_Name() + " " + getLast_Name() + "\n";
        s += "NATIONAL ID : " + getNational_ID() + "\n";
        s += "EMAIL : " + getEmail() + "\n";
        s += "PHONE NUMBER : " + getPhonenumber() + "\n";
        s += "AGE : " + getAge() + "\n";
        s += membertype;

        return s;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}