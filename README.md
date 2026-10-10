# BST vs Hash Table Performance Analysis

## Description
This project implements and compares two data structures in Java:
* **Binary Search Tree (BST)**
* **Hash Table** (using chaining with `LinkedList`)

The program benchmarks **Insert**, **Search**, and **Delete** operations across datasets of 100, 1,000, and 10,000 integer elements.

---

## Complexity Analysis

| Data Structure | Operation | Best Case | Average Case | Worst Case |
| :--- | :--- | :--- | :--- | :--- |
| **BST** | Insert / Search / Delete | $O(1)$ | $O(\log n)$ | $O(n)$ |
| **Hash Table** | Insert / Search / Delete | $O(1)$ | $O(1)$ | $O(n)$ |

### Worst-Case Scenarios:
* **BST:** Occurs when input elements arrive sorted or reverse-sorted, turning the tree into a linked list with $O(n)$ depth.
* **Hash Table:** Occurs when multiple keys hash to the same bucket index (collisions), resulting in $O(n)$ search time.

---

## Experimental Results

*Times measured in milliseconds (ms) using `System.nanoTime()`.*

| Size ($N$) | Structure | Insert (ms) | Search (ms) | Delete (ms) |
| :--- | :--- | :--- | :--- | :--- |
| **100** | BST | 12.7693 | 0.0917 | 0.0959 |
| **100** | Hash Table | 0.3225 | 0.0584 | 0.0760 |
| **1,000** | BST | 0.3402 | 0.3142 | 0.3072 |
| **1,000** | Hash Table | 0.6048 | 0.3483 | 0.5409 |
| **10,000** | BST | 3.9091 | 2.9717 | 2.7352 |
| **10,000** | Hash Table | 2.5224 | 3.4274 | 2.7521 |

---

## Conclusions

1. **Direct Access vs Traversal:** Hash Tables achieve faster insertion times on larger datasets ($2.52\text{ ms}$ vs $3.91\text{ ms}$ at $N=10,000$) because key locations are computed directly using a hash function ($O(1)$).
2. **CPU Caching:** Hash Tables store references in contiguous array buckets, which provides better memory locality and CPU caching compared to dynamically allocated BST nodes.
3. **Data Ordering:** While Hash Tables are generally faster for lookup, BSTs keep elements in sorted order, enabling range searches and in-order traversals without additional sorting steps.