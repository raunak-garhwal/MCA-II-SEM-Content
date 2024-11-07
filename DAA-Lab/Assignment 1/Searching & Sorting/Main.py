import Quick_Sort
import Merge_Sort
import Binary_Search

if __name__ == "__main__":
    print("\n--- Welcome to the Menu Driven Program ---")

    while(True):
        print("\nPress 1 to perform Merge Sort.\nPress 2 to perform Quick Sort.\nPress 3 to exit.")

        try:
            choice = int(input("\nEnter your choice: "))
        except:
            print("\nWARNING :- Please enter a valid numerical value.")
        else:    
            if choice == 1:
                my_list = list(map(int, input("\nEnter the elements of the list separated by spaces: ").split()))
                
                Merge_Sort.merge_sort(my_list)
                print(f"List after performing Merge sort: {my_list}")
                target = int(input("Enter the element to search in the list: "))
                result = Binary_Search.binary_search(my_list, target)

                if result != -1:
                    print(f"Element {target} found at index {result}.")
                else:
                    print(f"Element {target} not found in the list.")
                    
            elif choice == 2:
                my_list = list(map(int, input("\nEnter the elements of the list separated by spaces: ").split()))

                s = 0
                e = len(my_list)-1
                Quick_Sort.quick_sort(my_list,s,e)
                print(f"List after performing Quick sort: {my_list}")
                target = int(input("Enter the element to search in the list: "))
                result = Binary_Search.binary_search(my_list, target)

                if result != -1:
                    print(f"Element {target} found at index {result}.")
                else:
                    print(f"Element {target} not found in the list.")

            elif choice == 3:
                print("\nThanks for using this program. Please come back soon.....")
                break
                
            else:
                print("\nUNAVAILABLE-INPUT :- Please enter a valid available choice.")