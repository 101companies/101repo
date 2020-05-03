'''
Optimized solution to the subset-sum problem.
We use recursion to choose to select any given value or not.
We enforce some bounds for opptimization, thereby curtail recursion.
'''

def solve(values, target):

    # Collect solutions in a result list
    solutions = []

    values.sort(reverse=True)

    def recurse(
        selected,  # Elements selected so far
        sofar,  # Sum of selected
        available,  # Elements still available for selection
        promise,  # Sum of available
    ):

        nonlocal solutions

        # Met target!
        if sofar == target:
            solutions.append(selected.copy())

        # Greater equal target; don't select more numbers
        if sofar >= target:
            return

        # Nothing left to be selected
        if len(available) == 0:
            return

        head = available[0]
        tail = available[1:]
        
        # Skip head
        if sofar + promise - head >= target:
            recurse(selected, sofar, tail, promise-head)

        # Recursion while selecting head of available numbers
        selected.append(head)
        recurse(selected, sofar+head, tail, promise-head)
        selected.pop()

    recurse([], 0, values, sum(values))
    return solutions
