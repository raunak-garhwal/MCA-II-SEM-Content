def binarysearch(arr,x):
    low = 0
    high = len(arr)-1


    while low <= high:

        mid =(high+low)// 2
        print("mid value is ", mid)

        # if arr[mid] == x:
        #     return mid
        
        # elif arr[mid] < x :

        #     low = mid +1

        # else:
            
        #     high = mid -1
        if arr[mid] < x :
            low =  mid + 1

        elif arr[mid] > x :

            high = mid - 1

        else :
            return mid       


    

    return  -1

        
