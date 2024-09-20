def prim_mst(graph):
    V = len(graph)  # Number of vertices in the graph
    if V == 0:
        return []

    # Initialize MST to store the edges of the minimum spanning tree
    mst = []
    
    # Priority queue to store tuples of (weight, u, v)
    pq = [(0, 0, None)]  # Start from vertex 0 with weight 0 and no parent
    visited = set()     # Set to track visited vertices
    
    while pq:
        weight, v, parent = min(pq)  # Extract minimum weight edge
        pq.remove((weight, v, parent))  # Remove from priority queue
        
        if v not in visited:
            visited.add(v)  # Mark vertex as visited
            
            if parent is not None:
                mst.append((parent, v, weight))  # Add edge to MST
            
            # Add all adjacent edges to the priority queue
            for u, weight in graph.get(v, []):
                if u not in visited:
                    pq.append((weight, u, v))
    
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
    
    # Finding Minimum Spanning Tree (MST) using Prim's algorithm
    mst = prim_mst(graph)
    
    # Print the Minimum Spanning Tree edges and weights
    print("Minimum Spanning Tree:")
    for u, v, weight in mst:
        print(f"Edge: {u} - {v}, Weight: {weight}")
