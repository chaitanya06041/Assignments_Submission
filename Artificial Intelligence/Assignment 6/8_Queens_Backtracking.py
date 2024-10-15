def is_safe(board, row, col):    # Checking constraints
    for i in range(row - 1, -1, -1):   # Vertically upward
        if board[i][col] == 'Q':
            return False

    for i, j in zip(range(row - 1, -1, -1), range(col - 1, -1, -1)):   # Upper left diagonal
        if board[i][j] == 'Q':
            return False

    for i, j in zip(range(row - 1, -1, -1), range(col + 1, len(board))):   # Upper right diagonal
        if board[i][j] == 'Q':
            return False

    return True


def n_queens(board, row):
    if row == len(board):
        # Print the final board configuration
        for i in range(len(board)):
            for j in range(len(board)):
                print(board[i][j], end=' ')
            print()
        print()  # Blank line after the board
        return True  # Return True when a solution is found

    for i in range(len(board)):
        if is_safe(board, row, i):
            board[row][i] = 'Q'  # Place the queen
            if n_queens(board, row + 1):  # Recursion call
                return True  # Stop after finding the first solution
            board[row][i] = '.'  # Backtracking step


if __name__ == "__main__":
    n = 8
    board = [['.' for _ in range(n)] for _ in range(n)]
    if not n_queens(board, 0):
        print("No solution found.")
