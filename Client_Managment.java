import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Client_Managment {

    private static ArrayList<Client> Client_Array = new ArrayList<Client>();
    static int x = 0;
    static Scanner input = new Scanner(System.in);
    static int end = 1;

    public static void all() {
        {
            Scanner input = new Scanner(System.in);
            int choice;
            System.out.println(
                    "What do you want to do?\n1)Add Client\n2)Edit Client\n3)Remove Client\n4)Display Client\n5)Sort Clients\n6)Check client progression\n7)Calculate client calories\n8)Calculate client body fat percantage\n9)Calculate client body mass index\n10)Calculate client basic metabolic rate\n0) to exit");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("1)Add Client");
                    addClient();
                    break;
                case 2:
                    System.out.println("2)Edit Client");
                    editClient();
                    break;
                case 3:
                    System.out.println("3)Remove Client");
                    removeClient();
                    break;
                case 4:
                    System.out.println("4)Display Client");
                    displayClient();
                    break;
                case 5:
                    System.out.println("5)Sort Clients");
                    sortedClients();
                    break;
                case 6:
                    System.out.println("6)Check client progression");
                    CheckProgression();
                    break;
                case 7:
                    System.out.println("7)Calculate client calories");
                    CalculateCalories();
                    break;
                case 8:
                    System.out.println("8)Calculate client body fat percantage");
                    CalculateBodyFat();
                    break;
                case 9:
                    System.out.println("9)alculate client body mass index");
                    CalculateBMi();
                    break;
                case 10:
                System.out.println("10)Calculate client basic metabolic rate");
                    CalculateBMR();
                    break;
                default:
                    break;

            }

        }
    }

    public Client_Managment() {

    }

    public Client_Managment(ArrayList<Client> client_Array) {
        Client_Array = client_Array;
    }

    public ArrayList<Client> getClient_Array() {
        return Client_Array;
    }

    public void setClient_Array(ArrayList<Client> client_Array) {
        this.Client_Array = client_Array;
    }

    public static void addClient() {
        char dummy, gender;
        int months, age;
        float Height, weight;
        String first_Name, last_Name, address, email, membership, phonenumber, dateOfBirth;

        long national_ID;

        System.out.println("Enter the following information to add a new Client : ");
        System.out.printf("First Name : ");
        first_Name = input.next();
        System.out.printf("Last Name : ");
        last_Name = input.next();
        System.out.printf("Email : ");
        email = input.next();
        System.out.printf("Gender : ");
        gender = input.next().charAt(0);
        System.out.printf("Birth date : ");
        dateOfBirth = input.next();
        System.out.printf("Age : ");
        age = input.nextInt();
        System.out.printf("National ID : ");
        national_ID = input.nextLong();
        System.out.printf("Address : ");
        address = input.next();
        System.out.printf("Phone Number : ");
        phonenumber = input.next();
        System.out.printf("Client Height : ");
        Height = input.nextFloat();
        System.out.printf("Client Weight : ");
        weight = input.nextFloat();
        System.out.println("Choose type of Membership : ");
        System.out.println("1-Premium\t1000 LE");
        System.out.println("2-Standard\t500 LE");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                membership = "Premium";
                break;
            case 2:
                membership = "Standard";
                break;
            default:
                membership = "Standard";
                break;
        }

        System.out.println("How many months of membership ?");
        months = input.nextInt();
        Client_Array.add(new Client(Height, weight, first_Name, last_Name, gender, dateOfBirth, age, national_ID,
                address, email, membership, months, phonenumber));
        Client_Array.get(x).getMembertype().printCourse();
        System.out.println("Choose 3 courses by the ID : ");
        System.out.println("Enter 0 to exit !!");
        if (Client_Array.get(x).getMembertype().getType() == "Premium") {
            for (int i = 0; i < 3; i++) {
                int choice2 = input.nextInt();
                if (choice2 == 0) {
                    break;
                }
                Client_Array.get(x).getMembertype().searchCourse(choice2);
                Client_Array.get(x).getReserved_Courses().add(Client_Array.get(x).getMembertype().getCourse(choice2));
                Client_Array.get(x).calcCourse_cost(0);
                Client_Array.get(x).getMembertype().removeCourse(choice2);
            }
            Client_Array.get(x)
                    .setTotal_cost(Client_Array.get(x).getCourses_cost() + Client_Array.get(x).getMembership_cost());

        } else {
            for (int i = 0; i < 3; i++) {
                int choice2 = input.nextInt();
                if (choice2 == 0) {
                    break;
                }
                Client_Array.get(x).getMembertype().searchCourse(choice2);
                Client_Array.get(x).getReserved_Courses().add(Client_Array.get(x).getMembertype().getCourse(choice2));
                Client_Array.get(x).calcCourse_cost(Client_Array.get(x).getMembertype().getCourse_Prize(choice2));
                Client_Array.get(x).getMembertype().removeCourse(choice2);
            }
            Client_Array.get(x)
                    .setTotal_cost(Client_Array.get(x).getCourses_cost() + Client_Array.get(x).getMembership_cost());
        }

        if (Client_Array.get(x).getMembertype().getType() == "Premium") {
            System.out.println(Client_Array.get(x));
            System.out.println(Client_Array.get(x).printCustomerBill());
            System.out.println(Premium.getAccess_list());
        } else {
            System.out.println(Client_Array.get(x));
            System.out.println(Client_Array.get(x).printCustomerBill());
        }

        x++;

    }

    public static void editClient() {

        char dummy, gender;
        int months;
        float Height, weight;
        String first_Name, last_Name, dateOfBirth, address, email, membership, phonenumber;
        long national_ID;

        System.out.printf("Enter the Membership ID of the you want to edit : ");
        int membership_used = input.nextInt();
        for (Client client : Client_Array) {
            if (membership_used == client.getMembertype().getMembership_ID()) {
                System.out.println(client);

            }
            System.out.println("Which field would you like to edit ?");
            System.out.printf("1-First Name\n");
            System.out.printf("2-Last Name\n");
            System.out.printf("3-Email\n");
            System.out.printf("4-Gender\n");
            System.out.printf("5-Birth date\n");
            System.out.printf("6-National ID\n");
            System.out.printf("7-Address\n");
            System.out.printf("8-Phone Number\n");
            System.out.printf("9-Client Height\n");
            System.out.printf("10-Client Weight\n");
            System.out.println("11-Membership Type\n");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.printf("Enter the New First Name : ");
                    first_Name = input.next();
                    client.setFirst_Name(first_Name);
                    break;
                case 2:
                    System.out.printf("Enter the New Last Name : ");
                    last_Name = input.next();
                    client.setLast_Name(last_Name);
                    break;
                case 3:
                    System.out.printf("Enter the New Email : ");
                    email = input.next();
                    client.setEmail(email);
                    break;
                case 4:
                    System.out.printf("Enter the New Gender ");
                    gender = input.next().charAt(0);
                    client.setGender(gender);
                    break;
                case 5:
                    System.out.printf("Enter the New Birth Date : ");
                    dateOfBirth = input.next();
                    client.setBirthdate(dateOfBirth);
                    break;
                case 6:
                    System.out.printf("Enter the New National ID : ");
                    national_ID = input.nextLong();
                    client.setNational_ID(national_ID);
                    break;
                case 7:
                    System.out.printf("Enter the New Address : ");
                    address = input.next();
                    client.setAddress(address);
                    break;
                case 8:
                    System.out.printf("Enter the New Phone Number : ");
                    phonenumber = input.next();
                    client.setPhonenumber(phonenumber);
                    break;
                case 9:
                    System.out.printf("Enter the New Client Height : ");
                    Height = input.nextFloat();
                    client.setHeight(Height);
                    ;
                    break;
                case 10:
                    System.out.printf("Enter the New Client Weight : ");
                    weight = input.nextFloat();
                    client.setWeight(weight);
                    break;
                case 11:
                    System.out.printf("Enter the New Membership Type And The Number Of Mounths : ");
                    membership = input.next();
                    months = input.nextInt();
                    client.setMembertype(membership, months);
                    break;

                default:
                    System.out.println("Invalid Input !!");
                    break;
            }

        }

    }

    public static void removeClient() {
        System.out.printf("Enter the Membership ID of the you want to remove : ");
        int input_membership = input.nextInt();
        for (Client client : Client_Array) {
            if (client.getMembertype().getMembership_ID() == input_membership) {
                Client_Array.remove(client);
            }

        }
        System.out.println("The client has been removed");

    }

    public static void displayClient() {
        System.out.printf("Enter the Membership ID of the you want to display : ");
        int input_membership = input.nextInt();
        for (Client client : Client_Array) {
            if (client.getMembertype().getMembership_ID() == input_membership) {
                System.out.println("Client Informaion : ");
                System.out.println(client);
                System.out.println("Client Reserved Courses : ");
                System.out.println(client.getReserved_Courses());
            }

        }

    }

    public static void sortedClients() {
        Collections.sort(Client_Array);
        displayClient();

    }

    public static void CheckProgression() {
        System.out.printf("Enter the Membership ID of the client you want to check his or her Progression  : ");
        int membership_used = input.nextInt();
        float weight;
        for (Client client : Client_Array) {
            if (membership_used == client.getMembertype().getMembership_ID()) {
                System.out.println("Please enter the new weight of client");
                weight = input.nextFloat();
                client.Check_Progression(weight);
            }
        }

    }

    public static void CalculateCalories() {
        System.out.printf("Enter the Membership ID of the client you want to calculate his or her calories : ");
        int membership_used = input.nextInt();
        int workingdays;
        for (Client client : Client_Array) {
            if (membership_used == client.getMembertype().getMembership_ID()) {
                System.out.println("Please enter number of working days");
                workingdays = input.nextInt();
                client.Calc_Calories(workingdays);
            }
        }

    }

    public static void CalculateBodyFat() {
        System.out.printf("Enter the Membership ID of the client you want to calculate his or her BODYfat: ");
        int membership_used = input.nextInt();
        float weight;
        for (Client client : Client_Array) {
            if (membership_used == client.getMembertype().getMembership_ID()) {
                System.out.println("Please enter the weight");
                weight = input.nextFloat();
                System.out.println("The client body fat is "+client.Calc_BodyFatPercantage(weight)+" %"); 
            }
        }

    }

    public static void CalculateBMi() {
        System.out.printf("Enter the Membership ID of the client you want to calculate his or her BMI : ");
        int membership_used = input.nextInt();
        float weight;
        for (Client client : Client_Array) {
            if (membership_used == client.getMembertype().getMembership_ID()) {
                System.out.println("Please enter the weight");
                weight = input.nextFloat();
                System.out.println("Body Mass Index "+client.Calc_BMI(weight)); 
            }
        }
    }

    public static void CalculateBMR() {
        System.out.printf("Enter the Membership ID of the client you want to calculate his or her BMI : ");
        int membership_used = input.nextInt();
        float weight;
        for (Client client : Client_Array) {
            if (membership_used == client.getMembertype().getMembership_ID()) {
                System.out.println("Please enter number of working days");
                weight = input.nextFloat();
                System.out.println("The basic metabolic rate is "+client.Calc_Bmr());   
            }
        }

    }
}
