package org.example.service;

import org.example.data.DataGenerator;
import org.example.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class CardDepositServiceTest
{
    private ICardDepositService cardDepositService;
    private Company testCompanyTesla;
    private Card testCard;
    User testUser;

    @BeforeEach
    public void setup()
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.YEAR, 1);
        Date oneYearFromNow = cal.getTime();
        Date now = new Date();

        // Generate Companies
        testCompanyTesla = new Company(1, "TESLA", 1000);

        testUser = new User(1, "Ali", "Abou Khalil");
        cardDepositService = new CardDepositService();

        testCard = new Card(1, 100.0, testCompanyTesla, new Date(), oneYearFromNow, testUser);
    }

    @Test
    public void testGiftCardDepositBalance() throws Exception
    {
        CardDeposit giftCardDeposit = new GiftCardDeposit(1, 100, new Date(), testCard);

        cardDepositService.submitCardDeposit(giftCardDeposit);

        assertEquals(testCard.getBalance(), 200);
        assertEquals(testCompanyTesla.getBalance(), 900);
    }

    @Test
    public void testGiftCardInvalidAmount() throws Exception
    {
        CardDeposit giftCardDeposit = new GiftCardDeposit(1, 5000, new Date(), testCard);

        assertThrows(Exception.class, () -> cardDepositService.submitCardDeposit(giftCardDeposit));
    }

    @Test
    public void testMealCardDepositBalance() throws Exception
    {
        CardDeposit mealCardDeposit = new MealCardDeposit(1, 60, new Date(), testCard);

        cardDepositService.submitCardDeposit(mealCardDeposit);

        assertEquals(testCard.getBalance(), 160);
        assertEquals(testCompanyTesla.getBalance(), 940);
    }

    @Test
    public void testGiftCardDepositExpiryDate()
    {
        CardDeposit giftCardDeposit = new GiftCardDeposit(1, 100, new Date(), testCard);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);
        Date oneYearFromNow = calendar.getTime();

        assertEquals(giftCardDeposit.getExpiryDate(), oneYearFromNow);
    }

    @Test
    public void testMealCardDepositExpiryDate()
    {
        CardDeposit mealCardDeposit = new MealCardDeposit(1, 100, new Date(), testCard);

        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);

        Calendar expiryCal = Calendar.getInstance();
        expiryCal.set(Calendar.YEAR, currentYear);
        expiryCal.set(Calendar.MONTH, Calendar.FEBRUARY);
        expiryCal.set(Calendar.DAY_OF_MONTH, 28);

        Date endOfFebThisYear = expiryCal.getTime();
        expiryCal.set(Calendar.YEAR, currentYear + 1);
        Date endOfFebNextYear = expiryCal.getTime();

        assertEquals(mealCardDeposit.getExpiryDate(), endOfFebNextYear);
    }


}
