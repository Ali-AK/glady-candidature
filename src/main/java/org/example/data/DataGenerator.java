package org.example.data;

import org.example.entity.Card;
import org.example.entity.Company;
import org.example.entity.User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DataGenerator
{

    public static User USER_JOHN;
    public static User USER_JESSICA;

    public static Company TESLA ;
    public static Company APPLE;

    public static Card CARD_TESLA_JOHN;
    public static Card CARD_APPLE_JOHN;
    public static Card CARD_TESLA_JESSICA;
    public static Card CARD_APPLE_JESSICA;

    public static List<User> users = new ArrayList<>();
    public static List<Card> cards = new ArrayList<>();

    static
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.YEAR, 1);
        Date oneYearFromNow = cal.getTime();
        Date now = new Date();

        // Generate users
        USER_JOHN = new User(1, "John", "Doe");
        USER_JESSICA = new User(1, "Jessica", "Doe");

        // Generate Companies
        TESLA = new Company(1, "TESLA", 1000);
        APPLE = new Company(1, "APPLE", 1000);

        // Generate Cards
        CARD_TESLA_JOHN = new Card(1, 100.0, TESLA, new Date(), oneYearFromNow, USER_JOHN);
        CARD_APPLE_JOHN = new Card(2, 50, APPLE, new Date(), oneYearFromNow, USER_JOHN);

        CARD_TESLA_JESSICA = new Card(1, 100.0, TESLA, new Date(), oneYearFromNow, USER_JESSICA);
        CARD_APPLE_JESSICA = new Card(2, 50, APPLE, new Date(), oneYearFromNow, USER_JESSICA);
    }
}
