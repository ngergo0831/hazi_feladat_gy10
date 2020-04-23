package test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import bar.AgeGroup;
import bar.Person;

public class Task1 {
    // Set as 0 for messages in English.
    // Magyar nyelvű szövegekhez állítsd 1-re.
    public static final int MSGIDX = 0;


    static final String MSG_CTOR1[] = {
        "The constructor does not set the title correctly",
        "TODO HU"
    };
    static final String MSG_CTOR2[] = {
        "The constructor does not set the age correctly",
        "TODO HU"
    };
    static final String MSG_CTOR3[] = {
        "The constructor does not set the age group correctly",
        "TODO HU"
    };
    static final String MSG_SETTER1[] = {
        "setName is incorrect",
        "TODO HU"
    };
    static final String MSG_PERSON_TOSTRING1[] = {
        "toString is incorrect",
        "TODO HU"
    };

    @Test
    public void enumHasAllValues() {
        AgeGroup.valueOf("ADULT");
        AgeGroup.valueOf("MINOR");
        AgeGroup.valueOf("UNSPECIFIED");
    }

    @Test
    public void PersonConstructorCorrect() {
        Person person = new Person("Kate Ellen", 19, AgeGroup.UNSPECIFIED);
        assertEquals(MSG_CTOR1[MSGIDX], "Kate Ellen", person.getName());
        assertEquals(MSG_CTOR2[MSGIDX], 19, person.getAge());
        assertEquals(MSG_CTOR3[MSGIDX], AgeGroup.UNSPECIFIED, person.getAgeGroup());
    }

    @Test(expected = IllegalArgumentException.class)
    public void PersonConstructorThrowsExceptionOnNegativeAge() {
        Person person = new Person("Kate Ellen", -9, AgeGroup.ADULT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void PersonConstructorThrowsExceptionOnNullName() {
        Person person = new Person(null, 10, AgeGroup.MINOR);
    }

    @Test(expected = IllegalArgumentException.class)
    public void PersonConstructorThrowsExceptionOnEmptyString() {
        Person person = new Person("   ", 19, AgeGroup.ADULT);
    }

    @Test
    public void settersAreCorrect() {
        Person person = new Person("Zsolt Farago", 43, AgeGroup.ADULT);
        person.setName("Istvan Daniel");
        assertEquals(MSG_SETTER1[MSGIDX], "Istvan Daniel", person.getName());
    }

    @Test
    public void personToStringIsCorrect() {
        Person person = new Person("Kate Ellen", 19, AgeGroup.UNSPECIFIED);
        assertEquals(MSG_PERSON_TOSTRING1[MSGIDX], "Kate Ellen (19, UNSPECIFIED)", person.toString());
    }
}
