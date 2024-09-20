graph = {}

node_count = int(input("How many nodes you want to enter :- "))

for key in range(node_count):
  
  node = input("Enter Node :- ")
  neighbours = input("Enter neighbours of above node(seprated by spaces) :- ").split()
  graph[node] = neighbours

print("Graph :" ,graph)

visited = set()

def dfs(visited, graph, node):
  
    if node not in visited:
        print (node)
        visited.add(node)
        for neighbour in graph[node]:
            dfs(visited, graph, neighbour)

n = input("Enter Node to Traverse:- ")
print("Following is the Depth-First Search")
dfs(visited, graph, n)
