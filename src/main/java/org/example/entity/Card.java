package org.example.entity;


import java.util.Date;

public class Card
{
    private int id;
    private double balance;
    private Date createdAt;
    private Date expiryDate;
    // A card should be related to one and only one user
    private User user;
    // A card should be related to one and only one company
    private Company company;

    public Card() {}

    public Card(int id, double balance, Company company, Date createdAt, Date expiryDate, User user)
    {
        this.id = id;
        this.balance = balance;
        this.company = company;
        this.createdAt = createdAt;
        this.expiryDate = expiryDate;
        this.user = user;
    }

    public int getId()
    {
        return id;
    }

    public double getBalance()
    {
        return balance;
    }

    public Company getCompany()
    {
        return company;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public Date getExpiryDate()
    {
        return expiryDate;
    }

    public User getUser()
    {
        return user;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public void setCompany(Company company)
    {
        this.company = company;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    public void setExpiryDate(Date expiryDate)
    {
        this.expiryDate = expiryDate;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public boolean isExpired()
    {
        return expiryDate.before(new Date());
    }

    public void addToBalance(double amount) throws Exception
    {
        if(amount > 0 && !isExpired())
            this.balance += amount;

        else
            throw new Exception("The card is expired!");
    }

    @Override
    public String toString()
    {
        return "Card #" + id +  ": \n" +
                "-Balance: " + balance + " $\n" +
                "-Created At: " + createdAt.toString() + "\n" +
                "-Expires At: " + expiryDate.toString() + "\n" +
                "-Company: \n" +
                "--" + company.getName() + "\n" +
                "-User: " + user.toString() + "\n";
    }
}
