from robot.api.deco import keyword
from robot.api import logger

__version__ = '0.1'
ROBOT_LIBRARY_DOC_FORMAT = 'reST'
# ROBOT_LIBRARY_DOC_FORMAT = 'HTML'

# __all__=[]

class MyLibrary:
    # ROBOT_LIBRARY_SCOPE = "TEST SUITE"
    ROBOT_LIBRARY_SCOPE = "TEST CASE"

    def __init__(self, data ):
        self._data = data
        if hasattr(self, "_count") is False:
            self._count = 1
        else:
            self._count += 1
        print("this is the ", self._count, " time to create MyLib instance")
        logger.console("test add data to console")
        logger.info("test, add data info, to log and console", also_console=True)

    # @keyword("this is test") # give it an keyword name to instead the default one.
    def print_data(self, who):
        print(who, " is print the data: ", self._data)

    def printData2(self, who="test"):
        print(who, " is print data2 the data: ", self._data)

    def return_value(self):
        return "return's data"

    def print_data_named_arguments(self, var1, var2= "test"):
        print("test print named arguments", var1, var2)

    def print_data_named_arguments2(self, var1, var2="test1", var3="test2" ):
        print("test print named arguments", var1, var2, var3)