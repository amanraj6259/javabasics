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

//    @Override
//    public int hashCode() {
//        return Objects.hashCode(age);
//    }
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
