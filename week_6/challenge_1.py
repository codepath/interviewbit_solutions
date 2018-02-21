### Max Sum Without Adjacent Elements
def max_sum(grid):
    # Parameters: grid is a list of two lists of N integers
    # Perform: Find the maximum sum by choosing numbers that are not adjacent to
    #   each other (cannot be adjacent horizontally, vertically, or diagonally)
    # Ouptput: The maximum sum of the chosen non-adjacent numbers

    # Count columns
    n = len(grid[0])
    if n == 0:
        return 0

    # Fill the memoization array
    maxsums = [0] * n

    # Answer the first column, handle base case
    maxsums[0] = max(grid[0][0], grid[1][0])

    # Answer the first quad
    if n > 1:
        maxsums[1] = max(maxsums[0], grid[0][1], grid[1][1])

    # Answer any additional columns by comparing the last solution to the current max + the solution 2 columns ago
    if n > 2:
        for i in range(2, n):
            maxsums[i] = max(maxsums[i - 1], max(grid[0][i], grid[1][i]) + maxsums[i - 2])

    return maxsums[-1]
