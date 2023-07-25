import java.util.*;
import java.time.LocalDate;

public class Premium extends Membership {

    private static ArrayList<Pair<Integer, String>> access_list = new ArrayList<Pair<Integer, String>>();
    private static int ID = 0;
    private int months;
    private LocalDate startingDate;
    private LocalDate expiryDate;

    
    
    public Premium(String type,int months) {
        super(type);
        setMonths(months);
        setStartingDate(LocalDate.now());
        setExpiryDate(startingDate.plusMonths(months));
        Premium.ID++;
        addAccess_List("3 Courses for free");
        addAccess_List("Free access for garage");
        addAccess_List("Free mounth of personal trainng");
        addAccess_List("Free nutrition program");
        addAccess_List("Free access to swimming pool");

    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int mounths) {
        this.months = mounths;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public static ArrayList<Pair<Integer, String>> getAccess_list() {
        return access_list;
    }

    public static void setAccess_list(ArrayList<Pair<Integer, String>> access_list) {
        Premium.access_list = access_list;
    }

    public static void addAccess_List(String info) {
        Pair<Integer, String> pair = new Pair<Integer, String>(ID, info);
        ID++;
        access_list.add(pair);

    }

    public static String removeAccess_list(int id) {
        for (Pair<Integer, String> i : access_list) {
            if (i.getKey() == id) {
                access_list.remove(i);
                ID--;
                int flag = 1;
                for (Pair<Integer, String> pair : access_list) {

                    pair.setKey(flag++);

                }
                return "info have been removed";

            }

        }
        return "There is no info in this list!";
    }

    public static String editAccess_List(int id) {

        for (Pair<Integer, String> i : access_list) {
            if (i.getKey() == id) {
                int index = access_list.indexOf(i);
                System.out.print("\nEnter the new info : ");
                Scanner input = new Scanner(System.in);
                String new_info = input.nextLine();
                Pair<Integer, String> new_pair = new Pair<Integer, String>(i.getKey(), new_info);
                access_list.set(index, new_pair);
                input.close();
                return "info has been edited";

            }

        }
        return "There is no info in this list!";

    }
}

    



