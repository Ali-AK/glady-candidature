package org.example.service;

import org.example.data.DataGenerator;
import org.example.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CardDepositServiceTest
{
    private ICardDepositService cardDepositService;
    private Company testCompany;
    private Card testCard;
    private User testUser;

    @BeforeEach
    public void setup()
    {
        cardDepositService = new CardDepositService();
        testCompany = DataGenerator.TESLA;
        testCard = DataGenerator.CARD_TESLA_ALI;
    }

    @Test
    public void testGiftCardDepositBalance() throws Exception {
        CardDeposit giftCardDeposit = new GiftCardDeposit(1, 100, new Date(), testCard);

        cardDepositService.submitCardDeposit(giftCardDeposit);

        assertEquals(testCard.getBalance(), 200);
        assertEquals(testCompany.getBalance(), 900);
    }

    @Test
    public void testGiftCardInvalidAmount() throws Exception {
        CardDeposit giftCardDeposit = new GiftCardDeposit(1, 5000, new Date(), testCard);

        assertThrows(Exception.class, () -> cardDepositService.submitCardDeposit(giftCardDeposit));
    }
}
