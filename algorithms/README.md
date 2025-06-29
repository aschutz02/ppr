# ⚙️ Algorithms Module – PPR Project

This module contains implementations and performance benchmarks for classic algorithms used in searching, sorting, recursion, and combinatorics. Each algorithm includes:

- Clear Java implementation
- Unit tests
- Runtime performance tests
- Theoretical analysis using Big O notation

---

## 📊 Algorithm Summary

| Algorithm       | Best Case      | Average Case    | Worst Case     | Space Complexity | Use Case / When to Use                             |
|----------------|----------------|------------------|----------------|------------------|-----------------------------------------------------|
| **Binary Search**   | O(1)           | O(log n)         | O(log n)       | O(1)             | When the input array is sorted. Ideal for fast lookups. |
| **Bubble Sort**     | O(n)           | O(n²)            | O(n²)          | O(1)             | Educational purposes only. Avoid in production due to inefficiency. |
| **Fibonacci**       | O(n) (iterative)<br>O(2ⁿ) (recursive) | - | - | O(1) (iterative)<br>O(n) (recursive) | Iterative is better for performance. Recursive only for demonstration or when using memoization. |
| **Merge Sort**      | O(n log n)     | O(n log n)       | O(n log n)     | O(n)             | Stable and predictable. Ideal for large datasets or when stability is needed. |
| **QuickSort**       | O(n log n)     | O(n log n)       | O(n²)          | O(log n)         | Excellent average-case performance. Use when speed matters and stability is not required. |
| **Selection Sort**  | O(n²)          | O(n²)            | O(n²)          | O(1)             | Easy to implement, but inefficient. Suitable for very small datasets. |
| **Permutation**     | O(n!)          | O(n!)            | O(n!)          | O(n)             | Used in combinatorial problems. Avoid on large inputs due to exponential growth. |

---

## 📌 Details & Use Cases

### 🔍 Binary Search

- **Scenario**: Searching in a sorted array or list.
- **Strengths**: Very efficient; divides the problem space in half each time.
- **Limitation**: Requires data to be sorted in advance.

---

### 🫧 Bubble Sort

- **Scenario**: Educational / teaching sorting principles.
- **Strengths**: Very simple to understand and implement.
- **Limitation**: Extremely inefficient on large datasets.

---

### 🌀 Fibonacci (Iterative & Recursive)

- **Scenario**: Solving mathematical sequences; teaching recursion vs iteration.
- **Strengths**: Recursive shows elegant problem decomposition; iterative is practical.
- **Limitation**: Recursive version has exponential time unless memoized.

---

### 🧩 Merge Sort

- **Scenario**: Sorting large data where stability is required.
- **Strengths**: Consistent O(n log n); stable; good for linked lists and external sorting.
- **Limitation**: Requires extra memory space (O(n)).

---

### ⚡ QuickSort

- **Scenario**: Fast general-purpose sorting.
- **Strengths**: Usually faster than merge sort in practice.
- **Limitation**: Worst-case O(n²), but mitigated by good pivot selection.

---

### 🧠 Selection Sort

- **Scenario**: Simple sorting of very small datasets.
- **Strengths**: No extra space required.
- **Limitation**: Inefficient for most practical cases.

---

### 🔄 Permutations

- **Scenario**: Combinatorial tasks (e.g., generating possible orders, solving puzzles).
- **Strengths**: Demonstrates recursion well.
- **Limitation**: Grows factorially (n!) with input size.

---

## 🧪 Running the Algorithms

Each algorithm has an associated test class with benchmarks and edge case handling.