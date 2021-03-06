package GioiThieuArray;

/* 
    @author: chu tien dat
    Date: 4/21/2022
    Time: 9:22 AM

    Project Name: ArrayList
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrayListSortExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Lisa");
        names.add("Jennifer");
        names.add("Mark");
        names.add("David");

        System.out.println("Name: " + names);

        names.sort(new Comparator<String>() {
            @Override
            public int compare(String name1, String name2) {
                return name1.compareTo(name2);
            }
        });

        names.sort((name1, name2) -> name1.compareTo(name2));

        names.sort(Comparator.naturalOrder());

        System.out.println("Sorted Names: " + names);
    }
}
