
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EmployeeManagement {


    
/**
 *  prints all members of the Employee Arraylist
 * @param x
 * @throws ParseException
 */
    public static void show(ArrayList<Employee> x){
        for( int i=0;i<x.size();i++){
            System.out.println(x.get(i));
        }
    }

    public static void searchEmployee(ArrayList<Employee> x) throws ParseException{{
        int choice;
        boolean flag = false;
        Scanner s = new Scanner(System.in);
        long input;
        System.out.println("Input Employee's National ID: ");
        input = s.nextLong();
        for (Employee employee : x) {
            if(employee.getNational_ID()==input){
                flag=true;
                System.out.println(employee);
                break;
            }
            

            
        }
        if(!flag){
            System.out.println("Employee doesn't exist.");
        }
        System.out.println("\nDo yo want to search for another client?\n1)Yes\n2)No");
        choice = s.nextInt();
        switch (choice){
            case 1:
                searchEmployee(x);
                break;
            case 2:
                all(x);
                break;
            default:
                System.out.println("\nInvalid Input.\n");
                all(x);
                break;

            }

        }

    }

    /**
     * prints all members of the Employee Arraylist sorted according to the date of employment (Ascending) using compareTo in Employee class. (Numbered list)
     * @param x
     * @throws ParseException
     */
    public static void showSortedByEmploymentDate(ArrayList<Employee> x){
        Collections.sort(x);
        for( int i=0;i<x.size();i++){
            System.out.println(i+1 + ") " + x.get(i));
        }
    }


    /**
     * the main method used to call all the other methods for a smooth user experience
     * @param x
     * @throws ParseException
     */
    public static void all( ArrayList<Employee> x) throws ParseException{
        Scanner s = new Scanner(System.in);
        int choice,choice2;
        System.out.println("What do you want to do?\n1)Display Employees\n2)Add Employee\n3)Edit Employees\n4)Remove Employees\n5)Search Employee\nInput 0 to exit");
        choice = s.nextInt();
        switch(choice){
            case 1:
                System.out.println("1)Sorted by Employment Date\n2)Order Added");
                choice2 = s.nextInt();
                switch(choice2){
                    case 1:
                        showSortedByEmploymentDate(x);
                        break;
                    case 2:
                        show(x);
                    break;
                }
                break;
            case 2 :
                addEmployee(x);
                break;
            case 3 :
                editEmployee(x);
                break;
            case 4:
                removeEmployee(x);
                break;
            case 5:
                searchEmployee(x);
                break;
            default:
                break;

        }

    }


    /**
     * prompts user to choose an employee to remove by inputing the number corresponding to an employee.
     * @param x
     * @throws ParseException
     */
    public static void removeEmployee(ArrayList<Employee> x) throws ParseException{
        int choice,choice2;
        Scanner s = new Scanner(System.in);
        showSortedByEmploymentDate(x);
        System.out.println("Input Employee Number you Want to remove: ");
        choice = s.nextInt();
        if ( choice-1 <= x.size()){
            x.remove(choice-1);
        }
        showSortedByEmploymentDate(x);
        System.out.println("\nDo yo want to remove another client?\n1)Yes\n2)No");
        choice2 = s.nextInt();
        switch (choice2){
            case 1:
                removeEmployee(x);
                break;
            case 2:
                all(x);
                break;
            default:
                System.out.println("\nInvalid Input.\n");
                all(x);

        }

        }

    /**
     * Edits specific Employees by prompting the user to choose which employee to edit and follows by prompting the user to choose the data
     * they wish to modify, then ask for input to change the chosen field(s)
     * @param x
     * @throws ParseException
     */
    public static void editEmployee(ArrayList<Employee> x) throws ParseException{
        int choice, choice2,choice3;
        long NationalId;
        char dummy;
        String  FirstName, LastName, Gender, DateOfBirth,DateOfEmployment,Address;
        Scanner s = new Scanner(System.in);
        showSortedByEmploymentDate(x);
            System.out.println("Input Employee Number you Want to edit: ");
            choice = s.nextInt();
            if ( choice-1 <= x.size()){
                System.out.println(x.get(choice-1));
                System.out.println("What do you want to edit?\n1)Name\n2)Gender\n3)National ID\n4)Address\n5)Date of Birth\n6)Date of Employment\nInput 0 to exit");
                
                choice2 = s.nextInt();
                switch(choice2){
                    case 1:
                        System.out.println("First Name:");
                        FirstName = s.next();
                        System.out.println("Last Name:");
                        LastName = s.next();
                        x.get(choice-1).setFirst_Name(FirstName);
                        x.get(choice-1).setLast_Name(LastName);
                        System.out.println(x.get(choice-1));
                        System.out.println("\nDo yo want to edit another client?\n1)Yes\n2)No");
                        choice3 = s.nextInt();
                        switch (choice3){
                            case 1:
                                editEmployee(x);
                                break;
                            case 2:
                                all(x);
                                break;
                            default:
                                System.out.println("\nInvalid Input.\n");
                                all(x);
                            }
                        break;
                    case 2:
                        System.out.println("Gender: ");
                        Gender = s.next();
                        x.get(choice-1).setGender(Gender);
                        System.out.println(x.get(choice-1));
                        showSortedByEmploymentDate(x);
                        System.out.println("\nDo yo want to edit another client?\n1)Yes\n2)No");
                        choice3 = s.nextInt();
                        switch (choice3){
                            case 1:
                                editEmployee(x);
                                break;
                            case 2:
                                all(x);
                                break;
                            default:
                                System.out.println("\nInvalid Input.\n");
                                all(x);
                            }
                        break;
                    case 3:
                        System.out.println("National ID: ");
                        NationalId = s.nextLong();
                        x.get(choice-1).setNational_ID(NationalId);
                        System.out.println(x.get(choice-1));
                        System.out.println("\nDo yo want to edit another client?\n1)Yes\n2)No");
                        choice3 = s.nextInt();
                        switch (choice3){
                            case 1:
                                editEmployee(x);
                                break;
                            case 2:
                                all(x);
                                break;
                            default:
                                System.out.println("\nInvalid Input.\n");
                                all(x);
                            }
                        break;
                    case 4:
                        System.out.println("Address: ");
                        dummy = s.next().charAt(0);
                        Address = s.nextLine();
                        x.get(choice-1).setAddress(Address);
                        System.out.println(x.get(choice-1));
                        System.out.println("\nDo yo want to edit another client?\n1)Yes\n2)No");
                        choice3 = s.nextInt();
                        switch (choice3){
                            case 1:
                                editEmployee(x);
                                break;
                            case 2:
                                all(x);
                                break;
                            default:
                                System.out.println("\nInvalid Input.\n");
                                all(x);
                            }
                        break;
                    case 5:
                        System.out.println("Date of Birth: ");
                        DateOfBirth= s.next();
                        x.get(choice-1).setDateOfBirth(DateOfBirth);
                        System.out.println(x.get(choice-1));
                        System.out.println("\nDo yo want to edit another client?\n1)Yes\n2)No");
                        choice3 = s.nextInt();
                        switch (choice3){
                            case 1:
                                editEmployee(x);
                                break;
                            case 2:
                                all(x);
                                break;
                            default:
                                System.out.println("\nInvalid Input.\n");
                                all(x);
                            }
                        break;
                    case 6:
                        System.out.println("Date of Employment: ");
                        DateOfEmployment= s.next();
                        x.get(choice-1).setDateEmployed(DateOfEmployment);
                        System.out.println(x.get(choice-1));
                        System.out.println("\nDo yo want to edit another client?\n1)Yes\n2)No");
                        choice3 = s.nextInt();
                        switch (choice3){
                            case 1:
                                editEmployee(x);
                                break;
                            case 2:
                                all(x);
                                break;
                            default:
                                System.out.println("\nInvalid Input.\n");
                                all(x);
                            }
                        break;
                    default:
                            all(x);
                        break;
                }
            }
                
        }

    
    
        /**
         * prompts the user to input the type of employee they want to input, and follows by prompting the user to input each required 
         * field for forming the new Employee entry.
         * @param x
         * @throws ParseException
         */
    public static void addEmployee(ArrayList<Employee> x) throws ParseException{ 
        int choice,choice2;
        long NationalId;
        char dummy;
        String  FirstName, LastName, Gender, DateOfBirth,DateOfEmployment,Address;
        Scanner s = new Scanner(System.in);
        System.out.println(" What Kind of Employee do you want to add?\n1)Trainer\n2)Staff\n3)Repair Crew");
        choice = s.nextInt();

        switch(choice){
            case 1:
                System.out.println("First Name: ");
                FirstName = s.next();
                System.out.println("Last Name: ");
                LastName = s.next();
                System.out.println("Gender");
                Gender = s.next();
                System.out.println("Birth date:");
                DateOfBirth = s.next();
                System.out.println("National ID:");
                NationalId = s.nextLong();
                System.out.println("Address: ");
                dummy = s.next().charAt(0);
                Address = s.nextLine();
                System.out.println("Employment Date: ");
                DateOfEmployment = s.next();
                x.add(new Trainer(FirstName, LastName, Gender, DateOfBirth, NationalId, Address, DateOfEmployment));
                showSortedByEmploymentDate(x);
                System.out.println("\nDo yo want to add another client?\n1)Yes\n2)No");
                    choice2 = s.nextInt();
                    switch (choice2){
                        case 1:
                            addEmployee(x);;
                            break;
                        case 2:
                            all(x);
                                break;
                        default:
                        System.out.println("\nInvalid Input.\n");
                        all(x);
                    }
                break;
            case 2:
                System.out.println("First Name: ");
                FirstName = s.next();
                System.out.println("Last Name: ");
                LastName = s.next();
                System.out.println("Gender");
                Gender = s.next();
                System.out.println("Birth date:");
                DateOfBirth = s.next();
                System.out.println("National ID:");
                NationalId = s.nextLong();
                System.out.println("Address: ");
                dummy = s.next().charAt(0);
                Address = s.nextLine();
                System.out.println("Employment Date: ");
                DateOfEmployment = s.next();
                x.add(new Staff(FirstName, LastName, Gender, DateOfBirth, NationalId, Address, DateOfEmployment));
                showSortedByEmploymentDate(x);
                System.out.println("\nDo yo want to add another client?\n1)Yes\n2)No");
                choice2 = s.nextInt();
                switch (choice2){
                    case 1:
                        addEmployee(x);
                        break;
                    case 2:
                        all(x);
                            break;
                    default:
                    System.out.println("\nInvalid Input.\n");
                    all(x);
                }
                break;
            case 3:
                System.out.println("First Name: ");
                FirstName = s.next();
                System.out.println("Last Name: ");
                LastName = s.next();
                System.out.println("Gender");
                Gender = s.next();
                System.out.println("Birth date:");
                DateOfBirth = s.next();
                System.out.println("National ID:");
                NationalId = s.nextLong();
                System.out.println("Address: ");
                dummy = s.next().charAt(0);
                Address = s.nextLine();
                System.out.println("Employment Date: ");
                DateOfEmployment = s.next();
                x.add(new RepairCrew(FirstName, LastName, Gender, DateOfBirth, NationalId, Address, DateOfEmployment));
                showSortedByEmploymentDate(x);
                System.out.println("\nDo yo want to add another client?\n1)Yes\n2)No");
                choice2 = s.nextInt();
                switch (choice2){
                    case 1:
                        addEmployee(x);
                        break;
                    case 2:
                        all(x);
                            break;
                    default:
                    System.out.println("\nInvalid Input.\n");
                    all(x);
                }
                break;
            default:
                System.out.println("Invalid Input");
        } 
        
    }
  
}
