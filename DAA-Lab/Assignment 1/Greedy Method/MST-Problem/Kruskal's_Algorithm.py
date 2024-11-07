def find(parent, i):
    if parent[i] == i:
        return i
    else:
        return find(parent, parent[i])

def union(parent, rank, x, y):
    xroot = find(parent, x)
    yroot = find(parent, y)
    
    if rank[xroot] < rank[yroot]:
        parent[xroot] = yroot
    elif rank[xroot] > rank[yroot]:
        parent[yroot] = xroot
    else:
        parent[yroot] = xroot
        rank[xroot] += 1

# Input details
weighted_graph = []
mst = []
parent = []
rank = []
min_cost = 0

no_of_vertices = int(input("\nEnter the no. of vertices in the graph : "))
no_of_edges = int(input("Enter the no. of edges in the graph : "))
print("\n --- Enter the details of the edge --- ")

for i in range(no_of_edges):
    v1 = int(input("\nEnter first vertex of the edge : "))
    v2 = int(input("Enter second vertex of the edge : "))
    w = int(input("Enter the weight of the edge : "))
    weighted_graph.append((v1, v2, w))

# Sort edges based on weight
weighted_graph.sort(key=lambda x: x[2])

# Initialize disjoint sets
for node in range(no_of_vertices):
    parent.append(node)
    rank.append(0)

# Kruskal's Algorithm
for edge in weighted_graph:
    u, v, w = edge
    uroot = find(parent, u)
    vroot = find(parent, v)
    
    if uroot != vroot:
        mst.append(edge)
        union(parent, rank, uroot, vroot)

# Print MST
print("\nMinimum Spanning Tree (MST):-")
for u, v, w in mst:
    print(f"Edge: {u} --- {v}, Weight: {w}")
    min_cost += w

print("\nThe Minimum Cost is :-", min_cost)