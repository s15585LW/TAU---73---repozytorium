*** Settings ***
Documentation     A resource file with reusable keywords and variables.
...
...               The system specific keywords created here form our own
...               domain specific language. They utilize keywords provided
...               by the imported SeleniumLibrary.
Library           SeleniumLibrary

*** Variables ***
${SERVER}       automationpractice.com
${BROWSER}      Chrome
${DELAY}        0
${VALID EMAIL REGISTER}   test_email@wp.pl
${VALID EMAIL}   Test_email_valid@wp.pl
${INVALID EMAIL}     test_email_wrong@wp.pl
${VALID PASSWORD REGISTER}   Password123
${VALID PASSWORD}   pass1234
${INVALID PASSWORD}     pass_WRONG
${MAIN URL}    http://${SERVER}/index.php
${SIGNIN URL}    http://${SERVER}/index.php?controller=authentication&back=my-account
${T-SHIRTS URL}  http://${SERVER}/index.php?id_category=5&controller=category
${ALERT URL}    http://${SERVER}/index.php?controller=authentication

*** Keywords ***
Open Browser To Main Page
    Open Browser    ${MAIN URL}    ${BROWSER}
    Title Should Be    My Store
Go To T-shirts Page
    Click Element      css = .sf-menu > li:nth-child(3) > a:nth-child(1)
T-shirts Page Should Be Open
    Location Should Be  ${T-SHIRTS URL}
Input Email
    [Arguments]    ${email}
    Input Text    email    ${email}
Input Password
    [Arguments]    ${passwd}
    Input Text    passwd    ${passwd}
Log In
    Click Element   class=login
Submit Credentials
    Click Button    SubmitLogin
My Account Page Should Be Open
    Title Should Be    My account - My Store
Input Create Email
    [Arguments]    ${email}
    Input Text    email_create    ${email}
Create Account
    Click Button    xpath=//*[@id="SubmitCreate"]
Submit Account
    Click Button    xpath=//*[@id="submitAccount"]
Alert Page Should Be Open
    Location Should Be   ${ALERT URL}
Register Page Should Be Open
    Title Should Be    Login - My Store
Choose Male Title
    Select Radio Button    id_gender  1
Input FirstName
    Input Text    xpath=//*[@id="customer_firstname"]  Lukasz
Input LastName
    Input Text    xpath=//*[@id="customer_lastname"]  Walenski
Input RegisterPassword
    Input Text    xpath=//*[@id="passwd"]  Password123
Select Day
    Select From List by Value    xpath=//*[@id="days"]  12
Select Months
    Select From List by Value    xpath=//*[@id="months"]  4
Select Yours
    Select From List by Value    xpath=//*[@id="years"]  1990
Input Address
    Input Text    xpath=//*[@id="address1"]  Jednosci Narodu
Input City
    Input Text    xpath=//*[@id="city"]  Tczew
Select State
    Select From List by Value    xpath=//*[@id="id_state"]  9
Input PostCode
    Input Text    xpath=//*[@id="postcode"]  83110
Input Phone
    Input Text    xpath=//*[@id="phone_mobile"]  500500500