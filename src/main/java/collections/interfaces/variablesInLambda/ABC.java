package collections.interfaces.variablesInLambda;

/*
How to use varibale in labda expression
 */
interface Student{

    public String getStudentId();


}
public  class ABC {
    //with instance variable we can use labdas
   static int a =9;
    public static void main(String[] args)
    {
        //Functional Interface

        Student st = ()->{
           a=90;
            return "DMK2314";
        };


        //Ananyoumous class
        Student st1 = new Student() {
            @Override
            public String getStudentId() {

                return "DSV0987";
            }
        };
    }
}



/*
| Concept            | Explanation                                                            |
| ------------------ | ---------------------------------------------------------------------- |
| `static` keyword   | Belongs to the **class**, not instances                                |
| `main()` is static | Can't access instance (non-static) fields directly                     |
| `a` is non-static  | Belongs to objects of the class, not the class itself                  |
| Fix                | Make `a` static OR use an object to access it                          |
| Lambdas            | Can use static variables, and instance variables via object references |

 */
