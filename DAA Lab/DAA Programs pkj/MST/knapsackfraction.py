def knapsack_greedy(weights, values, capacity):
    n = len(weights)
    # Calculate value-to-weight ratio for each item
    value_per_weight = [(values[i] / weights[i], weights[i], values[i]) for i in range(n)]
    # Sort items based on value-to-weight ratio in descending order
    value_per_weight.sort(reverse=True, key=lambda x: x[0])

    total_value = 0
    total_weight = 0
    selected_items = []
    

    for ratio,weight, value in value_per_weight:
        if total_weight + weight <= capacity:
            selected_items.append((weight, value))
            total_weight += weight
            total_value += value
        else:
            # Calculate remaining capacity
            remaining_capacity = capacity - total_weight
            # Take a fraction of the item to fill the knapsack
            fraction = remaining_capacity / weight
            total_value += fraction * value
            total_weight += fraction * weight
            selected_items.append((fraction * weight, fraction * value))
            break

    return total_value, selected_items

# Example usage:
weights = []
values = []

elements =int(input("Enter how many elements you want to add : "))

for i in range(elements):
    elmntweight=int(input(f"Enter the weight of element {i+1} : "))
    elementvalue = int(input(f"Enter element {i+1} value : "))
    weights.append(elmntweight)
    values.append(elementvalue)


capacity =int(input("Enter Total Capacity : "))


print("Weights : ",weights)
print("Values : ",values)
print("Capacity : ",capacity)



total_value, selected_items = knapsack_greedy(weights, values, capacity)

print("\nMaximum value:", total_value)
print("Selected items:", selected_items)
