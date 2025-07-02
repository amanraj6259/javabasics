package collections;
//after java 13 we can return the value in switch using yield
public class YieldExample {
    public static void main(String[] args)
    {
        int number =10;

        int x= switch(number)
        {
            case 1->{
                System.out.println("Matched 1");
                yield 1;
            }
            case 2->{
                System.out.println("Matched 2");
                yield 2;
            }
            default ->{
                System.out.println("Default");
                yield 3;
            }
        };
        System.out.println(x);
    }
}
