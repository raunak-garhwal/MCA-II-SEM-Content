class UnionFind:
    def __init__(self, size):
        self.parent = list(range(size))
        self.rank = [0] * size

    def find(self, u):
        if self.parent[u] != u:
            self.parent[u] = self.find(self.parent[u])
        return self.parent[u]

    def union(self, u, v):
        root_u = self.find(u)
        root_v = self.find(v)
        
        if root_u != root_v:
            if self.rank[root_u] > self.rank[root_v]:
                self.parent[root_v] = root_u
            elif self.rank[root_u] < self.rank[root_v]:
                self.parent[root_u] = root_v
            else:
                self.parent[root_v] = root_u
                self.rank[root_u] += 1





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

# Process edges in sorted order
for v1, v2, weight in graph:
    if uf.find(v1) != uf.find(v2):
        uf.union(v1, v2)
        mst.append((v1, v2, weight))

minimumcost=0        

for u, v, weight in mst:
        minimumcost += weight
        print(f"\nEdge: {u} - {v}, Weight: {weight}")
        
print("\nMinimum Cost : - ",minimumcost)        

print("\nMinimum Spanning Tree (v1,v2,weight) ")
print(mst)
