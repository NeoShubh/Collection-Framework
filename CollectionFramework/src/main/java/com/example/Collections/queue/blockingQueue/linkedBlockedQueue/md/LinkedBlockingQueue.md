# LinkedBlockingQueue

`LinkedBlockingQueue` is a linked-list-based implementation of `BlockingQueue`.

Unlike `ArrayBlockingQueue`, it does not rely on a fixed-size array.

The capacity is optional.

```java
new LinkedBlockingQueue<>();
```

If no capacity is specified, it uses a very large default capacity (`Integer.MAX_VALUE`).

Elements are stored as linked-list nodes.

---

## Internal Locking Mechanism

`LinkedBlockingQueue` uses two separate locks:

```java
putLock
takeLock
```

### putLock

Used only by producer threads while inserting elements.

### takeLock

Used only by consumer threads while removing elements.

Because producers and consumers use different locks, they can often work simultaneously.

```text
Producer ---> putLock

Consumer ---> takeLock
```

A producer adding data does not necessarily block a consumer from removing data.

---

## Why is Throughput Better?

Since insertion and removal operations use separate locks, lock contention is reduced.

This allows producer and consumer threads to run concurrently in many situations.

As a result, `LinkedBlockingQueue` generally provides better throughput than `ArrayBlockingQueue` in highly concurrent environments.

---

## Internal Structure

Internally, it uses a linked list.

Each element is stored inside a separate node.

```text
Node -> Node -> Node -> Node
```

Each node contains:

* Data
* Reference to the next node
* Object metadata

---

## Characteristics

### Advantages

* High throughput in concurrent environments.
* Separate locks for producers and consumers.
* Capacity is optional.
* Suitable for Producer-Consumer systems with heavy concurrency.

### Disadvantages

* Higher memory usage because each element requires a separate node object.
* More memory overhead compared to array-based implementations.

---
## ArrayBlockingQueue vs LinkedBlockingQueue

### ArrayBlockingQueue

* Internal Structure: Circular Array
* Capacity: Mandatory
* Locks: Single Lock
* Throughput: Good
* Memory Usage: Lower
* Dynamic Growth: No

### LinkedBlockingQueue

* Internal Structure: Linked List
* Capacity: Optional (defaults to Integer.MAX_VALUE)
* Locks: Two Locks (`putLock` and `takeLock`)
* Throughput: Better under high concurrency
* Memory Usage: Higher
* Dynamic Growth: Yes (until capacity limit is reached)
