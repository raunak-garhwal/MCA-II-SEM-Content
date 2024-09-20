graph = {}

node = int(input("How many nodes you want to enter :- "))
for key in range(node):
  nodes = input("Enter Node :- ")
  neighbours =input("Enter neighbours of above node(seprated by spaces) :- ").split()
  graph[nodes]=neighbours

print("Graph :- ",graph)

visited = [] 
queue = []     

def bfs(visited, graph, node): 
  visited.append(node)
  queue.append(node)

  while queue:          
    m = queue.pop(0) 
    print (m, end = " ") 

    for neighbour in graph[m]:
      if neighbour not in visited:
        visited.append(neighbour)
        queue.append(neighbour)
        
n=input("Enter Node To Traverse :- ")

print("Following is the Breadth-First Search :- ")
bfs(visited, graph, n)
