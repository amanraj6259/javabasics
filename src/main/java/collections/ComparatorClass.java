package collections;

import java.util.*;

class MyClass implements Comparator<Integer>{

    @Override
    public int compare(Integer a, Integer b) {
        return b-a;
    }
}

public class ComparatorClass {
    public static void main(String[] args)
    {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,9,6,7,0));
       // Collections.sort(list, new MyClass());
        //using lamba expresssion
        Collections.sort(list,(a,b)->b-a);
        System.out.println(list);



    }


}
