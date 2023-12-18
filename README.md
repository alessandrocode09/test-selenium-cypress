# test-korber
This is a code challenge proposed by Korber Digital

## TestPart1-blackboxTests
The first part of the test is inside the zip file. 
The zip file contains a Word document with the bug and images and contains also a folder with a video of the bug.

## automation-test-part2
After you clone this repository, to run the project "automation-test-part2" you will need to install:
- Java JDK version 8
- Must have the Chrome browser installed (version 120.0.6099.109)
- You can see the test features on the: "/automation-test-part2/src/test/resources"
- All tests for the project are in the "test" directory.

How to run the tests?
- On the terminal go to the directory of the project
- On the terminal run the command line: "mvn clean install"
- Run the tests: "mvn test -Dtest=RunCucumber"
- After the test execution, run the report command: "mvn cluecumber-report:reporting"
- The report is on the following path: "automation-test-part2/target/formated-report/index.html"

The bug report screenshot for the first part:
![image](https://github.com/alessandrocode09/test-korber/assets/24464134/8c8ab3c6-af90-4f8c-86ee-75c42c622de6)


## automation-test-part3
Automation of the Booking API using Cypress.

You can see the test in cypress/e2e/booking-api/booking.cy.js

- Make sure that you already have installed
- Node JS
- NPM

- If you do not have installed, you can check here:
Link: https://docs.cypress.io/guides/getting-started/installing-cypress

- After cloning the repo into a directory run: "npm install cypress --save-dev" to install cypress in that directory context
- To run the tests: "npx cypress run"

- POST - Create a Token
- POST - Create a Booking
- PATCH  - Partially Update the Created Booking
- GET  - Read the Updated Booking
- PATCH  - Partially Update the Created Booking

The images for the run execution:
![image](https://github.com/alessandrocode09/test-korber/assets/24464134/7604b1e3-3963-4055-a177-7fabeba88544)
![image](https://github.com/alessandrocode09/test-korber/assets/24464134/92aef1b4-d31b-47a2-bbda-73aa060e0dec)
![image](https://github.com/alessandrocode09/test-korber/assets/24464134/4a32391e-ced5-4094-b0f6-277ddc8b4a5d)

