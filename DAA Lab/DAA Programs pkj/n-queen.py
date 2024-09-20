def solve_n_queens(n):
    def is_safe(board, row, col):
        for i in range(row):
            if board[i] == col or \
               board[i] - i == col - row or \
               board[i] + i == col + row:
                return False
        return True

    def solve(board, row):
        if row >= n:
            result.append(board[:])
            return
        
        for col in range(n):
            if is_safe(board, row, col):
                board[row] = col
                solve(board, row + 1)
                # Backtrack
                board[row] = -1

    result = []
    board = [-1] * n
    solve(board, 0)
    return result

def print_solutions(solutions):
    for solution in solutions:
        for row in solution:
            print(' '.join('Q' if i == row else '.' for i in range(len(solution))))
        print()

if __name__ == "__main__":
    while True:
        try:
            n = int(input("Enter the number of Queens (between 4 and 6): "))
            if 4 <= n <= 6:
                break
            else:
                print("Please enter a number between 4 and 6.")
        except ValueError:
            print("Invalid input. Please enter an integer.")
    solutions = solve_n_queens(n)
    print(f"Total solutions for {n}-Queens problem: {len(solutions)}")
    print_solutions(solutions)
