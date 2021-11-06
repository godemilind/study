package collection.treeset;

import collection.treeset.bo.Person;
import collection.treeset.comparator.FirstNameComparator;
import collection.treeset.comparator.LastNameComparator;

import java.util.*;

public class TreesetExample {

    public static void main(String[] args) {
        TreeSet<Person> set = new TreeSet<>();

        Person person = new Person("Milind","Gode");
        Person person4 = new Person("Vihaan","Tendulkar");
        Person person2 = new Person("Vihaan","Gode");
        Person person3 = new Person("Subhash","Gode");

        set.add(person);
        set.add(person2);
        set.add(person3);
        set.add(person4);

        System.out.println(set);


        FirstNameComparator fNcomparator = new FirstNameComparator();
        LastNameComparator lNcomparator = new LastNameComparator();

        Set<Comparator> comparators = new HashSet<>();
        comparators.add(fNcomparator);
        comparators.add(lNcomparator);

        TreeSet<Person> set2 = new TreeSet(comparators);
        Person person_2_1 = new Person("Milind","Gode");
        Person person_2_2 = new Person("Vihaan","Gode");
        Person person_2_3 = new Person("Subhash","Gode");
        Person person_2_4 = new Person("Vihaan","Tendulkar");

        set2.add(person_2_1);
        set2.add(person_2_2);
        set2.add(person_2_3);
        set2.add(person_2_4);

        System.out.println(set2);
    }
}


