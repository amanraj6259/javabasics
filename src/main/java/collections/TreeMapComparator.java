package collections;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapComparator {
    public static void main(String[] args)
    {
        Map<Integer,String> mp = new TreeMap<>();
        mp.put(1,"abc");
        mp.put(3,"xyz");
        mp.put(2,"lki");
        mp.put(7,"poi");

        System.out.println("Before sorting"+ mp);

        Map<Integer,String> mp1 = new TreeMap<>((a,b)->b-a);
        mp1.put(1,"abc");
        mp1.put(3,"xyz");
        mp1.put(2,"lki");
        mp1.put(7,"poi");
        System.out.println("After sorting" +  mp1);



    }
}
