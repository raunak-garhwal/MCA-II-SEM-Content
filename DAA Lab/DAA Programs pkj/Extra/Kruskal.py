class DisjointSet:
    def __init__(self, n):
        self.parent = list(range(n))
        self.rank = [1] * n
    
    def find(self, u):
        if self.parent[u] != u:
            self.parent[u] = self.find(self.parent[u])  # Path compression
        return self.parent[u]
    
    def union(self, u, v):
        root_u = self.find(u)
        root_v = self.find(v)
        
        if root_u != root_v:
            # Union by rank
            if self.rank[root_u] > self.rank[root_v]:
                self.parent[root_v] = root_u
            elif self.rank[root_u] < self.rank[root_v]:
                self.parent[root_u] = root_v
            else:
                self.parent[root_v] = root_u
                self.rank[root_u] += 1
            return True
        return False

def kruskal_mst(graph):
    edges = []
    
    # Collect all edges from the graph
    for u in graph:
        for v, weight in graph[u]:
            edges.append((weight, u, v))
    
    # Sort edges based on weight
    edges.sort()
    
    # Initialize Disjoint Set for vertices
    ds = DisjointSet(len(graph))
    mst = []
    
    for weight, u, v in edges:
        if ds.union(u, v):
            mst.append((u, v, weight))
    
    return mst

# Example usage:
if __name__ == "__main__":
    # Example weighted graph represented as an adjacency list
    
    graph = {
        0: [(1, 2), (2, 4)],
        1: [(0, 2), (2, 1), (3, 3)],
        2: [(0, 4), (1, 1), (3, 5)],
        3: [(1, 3), (2, 5)]
    }
    
    # Finding Minimum Spanning Tree (MST) using Kruskal's algorithm
    mst = kruskal_mst(graph)
    minimumcost = 0
    # Print the Minimum Spanning Tree edges and weights
    print("Minimum Spanning Tree:")
    for u, v, weight in mst:
        minimumcost += weight
        print(f"Edge: {u} - {v}, Weight: {weight}")

    print("Minimum Spanning Tree : - ",minimumcost)
