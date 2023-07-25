
import java.text.ParseException;
import java.util.*;

public class GYM_Main {

    public static void main(String[] args)
            throws ParseException {
        EmployeeManagement EM = new EmployeeManagement();
        Client_Managment CM = new Client_Managment();
        Scanner input = new Scanner(System.in);

        ArrayList<Employee> Employees = new ArrayList<>();

        Employee Emp1 = new Trainer("Ismail", "Wafaie", "Male", "13-03-2003", 65746666, "6 October, Giza, Egypt",
                "03-06-2021");
        Employee Emp2 = new Staff("Yossef", "El Kassaby", "Male", "14-12-2001", 56483936, "Al Mohandeseen, Egypt",
                "3-02-2014");
        Employee Emp3 = new Staff("Ahmed", "Sherif", "Male", "3-9-2001", 14230978, "Zayed, Giza, Egypt", "5-02-2011");
        Employee Emp4 = new RepairCrew("Omar", "Abo Bakr", "Male", "5-02-99", 57458975, "Giza Park", "03-11-2020");
        Employee Emp5 = new Staff("Momen", "Mousa", "Male", "28-11-2000", 63749823, "Al Mohandeseen, Egypt", "5-11-2021");
        Employee Emp6 = new Trainer("Omar", "Ali", "Male", "4-2-2009", 53820987, "El Ashgar, Egypt", "8-8-2020");

        Employees.add(Emp1);
        Employees.add(Emp2);
        Employees.add(Emp3);
        Employees.add(Emp4);
        Employees.add(Emp5);
        Employees.add(Emp6);

        int x = 3;
        while (x != 0) {

            System.out.println("\t\t\t\t\t\tWelcome GYM Mangment System\t\t\t\t\t\t\t");
            System.out.println("What would you like to manage ?");
            System.out.println("1)Employees\n2)Clients\nEnter 0 to exit the system");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    EM.all(Employees);

                    break;
                case 2:
                    CM.all();
                    break;

                default:

                    x = 0;
                    break;
            }

        }
    }

}
