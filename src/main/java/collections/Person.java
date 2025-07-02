package collections;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Person {

    int age;
    Person(int age)
    {
        this.age = age;
    }
    //If we doesnt override equals and hashcode , o/p will be 2 as it will cosider 2 different objects
    //Hashset internally checks equals and hashcode
    //if we just implement any one of hashcode or equals still output will be 2
    //if both hashCode() and equals() to check for uniqueness o/p will be 1.

   @Override
   public int hashCode() {
       return Objects.hashCode(age);
   }
    @Override
    public boolean equals(Object obj)
    {
        Person p1= (Person)obj;
        return p1.age == age;
    }


    public static void main(String[] args)
    {
        Set<Person> st = new HashSet<>();
        Person p1 = new Person(1);
        Person p2 = new Person(1);
        st.add(p1);
        st.add(p2);

        System.out.println("Size of set" + " " + st.size());

    }


}
