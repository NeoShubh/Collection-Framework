# Garbage Collection and Weak References in Java

## Normal Object Reference

When we create an object in Java, the reference variable points to the object stored in heap memory.

```java
public class GC {
    public static void main(String[] args) {

        Phone phone = new Phone("Apple", "16 Pro Max");

        System.out.println(phone);

        phone = null;

        System.out.println(phone);
    }
}
```

### What happens here?

- `phone` is a strong reference to the `Phone` object.
- As long as a strong reference exists, the object cannot be garbage collected.
- When we assign:

```java
phone = null;
```

the object becomes unreachable.

- Since no reference points to the object anymore, it becomes eligible for Garbage Collection.
- JVM may remove it from memory during the next GC cycle.

---

## Weak Reference

A `WeakReference` tells the JVM:

> "You may remove this object whenever memory cleanup happens if no strong reference exists."

```java
import java.lang.ref.WeakReference;

public class GC {

    public static void main(String[] args) {

        WeakReference<Phone> phoneWeakReference =
                new WeakReference<>(new Phone("Apple", "16 Pro Max"));

        System.out.println(phoneWeakReference.get());

        System.gc();

        try {
            Thread.sleep(10000);
        } catch (Exception ignored) {
        }

        System.out.println(phoneWeakReference.get());
    }
}
```

---

## Internal Working

### Step 1

Object is created:

```java
new Phone("Apple", "16 Pro Max")
```

and wrapped inside:

```java
WeakReference<Phone>
```

There is **no strong reference** to the object.

---

### Step 2

```java
phoneWeakReference.get();
```

returns the actual object if it still exists.

---

### Step 3

```java
System.gc();
```

requests the JVM to perform Garbage Collection.

> Note: `System.gc()` is only a request. JVM may or may not run GC immediately.

---

### Step 4

```java
Thread.sleep(10000);
```

gives JVM time to perform Garbage Collection.

---

### Step 5

```java
phoneWeakReference.get();
```

If the object has been collected:

```java
null
```

will be printed.

Otherwise, the object will still be returned.

---

# Strong Reference vs Weak Reference

| Strong Reference | Weak Reference |
|------------------|---------------|
| Default type of reference in Java | Created using `WeakReference<T>` |
| Prevents Garbage Collection | Does not prevent Garbage Collection |
| Object stays alive while reference exists | Object can be removed anytime by JVM |
| Need to assign `null` manually to make object eligible for GC | No need to assign `null` |
| Used for normal objects | Used for caches, memory-sensitive data structures |

---

# Important Interview Point

In normal references:

```java
Phone phone = new Phone("Apple", "16 Pro Max");
```

the object remains in memory until:

```java
phone = null;
```

or the reference goes out of scope.

In weak references:

```java
WeakReference<Phone> phoneWeakReference =
        new WeakReference<>(new Phone("Apple", "16 Pro Max"));
```

the JVM is free to remove the object whenever Garbage Collection runs because there is no strong reference holding it.

---

# Quick Revision

### Strong Reference

```java
Phone phone = new Phone("Apple", "16 Pro Max");
```

- Object survives.
- GC cannot remove it.

### Weak Reference

```java
WeakReference<Phone> phone =
        new WeakReference<>(new Phone("Apple", "16 Pro Max"));
```

- Object can be removed during GC.
- `phone.get()` may return `null`.

### Key Idea

Weak references are mainly used for:

- Caching
- Memory-sensitive applications
- Avoiding memory leaks
- Data that can be recreated when needed

What is String Pool?

String Pool is a special memory area where Java stores string literals. Before creating a new string literal, JVM checks whether the same value already exists in the pool. If it does, JVM reuses the existing object instead of creating a new one, saving memory.


Are Strings strong references?

The String object itself is just an object. Variables like String s = "Hello" are strong references to that object. As long as a strong reference exists, the String object cannot be garbage collected.

