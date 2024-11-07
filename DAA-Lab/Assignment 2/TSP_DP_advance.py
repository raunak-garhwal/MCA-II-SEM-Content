def tsp(dist_matrix):
    n = len(dist_matrix)
    # DP table to store the minimum cost to reach each subset of cities ending at a specific city
    dp = [[float('inf')] * n for _ in range(1 << n)]
    # Table to track the previous city to help reconstruct the path
    parent = [[-1] * n for _ in range(1 << n)]

    # Start at city 0 with only city 0 visited
    dp[1][0] = 0

    # Iterate over all possible subsets of cities
    for mask in range(1 << n):
        for i in range(n):
            if dp[mask][i] == float('inf'):
                continue
            # Try to visit all unvisited cities
            for j in range(n):
                if mask & (1 << j) == 0:  # If city j is not visited
                    next_mask = mask | (1 << j)
                    new_cost = dp[mask][i] + dist_matrix[i][j]
                    if new_cost < dp[next_mask][j]:
                        dp[next_mask][j] = new_cost
                        parent[next_mask][j] = i

    # Find the minimum cost to return to the starting city (0)
    final_mask = (1 << n) - 1  # All cities visited
    min_cost = min(dp[final_mask][i] + dist_matrix[i][0] for i in range(1, n))
    last_city = min(range(1, n), key=lambda i: dp[final_mask][i] + dist_matrix[i][0])

    # Reconstruct the best path
    best_path = [0]
    mask = final_mask
    while last_city != -1:
        best_path.append(last_city)
        temp = last_city
        last_city = parent[mask][last_city]
        mask ^= (1 << temp)

    best_path.reverse()

    return min_cost, best_path


# Driver code
dist_matrix = []

order = int(input("\nEnter order of the Matrix : "))

print("\nEnter elements into the Matrix :-")

for i in range(order):
    row = list(map(int, input(f"Enter elements in row {i+1} (separated by space) :- ").split()))
    dist_matrix.append(row)

print("\nDistance Matrix :-")
for row in dist_matrix:
    print(" ".join(map(str, row)))

min_cost, best_path = tsp(dist_matrix)

print(f"\nMinimum cost of TSP :- {min_cost}")
print("\nBest path :-")
print(" -> ".join(f"City {i}" for i in best_path))