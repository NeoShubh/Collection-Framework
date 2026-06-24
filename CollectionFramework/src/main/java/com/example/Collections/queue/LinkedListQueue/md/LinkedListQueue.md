# LinkedList as Queue

`LinkedList` implements both the `Queue` and `Deque` interfaces.

Therefore, it can behave as:

* A Queue (FIFO)
* A Stack (LIFO)
* A Double-Ended Queue (Deque)

## Internal Working

Internally, `LinkedList` is implemented as a **Doubly Linked List**.

Each node contains:

* Data
* Previous Pointer
* Next Pointer

### Addition of Elements

When an element is added to the queue, a new node is created and attached to the end (tail) of the linked list.

### Poll Operation

When `poll()` is called, the head (first node) of the linked list is removed and returned.

This operation mainly involves updating a few pointers.

## Why are LinkedList Queues Rarely Preferred in Production?

Each element is stored as a separate node object in heap memory.

Every node contains:

* The actual data
* A previous pointer
* A next pointer
* Object header information

Because of these extra objects and pointers, `LinkedList` has higher memory overhead compared to array-based implementations such as `ArrayDeque`.

For this reason, `ArrayDeque` is usually preferred for queue implementations in production systems.
