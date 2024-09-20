#quick sort using list comprehension

def Quicksort(arr):
    if len(arr) <= 1 :
        return arr

    else:
        pivot = arr[0]
        left=[x for x in arr[1:] if x < pivot]
        right=[x for x in arr[1:] if x >= pivot]
        return Quicksort(left)+ [pivot]+ Quicksort(right)

arr =[]
n=int(input("Enter how many element you want to add for Quick sort  :- "))

for i in range(n):
    num =float(input(f"Enter {i+1} element for Quick sort  :- "))
    arr.append(num)
    
print("Unsorted Array :- ")
print(arr)
print("sorted Array :- ")
print(Quicksort(arr))
    
