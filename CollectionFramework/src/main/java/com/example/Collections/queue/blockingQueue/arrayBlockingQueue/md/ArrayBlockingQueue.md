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
