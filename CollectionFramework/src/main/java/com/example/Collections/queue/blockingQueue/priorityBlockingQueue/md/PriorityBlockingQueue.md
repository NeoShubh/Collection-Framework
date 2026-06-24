# PriorityBlockingQueue

`PriorityBlockingQueue` combines the features of:

```text id="c3h15t"
PriorityQueue
+
BlockingQueue
=
PriorityBlockingQueue
```

It is:

* Thread-safe
* Priority-based
* Blocking for consumers
* Unbounded by default

---

## Internal Working

Internally, `PriorityBlockingQueue` uses a **Min Heap**.

The element with the highest priority (smallest element by default) is always available at the head of the queue.

```text id="l5gqsb"
1
├── 3
└── 5
```

The smallest element is always removed first.

---

## Blocking Behavior

### Consumer

If the queue is empty:

```text id="bj66j5"
Consumer waits
```

The consumer thread blocks until an element becomes available.

### Producer

Producers do not wait.

```text id="u4jrvl"
put() never blocks
offer() never blocks
```

Since the queue is unbounded, elements can always be added.

---

## Why is it Unbounded?

Internally, it uses an array-based heap that grows automatically when additional space is required.

There is no fixed capacity limit.

Because of this, producers are never blocked due to a full queue.

---

## Potential Problem

### Interview Question

**If producers never block, can this cause issues?**

Yes.

If producers generate elements faster than consumers can process them:

```text id="f6h1el"
Producer >>> Consumer
```

the queue continues growing.

Eventually, excessive growth may lead to:

```text id="3flgke"
OutOfMemoryError
```

For this reason, `PriorityBlockingQueue` must be used carefully in production systems.

---

## When Should You Use It?

Use `PriorityBlockingQueue` when:

* Multiple threads are producing and consuming data.
* Elements must be processed according to priority rather than insertion order.

---

## Real-World Example

### Hospital Emergency System

Patients arrive continuously.

```text id="w5jwhl"
Patient A -> Priority 5
Patient B -> Priority 1
Patient C -> Priority 3
```

Even if Patient A arrived first:

```text id="2wzg0t"
Patient B
Patient C
Patient A
```

will be processed first because Patient B has the highest priority.

The processing order is determined by priority, not arrival time.

---

## Key Points

* Uses a Min Heap internally.
* Thread-safe.
* Priority-based ordering.
* Consumer blocks when queue is empty.
* Producer never blocks.
* Unbounded queue.
* Can grow large and potentially cause OutOfMemoryError.
* Ideal when priority matters more than insertion order.
