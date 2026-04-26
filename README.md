# UMKC Campus Graph Project

**Authors:** Syed Abdul Mateen Shah
             Anas Ali

## Overview

This project models part of the UMKC campus as a weighted graph.
Each building is a vertex, and paths between buildings are edges with weights representing distance.

## Locations

* Student Union
* Bloch School
* Miller Nichols Library
* Spencer Chemistry
* Flarsheim Hall
* Katz Hall
* Swinney Rec Center
* Royall Hall
* Haag Hall
* Education Building

## Algorithms Used

### Dijkstra’s Algorithm

Finds the shortest path between two locations.
Example: Student Union → Katz Hall

### Kruskal’s Algorithm

Finds the Minimum Spanning Tree (connects all buildings with minimum total weight).

## How to Run

```bash
javac *.java
java Main
```

## Output

* Graph structure
* Shortest path
* Minimum spanning tree

## Note

Weights are approximate and kept small for simplicity.
