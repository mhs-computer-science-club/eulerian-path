# Introduction

In mathematics, a **graph** is a structure defined by a set of **vertices** and a set of **edges**, which are the connections between the vertices.

A graph can be represented as:

```
G = (V, E)
```

where 

- `V(G)` is the set of vertices (e.g., `{a, b, c}`),
- and `E(G)` is the set of edges (e.g., `{{a, b}, {a, c}, {b, c}}`).

An **undirected graph** is one where the edges have no direction; that is, the edge `(a, b)` is the same as the edge `(b, a)`. Hence, the edges are *unordered pairs* represented as sets `{a, b}`.

A **directed graph** is one where the edges have directions; that is, the edge `(a, b)` is not the same as the edge `(b, a)`. These are represented as sets of *ordered pairs*.

An **Eulerian path** (or **Eulerian trail**) is a path in a graph which visits every edge exactly once.

Some common definitions:

- **order** of a graph   - Is the number of vertices in a graph denoted as `|V(G)|`.
- **size** of a graph    - Is the number of vertices in a graph, denoted as `|E(G)|`.
- **degree** of a vertex - Is the number of edges that connect to it.
- **connected** graph    - It is said of a graph that has a path for every pair of vertices it contains.

## Pre-Conditions

To answer whether or not a graph contains an Eulerian path, it is not necessary to find the path. It is possible to determine this by simply analyzing the degree (i.e., the number of edges connected to the node) of each node.

An *undirected graph* has an Eulerian path if and only if it is **connected** and **all vertices except possibly two have even degree**. One of those two vertices that have an odd degree must be the start vertex, and the other one must be the end vertex.

A *directed graph* has an Eulerian path if and only if it is **connected** and **each vertex except possibly two have the same in-degree as out-degree**. Also, if two vertices have different out-degree and in-degree, then one has an out-degree greater than its in-degree by one--the start node--and the other has an in-degree that is greater than its out-degree by one--the end node.
