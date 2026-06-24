# PriorityQueue

A `PriorityQueue` in Java is implemented using a **Heap** data structure.

In a heap, the minimum (or maximum) priority element is always stored at the root.

A heap is **not a fully sorted structure**. It is a **partially ordered** tree where only the parent-child relationship is maintained.

For a Min Heap:

```text
Parent <= Children
```

There is no guaranteed ordering among nodes at the same level.

## Why is a Heap Useful?

A heap is useful when you frequently need to access or remove the element with the highest priority (minimum or maximum).

A common use of a heap is to implement a `PriorityQueue`.

## Internal Operations

### offer()

Adds an element at the end of the heap and then moves it upward (bubble up / heapify up) until the heap property is restored.

**Time Complexity:** `O(log n)`

### poll()

Removes the root element (smallest element in a Min Heap).

The last element is moved to the root and then moved downward (bubble down / heapify down) until the heap property is restored.

**Time Complexity:** `O(log n)`

### peek()

Returns the root element without removing it.

**Time Complexity:** `O(1)`

## Interview Question

### Is PriorityQueue Sorted?

**No.**

Only the head (root) is guaranteed to be the smallest element in a Min Heap.

The remaining elements are not fully sorted.

This is a common misconception.

## Additional Characteristics

* Allows duplicate elements.
* Does not allow `null` values.
* Elements must be comparable so that heap ordering can be maintained.

## Interview Hint

Whenever a problem contains phrases like:

* Kth Largest Element
* Kth Smallest Element
* Top K Elements
* Highest Priority
* Lowest Priority

A `Heap` or `PriorityQueue` is often one of the best solutions to consider.
