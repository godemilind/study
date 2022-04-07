package collection.comparable;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Person p1 = new Person("Vihaan","Gode");
        Person p2 = new Person("Subhash","Gode");
        Person p3 = new Person("Subhash","Gawade");
        Person p4 = new Person("Shyamal","Gode");
        Person p5 = new Person("Milind","Gode");

        Set<Person> set;
        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);

        // Treeset Sort it using Comparable
        set = new TreeSet<>(list);
        System.out.println(set);

        // List is sorted using sort method
        Collections.sort(list);
        System.out.println(list);

        // the sorting will be lost
        set = new HashSet<>(list);
        System.out.println(set);

    }
}
