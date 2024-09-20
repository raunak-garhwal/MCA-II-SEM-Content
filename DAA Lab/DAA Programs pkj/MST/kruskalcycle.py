class UnionFind:
    def __init__(self, size):
        self.parent = list(range(size))
        self.rank = [0] * size

    def find(self, u):
        if self.parent[u] != u:
            self.parent[u] = self.find(self.parent[u])  # Path compression
        return self.parent[u]

    def union(self, u, v):
        root_u = self.find(u)
        root_v = self.find(v)
        
        if root_u == root_v:
            return False  # They are already in the same set; union would create a cycle
        
        # Union by rank
        if self.rank[root_u] > self.rank[root_v]:
            self.parent[root_v] = root_u
        elif self.rank[root_u] < self.rank[root_v]:
            self.parent[root_u] = root_v
        else:
            self.parent[root_v] = root_u
            self.rank[root_u] += 1
        
        return True  # Union was successful

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

# Sort edges based on weight
graph.sort(key=lambda x: x[2])

# Initialize Union-Find
uf = UnionFind(No_of_vertices)

mst = []
cycle_edges = []

# Process edges in sorted order
for v1, v2, weight in graph:
    if uf.union(v1, v2):
        mst.append((v1, v2, weight))
    else:
        cycle_edges.append((v1, v2, weight))

minimumcost = 0

print("\nMinimum Spanning Tree : ")

for u, v, weight in mst:
    minimumcost += weight
    print(f"Edge: {u} - {v}, Weight: {weight}")

print("Minimum Cost : - ", minimumcost)        


print("\nEdges that would create a cycle if added:")
for u, v, weight in cycle_edges:
    print(f"Edge: {u} - {v}, Weight: {weight}")
