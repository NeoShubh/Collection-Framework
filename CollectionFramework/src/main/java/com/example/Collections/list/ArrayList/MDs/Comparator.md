Why is return o2-o1 descending and return o1-o2 ascending?

Answer:

Because Comparator follows this rule:

negative -> first element comes before second
positive -> first element comes after second

o1-o2 makes smaller elements come first (ascending).

o2-o1 makes larger elements come first (descending).

lets say - > o2 - o1 gives negative then o2 comes before
o1 and if it gives positive then it comes after but if
it gives
0 then things will be there as at ease