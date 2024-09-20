class UnionFind:
    def __init__(self, size):
        self.parent = list(range(size))
        self.rank = [0] * size

    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def union(self, x, y):
        rootX = self.find(x)
        rootY = self.find(y)
        
        if rootX != rootY:
            if self.rank[rootX] > self.rank[rootY]:
                self.parent[rootY] = rootX
            elif self.rank[rootX] < self.rank[rootY]:
                self.parent[rootX] = rootY
            else:
                self.parent[rootY] = rootX
                self.rank[rootX] += 1

def main():
    # Number of elements
    n = int(input("Enter the number of elements: "))
    uf = UnionFind(n)
    
    # Input sets
    sets = []
    for i in range(2):
        print(f"Enter elements for set {i+1} (separate elements by space):")
        elements = list(map(int, input().split()))
        sets.append(elements)
    
    # Map elements to indices
    element_to_index = {}
    index = 0
    for element_set in sets:
        for element in element_set:
            if element not in element_to_index:
                element_to_index[element] = index
                index += 1

    print("\nElement to index mapping:")
    for element, idx in element_to_index.items():
        print(f"Element {element} -> Index {idx}")

    # Perform union operations
    while True:
        print("\nOptions:")
        print("1. Union")
        print("2. Exit")
        option = int(input("Choose an option (1/2): "))
        
        if option == 1:
            # Union operation
            x = int(input("Enter the first element to union: "))
            y = int(input("Enter the second element to union: "))
            
            if x in element_to_index and y in element_to_index:
                x_index = element_to_index[x]
                y_index = element_to_index[y]
                uf.union(x_index, y_index)
                print(f"Union of {x} and {y} performed.")
            else:
                print("One or both elements are not in the initial sets.")
                
        elif option == 2:
            print("Exiting...")
            break
            
        else:
            print("Invalid option. Please try again.")

if __name__ == "__main__":
    main()
