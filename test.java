

import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;



public class test {

    public static void main( String[] args) throws ParseException, FileNotFoundException, IOException, ClassNotFoundException{

        SimpleDateFormat str = new SimpleDateFormat("dd-MM-yyyy");
        Date date1 = str.parse("25-5-2020");
        Date date2 = str.parse("25-2-2020");

        ArrayList<Employee> Employees = new ArrayList<>();
        /*ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Test.bin"));
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Test.bin"));*/

        Employee Emp1 = new Trainer("Ismail", "Wafaie", "Male", "13-03-2003", 65746666, "6 October, Giza, Egypt", "03-06-2021");
        Employee Emp2 = new Staff("Yossef", "El Kassaby", "Male", "14-12-2001", 56483936, "Al Mohandeseen, Egypt", "3-02-2014");
        Employee Emp3 = new Staff("Ahmed", "Sherif", "Male", "3-9-2001", 14230978, "Zayed, Giza, Egypt", "5-02-2011");
        RepairCrew Emp4 = new RepairCrew("Omar", "Abo Bakr", "Male", "5-02-99", 57458975, "El 7adaye2", "03-11-2020");
        Staff Emp5 = new Staff("Momen", "Mousa", "Male", "28-11-2000", 63749823, "Al Mohandeseen, Egypt", "5-11-2021");
        Employee Emp6 = new Trainer("Omar", "Ali", "Male", "4-2-2009", 53820987, "El Ashgar, Egypt", "8-8-2020");

    
        Employees.add(Emp1);
        Employees.add(Emp2);
        Employees.add(Emp3);
        Employees.add(Emp4);
        Employees.add(Emp5);
        Employees.add(Emp6);

        EmployeeManagement.all(Employees);
        
        /*Collections.sort(Employees);
    
        for ( int i=0; i<Employees.size();i++ ){
            System.out.println("\n" + Employees.get(i));
            System.out.println(" ");
        }*/


        /*out.writeObject(Employees);

        Employees = (ArrayList<Employee>) in.readObject();
        System.out.println(Employees);
        in.close();*/


        







       

        
    } 
    
}
