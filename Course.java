
public class Course{

    private int course_ID;
    private String course_name;
    private double course_price;

    public Course() {
        setCourse_ID(0);
        setCourse_name("null");
        setCourse_price(0.0);
    }

    public Course(int course_ID, String course_name, double course_price) {
        setCourse_ID(course_ID);
        setCourse_name(course_name);
        setCourse_price(course_price);
    }

    public int getCourse_ID() {
        return course_ID;
    }

    private void setCourse_ID(int course_ID) {
        this.course_ID = course_ID;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public double getCourse_price() {
        return course_price;
    }

    public void setCourse_price(double course_price) {
        this.course_price = course_price;
    }

    @Override
    public String toString() {

        return "[ " + getCourse_ID() + " , " + getCourse_name() + " , " + getCourse_price() + "LE ]";
    }

}