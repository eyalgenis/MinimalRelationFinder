package org.eyalgenis;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimalRelationFinderTest {


    @Test
    public void init() {
        Person[] people = new Person[5];

        Person alan1 = new Person();
        alan1.setFullName(new Name("Alan", "Turing"));
        alan1.setAddress(new Address("Bletchley Park", ""));
        people[0] = alan1;

        Person alan2 = new Person();
        alan2.setFullName(new Name("Alan", "Turing"));
        alan2.setAddress(new Address("", "Cambridge"));
        people[1] = alan2;

        Person joan1 = new Person();
        joan1.setFullName(new Name("Joan", "Clarke"));
        joan1.setAddress(new Address("Bletchley Park", ""));
        people[2] = joan1;

        Person joan2 = new Person();
        joan2.setFullName(new Name("Joan", "Clarke"));
        joan2.setAddress(new Address("", "London"));
        people[3] = joan2;

        Person grace1 = new Person();
        grace1.setFullName(new Name("Grace", "Hopper"));
        grace1.setAddress(new Address("", "New York"));
        people[4] = grace1;

        MinimalRelationFinder finder = new MinimalRelationFinder();
        finder.Init(people);

        assertArrayEquals(finder.getPeople(), people);
    }

    @Test
    public void findMinRelationLevelTest1() {
        Person[] people = new Person[5];

        Person alan1 = new Person();
        alan1.setFullName(new Name("Alan", "Turing"));
        alan1.setAddress(new Address("Bletchley Park", ""));
        people[0] = alan1;

        Person alan2 = new Person();
        alan2.setFullName(new Name("Alan", "Turing"));
        alan2.setAddress(new Address("", "Cambridge"));
        people[1] = alan2;

        Person joan1 = new Person();
        joan1.setFullName(new Name("Joan", "Clarke"));
        joan1.setAddress(new Address("Bletchley Park", ""));
        people[2] = joan1;

        Person joan2 = new Person();
        joan2.setFullName(new Name("Joan", "Clarke"));
        joan2.setAddress(new Address("", "London"));
        people[3] = joan2;

        Person grace1 = new Person();
        grace1.setFullName(new Name("Grace", "Hopper"));
        grace1.setAddress(new Address("", "New York"));
        people[4] = grace1;

        MinimalRelationFinder finder = new MinimalRelationFinder();
        finder.Init(people);
        int minRelationLevel = finder.FindMinRelationLevel(alan1, joan2);

        assertEquals(2, minRelationLevel);
    }

    @Test
    public void findMinRelationLevelTest2() {
        Person[] people = new Person[6];

        Person alan1 = new Person();
        alan1.setFullName(new Name("Alan", "Turing"));
        alan1.setAddress(new Address("Bletchley Park", ""));
        people[0] = alan1;

        Person alan2 = new Person();
        alan2.setFullName(new Name("Alan", "Turing"));
        alan2.setAddress(new Address("", "Cambridge"));
        people[1] = alan2;

        Person joan1 = new Person();
        joan1.setFullName(new Name("Joan", "Clarke"));
        joan1.setAddress(new Address("Bletchley Park", ""));
        people[2] = joan1;

        Person joan2 = new Person();
        joan2.setFullName(new Name("Joan", "Clarke"));
        joan2.setAddress(new Address("", "London"));
        people[3] = joan2;

        Person grace1 = new Person();
        grace1.setFullName(new Name("Grace", "Hopper"));
        grace1.setAddress(new Address("", "New York"));
        people[4] = grace1;

        Person yossi1 = new Person();
        yossi1.setFullName(new Name("Yossi", "Cohen"));
        yossi1.setAddress(new Address("", "London"));
        people[5] = yossi1;

        MinimalRelationFinder finder = new MinimalRelationFinder();
        finder.Init(people);
        int minRelationLevel = finder.FindMinRelationLevel(alan1, yossi1);

        assertEquals(3, minRelationLevel);
    }

    @Test
    public void findMinRelationLevelTest3() {
        Person[] people = new Person[7];

        Person alan1 = new Person();
        alan1.setFullName(new Name("Alan", "Turing"));
        alan1.setAddress(new Address("Bletchley Park", ""));
        people[0] = alan1;

        Person alan2 = new Person();
        alan2.setFullName(new Name("Alan", "Turing"));
        alan2.setAddress(new Address("", "Cambridge"));
        people[1] = alan2;

        Person joan1 = new Person();
        joan1.setFullName(new Name("Joan", "Clarke"));
        joan1.setAddress(new Address("Bletchley Park", ""));
        people[2] = joan1;

        Person joan2 = new Person();
        joan2.setFullName(new Name("Joan", "Clarke"));
        joan2.setAddress(new Address("", "London"));
        people[3] = joan2;

        Person grace1 = new Person();
        grace1.setFullName(new Name("Grace", "Hopper"));
        grace1.setAddress(new Address("", "New York"));
        people[4] = grace1;

        Person yossi1 = new Person();
        yossi1.setFullName(new Name("Yossi", "Cohen"));
        yossi1.setAddress(new Address("", "London"));
        people[5] = yossi1;

        Person yossi2 = new Person();
        yossi2.setFullName(new Name("Yossi", "Cohen"));
        yossi2.setAddress(new Address("", "Cambridge"));
        people[6] = yossi2;

        MinimalRelationFinder finder = new MinimalRelationFinder();
        finder.Init(people);
        int minRelationLevel = finder.FindMinRelationLevel(alan1, yossi2);

        assertEquals(2, minRelationLevel);
    }
}