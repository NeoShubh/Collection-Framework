## ConcurrentSkipListMap

A map which is achieving sorting as well as concurrency (Thread safe TreeMap).

### What is Skip List?

- It's a probabilistic data structure that allows for efficient insertion, deletion and search operation.
- It's similar to a sorted linked list but with multiple layers that "skips" over portions of the list to provide faster access to elements.

### Understanding Skip List

You have a list:

```text
[1,2,3,4,5,6,7,8,9]
```

These are layers:

```text
1 - - - 5 - - - 9
1 - 3 - 5 - 7 - 9
1 2 3 4 5 6 7 8 9
```

Now we need to search `2` in this list.

- First layer → we found out that it is present between `1` and `5`.
- Second layer → we found out that it is present between `1` and `3`.
- Last layer → we found it.

So through that we actually find the `2` and did not search lots of elements.

The layers are used to skip unnecessary elements and provide faster searching.