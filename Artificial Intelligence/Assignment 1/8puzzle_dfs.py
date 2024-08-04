from collections import deque

# Define the goal state
goal_state = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 0]
]

# Directions for moving the blank space (0)
directions = {
    'up': (-1, 0),
    'down': (1, 0),
    'left': (0, -1),
    'right': (0, 1)
}

def is_goal(state):
    return state == goal_state

def get_blank_position(state):
    for i in range(3):
        for j in range(3):
            if state[i][j] == 0:
                return (i, j)
    return None

def move(state, direction):
    new_state = [row[:] for row in state]
    blank_pos = get_blank_position(new_state)
    i, j = blank_pos
    di, dj = directions[direction]
    new_i, new_j = i + di, j + dj

    if 0 <= new_i < 3 and 0 <= new_j < 3:
        # Swap the blank with the target cell
        new_state[i][j], new_state[new_i][new_j] = new_state[new_i][new_j], new_state[i][j]
        return new_state
    return None

def dfs(initial_state):
    stack = [initial_state]
    visited = set()
    visited.add(tuple(tuple(row) for row in initial_state))
    parent_map = {tuple(tuple(row) for row in initial_state): None}

    while stack:
        current_state = stack.pop()
        if is_goal(current_state):
            return reconstruct_path(parent_map, current_state)
        
        for direction in directions:
            new_state = move(current_state, direction)
            if new_state is not None:
                new_state_tuple = tuple(tuple(row) for row in new_state)
                if new_state_tuple not in visited:
                    visited.add(new_state_tuple)
                    parent_map[new_state_tuple] = current_state
                    stack.append(new_state)
    return None

def reconstruct_path(parent_map, end_state):
    path = []
    state = end_state
    while state is not None:
        path.append(state)
        state = parent_map[tuple(tuple(row) for row in state)]
    path.reverse()
    return path

def print_path(path):
    for state in path:
        for row in state:
            print(row)
        print()

# Example usage
initial_state = [
    [1, 2, 3],
    [4, 0, 6],
    [7, 5, 8]
]

path = dfs(initial_state)
if path:
    print_path(path)
else:
    print("No solution found.")
