## IdentityHashMap

Unlike HashMap, IdentityHashMap creates the hashcode of every new string created even if your value for the string is same.

For two variables, both the variables will be pointing to one memory location but still IdentityHashMap will be creating a new hashcode each time.

So with HashMap you can get one key with overridden value, but with IdentityHashMap it contains the identity hashcode and it checks the equality with `==` operator to compare.

### HashMap

- Uses `hashCode()`
- Uses `equals()`
- Compares object content
- Same key → value gets overridden

### IdentityHashMap

- Uses `System.identityHashCode()`
- Uses `==`
- Compares object references (memory addresses)
- Same content but different objects → treated as different keys