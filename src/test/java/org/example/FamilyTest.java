package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {

    @Test
    void testToString() {
        Human mother = new Human("Jessica", "Parker", 1970);
        Human father = new Human("Max", "Parker", 1968);
        Family family = new Family(mother, father);
        String ExpectedResult = "Family{mother=Human{name='Jessica', surname='Parker', year=1970, iq=0, schedule=null}, father=Human{name='Max', surname='Parker', year=1968, iq=0, schedule=null}, children=[], pet=[]}";
        assertEquals(ExpectedResult, family.toString(), "They are not equal");
    }

    @Test
    void testDeleteChild() {
        Human mother = new Human("Jessica", "Parker", 1970);
        Human father = new Human("Max", "Parker", 1968);
        Family family = new Family(mother, father);
        Family family2 = new Family(mother, father);
        Human child = new Human("Veronica", "Parker", 1995);
        family.addChild(child);

        assertNotEquals(family2, family, "deleting complete");
        assertTrue(family.deleteChild(child), "deleting complete");

        Human child2 = new Human("Natasha", "Parker", 1993);
        assertFalse(family.deleteChild(child2), "child2 is not exists");
        assertNull(child2.getFamily());
    }

    @Test
    void testDeleteChildByIndex() {
        Human mother = new Human("Jessica", "Parker", 1970);
        Human father = new Human("Max", "Parker", 1968);
        Family family = new Family(mother, father);
        Human child = new Human("Veronica", "Parker", 1995);
        family.addChild(child);
        assertTrue(family.deleteChild(0), "deleting complete");
        assertEquals(0, family.getChildren().size());

        assertFalse(family.deleteChild(12), "not found");
        assertEquals(0, family.getChildren().size());
        assertNull(child.getFamily());
    }

    @Test
    void testAddChild() {
        Human mother = new Human("Jessica", "Parker", 1970);
        Human father = new Human("Max", "Parker", 1968);
        Family family = new Family(mother, father);
        Human child = new Human("Veronica", "Parker", 1995);
        family.addChild(child);
        assertEquals(1, family.getChildren().size());
        assertEquals(family, child.getFamily());
    }

    @Test
    void TestCountFamily() {
        Human mother = new Human("Jessica", "Parker", 1970);
        Human father = new Human("Max", "Parker", 1968);
        Family family = new Family(mother, father);
        Human child = new Human("Veronica", "Parker", 1995);
        family.addChild(child);
        assertEquals(3, family.countFamily(), "countFamily should return 3 person");
    }

    @Test
    void testEquals() {
        Human mother = new Human("Jessica", "Parker", 1970);
        Human father = new Human("Max", "Parker", 1968);
        Family family = new Family(mother, father);
        Human mother2 = new Human("Jessica", "Parker", 1970);
        Human father2 = new Human("Max", "Parker", 1968);
        Family family2 = new Family(mother2, father2);
        assertEquals(family2, family, "they are equal");
        Human mother3 = new Human("Veronica", "Parker", 1970);
        Human father3 = new Human("Oleg", "Parker", 1968);
        Family family3 = new Family(mother3, father3);
        assertNotEquals(family3, family, "they are not equal");
    }

    @Test
    void testHashCode() {
        Human mother = new Human("Jessica", "Parker", 1970);
        Human father = new Human("Max", "Parker", 1968);
        Family family = new Family(mother, father);
        Human mother2 = new Human("Jessica", "Parker", 1970);
        Human father2 = new Human("Max", "Parker", 1968);
        Family family2 = new Family(mother2, father2);
        assertEquals(family2.hashCode(), family.hashCode());
    }
}