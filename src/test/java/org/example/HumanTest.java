package org.example;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

    @Test
    void testToString() {
        Map<DayOfWeek, String> schedule = new HashMap<>();
        schedule.put(DayOfWeek.MONDAY, "go to courses");
        schedule.put(DayOfWeek.TUESDAY, "go to gym");
        schedule.put(DayOfWeek.WEDNESDAY, "go for a walk");
        schedule.put(DayOfWeek.THURSDAY, "go SPA");
        schedule.put(DayOfWeek.FRIDAY, "visit friends");
        schedule.put(DayOfWeek.SATURDAY, "watch a film");
        schedule.put(DayOfWeek.SUNDAY, "do home work");
        Map<DayOfWeek, String> sortedSchedule = new TreeMap<>(schedule);

        Human fatherDexter = new Human("John", "Dexter", 1900, 80, sortedSchedule);
        String ExpectedResult = "Human{name='John', surname='Dexter', year=1900, iq=80, schedule={MONDAY=go to courses, TUESDAY=go to gym, WEDNESDAY=go for a walk, THURSDAY=go SPA, FRIDAY=visit friends, SATURDAY=watch a film, SUNDAY=do home work}}";
        assertEquals(ExpectedResult, fatherDexter.toString(), "They are equal");
    }

    @Test
    void testEquals() {
        Map<DayOfWeek, String> schedule = new HashMap<>();
        schedule.put(DayOfWeek.MONDAY, "go to courses");
        schedule.put(DayOfWeek.TUESDAY, "go to gym");
        schedule.put(DayOfWeek.WEDNESDAY, "go for a walk");
        schedule.put(DayOfWeek.THURSDAY, "go SPA");
        schedule.put(DayOfWeek.FRIDAY, "visit friends");
        schedule.put(DayOfWeek.SATURDAY, "watch a film");
        schedule.put(DayOfWeek.SUNDAY, "do home work");
        Human fatherDexter = new Human("John", "Dexter", 1900, 80, schedule);
        Human fatherDexter2 = new Human("John", "Dexter", 1900, 80, schedule);
        assertEquals(fatherDexter2, fatherDexter, "They are equal");
        Human fatherDexter3 = new Human("Petya", "Dexter", 1900, 80, schedule);
        assertNotEquals(fatherDexter3, fatherDexter, "They are not equal");
    }

    @Test
    void testHashCode() {
        Map<DayOfWeek, String> schedule = new HashMap<>();
        schedule.put(DayOfWeek.MONDAY, "go to courses");
        schedule.put(DayOfWeek.TUESDAY, "go to gym");
        schedule.put(DayOfWeek.WEDNESDAY, "go for a walk");
        schedule.put(DayOfWeek.THURSDAY, "go SPA");
        schedule.put(DayOfWeek.FRIDAY, "visit friends");
        schedule.put(DayOfWeek.SATURDAY, "watch a film");
        schedule.put(DayOfWeek.SUNDAY, "do home work");
        Human fatherDexter = new Human("John", "Dexter", 1900, 80, schedule);
        Human fatherDexter2 = new Human("John", "Dexter", 1900, 80, schedule);
        assertEquals(fatherDexter2.hashCode(), fatherDexter.hashCode(), "They are equal");
    }
}