package org.example.entity;

import java.util.Calendar;
import java.util.Date;

public class GiftCardDeposit extends CardDeposit
{

    public GiftCardDeposit(int id, double amount, Date receivedDate, Card card)
    {
        super(id, amount, receivedDate, card);

        // set the expiry date a year from now
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);
        this.expiryDate = calendar.getTime();
    }

    @Override
    protected boolean isExpired()
    {
        Date currentDate = new Date();
        return currentDate.after(expiryDate);
    }


    @Override
    public String toString()
    {
        return "Gift Card Deposit # : " + id + "\n" +
                "-Amount: " + amount + "$\n" +
                "-Received Date: " + receivedDate.toString() + "\n" +
                "-Expiry Date: " + expiryDate.toString() + "\n";
//                "-----------------------------\n";
//                "For the following card: " + card.toString();
    }
}
