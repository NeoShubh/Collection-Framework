# SynchronousQueue

`SynchronousQueue` is a special type of `BlockingQueue` with **zero capacity**.

```text
Capacity = 0
```

It does not store elements.

Instead, it acts as a direct handoff mechanism between producer and consumer threads.

---

## How It Works

A producer cannot add an element unless a consumer is ready to receive it.

Likewise, a consumer cannot receive an element unless a producer is ready to provide one.

```text
Producer  ----->  Consumer
         Direct Handoff
```

No element is ever stored inside the queue.

---

## Blocking Behavior

### Producer

If no consumer is waiting:

```text
Producer waits
```

### Consumer

If no producer is available:

```text
Consumer waits
```

The transfer happens only when both sides are present.

---

## Why Is It Special?

Unlike other queues:

```text
ArrayBlockingQueue
LinkedBlockingQueue
PriorityBlockingQueue
```

there is no internal storage.

The element goes directly from producer to consumer.

---

## Internal Usage

One of the most important uses of `SynchronousQueue` is:

```java
Executors.newCachedThreadPool()
```

`newCachedThreadPool()` uses a `SynchronousQueue` internally.

---

## Cached Thread Pool Behavior

When a task arrives:

### If a worker thread is available

```text
Task
  ↓
Worker Thread
```

The task is handed directly to that thread.

### If no worker thread is available

```text
Create New Thread
```

A new worker thread is created to execute the task.

Tasks are not stored in a queue waiting for execution.

---

## Simple Analogy

Imagine a producer holding a package.

```text
Producer 📦
```

The producer cannot put the package down anywhere.

The package can only be given directly to a consumer.

```text
Producer 📦 -----> Consumer
```

If the consumer is not present, the producer waits.

The moment the consumer arrives, the package is handed over instantly.

---

## Key Points

* Capacity is always zero.
* Stores no elements.
* Direct handoff between producer and consumer.
* Both sides may block while waiting for each other.
* Used internally by `Executors.newCachedThreadPool()`.
* Ideal when tasks should be handed directly to worker threads instead of being queued.
