package test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import bar.AgeGroup;
import bar.Person;
import bar.Beverage;
import bar.Guest;
import bar.Bartender;
import bar.util.AgeGroupException;

public class Task2 {
    static final String[] MSG_CTOR1 = {
        "The constructor does not set the name correctly",
        "TODO HU"
    };
    static final String[] MSG_CTOR2 = {
        "The constructor does not set the price correctly",
        "TODO HU"
    };
    static final String[] MSG_CTOR3 = {
        "The constructor does not set the legal age correctly",
        "TODO HU"
    };
    static final String[] MSG_STR1 = {
        "toString is incorrect",
        "TODO HU"
    };
    static final String[] MSG_NONE1 = {
        "none is not represented correctly in Guest",
        "TODO HU"
    };

    @Test(expected = AgeGroupException.class)
    public void AgeGroupExceptionExists() throws AgeGroupException {
        throw new AgeGroupException("Exists");
    }

    @Test
    public void beverageConstructorIsCorrect() {
        Beverage beverage = new Beverage("2012 Villanyi Cuvee", 35900, 18);
        assertEquals(MSG_CTOR1[Task1.MSGIDX], "2012 Villanyi Cuvee", beverage.getName());
        assertEquals(MSG_CTOR2[Task1.MSGIDX], 35900, beverage.getPrice());
        assertEquals(MSG_CTOR3[Task1.MSGIDX], 18, beverage.getLegalAge());
    }

    @Test
    public void beverageToStringCorrect() {
        Beverage beverage = new Beverage("2012 Villanyi Cuvee", 35900, 18);
        assertEquals(MSG_STR1[Task1.MSGIDX], "2012 Villanyi Cuvee (35900, 18)", beverage.toString());
    }

    @Test
    public void guestContainsBeverages() {
        Guest guest = new Guest("Ferenc Foldvary", 19, AgeGroup.UNSPECIFIED);
        guest.getBeverage();
    }

    @Test
    public void guestContainsNone() {
        Guest guest = new Guest("Robert Ronto", 37, AgeGroup.ADULT);
        assertEquals(MSG_NONE1[Task1.MSGIDX], "none", guest.getBeverage().getName());
    }

    @Test(expected = AgeGroupException.class)
    public void bartenderConstructor() throws AgeGroupException {
        Bartender bartender = new Bartender("Ferenc Szabo", 17, AgeGroup.MINOR);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void personGiveBeverageBehavior() throws AgeGroupException {
        Person person = new Person("Albert Pesti", 39, AgeGroup.ADULT);
        Guest guest = new Guest("Szilvia Kiss", 14, AgeGroup.MINOR);
        Beverage beverage = new Beverage("Decaffeinated cappucino", 900, 6);
        person.giveBeverage(guest, beverage);
    }
}
