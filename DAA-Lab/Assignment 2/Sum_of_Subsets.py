def sum_of_subsets(nums, target):
    result = []

    # Recursive function to find subsets
    def find_subsets(index, current_subset):
        # Base case: Check if the sum of the current subset matches the target
        if sum(current_subset) == target:
            result.append(current_subset)
            return
        
        # Stop recursion if the end of the list is reached
        if index == len(nums):
            return
        
        # Explore including the current number
        find_subsets(index + 1, current_subset + [nums[index]])
        
        # Explore excluding the current number
        find_subsets(index + 1, current_subset)

    # Start the recursive function from the first index
    find_subsets(0, [])
    return result

nums = list(map(int, input("\nEnter the numbers in the set separated by spaces: ").split()))
target = int(input("\nEnter the target sum: "))

subsets = sum_of_subsets(nums, target)
if subsets:
    print(f"\nSubsets that sum to {target} are:-", subsets)
else:
    print(f"\nNo Subsets found that sum to {target}.")


# def subsets(arr, target, list, index=0):
#     if sum(list) == target:
#         print(list)
#     if sum(list) > target or index == len(arr):
#         return

#     for i in range(index, len(arr)):
#         subsets(arr, target, list + [arr[i]], i + 1)

# if _name_ == "_main_":
#     n = int(input("How many element u want to add in list: "))
#     arr = []
#     list = []
#     for i in range(n):
#         v = int(input(f"enter {i + 1} element "))
#         arr.append(v)
#     target = int(input("enter the value which u want to find sum of subset: "))
#     print("Subsets that sum to", target, ":")
#     subsets(arr, target, list)