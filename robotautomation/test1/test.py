

from libs import  *

# MyLibrary


def test(x:"int", y:"int") -> "sum":
    return x + y

# print(test(1,2))

def test_args(a, *args, b=1):
    print("args are ", a, args, b)
