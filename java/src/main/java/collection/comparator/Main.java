package collection.comparator;

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

        Collections.sort(list,new PersonComparator());
        System.out.println(list);

    }
}
