package org.example.entity;


import java.util.Date;

public class Card
{
    private String id;
    private double balance;
    private String issuingCompany;
    private Date createdAt;
    private Date expireyDate;
    private User user;

    public Card() {}

    public Card(String id, double balance, String issuingCompany, Date createdAt, Date expireyDate, User user)
    {
        this.id = id;
        this.balance = balance;
        this.issuingCompany = issuingCompany;
        this.createdAt = createdAt;
        this.expireyDate = expireyDate;
        this.user = user;
    }

    public String getId()
    {
        return id;
    }

    public double getBalance()
    {
        return balance;
    }

    public String getIssuingCompany()
    {
        return issuingCompany;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public Date getExpireyDate()
    {
        return expireyDate;
    }

    public User getUser()
    {
        return user;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public void setIssuingCompany(String issuingCompany)
    {
        this.issuingCompany = issuingCompany;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    public void setExpireyDate(Date expireyDate)
    {
        this.expireyDate = expireyDate;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
