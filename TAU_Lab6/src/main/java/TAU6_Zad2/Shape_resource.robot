# This file is located in "robot" folder

*** Settings ***
Documentation   CommonResource file with KWs
Library         OperatingSystem
Library         String
Library         Process

*** Variables ***
${SRC_PATH}   C://studia//Tau//Testowanie_Aut//Cwiczenia//TAU_Lab6//target//classes//

*** Keywords ***

Run Java Class With Args
    [Arguments]  ${class_name}  ${args}     ${path}=${SRC_PATH}
    ${output}=   Run  java -cp ${path} ${class_name} ${args}
    Log     ${output}   WARN
    [return]    ${output}