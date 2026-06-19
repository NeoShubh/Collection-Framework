An ArrayList is a resizable array implementation of the
List interface. Unlike arrays in Java, which have a
fixed size, an ArrayList can change its size
dynamically as elements are added or removed. This
flexibility makes it a popular choice when the number
of elements in a list isn't known in advance.

Internal working
Unlike a regular array, which has a fixed size,
an ArrayList can grow and shrink as elements
are added or removed. This dynamic resizing
is achieved by creating a new array when the
current array is full and copying the elements
to the new array.

Internally, the ArrayList is implemented as an
array of Object references. When you add
elements to an ArrayList, you're essentially
storing these elements in this internal array.

When you create an ArrayList, it has an initial
capacity (default is 10). The capacity refers
to the size of the internal array that can hold
elements before needing to resize.

Adding Elements
When we add an element to an ArrayList, the following steps occur

Check Capacity: Before adding the new element, ArrayList checks if
there is enough space in the internal array (elementData). If the array is
full, it needs to be resized.

Resize if Necessary: If the internal array is full, the ArrayList will create
a new array with a larger capacity (usually 1.5 times the current
capacity) and copy the elements from the old array to the new array.

Add the Element: The new element is then added to the internal array at
the appropriate index, and the size is incremented.


Resizing the Array

. Initial Capacity: By default, the initial capacity is 10. This means the
internal array can hold 10 elements before it needs to grow.

. Growth Factor: When the internal array is full, a new array is created
with a size 1.5 times the old array. This growth factor balances
memory efficiency and resizing cost.

. Copying Elements: When resizing occurs, all elements from the old
array are copied to the new array, which is an O(n) operation, where
n is the number of elements in the ArrayList.

Removing Elements

. Check Bounds: The ArrayList first checks if the index is within the
valid range.

. Remove the Element: The element is removed, and all elements to
the right of the removed element are shifted one position to the left
to fill the gap.

. Reduce Size: The size is decremented by 1.

Creating an ArrayList

// Default constructor, creates an empty ArrayList with an initial capacity of 10
ArrayList<String> list = new ArrayList<>();

// Creating an ArrayList with a specified initial capacity
ArrayList<String> listWithCapacity = new ArrayList<>(20);

// Creating an ArrayList from another collection
List<String> anotherList = Arrays.asList( "Apple", "Banana", "Orange");
ArrayList<String> listFromCollection = new ArrayList<>(anotherList);


Adding Elements

ArrayList<String> list = new ArrayList<>();

// Adding elements to the end of the list
list. add( "Apple");
list. add( "Banana" );

// Adding an element at a specific index
list.add(1, "Orange"); // "Orange" will be added at index 1, shifting "Banana" to index 2


Time Complexity

. Access by index (get) is O(1).
. Adding an element is O(n) in the worst case when resizing occurs.
. Removing elements can be O(n) because it may involve shifting elements.
· Iteration is O(n).