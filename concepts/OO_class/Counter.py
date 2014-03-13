class Counter:
    def __init__(self):
        self.count = 0
    def __repr__(self):
        return str(self.count)
    def inc(self):
        self.count += 1
    def reset(self):
        self.count = 0
