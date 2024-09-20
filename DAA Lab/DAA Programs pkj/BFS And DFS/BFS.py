graph = {}

node_count = int(input("How many nodes you want to enter: "))
for key in range(node_count):
    node = input("Enter Node: ")
    neighbours = input("Enter neighbours of above node (separated by spaces): ").split()
    graph[node] = neighbours

print("Graph :", graph)

visited = {}  
queue = []

def bfs(visited, graph, node):
    front = 0
    visited[node] = True
    queue.append(node)

    while front < len(queue):
        m = queue[front]
        front += 1
        print(m, end=" ")

        for neighbour in graph[m]:
            if neighbour not in visited:
                visited[neighbour] = True
                queue.append(neighbour)

start_node = input("Enter Node to Traverse: ")
print("Following is the Breadth-First Search:")
bfs(visited, graph, start_node)
