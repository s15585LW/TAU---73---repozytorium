*** Settings ***
Documentation     Simple example using SeleniumLibrary.
Library           SeleniumLibrary
Resource          BrowserSpot_resource.robot

*** Test Cases ***

Get Url
    Open main page
    Click Sign Up
    Registartion Page Should be open
    [Teardown]    Close Browser

Valid Registration
    Open main page
    Click Sign Up
    Input FirstName
    Input LastName
    Input Email
    Input Password
    Input ConfirmPassword
    Select ApplicationLanguage
    Select Checkbox
    Register Button
    Assert Statement
    [Teardown]    Close Browser

Invalid Login
    Open main page
    Input Login Username    ${INVALID USER}
    Input Login Password    ${INVALID PASSWORD}
    Login Button
    Alert Text Should Be Open
    [Teardown]    Close Browser
