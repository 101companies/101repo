class Complex:
    def __init__(self, re, im):
        self.re = re
        self.im = im
    def __repr__(self):
        return "Complex(" \
               + str(self.re) \
               + ", " \
               + str(self.im) + ")"
    def add(self, cnum):
        return Complex(\
                  self.re+cnum.re, \
                  self.im+cnum.im)
