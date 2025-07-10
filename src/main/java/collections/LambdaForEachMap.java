package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LambdaForEachMap {
    public static void main(String[] args)
    {
        Map<Integer,Integer> mp = new TreeMap<>();
        mp.put(1,1);
        mp.put(2,2);
        mp.put(9,8);
        mp.put(3,0);
        System.out.println("normal"+ mp);
        //Not possible with hashmap
        Map<Integer, Integer> mp1 = new TreeMap<>((a, b)->b-a);
        mp1.put(1,1);
        mp1.put(2,2);
        mp1.put(9,8);
        mp1.put(3,0);
        System.out.println("Using labda" + mp1);


    }
}
