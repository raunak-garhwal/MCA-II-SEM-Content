import heapq

def prims_mst(vertices, edges):
    # Create an adjacency list from the edge list
    adj = {i: [] for i in range(vertices)}
    for u, v, weight in edges:
        adj[u].append((weight, v))
        adj[v].append((weight, u))

    # Initialize Prim's algorithm structures
    in_mst = [False] * vertices
    min_heap = [(0, 0)]  # (weight, vertex) - start with vertex 0 with weight 0
    mst_edges = []
    minimum_cost = 0

    while min_heap:
        weight, u = heapq.heappop(min_heap)

        if in_mst[u]:
            continue

        # Include this edge in the MST
        in_mst[u] = True
        minimum_cost += weight
        if weight > 0:  # Skip the starting vertex with weight 0
            mst_edges.append((prev, u, weight))

        # Update the heap with the edges from the current vertex
        for next_weight, v in adj[u]:
            if not in_mst[v]:
                heapq.heappush(min_heap, (next_weight, v))
                prev = u

    return mst_edges, minimum_cost

# Input and execution
graph = []

No_of_vertices = int(input("Enter Number of Vertices : "))
No_of_edges = int(input("Enter Number of edges : "))

print("\nEnter The Details of Edges : ")

for i in range(No_of_edges):
    v1 = int(input("\nEnter First vertex of Edge :- "))
    v2 = int(input("Enter Second vertex of Edge :- "))
    weight = int(input("Enter assigned weight  :- "))
    graph.append((v1, v2, weight))

# Compute MST using Prim's algorithm
mst, minimum_cost = prims_mst(No_of_vertices, graph)

print("\nMinimum Spanning Tree (v1,v2,weight):")
for u, v, weight in mst:
    print(f"Edge: {u} - {v}, Weight: {weight}")

print("Minimum Cost: ", minimum_cost)
