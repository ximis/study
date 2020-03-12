*** Settings ***
Library       MyLibrary    1
Library       DynamicLib
Variables     MyObject2.py
#Variables     MyObject.py      www
Variables     variabletest.py
Variables     getvariablesfunction.py


*** Variables ***
${var1}    this is var1
@{vls}     test 1    test 2     test 3
&{vdic}    a=1    b=2    c=3


*** Test Cases ***
My Test
    print data     sfas

Test 2
    printData2     who=1
    printData2      aaa

Test 3
    ${var} =    return value
    printData2    ${var}

dynamic lib test
    test dynamic kw     james
    test dynamic kw     tom
    test dynamic kw     jack
    test dynamic kw     data=123
named arguments test
    print data named arguments      11    var2=22
    test named arguments    44   var2=33

named arguments test 2
    print data named arguments2     11    var3=33
    test named arguments    11    var3=33

test variable object
    print data    ${a}
    print data    ${b}

test variable types
    log    ${var1}
    FOR     ${i}    IN    @{vls}
        log    this is ${i}
    END
    print data    &{vdic}


