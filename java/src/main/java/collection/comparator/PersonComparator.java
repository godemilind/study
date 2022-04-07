package collection.comparator;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int compare = o1.getFirstName().compareTo(o2.getFirstName());
        if(compare != 0){
            return compare;
        }

        return o1.getLastName().compareTo(o2.getLastName());
    }
}
