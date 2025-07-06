package collections;
class Parents{
    int a=10;
}
class Children extends Parents{
    int a=50;
}
public class ABC2 {
    public static void main(String[] args)
    {
        Parents parents = new Children();
        System.out.println(parents.a);
    }
}

/*
Why 10 and not 50?
Here, you are accessing a field (a), not a method.

Field access is resolved at compile-time based on the reference type, NOT the actual object type.

Your reference variable parents is of type Parents, so parents.a refers to Parents.a (which is 10).

The field a in Children hides the field a in Parents, but does not override it because fields cannot be overridden.

Why method call resolves to Child's method?
Methods are dynamically dispatched (runtime polymorphism).

The actual method that executes depends on the runtime type of the object (Child), not the reference type (Parent).

| Concept               | Applies To         | Binding Time          | Example      | Output when `Parent p = new Child();`    |
| --------------------- | ------------------ | --------------------- | ------------ | ---------------------------------------- |
| **Method Overriding** | Methods            | Runtime (dynamic)     | `p.draw(10)` | Calls `Child` method (prints `Child 10`) |
| **Variable Hiding**   | Fields (variables) | Compile-time (static) | `p.a`        | Accesses `Parent.a` (prints `10`)        |

 */
