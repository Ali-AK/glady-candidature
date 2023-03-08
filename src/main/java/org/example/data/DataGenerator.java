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

    public static User USER_ALI;

    public static Company TESLA ;
    public static Company APPLE;

    public static Card CARD_TESLA_ALI;
    public static Card CARD_APPLE_ALI;

    public static List<User> users = new ArrayList<>();
    public static List<Card> cards = new ArrayList<>();

    static
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.YEAR, 1);
        Date oneYearFromNow = cal.getTime();
        Date now = new Date();

        // Generate a user
        USER_ALI = new User(1, "Ali", "Abou Khalil");

        // Generate Companies
        TESLA = new Company(1, "TESLA", 1000);
        APPLE = new Company(1, "APPLE", 1000);

        // Generate Cards
        CARD_TESLA_ALI = new Card(1, 100.0, TESLA, new Date(), oneYearFromNow, USER_ALI);
        CARD_APPLE_ALI = new Card(2, 50, APPLE, new Date(), oneYearFromNow, USER_ALI);
    }
}
