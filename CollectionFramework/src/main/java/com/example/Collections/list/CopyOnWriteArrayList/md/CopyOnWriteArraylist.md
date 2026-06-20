"Copy on Write" means that whenever a write operation
like adding or removing an element
instead of directly modifying the existing list
a new copy of the list is created, and the modification is applied to that copy
This ensures that other threads reading the list while it's being modified are unaffected.

Read Operations: Fast and direct, since they happen on a stable list without interference from modifications.
Write Operations: A new copy of the list is created for every modification.
The reference to the list is then updated so that subsequent reads use this new list.

notepad -- > notepad-copy

