# ArrayBlockingQueue

`ArrayBlockingQueue` is a bounded implementation of `BlockingQueue`.

Internally, it uses a circular array similar to `ArrayDeque`.

It maintains two pointers:

* `head`
* `tail`

Unlike `ArrayDeque`, it does **not resize dynamically**.

The capacity must be provided when the queue is created.

```java id="m4wprn"
BlockingQueue<Integer> queue =
        new ArrayBlockingQueue<>(100);
```

## Internal Synchronization

`ArrayBlockingQueue` uses a single `ReentrantLock` along with two `Condition` variables to coordinate between producer and consumer threads.

```java id="8uoqh0"
ReentrantLock lock = new ReentrantLock();

Condition notFull  = lock.newCondition();
Condition notEmpty = lock.newCondition();
```

### Purpose of Conditions

```java id="ajl5ow"
notFull  -> Producer waits here
notEmpty -> Consumer waits here
```

## put()

### Flow

```text id="7mw0af"
Acquire Lock
      ↓
Queue Full?
      ↓
Wait on notFull
      ↓
Add Element
      ↓
Signal notEmpty
      ↓
Release Lock
```

## take()

### Flow

```text id="4fb4e4"
Acquire Lock
      ↓
Queue Empty?
      ↓
Wait on notEmpty
      ↓
Remove Element
      ↓
Signal notFull
      ↓
Release Lock
```

## Why Would I Use ArrayBlockingQueue?

Suppose a server can process only a limited number of requests at a time.

Incoming requests arrive faster than they can be processed.

`ArrayBlockingQueue` can act as a buffer between request producers and worker threads.

```text id="g10vqz"
Incoming Requests
        ↓
ArrayBlockingQueue
        ↓
Worker Threads
```

Benefits:

* Prevents uncontrolled memory growth.
* Controls throughput using a fixed capacity.
* Automatically coordinates producers and consumers.
* Ideal for Producer-Consumer systems.


# Why LinkedBlockingQueue Has Better Throughput

## ArrayBlockingQueue — Single Lock

```text
Producer          Single Lock        Consumer
   |                  🔒                 |
   |---wants to ADD---|                  |
   |   LOCK ACQUIRED  |                  |
   |                  |                  |
   |            consumer wants to REMOVE |
   |            ❌ BLOCKED — lock taken  |
   |                  |                  |
   | done, RELEASES   |                  |
   |                  | ✅ consumer goes |
```

Even though the producer is adding at the tail and the consumer is removing from the head, they still block each other because there is only **one lock** protecting the entire queue.

---

## LinkedBlockingQueue — Two Locks

```text
Producer          putLock      takeLock       Consumer
   |                🔒            🔒              |
   |---wants to ADD-|                             |
   |  putLock ACQUIRED                            |
   |                             consumer wants REMOVE
   |                             takeLock ACQUIRED ✅
   |                             ✅ BOTH RUNNING SIMULTANEOUSLY
   |                🔓            🔓
```

Producer threads use `putLock`.

Consumer threads use `takeLock`.

Since insertion and removal usually operate on different ends of the linked list, producers and consumers can often work concurrently.

This significantly reduces lock contention and improves throughput.

---

## Simplified Internal Flow

The actual JDK implementation is more complex, but the core idea looks like this:

### PUT Operation

```java
putLock.lock();
try {
    while (count == capacity)
        notFull.await();

    enqueue(element);

    if (count < capacity)
        notFull.signal();
} finally {
    putLock.unlock();
}
```

### TAKE Operation

```java
takeLock.lock();
try {
    while (count == 0)
        notEmpty.await();

    element = dequeue();

    if (count > 0)
        notEmpty.signal();
} finally {
    takeLock.unlock();
}
```

---

## Key Takeaway

`ArrayBlockingQueue`

* One lock for both producers and consumers.
* Higher lock contention.
* Lower concurrency.

`LinkedBlockingQueue`

* Separate `putLock` and `takeLock`.
* Producers and consumers can often run simultaneously.
* Better throughput in highly concurrent environments.
