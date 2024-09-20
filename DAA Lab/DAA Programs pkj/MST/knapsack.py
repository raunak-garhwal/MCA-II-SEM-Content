def knapsack_greedy(weights, values, capacity):
    n = len(weights)
    # Calculate value-to-weight ratio for each item
    value_per_weight = [(values[i] / weights[i], weights[i], values[i]) for i in range(n)]
    # Sort items based on value-to-weight ratio in descending order
    value_per_weight.sort(key=lambda x: x[0])
    # value_per_weight.sort(reverse=True,key=lambda x: x[0])

    total_value = 0
    total_weight = 0
    selected_items = []

    for weight, value in value_per_weight:
        if total_weight + weight <= capacity:
            selected_items.append((weight, value))
            total_weight += weight
            total_value += value
        else:
            break

    return total_value, selected_items

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


max_value, selected_items = knapsack_greedy(weights, values, capacity)
print("Maximum value:", max_value)
print("Selected items:", selected_items)
