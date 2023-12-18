# test-korber
This is a code challenge proposed by Korber Digital

## TestPart1-blackboxTests
The first part of the test is inside the zip file. 
The zip file contains a Word document with the bug and images and contains also a folder with a video of the bug.

## automation-test-part2
After you clone this repository, to run the project "automation-test-part2" you will need to install:
- Java JDK version 8
- Must have the Chrome browser installed (version 120.0.6099.109)

How to run the tests?
1. On the terminal go to the directory of the project
2. On the terminal run the command line: "mvn clean install"
3. Run the tests: "mvn test -Dtest=RunCucumber"
4. After the test execution, run the report command: "mvn cluecumber-report:reporting"
5. The report is on the following path: "automation-test-part2/target/formated-report/index.html"


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
