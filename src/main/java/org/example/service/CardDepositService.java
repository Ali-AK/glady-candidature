package org.example.service;
import org.example.entity.CardDeposit;

public class CardDepositService implements ICardDepositService
{
    public void submitCardDeposit(CardDeposit cardDeposit) throws Exception
    {
        // Checking if the company has enough balance
        if(cardDeposit.getCard().getCompany().deductFromBalance(cardDeposit.getAmount()))
            // Adding the amount to the card's balance
            cardDeposit.getCard().addToBalance(cardDeposit.getAmount());

        else
            throw new Exception("Can't submit deposit. Insufficient balance!");

    }
}
