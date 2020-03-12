from robot.api.deco import keyword
from robot.api import logger

class DynamicLib:
    def __init__(self):
        print("this is the init data")

    def get_keyword_names(self):
        '''
        dynamic library uses this method to get keyword names.        :return:
        '''
        logger.console("get keyword names execute")
        return [name for name in dir(self) if hasattr(getattr(self, name), 'robot_name')]

    def run_keyword(self, name, args, kwargs):
        '''
        dynamic library uses this method to run the keyword
        :param name:
        :param args:
        :param kwargs:
        :return:
        '''
        logger.console("run kw execute")
        print("Running keyword %s with positional arguments %s and named arguments %s" %(name, args, kwargs))

    @keyword
    def test_dynamic_kw(self, data="default"):
        print("test dynamic kw %s" % data)

    @keyword
    def test_named_arguments(self, var1, var2="test"):
        print("test named arguments ", var1, var2)

    @keyword
    def test_named_arguments(self, var1, var2="test2", var3="test3"):
        print("test named arguments ", var1, var2, var3)
        logger.info("function test %s %s %s" %(var1, var2, var3))

