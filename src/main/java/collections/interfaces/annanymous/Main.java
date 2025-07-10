package collections.interfaces.annanymous;

public class Main {
    public static void main(String[] args)
    {
        //with one abstract method in Employee we use lamba expression
//        Employee emp = ()->{
//            return "100";
//        };


        //with more than one abstract class we use annanyoums inner class
        Employee emp = new Employee(){


            @Override
            public String getSalary() {
               return "100";
            }

            @Override
            public int getEmpCode() {
                return 21098;
            }
        };
        System.out.println(emp.getSalary());
        System.out.println(emp.getEmpCode());
    }
}
