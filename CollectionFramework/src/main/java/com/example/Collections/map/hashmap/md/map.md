# Map Interface in Java

In Java, a Map is an object that maps keys to values.

It cannot contain duplicate keys, and each key can map to at most one value.

Think of it as a dictionary where you look up a word (key) to find its definition (value).

---

# Key Characteristics of the Map Interface

- **Key-Value Pairs:** Each entry in a Map consists of a key and a value.
- **Unique Keys:** No two entries can have the same key.
- **One Value per Key:** Each key maps to a single value.
- **Order:** Some implementations maintain insertion order (LinkedHashMap), natural order (TreeMap), or no order (HashMap).

---

# Key Characteristics of HashMap

- **Unordered:** Does not maintain any order of its elements.
- **Allows null Keys and Values:** Can have one null key and multiple null values.
- **Not Synchronized:** Not thread-safe; requires external synchronization if used in a multi-threaded context.
- **Performance:** Offers constant-time performance (O(1)) for basic operations like get and put, assuming the hash function disperses elements properly.

---

# Key Components of HashMap

- **Key** - the identifier used to get the value.
- **Value** - the data associated with the key.
- **Bucket** - a place where key-value pairs are stored. Think of buckets as cells in a list (array).
- **Hash Function** - converts the key into an index to the cell of the array.

---

# Hash Function

A hash function is an algorithm that takes an input (or "key") and returns a fixed-size string of bytes, typically a numerical value.

The output is known as a:

- Hash Code
- Hash Value
- Hash

The primary purpose of a hash function is to map data of arbitrary size to data of fixed size.

## Characteristics

- **Deterministic:** The same input will always produce the same output.
- **Fixed Output Size:** Regardless of the input size, the hash code has a consistent size (e.g., 32-bit, 64-bit).
- **Efficient Computation:** The hash function should compute the hash quickly.

---

# How Data is Stored in HashMap

## Step 1: Hashing the Key

First, the key is passed through a hash function to generate a unique hash code (an integer number).

This hash code helps determine where the key-value pair will be stored in the array (called a "bucket array").

---

## Step 2: Calculating the Index

The hash code is then used to calculate an index in the array (bucket location) using:

```java
int index = hashCode % arraySize;
```

The index decides which bucket will hold this key-value pair.

For example, if the array size is 16, the key's hash code will be divided by 16, and the remainder will be the index.

---

## Step 3: Storing in the Bucket

The key-value pair is stored in the bucket at the calculated index.

Each bucket can hold multiple key-value pairs.

This is called a collision handling mechanism.

Example:

```java
map.put("apple", 50);
```

- "apple" is the key.
- 50 is the value.
- The hash code of "apple" is calculated.
- The index is found using the hash code.
- The pair ("apple", 50) is stored in the corresponding bucket.

---

# How HashMap Retrieves Data

When we call:

```java
map.get(key);
```

HashMap follows these steps:

### 1. Hashing the Key

The key is hashed using the same hash function to calculate its hash code.

### 2. Finding the Index

The hash code is used to find the index of the bucket where the key-value pair is stored.

### 3. Searching in the Bucket

Once the correct bucket is found, it checks for the key in that bucket.

If it finds the key, it returns the associated value.

---

# Internal Node Structure

```java
class Node<K, V> {
    final int hash;      // hash code of the key
    final K key;         // the key itself
    V value;             // the value associated with the key
    Node<K, V> next;     // pointer to next node in case of collision
}
```

---

# Handling Collisions

Since different keys can generate the same index (called a collision), HashMap uses a technique to handle this situation.

Java's HashMap uses:

- Linked Lists
- Balanced Trees (after Java 8)

If multiple key-value pairs map to the same bucket, they are stored in a linked list inside the bucket.

When a key-value pair is retrieved, HashMap traverses the linked list, checking each key until it finds a match.

---

## Collision Example

```java
map.put("apple", 50);
map.put("banana", 30);
map.put("orange", 80);
```

Let's say:

- "apple"
- "orange"

end up in the same bucket due to a hash collision.

They will be stored like:

```text
Bucket 5:
("apple", 50) -> ("orange", 80)
```

When we do:

```java
map.get("orange");
```

HashMap will:

1. Go to Bucket 5.
2. Traverse the linked list.
3. Find the key "orange".
4. Return value 80.

---

# HashMap Resizing (Rehashing)

HashMap has an internal array size, which by default is 16.

When the number of elements grows and exceeds a certain load factor (default = 0.75), HashMap automatically resizes the array.

This process is called:

**Rehashing**

---

## Default Threshold

```text
Array Size = 16
Load Factor = 0.75

Threshold = 16 × 0.75 = 12
```

After 12 elements, HashMap resizes itself.

---

## During Rehashing

### 1. Array Size Doubles

```text
16 → 32
32 → 64
64 → 128
```

### 2. Existing Entries Are Rehashed

All existing entries are rehashed.

Their positions are recalculated and inserted into the new array.

This ensures efficient performance as more data is added.

---

# Time Complexity

HashMap provides constant-time performance:

```text
put()  -> O(1)
get()  -> O(1)
remove() -> O(1)
```

assuming there are minimal collisions.

---

## Worst Case

If many elements are stored in the same bucket:

```text
O(n)
```

where n is the number of elements in that bucket.

---

## After Java 8

If a bucket contains too many elements, HashMap switches from:

```text
Linked List
      ↓
Balanced Tree
```

This improves lookup performance from:

```text
O(n)
      ↓
O(log n)
```
# HashMap Example – Storing Fruit Quantities

Suppose we want to store information about the number of fruits in a store.

| Fruit  | Quantity |
|---------|----------|
| Apple   | 50 |
| Banana  | 30 |
| Orange  | 80 |
| Grape   | 20 |

---

# Adding Key-Value Pairs to HashMap

Let's add the key-value pairs one by one.

```java
fruitMap.put("Apple", 50);
```

## Internal Process

The key `"Apple"` is hashed using its `hashCode()`.

Let's assume `"Apple"` generates a hash code of:

```text
14332233
```

*(Example value only)*

The hash code is used to calculate the index in the internal bucket array.

Assume the array size is:

```text
16
```

Index calculation:

```java
index = hashCode % arraySize;
```

```java
index = 10832233 % 16 = 9;
```

This means:

```text
"Apple" → Bucket 9
```

---

## Adding Banana

```java
fruitMap.put("Banana", 30);
```

Index calculation:

```java
index = 13942244 % 16 = 4;
```

This means:

```text
"Banana" → Bucket 4
```

---

## Adding Grape

```java
fruitMap.put("Grape", 20);
```

Index calculation:

```java
index = 548734 % 16 = 14;
```

This means:

```text
"Grape" → Bucket 14
```

---

## Adding Orange

```java
fruitMap.put("Orange", 80);
```

Index calculation:

```java
index = 19332414 % 16 = 14;
```

This means:

```text
"Orange" → Bucket 14
```

---

# Collision Occurs

Both:

```text
"Grape"
"Orange"
```

are mapped to:

```text
Bucket 14
```

Since the bucket already contains an entry, HashMap handles the collision by storing both entries in a linked list.

Bucket 14 now contains:

```text
("Orange", 80) -> ("Grape", 20)
```

---

# Internal HashMap Structure

Array Size = 16

| Index | Bucket Contents |
|---------|----------------|
| 0 | Empty |
| 1 | Empty |
| 2 | Empty |
| 3 | Empty |
| 4 | ("Banana", 30) |
| 5 | Empty |
| 6 | Empty |
| 7 | Empty |
| 8 | Empty |
| 9 | ("Apple", 50) |
| 10 | Empty |
| 11 | Empty |
| 12 | Empty |
| 13 | Empty |
| 14 | ("Orange", 80) → ("Grape", 20) |
| 15 | Empty |

---

# Collision Handling

```text
Bucket 14

("Orange", 80)
        ↓
("Grape", 20)
```

HashMap stores collided entries using a linked list.

When retrieving a value, HashMap traverses the linked list and compares keys until a match is found.

---

# Treeification in Java 8+

When the number of nodes in a single bucket exceeds the threshold of:

```text
8
```

HashMap converts the linked list into a:

```text
Red-Black Tree
```

This process is called:

```text
Treeification
```

### Before Treeification

```text
Bucket 14

A -> B -> C -> D -> E -> F -> G -> H -> I
```

Lookup Time:

```text
O(n)
```

---

### After Treeification

```text
          D
        /   \
       B     G
      / \   / \
     A  C F   I
           / \
          H   ...
```

Lookup Time:

```text
O(log n)
```

---

# Important Interview Point

HashMap uses:

```text
Linked List
```

for collision handling by default.

After Java 8:

```text
Linked List
        ↓
Red-Black Tree
```

when:

```text
Bucket Size > 8
```

This improves search performance from:

```text
O(n)
```

to:

```text
O(log n)
```
