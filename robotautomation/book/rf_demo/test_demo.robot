*** Variables ***
${a}              hello
@{ls}             aaa    bbb
&{dic}            aa=1    bb=2

*** Test Cases ***
test_case
    log    ${a}
    FOR    ${i}    IN    @{ls}
        log    ${i}
    END
    FOR    ${i}    IN    &{dic}
        log    ${dic}[${i}]
    END

test_v
    @{t}    Create List    b    c
    FOR    ${i}    IN    @{t}
        log    ${i}
    END
    ${a}=    Set Variable    ttt
    log    ${a}
    &{dic2}    Create Dictionary    a=1    b=2    c=3
    Length Should Be    ${dic2}    3
    Log    ${dic2.a}
    Log    ${dic2}
    Log    ${dic2}[a]
    FOR    ${index}    IN RANGE    2
        log    @{t}[${index}]
    END
    FOR    ${key}    IN    ${dic2}
        log    &{dic2}[${key}]
    END
