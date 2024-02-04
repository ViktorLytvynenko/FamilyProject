package org.example;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.example.Species.DOG;
import static org.junit.jupiter.api.Assertions.*;

class PetTest {

    @org.junit.jupiter.api.Test
    void testToString() {
        Set<String> habits = new LinkedHashSet<>();
        habits.add("eat");
        habits.add("drink");
        habits.add("sleep");

        Dog dog = new Dog("Rock", (byte) 5, (byte) 75, habits);
        dog.setSpecies(DOG);
        String ExpectedResult = "DOG{nickname='Rock', age=5, trickLevel=75, habits=[eat, drink, sleep], canFly=false, numberOfLegs=4, hasFur=true}";
        assertEquals(ExpectedResult, dog.toString(), "They are not equal");
    }

    @Test
    void testEquals() {
        Set<String> habits = new HashSet<>();
        habits.add("eat");
        habits.add("drink");
        habits.add("sleep");
        Pet dog1 = new Dog("Rock", (byte) 5, (byte) 75, habits);
        Pet dog2 = new Dog("Rock", (byte) 5, (byte) 75, habits);
        Pet dog3 = new Dog("Rambo", (byte) 5, (byte) 75, habits);
        assertEquals(dog1, dog2);
        assertNotEquals(dog3, dog1);
    }

    @Test
    void testHashCode() {
        Set<String> habits = new HashSet<>();
        habits.add("eat");
        habits.add("drink");
        habits.add("sleep");
        Pet dog1 = new Dog("Rock", (byte) 5, (byte) 75, habits);
        Pet dog2 = new Dog("Rock", (byte) 5, (byte) 75, habits);
        assertEquals(dog1.hashCode(), dog2.hashCode());
    }
}