# Initialize a string direction which represents all the directions.
direction = "DLRU"

# Arrays to represent change in rows and columns
dr = [1, 0, 0, -1]
dc = [0, -1, 1, 0]

# Function to check if cell(row, col) is inside the maze and unblocked
def is_valid(row, col, maze, n):
    return 0 <= row < n and 0 <= col < n and maze[row][col] == 1

# Function to get all valid paths
def find_path(row, col, maze, n, result, current_path):
    # If we reach the bottom right cell of the matrix, add the current path to result and return
    if row == n - 1 and col == n - 1:
        result.append(current_path)
        return
    
    # Mark the current cell as blocked
    maze[row][col] = 0

    for i in range(4):
        # Find the next row based on the current row (row) and the dr[] array
        next_row = row + dr[i]
        # Find the next column based on the current column (col) and the dc[] array
        next_col = col + dc[i]
        
        # Check if the next cell is valid or not
        if is_valid(next_row, next_col, maze, n):
            current_path += direction[i]
            # Recursively call the find_path function for the next cell
            find_path(next_row, next_col, maze, n, result, current_path)
            # Remove the last direction when backtracking
            current_path = current_path[:-1]

    # Mark the current cell as unblocked
    maze[row][col] = 1

# Driver code
maze = []
result = []
current_path = ""
n = int(input("\nEnter the order of Maze : "))
print("\nAdd path into the Maze :-\n" )

for i in range(n):
    row = list(map(int,input(f"Enter routes in row {i+1} (seperated by spaces) : ").split()))
    maze.append(row)

print("\nMaze :-\n")
for row in maze:    
    print(" ".join(map(str,row)))

if maze[0][0] != 0 and maze[n - 1][n - 1] != 0:
    find_path(0, 0, maze, n, result, current_path)

if not result:
    print("\nNo Path is available......")
else:
    print("\nAvailable Paths :- ")
    print(" ".join(result))