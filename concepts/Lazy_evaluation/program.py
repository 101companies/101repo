# A straightforward definition of factorial
def factorial(x):
    if not isinstance(x, (int, long)) or x<0:
        raise RuntimeError('factorial arg error')
    else:
        if x <= 1:
            return 1
        else:
            return x * factorial(x-1)

# A troubled re-definition of "if"
def troubledIf(b,x1,x2):
    if b:
        return x1
    else:
        return x2

# Factorial re-defined to use user-defined if
def troubledFactorial(x):
    if not isinstance(x, (int, long)) or x<0:
        raise RuntimeError('factorial arg error')
    else:
        return troubledIf(x<=1,1,x * troubledFactorial(x-1))

# A (properly) lazy re-definition of "if"
def lazyIf(b,x1,x2):
    if b:
        return x1(())
    else:
        return x2(())

# A definition of factorial using lazyIf
def lazyFactorial(x):
    if not isinstance(x, (int, long)) or x<0:
        raise RuntimeError('factorial arg error')
    else:
        return lazyIf(x<=1,lambda _: 1, lambda _: x * lazyFactorial(x-1))
