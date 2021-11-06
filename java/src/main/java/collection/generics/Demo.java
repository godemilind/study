package collection.generics;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {

        List<?> list = new ArrayList<>();
        List<?> list2 = new ArrayList<A>();
        List<?> list3 = new ArrayList<B>();
        List<?> list4 = new ArrayList<C>();


        List<A> list5 = new ArrayList<A>();
        List<B> list6 = new ArrayList<B>();
        List<C> list7 = new ArrayList<C>();

        // Not Allowed compilation error
        //List<A> list51 = new ArrayList<B>();
        //List<A> list52 = new ArrayList<C>();

        List<? extends B> list8 = new ArrayList<B>();
        List<? extends B> list9 = new ArrayList<C>();

        List<? super B> list10 = new ArrayList<B>();
        List<? super B> list11 = new ArrayList<A>();

        List<? extends B> list12 = new ArrayList<C>();
        List<? super B> list13 = new ArrayList<A>();

        // compilation error
        //List<?> list41 = new ArrayList<? extends A>();
    }
}
