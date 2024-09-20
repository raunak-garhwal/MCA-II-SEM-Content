def add_matrix(A, B):
    """Add two matrices."""
    return [[A[i][j] + B[i][j] for j in range(len(A[0]))] for i in range(len(A))]

def subtract_matrix(A, B):
    """Subtract matrix B from matrix A."""
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

# Example usage
A = []

B = []

orderA = int(input("Enter order of Mtrix A : "))

print("Add elements into A matrix :" )

for i in range(orderA):
    str_rowa =input(f"Enter element in {i+1} row (Seprated by space) : ").split()
    int_rowa =[int(x) for x in str_rowa]
    A.append(int_rowa)
    
print(A)

orderB = int(input("Enter order of Mtrix B : "))

print("Add elements into B matrix :" )

for i in range(orderB):
    str_rowb =input(f"Enter element in {i+1} row (Seprated by space) : ").split()
    int_rowb =[int(x) for x in str_rowb]
    B.append(int_rowb)
    
print(B) 

result = strassen(A, B)
print("Result of Strassen's matrix multiplication:")
for row in result:
    print(row)
