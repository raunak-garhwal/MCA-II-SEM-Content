def knapsack_greedy(weights, profits, capacity):
    n = len(weights)
    # Calculate profit-to-weight ratio for each item
    profit_per_weight = [(profits[i] / weights[i], weights[i], profits[i]) for i in range(n)]
    # Sort items based on profit-to-weight ratio in descending order
    profit_per_weight.sort(reverse=True, key=lambda x: x[0])

    total_profit = 0.0
    selected_items = []

    for _, weight, profit in profit_per_weight:
        if weight <= capacity:
            selected_items.append((weight, profit))
            capacity -= weight
            total_profit += profit
        else:
            # Take a fraction of the item to fill the knapsack
            # Note:- If you want only 0/1 knapsack, just comment the below 3 lines (except the break statement)
            fraction = capacity / weight
            total_profit += fraction * profit
            selected_items.append((fraction * weight, fraction * profit))
            break

    return total_profit, selected_items

# driver code
weights = []
profits = []

capacity = int(input("\nEnter Total Capacity : "))
elements = int(input("\nEnter how many elements you want to add : "))

for i in range(elements):
    element_weight = int(input(f"\nEnter the weight of element {i+1} : "))
    element_profit = int(input(f"Enter the profit of element {i+1} : "))
    weights.append(element_weight)
    profits.append(element_profit)

max_profit, selected_items = knapsack_greedy(weights, profits, capacity)

print("\n<--- Inserted Data --->")
print("Weights : ", weights)
print("Profits : ", profits)
print("Capacity : ", capacity)

print("\n<--- Final Solution --->")
print("Maximum profit : ", max_profit)
print("Selected items(W,P) : ", selected_items)