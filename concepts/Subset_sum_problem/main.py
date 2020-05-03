'''
Solve some instances of the subset sum problem.
We use two different solutions: a brute force one and an optimized one.
We use an extra driver to time and print the solutions.
'''

# Measure elapsed time
import time

# Import sample data
import samples

# Imports solutions
import brute_force
import optimized


# Common driver code
def run(sample, solver):
    start = time.time()    
    solutions = solver(sample[0], sample[1])
    end = time.time()
    for selected in solutions:
        formula = '+'.join((str(v) for v in selected))
        actual = sum(selected)
        print(f"{formula} = {actual}")
        assert actual == sample[1]
    print(f"Number of solutions = {len(solutions)}")
    print(f"Time elapsed = {end - start}")


# All the test runs
run(samples.simple, brute_force.solve)
run(samples.simple, optimized.solve)
run(samples.complex, optimized.solve)

'''
61.98+83.07 = 145.05
Number of solutions = 1
Time elapsed = 0.00033593177795410156
83.07+61.98 = 145.05
Number of solutions = 1
Time elapsed = 5.0067901611328125e-05
...
1600.51+1437.61+350.57+323.49+308.44+6.53 = 4027.15
1600.51+1437.61+419.85+415.46+58.81+55.32+22.02+11.58+5.99 = 4027.15
1600.51+1437.61+560.61+323.49+58.81+22.02+11.58+6.53+5.99 = 4027.15
1600.51+1478.42+560.61+248.71+61.98+58.81+11.58+6.53 = 4027.15
1600.51+1478.42+615.11+268.31+58.81+5.99 = 4027.15
3234.29+323.49+309.38+83.07+58.81+11.58+6.53 = 4027.15
Number of solutions = 16604
Time elapsed = 45.059534788131714

'''
