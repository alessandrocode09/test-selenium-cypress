# test-korber
This is a code challenge proposed by Korber Digital

## automation-test-part2
After you clone this repository, to run the project "automation-test-part2" you will need to install:
- Java JDK version 8
- Must have the Chrome browser installed (version 120.0.6099.109)

How to run the tests?
1. On the terminal go to the directory of the project
2. On the terminal run the command line: "mvn clean install"
3. Run the tests: "mvn test -Dtest=RunCucumber"
4. The cucumber report is on the following path: "automation-test-part2/target/reports/index.html"


## automation-test-part3
Automation of the Booking API using Cypress.

You can see the test in cypress/e2e/booking-api/booking.cy.js

- Make sure that you already have installed
- Node JS
- NPM

- If you do not have installed, you can check here:
Link: https://docs.cypress.io/guides/getting-started/installing-cypress

- POST - Create a Token
- POST - Create a Booking
- PATCH  - Partially Update the Created Booking
- GET  - Read the Updated Booking
- PATCH  - Partially Update the Created Booking

- After all tests running on Google Chrome:
<img src="https://github.com/alessandrocode09/test-korber/automation-test-part3/blob/master/images/photo01.png" width="500"/>
<img src="https://github.com/alessandrocode09/test-korber/automation-test-part3/blob/master/images/photo02.pgn" width="500"/>

- After all tests running on Terminal:
<img src="https://github.com/alessandrocode09/test-korber/automation-test-part3/blob/master/images/photo03.pgn" width="500"/>
