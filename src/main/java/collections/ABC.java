package collections;

class Parent {

    Parent()
    {
        draw(5);

    }

    void draw(int i)
    {
        System.out.println("Parent"+i);
    }
}
class Child extends Parent{
    void draw(int a)
    {
        System.out.println("Child"+a);
    }
}

public class ABC {
    public static void main(String[] args)
    {
        Parent p = new Child();
        p.draw(10);
    }
}

/*

Great question! This is a classic example of **dynamic method dispatch** (runtime polymorphism) in Java, especially how **overriding methods behave during object construction**.

---

### Code Recap:

```java
class Parent {
    Parent() {
        draw(5); // Called in Parent constructor
    }
    void draw(int i) {
        System.out.println("Parent " + i);
    }
}

class Child extends Parent {
    void draw(int a) {
        System.out.println("Child " + a);
    }
}

public class ABC {
    public static void main(String[] args) {
        Parent p = new Child();
        p.draw(10);
    }
}
```

---

### Why is the output:

```
Child 5
Child 10
```

and **not**:

```
Parent 5
Child 10
```

---

## Detailed Explanation

### 1. **Object Creation & Constructor Call Chain**

When you write:

```java
Parent p = new Child();
```

* Java first allocates memory for the `Child` object.
* It then calls the **Parent constructor** first (because Child's constructor implicitly calls `super()`).
* Inside the `Parent()` constructor, it calls `draw(5)`.

### 2. **Dynamic Method Dispatch**

Even though you are inside the `Parent` constructor, the method call `draw(5)` is **virtual** (non-static, non-final). Java uses **runtime polymorphism** to determine which `draw` method to call:

* At **runtime**, the actual object's type is `Child` (because of `new Child()`).
* So, the **Child's overridden `draw(int)`** method is called — not the Parent's.

This is why when `draw(5)` is called inside the Parent constructor, it actually executes:

```java
System.out.println("Child " + 5);
```

### 3. **After construction**

Then, in `main()`, when you do:

```java
p.draw(10);
```

Since `p` points to a `Child` object, the `Child`'s `draw` method is called again, printing:

```
Child 10
```

---

## Why doesn't it call Parent's `draw(5)` inside the constructor?

* Because **method calls on `this` are dynamically dispatched** based on the actual object type at runtime.
* Even inside a superclass constructor, calls to instance methods use the **overridden version** in the subclass, if any.

---

## Important Note & Pitfall

Calling overridden methods from constructors can be risky:

* The subclass's fields may **not yet be initialized** when its method is called.
* This can cause bugs if the overridden method relies on subclass state.

---

## Simple Example to Demonstrate

```java
class Parent {
    Parent() {
        System.out.println("Parent constructor starts");
        draw();
        System.out.println("Parent constructor ends");
    }
    void draw() {
        System.out.println("Parent draw");
    }
}

class Child extends Parent {
    int x = 10;
    Child() {
        System.out.println("Child constructor");
    }
    void draw() {
        System.out.println("Child draw: x = " + x);
    }
}

public class Test {
    public static void main(String[] args) {
        Parent p = new Child();
    }
}
```

### Output:

```
Parent constructor starts
Child draw: x = 0
Parent constructor ends
Child constructor
```

**Notice**: `x` is `0` (default for int) inside `draw()` called from Parent constructor, because Child's constructor hasn't run yet to initialize `x` to 10.

---

## Summary:

| Step                             | What happens                            |
| -------------------------------- | --------------------------------------- |
| `new Child()`                    | Allocate memory for Child               |
| Parent constructor runs          | Calls `draw(5)`                         |
| `draw(5)` is overridden in Child | Child's `draw` runs, prints `Child 5`   |
| Child constructor runs           | Completes construction                  |
| `p.draw(10)` in main             | Calls Child's `draw`, prints `Child 10` |

---

If you want, I can also show you how this behavior changes if `draw()` was **final** or **private** or **static**. Let me know!

 */
