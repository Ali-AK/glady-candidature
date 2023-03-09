package org.example;

import org.example.data.DataGenerator;
import org.example.entity.*;
import org.example.service.CardDepositService;

import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.YEAR, 1);
        Date oneYearFromNow = cal.getTime();
        Date now = new Date();

        // Here we declare all the needed variables
        User userJohn = DataGenerator.USER_JOHN;
        User userJessica = DataGenerator.USER_JESSICA;

        Company tesla = DataGenerator.TESLA;
        Company apple = DataGenerator.APPLE;

        Card cardTeslaJohn = DataGenerator.CARD_TESLA_JOHN;
        Card cardAppleJessica = DataGenerator.CARD_APPLE_JESSICA;

        CardDepositService cardDepositService = new CardDepositService();
        // -----------------------------------------------------------------------------------//
        // Scenario #1:
        // Company TESLA decides to make a Gift Card Deposit to user Ali on his TESLA Card
        System.out.println("Scenario #1");
        // First we check the card's and company's balance
        System.out.println("The card's OLD balance is: " + cardTeslaJohn.getBalance() + "$");
        System.out.println("The company OLD balance is: " + tesla.getBalance() + "$\n");

        CardDeposit giftCardDeposit = new GiftCardDeposit(1, 50, now, cardTeslaJohn);
        cardDepositService.submitCardDeposit(giftCardDeposit);

        // Now we check the card's and company's new balance
        System.out.println("The card's NEW balance is: " + cardTeslaJohn.getBalance() + "$");
        System.out.println("The company NEW balance is: " + tesla.getBalance() + "$\n");
        System.out.println("-----------------------------------------------------------------------------------\n");
        // -----------------------------------------------------------------------------------//

        // Scenario #2:
        // Company Apple decides to make a Meal Card Deposit to user Ali on his Apple Card
        System.out.println("Scenario #2");
        // First we check the card's and company's balance
        System.out.println("The card's OLD balance is: " + cardAppleJessica.getBalance() + "$");
        System.out.println("The company OLD balance is: " + apple.getBalance() + "$\n");

        CardDeposit mealCardDeposit = new MealCardDeposit(1, 120, now, cardAppleJessica);
        cardDepositService.submitCardDeposit(mealCardDeposit);
        // Now we check the card's and company's new balance
        System.out.println("The card's NEW balance is: " + cardAppleJessica.getBalance() + "$");
        System.out.println("The company NEW balance is: " + apple.getBalance() + "$\n");
        System.out.println("-----------------------------------------------------------------------------------\n");
        // -----------------------------------------------------------------------------------//

        System.out.print(userJohn);
        System.out.println();
        System.out.println();
        System.out.print(userJessica);
        System.out.println();
        System.out.println();
        System.out.println(tesla);
        System.out.println();
        System.out.println();
        System.out.println(apple);
        System.out.println();
        System.out.println();
        System.out.println(giftCardDeposit);
        System.out.println();
        System.out.println();
        System.out.println(mealCardDeposit);
        System.out.println();
        System.out.println();
        System.out.println(cardTeslaJohn);
        System.out.println();
        System.out.println();
        System.out.println(cardAppleJessica);
    }
}