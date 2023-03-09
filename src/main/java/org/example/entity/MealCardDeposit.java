package org.example.entity;

import java.util.Calendar;
import java.util.Date;

public class MealCardDeposit extends CardDeposit
{
    public MealCardDeposit(int id, double amount, Date receivedDate, Card card)
    {
        super(id, amount, receivedDate, card);

        // Set the expiry date to be the next end of February
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);

        Calendar expiryCal = Calendar.getInstance();
        expiryCal.set(Calendar.YEAR, currentYear);
        expiryCal.set(Calendar.MONTH, Calendar.FEBRUARY);
        expiryCal.set(Calendar.DAY_OF_MONTH, 28);

        Date endOfFebThisYear = expiryCal.getTime();
        expiryCal.set(Calendar.YEAR, currentYear + 1);
        Date endOfFebNextYear = expiryCal.getTime();
        this.expiryDate = receivedDate.before(endOfFebThisYear) ? endOfFebThisYear : endOfFebNextYear;
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
        return "Meal Card Deposit # : " + id + "\n" +
                "-Amount: " + amount + "$\n" +
                "-Received Date: " + receivedDate.toString() + "\n" +
                "-Expiry Date: " + expiryDate.toString() + "\n";
//                "-----------------------------\n";
//                "For the following card: " + card.toString();
    }
}
