# Assume operands to be positive

def gcdIterative(x, y):
    while x != y:
        if x > y: 
            x -= y
        else:
            y -= x 
    return x

def gcdRecursive(x, y):
    if x > y: 
        return gcdRecursive(x-y, y)
    elif x > y: 
        return gcdRecursive(x, y-x)
    else:
        return x
