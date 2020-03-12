*** Variables ***
&{test}           a=1    b=2

*** Test Cases ***
test
    log    &{test}
