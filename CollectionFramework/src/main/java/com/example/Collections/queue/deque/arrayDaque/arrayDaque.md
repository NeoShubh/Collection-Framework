# Deque

`Deque` (Double Ended Queue) allows insertion and removal of elements from both ends.

We can:

* Add elements at the head or tail.
* Remove elements from the head or tail.

## Queue and Stack Behavior

A `Deque` can work as both a Queue and a Stack.

### As a Queue (FIFO)

* Add at the back.
* Remove from the front.

```text id="t6gh5r"
10 20 30

Remove -> 10
```

### As a Stack (LIFO)

* Add at the front.
* Remove from the front.

```text id="cg8vkk"
30 20 10

Remove -> 30
```

## Common Use Cases

* Sliding Window Problems
* LRU Cache
* Undo/Redo Operations
* Task Scheduling

---

# Internal Working of ArrayDeque

`ArrayDeque` is implemented using a **circular array**.

Initial state:

```text id="xuwt7h"
Index: 0 1 2 3 4 5 6 7 8 9 10

Head = 0
Tail = 0
```

## offerLast(10)

```text id="mf3iq8"
Index: 0 1 2 3 4 5 6 7 8 9 10
Data : 10

Head = 0
Tail = 1
```

---

## offerLast(20)

```text id="tn3zw5"
Index: 0 1 2 3 4 5 6 7 8 9 10
Data : 10 20

Head = 0
Tail = 2
```

---

## offerLast(30)

```text id="zv1g9w"
Index: 0 1 2 3 4 5 6 7 8 9 10
Data : 10 20 30

Head = 0
Tail = 3
```

---

## offerFirst(50)

Since there is no index before `0`, the circular array wraps around.

```text id="ln5x1y"
Index: 0 1 2 3 4 5 6 7 8 9 10
Data : 10 20 30             50

Head = 10
Tail = 3
```

---

## offerFirst(60)

```text id="vjiz4h"
Index: 0 1 2 3 4 5 6 7 8 9 10
Data : 10 20 30          60 50

Head = 9
Tail = 3
```

---

## Logical Order

Even though the physical storage is:

```text id="2ml2e9"
10 20 30          60 50
```

The logical order from Head to Tail is:

```text id="h6fcy0"
60 → 50 → 10 → 20 → 30
```

Head = 9

Tail = 3

---

## What Happens When the Array Gets Full?

When the internal circular array becomes full:

1. Java creates a larger array (typically double the size).
2. Elements are copied into the new array in their logical order.
3. Head and Tail are recalculated.
4. Operations continue normally.

This resizing operation is infrequent, which helps keep insertion operations efficient.
