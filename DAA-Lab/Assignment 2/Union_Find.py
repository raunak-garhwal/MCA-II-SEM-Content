class UnionFind:
    def __init__(self, size):
        # Initialize the parent and rank arrays
        self.parent = list(range(size))  # Each element is its own parent initially
        self.rank = [0] * size  # Used to keep the tree flat

    def find(self, x):
        # Find the root of the set containing x with path compression
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])  # Path compression
        return self.parent[x]

    def union(self, x, y):
        # Merge the sets containing x and y
        rootX = self.find(x)
        rootY = self.find(y)

        if rootX != rootY:
            # Union by rank
            if self.rank[rootX] > self.rank[rootY]:
                self.parent[rootY] = rootX
            elif self.rank[rootX] < self.rank[rootY]:
                self.parent[rootX] = rootY
            else:
                self.parent[rootY] = rootX
                self.rank[rootX] += 1

    def connected(self, x, y):
        # Check if x and y are in the same set
        return self.find(x) == self.find(y)


try:
    size = int(input("\nEnter the number of elements: "))
    uf = UnionFind(size)

    while True:
        print("\nChoose an operation:")
        print("1. Union (merge two sets)")
        print("2. Find (check if two elements are connected)")
        print("3. Exit")
        choice = input("Enter your choice: ")

        if choice == '1':
            # Merge two sets
            x, y = map(int, input("Enter two elements to union (space-separated): ").split())
            if x < 0 or x >= size or y < 0 or y >= size:
                print("Invalid elements! Enter numbers between 0 and", size - 1)
                continue
            uf.union(x, y)
            print(f"Merged sets containing {x} and {y}.")

        elif choice == '2':
            # Check if two elements are connected
            x, y = map(int, input("Enter two elements to check connection (space-separated): ").split())
            if x < 0 or x >= size or y < 0 or y >= size:
                print("Invalid elements! Enter numbers between 0 and", size - 1)
                continue
            if uf.connected(x, y):
                print(f"{x} and {y} are in the same set.")
            else:
                print(f"{x} and {y} are in different sets.")

        elif choice == '3':
            print("Exiting...")
            break

        else:
            print("Invalid choice! Please choose a valid operation.")

except ValueError:
    print("Invalid input! Please enter valid integers.")