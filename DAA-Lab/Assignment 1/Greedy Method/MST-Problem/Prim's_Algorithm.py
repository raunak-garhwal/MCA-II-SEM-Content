weighted_graph = []
mst = []
min_cost = 0

no_of_vertices = int(input("\nEnter the no. of vertices in the graph : "))
no_of_edges = int(input("Enter the no. of edges in the graph : "))
print("\n --- Enter the details of the edge --- ")

for i in range(no_of_edges):
    v1 = int(input("\nEnter first vertex of the edge : "))
    v2 = int(input("Enter second vertex of the edge : "))
    w = int(input("Enter the weight of the edge : "))
    weighted_graph.append((v1, v2, w))

# Prim's Algorithm
selected_vertex = [False] * no_of_vertices
selected_vertex[0] = True  # Starting from vertex 0

while len(mst) < no_of_vertices - 1:
    min_edge = None
    
    for u, v, w in weighted_graph:
        if selected_vertex[u] and not selected_vertex[v]:
            if min_edge is None or w < min_edge[2]:
                min_edge = (u, v, w)
        elif selected_vertex[v] and not selected_vertex[u]:
            if min_edge is None or w < min_edge[2]:
                min_edge = (v, u, w)
    
    if min_edge is not None:
        u, v, w = min_edge
        mst.append((u, v, w))
        selected_vertex[v] = True

# Print MST
print("\nMinimum Spanning Tree (MST):-")
for u, v, w in mst:
    print(f"Edge: {u} - {v}, Weight: {w}")
    min_cost += w

print("\nThe Minimum Cost is :", min_cost)