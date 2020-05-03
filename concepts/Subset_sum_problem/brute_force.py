'''
Brute force solution to the subset-sum problem.
We iterate over all pow(2, len(values)) combinations.
To this end, we use a list of bits on which we perform all those many increments.
We maintain a current sum along the way.
'''
def solve(values, target):
    
    # Collect solutions in a result list
    solutions = []
    
    # Initialize all bits (positions) to False
    bits = [False] * len(values)

    # Initialize current sum
    currentSum = 0

    # Loop over all binary numbers  - 1
    while True:

        if currentSum == target:
            selected = [v for i, v in enumerate(values) if bits[i]]
            solutions.append(selected)

        # Increment bits and adjust current sum along the way.
        # We are done once we run out of bits to increment.
        pos = 0
        while pos < len(values) and bits[pos] == True:
            bits[pos] = False
            currentSum -= values[pos]
            pos += 1            
        if pos == len(values):
            break
        else:
            bits[pos] = True
            currentSum += values[pos]

    return solutions
