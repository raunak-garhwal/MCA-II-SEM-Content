def sum_of_subsets(weights, capacity):
    def backtrack(start, path, current_sum):
        
        if current_sum == capacity:
            result.append(path[:])
            return
        
        
        if current_sum > capacity:
            return
        
        
        for i in range(start, len(weights)):
        
            path.append(weights[i])
            backtrack(i + 1, path, current_sum + weights[i])
            path.pop()
    
    result = []
    backtrack(0, [], 0)
    return result


weights = []

size = int(input("Enter how many weights you want to add in Set : "))

for i in range(size):
    wgt = int(input(f"Enter {i+1} Weight : "))
    weights.append(wgt)
    
capacity =int(input("Enter the Capacity of Set : "))

print("Subsets with sum equal to target:", sum_of_subsets(weights, capacity))
