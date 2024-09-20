import sys

def tsp(dist):
    n = len(dist)
    dp = [[None] * n for _ in range(1 << n)]
    
    # Base case: Start from the first city (0) and visit all others
    for i in range(n):
        dp[1 << i][i] = dist[0][i]
    
    # Iterate through all subsets of cities
    for mask in range(1 << n):
        for i in range(n):
            if dp[mask][i] is None:
                continue
            # Try to visit all cities not yet visited
            for j in range(n):
                if mask & (1 << j) == 0:
                    next_mask = mask | (1 << j)
                    new_cost = dp[mask][i] + dist[i][j]
                    if dp[next_mask][j] is None or dp[next_mask][j] > new_cost:
                        dp[next_mask][j] = new_cost
    
    # Final step: Complete the cycle by returning to the starting city (0)
    result = min(dp[(1 << n) - 1][i] + dist[i][0] for i in range(1, n))
    
    return result

# Example usage:
dist_matrix = []

order = int(input("Enter order of Mtrix : "))

print("Add elements into matrix :" )

for i in range(order):
    str_row =input(f"Enter element in {i+1} row (Seprated by space) : ").split()
    int_row =[int(x) for x in str_row]
    dist_matrix.append(int_row)
    
print(dist_matrix)

print(f"Minimum cost of TSP: {tsp(dist_matrix)}")
