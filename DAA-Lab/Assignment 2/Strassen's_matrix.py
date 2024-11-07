def createMatrix(n):
    """Creates a matrix of order n by taking user input."""
    print("\nEnter the elements of the Matrix :-")
    temp_matrix = []
    for _ in range(n):
        row = list(map(int, input("Enter the elements row-wise with spaces: ").split()))
        if len(row) != n:
            print(f"Error: Expected {n} elements, but got {len(row)}. Please try again.")
            return createMatrix(n)  # Recursively prompt until correct input
        temp_matrix.append(row)
    return temp_matrix

def printMatrix(matrix):
    """Prints a matrix in a readable format."""
    for row in matrix:
        print(" ".join(map(str, row)))
    print()

def isPowerOfTwo(n):
    """Checks if a number is a power of 2."""
    return (n & (n-1) == 0) and n != 0

def add_matrix(A, B):
    """Adds two matrices."""
    return [[A[i][j] + B[i][j] for j in range(len(A[0]))] for i in range(len(A))]

def subtract_matrix(A, B):
    """Subtracts matrix B from matrix A."""
    return [[A[i][j] - B[i][j] for j in range(len(A[0]))] for i in range(len(A))]

def strassen(A, B):
    """Perform Strassen's matrix multiplication."""
    n = len(A)
    
    if n == 1:
        # Base case: 1x1 matrix multiplication
        return [[A[0][0] * B[0][0]]]

    # Split matrices into quarters
    mid = n // 2
    A11 = [row[:mid] for row in A[:mid]]
    A12 = [row[mid:] for row in A[:mid]]
    A21 = [row[:mid] for row in A[mid:]]
    A22 = [row[mid:] for row in A[mid:]]

    B11 = [row[:mid] for row in B[:mid]]
    B12 = [row[mid:] for row in B[:mid]]
    B21 = [row[:mid] for row in B[mid:]]
    B22 = [row[mid:] for row in B[mid:]]

    # Compute intermediate matrices
    M1 = strassen(add_matrix(A11, A22), add_matrix(B11, B22))
    M2 = strassen(add_matrix(A21, A22), B11)
    M3 = strassen(A11, subtract_matrix(B12, B22))
    M4 = strassen(A22, subtract_matrix(B21, B11))
    M5 = strassen(add_matrix(A11, A12), B22)
    M6 = strassen(subtract_matrix(A21, A11), add_matrix(B11, B12))
    M7 = strassen(subtract_matrix(A12, A22), add_matrix(B21, B22))

    # Combine intermediate matrices to get the final result
    C11 = add_matrix(subtract_matrix(add_matrix(M1, M4), M5), M7)
    C12 = add_matrix(M3, M5)
    C21 = add_matrix(M2, M4)
    C22 = add_matrix(subtract_matrix(add_matrix(M1, M3), M2), M6)

    # Combine submatrices into one matrix
    C = []
    for i in range(mid):
        C.append(C11[i] + C12[i])
    for i in range(mid):
        C.append(C21[i] + C22[i])

    return C

# Input matrix size and validate power of two
n = int(input("\nEnter the order of matrix :- "))
while not isPowerOfTwo(n):
    print(f"{n} is not a power of 2. Please enter the order of matrix in a power of 2.")
    n = int(input("Enter the order of matrix :- "))

# Create matrices A and B
print("\nEnter data for Matrix A :-")
A = createMatrix(n)
print("\nEnter data for Matrix B :-")
B = createMatrix(n)

# Display matrices
print("\nMatrix A :-")
printMatrix(A)
print("Matrix B :-")
printMatrix(B)

# Perform Strassen's multiplication
result = strassen(A, B)
print("Result of Strassen's Matrix Multiplication :-")
printMatrix(result)