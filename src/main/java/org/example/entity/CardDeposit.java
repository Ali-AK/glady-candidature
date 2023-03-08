package org.example.entity;

import java.util.Date;

public abstract class CardDeposit
{
    protected int id;
    protected double amount;
    protected Date receivedDate;
    // Each CardDeposit must belong to a certain card
    protected Card card;

    public CardDeposit() {}

    public CardDeposit(int id, double amount, Date receivedDate, Card card)
    {
        this.id = id;
        this.amount = amount;
        this.receivedDate = receivedDate;
        this.card = card;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public Card getCard()
    {
        return card;
    }

    public void setCard(Card card)
    {
        this.card = card;
    }

    protected abstract boolean isExpired();

}
