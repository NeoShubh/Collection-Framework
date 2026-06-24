# DelayQueue

`DelayQueue` is a special implementation of `BlockingQueue` where elements become available only after a specified delay has expired.

You can insert elements immediately, but consumers cannot retrieve them until their delay period is over.

---

## Core Idea

```text
Add Element Immediately
          ↓
Wait for Delay to Expire
          ↓
Element Becomes Available
          ↓
Consumer Can Take It
```

---

## OTP Analogy

Consider an OTP system.

After an OTP is generated, the user must wait for a certain amount of time before requesting another one.

A `DelayQueue` can be used to track when the OTP becomes eligible for regeneration or expiration.

---

## Delayed Interface

You cannot store plain integers or strings directly in a `DelayQueue`.

The stored object must implement the `Delayed` interface.

```java
getDelay(TimeUnit unit)
```

Returns the remaining delay before the element becomes available.

```java
compareTo(Delayed other)
```

Used to order elements based on their expiration time.

---

## How It Works

Suppose we add three tasks:

```text
Task A -> 5 seconds
Task B -> 10 seconds
Task C -> 15 seconds
```

Even if all tasks are added immediately:

```text
Time 5s  -> Task A available
Time 10s -> Task B available
Time 15s -> Task C available
```

A consumer calling `take()` will wait until the next element's delay has expired.

---

## Blocking Behavior

### Producer

```text
Never waits
```

Elements can be added immediately.

### Consumer

```text
Waits until delay expires
```

`take()` blocks if no expired element is available.

---

## Common Use Cases

### Session Expiry

```text
Expire user session after 30 minutes
```

### OTP Expiry

```text
Invalidate OTP after 5 minutes
```

### Retry Mechanisms

```text
Retry failed request after 5 seconds
```

### Cache Eviction

```text
Remove cache entry after 10 minutes
```

### Scheduled Tasks

```text
Execute task after a specified delay
```

---

## Key Points

* Elements become available only after their delay expires.
* Uses the `Delayed` interface.
* Elements can be added immediately.
* Consumers may block while waiting for the next expired element.
* Commonly used for expiration, scheduling, retries, and cache cleanup.
