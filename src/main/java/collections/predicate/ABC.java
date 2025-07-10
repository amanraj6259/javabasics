package collections.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ABC {
    public static void main(String[] args)
    {
        Predicate<Integer> isEven = x->x%2==0;
        List<Integer> lst = Arrays.asList(1,2,3,4,5,6);
        //using loop
        for(Integer i: lst)
        {
            System.out.println(isEven.test(i));
        }
        //with the help of stream we can use predicate
        lst.stream().filter(x->x%2==0).map(x->x*2).forEach(x->System.out.println(x));

        //and nd or in predicate

        Predicate<String> v1 = x->x.toLowerCase().charAt(0)=='v';
        Predicate<String> v2 =x->x.toLowerCase().charAt(x.length()-1)=='l';
        Predicate<String> and = v1.and(v2);
        System.out.println(and.test("vipuls"));

    }
}
