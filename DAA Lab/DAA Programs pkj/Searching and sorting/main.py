import Binarysearch;
import Mergesort;
import Quicksort;

def main():

    while(True):
        
        print("\nChose a option to perform action :- ")
        print("[1].Add Number in the list :- ")
        print("[2].Apply Mergesort :- ")
        print("[3].Apply Quicksort :- ")

        optn = int(input("Enter option :- "))

        if optn==1:

            arr =[]

            n = int(input("Enter how many elements you want to add :- "))

            for i in range(n):
                a= int(input(f"Enter {i+1} Element :- "))
                arr.append(a)

            print("\nArray : ",arr)

        elif optn ==2:

            merge = Mergesort.mergesort(arr)
            print("Sorted array is :- ",arr)
            
            x= int(input("Enter element to search :- "))
            bnry=Binarysearch.binarysearch(arr,x)
            print(bnry)

            if bnry != -1 :
                print("Element is present at index ", str(bnry))

            else :
                print("Element is not present ")   
            

        elif optn ==3:

            quick = Quicksort.quicksort(arr)
            print("\nSorted array is :- ",arr)
            
            x= int(input("Enter element to search :- "))
            bnry=Binarysearch.binarysearch(arr,x)

            if bnry != -1 :
                print("Element is present at index ",str(bnry))

            else :
                print("Element is not present ")  

        else:
            print("Please enter a valid option")          

main()
            

            
            
                

  

    
