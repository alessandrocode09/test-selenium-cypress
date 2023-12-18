let token = "";
let bookingId = 0;

describe('Booking tests restful-booker', () => {

  it('Create token', () => {

    const body = {
      username: "admin",
      password: "password123"
    };

    cy.request('POST', '/auth', body).then(response => {

      // Check the status if equal 200 , everything is OK
      expect(response.status).to.equal(200);
      token = response.body.token;
    });
  });

  it('Create a booking', () => {

    const body = {
      "firstname": "Ale",
      "lastname": "Almeida",
      "totalprice": 125,
      "depositpaid": true,
      "bookingdates": {
        "checkin": "2022-01-02",
        "checkout": "2023-01-03"
      },
      "additionalneeds": "Breakfast"
    };

    cy.request('POST', '/booking', body).then(response => {

      // Check the status if equal 200 , everything is OK
      expect(response.status).to.equal(200);
      // Check the body values are matching with expected
      expect(response.body.booking.firstname).to.equal('Ale');
      expect(response.body.booking.lastname).to.equal('Almeida');
      expect(response.body.booking.totalprice).to.equal(125);
      expect(response.body.booking.depositpaid).to.equal(true);
      expect(response.body.booking.bookingdates.checkin).to.equal("2022-01-02");
      expect(response.body.booking.bookingdates.checkout).to.equal("2023-01-03");
      expect(response.body.booking.additionalneeds).to.equal("Breakfast");
      bookingId = response.body.bookingid;
    });
  });

  it('Partially Update the Created Booking', () => {

    const body = {
      "firstname": "Mick",
      "lastname": "Jagger",
      "additionalneeds": "Dinner"
    };

    const header = {
      'Content-Type': 'application/json',
      'Accept': 'application/json',
      'Cookie': 'token=' + token
    };

    cy.request({
      method: 'PATCH',
      url: '/booking/' + bookingId,
      headers: header,
      body: body
    }).then(response => {

      // Check the status if equal 200 , everything is OK
      expect(response.status).to.equal(200);
      // Check the body values are matching with expected
      expect(response.body.firstname).to.equal('Mick');
      expect(response.body.lastname).to.equal('Jagger');
      expect(response.body.additionalneeds).to.equal('Dinner');
    });
  });

  it('Read the Updated Booking', () => {

    cy.request({
      method: 'GET',
      url: '/booking/' + bookingId
    }).then(response => {

      // Check the status if equal 200 , everything is OK
      expect(response.status).to.equal(200);
      expect(response.body.firstname).to.equal('Mick');
      expect(response.body.lastname).to.equal('Jagger');
      expect(response.body.totalprice).to.equal(125);
      expect(response.body.depositpaid).to.equal(true);
      expect(response.body.bookingdates.checkin).to.equal("2022-01-02");
      expect(response.body.bookingdates.checkout).to.equal("2023-01-03");
      expect(response.body.additionalneeds).to.equal('Dinner');
    });
  });

  it('Delete the Booking', () => {

    const header = {
      'Content-Type': 'application/json',
      'Accept': 'application/json',
      'Cookie': 'token=' + token
    };

    cy.request({
      method: 'DELETE',
      url: '/booking/' + bookingId,
      headers: header
    }).then(response => {

      // Check the status if equal 201 , everything is OK
      expect(response.status).to.equal(201);
      expect(response.body).to.equal('Created');
      expect(response.statusText).to.equal('Created');
    });
  });
});
