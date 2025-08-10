package collections.function;

import java.util.function.Function;

public class main {
    public static void main(String[] args)
    {
        Function<String,String> f1=x->x.substring(0,4);
        System.out.println(f1.apply("AmanRaj"));

        Function<String,String> f2 = s->s.toUpperCase();
        System.out.println(f1.andThen(f2).apply("asthgs"));
    }
}
