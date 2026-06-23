# Queue

`Queue` is an interface that follows the **FIFO (First In, First Out)** principle.

The element that is inserted first will be accessed and removed first.

### Example

Suppose we have the following queue:

```java
[1, 2, 3, 4, 5]
```

### offer()

Used to add an element to the queue.

```java
queue.offer(10);
```

After insertion:

```java
[1, 2, 3, 4, 5, 10]
```

### poll()

Used to access and remove the first element from the queue.

```java
queue.poll();
```

Output:

```java
1
```

Queue after removal:

```java
[2, 3, 4, 5, 10]
```

The next accessible element becomes:

```java
2
```

### peek()

Used to view the first element without removing it.

```java
queue.peek();
```

Output:

```java
1
```

Queue remains unchanged:

```java
[1, 2, 3, 4, 5, 10]
```
