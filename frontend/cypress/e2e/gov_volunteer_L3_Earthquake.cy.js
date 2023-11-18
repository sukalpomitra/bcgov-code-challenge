describe('Personal Details and Volunteer Profile Details Form', () => {
    it('passes', () => {
        cy.visit('http://localhost:3000')

        //Click Join Button
        cy.get('.btn').click()

        cy.visit('http://localhost:3000/govemployee/volunteer')

        // First Name
        cy.get('[id *=-firstName]').eq(1).type('Saman')

        //Last Name
        cy.get('[id *=-lastName]').eq(1).type('Perera')

        // Phone Number
        cy.get('[id *=-phoneNumber]').eq(1).type('(123) 456-7445')

        // Email
        cy.get('[id *=-email]').eq(1).type('info2@gmail.com')


        // Date of Birth
        cy.get('.input').type('1995-12-01').type('{enter}')

        //Gender
        //cy.get('[id *=->.choices > .ui > .choices__list > .choices__item]').eq(2).select("female")


        //Emergency Contact No
        cy.get('[id *=-emergencyNumber]').eq(1).type('(123) 456-7894')

        //Transportation
        cy.get('input[name*="data[doYouHaveOwnTransportation]"][value="true"]').click()

        //availability
        cy.get('input[name*="data[availability]"][value="IMMEDIATE"]').click()

        //Skills
        //1st Scenario - Wildfire L1

        //Medical
        cy.get('input[name*="data[Medical]"][value="BEGINNER"]').click()

        //Firefighting 
        cy.get('input[name*="data[Firefighting]"][value="ADVANCED"]').click()

        //Communication
        cy.get('input[name*="Communication]"][value="INTERMEDIATE"]').click()


        //Limitations or Constrains
        cy.get('input[name*="data[limitations]"][value="NO"]').click()

        //submit
        cy.get('button[type="submit"]').click();

        cy.get('.modal_btn').click();

        cy.contains('Earthquake').click()
    })


})