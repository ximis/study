
__all__=["OBJECT"]


class MyObject2:

    def __init__(self):
       self.name = "test"

    def eat(self, what):
        return '%s eats %s' % (self.name, what)

    def __str__(self):
        return self.name

OBJECT = MyObject2()
DICTIONARY = {1: 'one', 2: 'two', 3: 'three'}