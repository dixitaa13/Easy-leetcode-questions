706. Design HashMap

Implement the MyHashMap class:
MyHashMap() initializes the object with an empty map.
void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.

Example 1:
Input
["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
Output
[null, null, null, 1, -1, null, 1, null, -1]

Explanation
MyHashMap myHashMap = new MyHashMap();
myHashMap.put(1, 1); // The map is now [[1,1]]
myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]

Explaination:
🧠 Step 1: What is a HashMap?
A HashMap is just a data structure that lets you:
Store data as key-value pairs (like key -> value)
Find values quickly using the key
Add, remove, update key-value pairs easily

🗄️ Step 2: The Cabinet Analogy
Imagine you have 100 drawers in a cabinet.
When you want to store something, you don’t want to search through all 100 drawers — that’s slow.
So we use a hash function – it’s like a smart machine that takes your key (like a name) and tells you exactly which drawer to use.

Example:
Key: "Alice"
Hash function says: "Alice" goes to drawer 27
You put Alice’s info in drawer 27.
When you need Alice’s info again, you ask the hash function:
"Alice" → Drawer 27 → Open it → Get the value
This is why lookup is super fast — you jump straight to the correct drawer.

🧮 Step 3: The Hash Function
A hash function is just a formula that converts the key into a number.
Example (simplified):
hash("Alice") = 27
hash("Bob")   = 54
hash("Eve")   = 27   <- Uh oh! Same drawer!

🚧 Step 4: Collisions (When Two Keys Go to Same Drawer)
Sometimes two keys may go to the same drawer (like "Alice" and "Eve" both going to drawer 27).
This is called a collision.

How do we fix this? Two common ways:
Chaining (Linked List in Each Drawer)
Each drawer stores a list of key-value pairs.
If multiple keys land in the same drawer, we just chain them in a list.
To find a value, we look inside the list.

Open Addressing
If a drawer is already full, find the next empty drawer (like putting it in the next available spot).

📈 Step 5: Rehashing (When Cabinet Gets Full)
If too many keys are stored, drawers get crowded, and lookup becomes slow.
So we make a bigger cabinet (more drawers) and rehash (recalculate) all keys so they are spread out again.


