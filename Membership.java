import java.util.*;

public class Membership {

    private int Membership_ID;
    private static int premium_ID = 50223, standard_ID = 10132;
    private ArrayList<Course> courses = new ArrayList<Course>();
    private String type;

    public Membership() {

        setType("null");
        generate_Membership_ID();
        addCourse(1231, "Bell Dance", 319.0);
        addCourse(1232, "Kick Boxing", 200.0);
        addCourse(1233, "Yoga", 150.0);
        addCourse(1234, "MMA", 336.5);
        addCourse(1235, "Zumba Step", 200.0);
        addCourse(1236, "Flixibility", 400.0);
        addCourse(1237, "AAST", 533.0);
        addCourse(1238, "Core Burner", 200.0);
        addCourse(1239, "Youth Programs", 500.0);
        addCourse(1240, "Functional Training", 350.0);

    }

    public Membership(String type) {
        setType(type);
        generate_Membership_ID();
        addCourse(1231, "Bell Dance", 319.0);
        addCourse(1232, "Kick Boxing", 200.0);
        addCourse(1233, "Yoga", 150.0);
        addCourse(1234, "MMA", 336.5);
        addCourse(1235, "Zumba Step", 200.0);
        addCourse(1236, "Flixibility", 400.0);
        addCourse(1237, "AAST", 533.0);
        addCourse(1238, "Core Burner", 200.0);
        addCourse(1239, "Youth Programs", 500.0);
        addCourse(1240, "Functional Training", 350.0);

    }

    public int getMembership_ID() {
        return Membership_ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {

        if (type == "Premium" || type == "P" || type == "p" || type == "premium") {
            this.type = "Premium";
        } else if (type == "Standard" || type == "S" || type == "s" || type == "standard") {
            this.type = "Standard";
        } else {
            this.type = "null";
        }
    }

    private void generate_Membership_ID() {
        if (this.type == "Standard" && Membership.standard_ID < 50132)
            this.Membership_ID = Membership.standard_ID++;
        else if (this.type == "Premium" && Membership.premium_ID < 100000)
            this.Membership_ID = Membership.premium_ID++;
        else {
            this.Membership_ID = 0;
        }
    }

    @Override
    public String toString() {
        return "Membership ID : " + Membership_ID + "\nType : " + getType() + " ";
    }

    // -------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourse(ArrayList<Course> course) {
        this.courses = course;
    }

    public String searchCourse(int course_ID) {
        for (Course course : courses) {
            if (course.getCourse_ID() == course_ID) {
                return "Course ID : " + course.getCourse_ID() + " Course Name : " + course.getCourse_name()
                        + " Course Price : " + course.getCourse_price() + "$ .";

            }
        }

        return "There is no course with this ID !!";

    }
    
    public double getCourse_Prize(int course_ID) {
        for (Course course : courses) {
            if (course.getCourse_ID() == course_ID) {
                return course.getCourse_price() ;

            }
        }

        return 0;

    }

    public Course getCourse(int course_ID) {
        for (Course course : courses) {
            if (course.getCourse_ID() == course_ID) {
                return course;

            }
        }

        return null;

    }

    public void addCourse(int course_ID, String course_name, double course_price) {
        courses.add(new Course(course_ID, course_name, course_price));

    }

    public String removeCourse(int course_ID) {
        for (Course course : courses) {
            if (course.getCourse_ID() == course_ID) {
                courses.remove(course);
                return "Course have been removed";

            }

        }
        return "There is no course with this ID !";
    }

    public String editCourse(int course_ID) {
        for (Course course : courses) {
            if (course.getCourse_ID() == course_ID) {
                System.out.println("what would you like to edit ?");
                System.out.println("1)Course Name");
                System.out.println("2)Course Price");
                Scanner input = new Scanner(System.in);
                int x = input.nextInt();
                if (x == 1) {
                    System.out.printf("Enter the new name : ");
                    String Name = input.nextLine();
                    course.setCourse_name(Name);
                    input.close();
                } else if (x == 2) {
                    System.out.printf("Enter the new Price : ");
                    double price = input.nextDouble();
                    course.setCourse_price(price);
                    input.close();

                }

                else {
                    System.out.println("Wrong Input");
                    input.close();
                    return "Somthing went wrong";
                }
                return "Course have been edited";

            }

        }
        return "There is no course with this ID !";
    }

    public void printCourse() {
      
        for (Course course : courses) {
            System.out.println("[ ID : "+course.getCourse_ID()+" Course Name : "+course.getCourse_name()+" Course Prise : "+course.getCourse_price()+" LE ]");
            
        }
        
    }
    // -------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------

}
