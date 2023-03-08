# glady-candidature

## Architecture
###  Entities
    In this project, we have 5 main classes that represent the entites:
    * User Class: This class represents the user that's gonna be using the application
    * Company Class: This class represents the Company that's going to create gift and meal deposits.
    * Card Class: This class represents the card that the user can have. Each card belongs to one and only one User and it's related to one and only one Company
    * GiftCardDeposit and MealCardDeposit: These classes represent the idea of having both gift and meal deposits.

### Services
    * CardDepositService: This service provides the functionality of submitting deposits to a card. 
                            It's what the company will interact with in order to submit deposits

### Dummy Data Generator
    * DataGenerator: This is a simple class that will provide some dummy data to work with through static variables.

### Tests
    In the test package, you will find some unit tests
    * CardDepositServiceTest: This is the test class that will perform unit tests on the CardDepositService to ensure the deposits will affect both the card and company's balance.


## Application Flow
    With this Architecture, we can assume that the user will have an account and some cards related to his/her account. 
    Let's say we have a user called Ali, and 2 cards in his account, one provided by Tesla and the other by Apple.
    The card will start by having a balance (could be 0$ and could be more), and the company will issue deposits through the CardDepositService.
    To do so, the application will first create a CardDeposit Object which will be of type GiftCardDepoist or MealCardDeposit. The CardDeposit will be for a specific Card. 
    After creating the CardDeposit Object, the application will invoke the submitCardDeposit method in the CardDepositService to verify and submit the deposit to the user's related card.
    

### Modifications to enhance the application
    An important thing is to keep track of the submitted deposits, in order to allow the user to actually use these deposits if they are valid. 
    The way we do that is to have a list of all deposits done on a single card (List<CardDeposits> for each card). That way we can display the VALID list of deposits to the user so he could choose from.
