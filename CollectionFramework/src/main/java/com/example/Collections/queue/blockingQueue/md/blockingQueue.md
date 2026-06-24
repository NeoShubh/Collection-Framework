# BlockingQueue

`BlockingQueue` is designed for multithreaded applications.

It is commonly used in the **Producer-Consumer Pattern**.

## Producer and Consumer

* Producer puts data into the queue.
* Consumer takes data out of the queue.

```text id="9jrj34"
Producer ---> BlockingQueue ---> Consumer
```

## Problem It Solves

Imagine the producer is faster than the consumer:

```text id="7tqaqe"
Producer:
[1] [2] [3] [4] [5] [6] [7] ...

Consumer:
Still processing [1]
```

The producer may continue generating data faster than the consumer can process it.

Without a `BlockingQueue`, the application must manually handle situations where the queue becomes full or empty.

`BlockingQueue` handles these situations automatically.

## Blocking Behavior

### Queue is Full

If the queue is full:

```text id="uk6wja"
Producer waits
```

The producer thread is blocked until space becomes available.

### Queue is Empty

If the queue is empty:

```text id="0iwy0w"
Consumer waits
```

The consumer thread is blocked until an element is added.

## Key Idea

* Consumer waits when the queue is empty.
* Producer waits when the queue is full.

This automatic coordination between producer and consumer is the main purpose of `BlockingQueue`.
