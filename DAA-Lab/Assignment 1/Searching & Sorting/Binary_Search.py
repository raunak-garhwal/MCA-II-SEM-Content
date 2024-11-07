def binary_search(my_list, target_value):
    low = 0
    high = len(my_list) - 1

    while low <= high:
        mid = (low + high) // 2
        mid_value = my_list[mid]

        if mid_value == target_value:
            return mid  # Element found, return its index
        elif mid_value < target_value:
            low = mid + 1  # Discard the left half
        else:
            high = mid - 1  # Discard the right half

    return -1  # Element not found in the list