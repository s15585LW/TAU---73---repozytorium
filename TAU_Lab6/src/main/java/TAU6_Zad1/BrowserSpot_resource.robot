*** Settings ***
Documentation     A resource file with reusable keywords and variables.
...
...               The system specific keywords created here form our own
...               domain specific language. They utilize keywords provided
...               by the imported SeleniumLibrary.
Library           SeleniumLibrary

*** Variables ***
${LOGIN URL}          https://app.browserspot.com/login
${SERVER}       app.browserspot.com
${BROWSER}      Chrome
${DELAY}  0
${FIRSTNAME}  Lukasz
${LASTNAME}  Walenski
${EMAIL}  luw_tau_test@gmail.com
${VALID PASSWORD}  Password123
${CONFIRM PASSWORD}  Password123
${INVALID USER}     wrong_email@tau.pl
${INVALID PASSWORD}   cos_tam@yahoo
${LOGIN URL}    https://${SERVER}/login
${REGISTER URL}  https://${SERVER}/registration
@{REGISTER TEXT}  Please check your email and confirm your registration
@{LOGIN TEXT}  Problem while login. Check data.
*** Keywords ***

Open main page
    Open browser    ${LOGIN URL}   ${BROWSER}
    Title Should Be   BrowserSpot
Click Sign Up
    Click Element  xpath = //button[text()='Sign up']
Registartion Page Should be open
    Location Should Be  ${REGISTER URL}
Alert Text Should Be Open
    Wait until Page Contains Element  css = div.app-alert:nth-child(1) > div:nth-child(1)  timeout=10 s
    Element Should Contain  css = div.app-alert:nth-child(1)  @{LOGIN TEXT}
Input Login Username
    [Arguments]    ${username}
    Input Text    xpath = /html/body/div/section/div/div[2]/div[1]/form/div[1]/input    ${username}
Input Login Password
    [Arguments]    ${password}
    Input Text    css = div.input-wrapper:nth-child(2) > input:nth-child(2)    ${password}
Input FirstName
    Input Text  css = input[name=\"firstname\"]  ${FIRSTNAME}
Input LastName
    Input Text  css = input[name=\"lastname\"]    ${LASTNAME}
Input Email
    Input Text  css = input[name=\"email\"]   ${EMAIL}
Input Password
    Input Text  xpath = //input[@name=\"password\"]   ${VALID PASSWORD}
Input ConfirmPassword
    Input Text  xpath = //input[@name=\"password_confirmation\"]  ${CONFIRM PASSWORD}
Select ApplicationLanguage
    Click Element  css = .fake-input
    Click Element  css = div.active > div:nth-child(1) > span:nth-child(2)
Select Checkbox
    Click Element  css = .checkbox > span:nth-child(2)
Register Button
    Click Button  xpath = //button[text()='Sign up']
Login Button
    Click Button  css = .form-wrapper > form:nth-child(2) > div:nth-child(3) > button:nth-child(1)
Assert Statement
    Wait until Page Contains Element  css = .confirm-registration > h2:nth-child(1)  timeout=10 s
    Element Should Contain  css = .confirm-registration > p:nth-child(2)  @{REGISTER TEXT}


