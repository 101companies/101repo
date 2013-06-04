from functools import partial, reduce
import copy
from collections import namedtuple
from functools import partial
import sys

sys.setrecursionlimit(10**3)

#helpers

def curry(f):
    arg_num = f.func_code.co_argcount

    def wrap(*args):
        _f = partial(f, *args)
        if hasattr(f, 't'):
            _f.t = f.t
        if len(_f.args) == arg_num:
            return _f()
        return _f

    return wrap

class Infix:
    #taken from http://code.activestate.com/recipes/384122-infix-operators/
    def __init__(self, function):
        self.function = function
    def __ror__(self, other):
        return Infix(lambda x, self=self, other=other: self.function(other, x))
    def __or__(self, other):
        return self.function(other)
    def __rlshift__(self, other):
        return Infix(lambda x, self=self, other=other: self.function(other, x))
    def __rshift__(self, other):
        return self.function(other)
    def __call__(self, value1, value2):
        return self.function(value1, value2)

class Maybe(object):
    pass

class Just(Maybe):

    def __init__(self, value):
        self.value = value

class Nothing(Maybe):
    pass

def isJust(n):
    assert isinstance(n, Maybe)
    if isinstance(n, Nothing):
        return False
    else:
        return True

isNothing = lambda n: not isJust(n)

def fromMaybe(d, x):
    assert isinstance(x, Maybe)
    if isJust(x):
        return x.value
    else:
        return d

def fromJust(j):
    assert isinstance(j, Maybe)
    if isJust(j):
        return j.value
    else:
        raise TypeError('Maybe.fromJust: Nothing')

def maybe(n, f, m):
    assert isinstance(m, Maybe)
    if isNothing(m):
        return n
    else:
        return f(m.value)

def t(_type):

    def inner(f):

        f.t = _type
        return f

    return inner

@t(object)
def id_(i): return i

def special_id(_type):

    @t(_type)
    def sid(i): return i

    return sid

foldl = lambda f, z, x: reduce(f, x, z)


# end of helpers


orElse = lambda x, y: x or y

@curry
def everywhere(f, x):
    '''
    Generic traversal combinator for every node in the tree bottom up.

    '''

    return f(gmapT(everywhere(f), x))

everywhereBU = everywhere

@curry
def everywhereTD(f, x):
    '''
    Generic traversal combinator for every node in the tree top down.

    '''

    return gmapT(everywhereTD(f), f(x))

def everywhereBut(q, f, x):

    if q(x):
        return x
    return f(gmapT(everywhereBut(q, f), x))

everywhereButBU = everywhereBut

@curry
def everywhereButTD(q, f, x):
    '''
    everywhereButTD :: (object -> bool) -> (object -> object) -> object
    '''
    if q(x):
        return x
    return gmapT(everywhereButTD(q, f),  f(x))


@curry
def everywhereButAny(q, f, x):
    '''
    everywhereButAny :: [(object -> bool)] -> (object -> object) -> object
    '''

    if any([q(xi) for x in x]):
        return x
        
    return f(gmapT(everywhereBut(q, f), x))

everywhereButAnyBU = everywhereButAny

@curry
def everywhereButAnyTD(q, f, x):
    '''
    everywhereButAny :: [(object -> bool)] -> (object -> object) -> object
    '''
    if any(map(q, x)):
        return x

    return gmapT(everywhereBut(q, f), f(x))

@curry
def everything(k, f, x):
    return foldl(k, f(x), gmapQ(everything(k, f), x))
    

@curry
def mkT(f, value):
    '''
    apply transformation f to value.
    '''
    
    m = cast(value, f)
    if isJust(m):
        return f(m.value)
    else:
        return value

@Infix
@curry
def choice(f, q, a):
    try:
        return f(a)
    except fail:
          return q(a)

@Infix
@curry
def mkQ(r, q, a):

    m = cast(a, q)
    if isJust(m):
        return q(m.value)
    else:
        return r

@Infix
@curry
def extQ(f, g, a):
    return maybe(f(a), g, cast(a, g))

    
def cast(val, t):
    '''
    Return Just(val) if the type of value equals the type of the function parameter.
    
    '''
    if isinstance(val, t.t):
        return Just(val)
    else:
        return Nothing()

def gmapT(f, val):
    if type(val) in [int, str, float, bool, unicode]:
        return val

    elif type(val) in [list, set]:
        if len(val) > 0:
            return [f(val[0])] + f(val[1:])
        else:
            return []
            
    elif type(val) == dict:
        return { key:f(value) for key, value in val.items() }
            
    elif callable(val):
        return val

    elif type(val) == tuple:
        return tuple(*map(f, val))

    else:
        val = copy.deepcopy(val)
    
        keys = dir(val)
        keys = list(set(keys) - set(dir(object)))
        keys = [key for key in keys if not key.startswith('_')]
        items = [getattr(val, key) for key in keys]

        items = map(f, items)
        for key, value in zip(keys, items):
            setattr(val, key, value)
        return val
 
def gmapQ(f, val):
    if type(val) in [int, str, float]:
        return []

    elif type(val) in [list, set, tuple]:
        if len(val) > 0:
            return [f(val[0]), f(val[1:])]
        else:
            return []

    else:
        val = copy.deepcopy(val)
    
        keys = dir(val)
        keys = [key for key in list(set(keys) - set(dir(object))) if not key.startswith('_')]
        items = [getattr(val, key) for key in keys]

        return map(f, items)

@t(object)     
def gsize(t):
    return 1 + sum(gmapQ(gsize, t))






