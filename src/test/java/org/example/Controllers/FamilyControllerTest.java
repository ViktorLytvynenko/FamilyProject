package org.example.Controllers;

import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FamilyControllerTest {
    private FamilyController familyController;
    @BeforeEach
    void init() {
        this.familyController = new FamilyController();
        Human mother = new Human("Jessica", "Parker", 1970);
        Human father = new Human("Max", "Parker", 1968);
        familyController.createNewFamily(mother, father);
    }

    @Test
    void createNewFamily() {
//        assertThat
        FamilyController familyControllerExpected = new FamilyController();
        assertNotEquals(familyControllerExpected, familyController);
    }

    @Test
    void getAllFamilies() {
        List<Family> result = familyController.getAllFamilies();
        assertEquals(1, result.size());
    }

    @Test
    void getFamiliesBiggerThan() {
        List<Family> result = familyController.getFamiliesLessThan(3);
        System.out.println(result.size());
        assertEquals(1, result.size());
    }

    @Test
    void getFamiliesLessThan() {
        List<Family> result = familyController.getFamiliesLessThan(3);
        System.out.println(result.size());
        assertEquals(1, result.size());
    }

    @Test
    void countFamiliesWithMemberNumber() {
        int result = familyController.countFamiliesWithMemberNumber(2);
        System.out.println(result);
        assertEquals(1, result);
    }

    @Test
    void bornChild() {
        Family result = familyController.bornChild(familyController.getFamilyById(0), "Erik", "Elsa");
        assertEquals(1, result.getChildren().size());
    }

    @Test
    void adoptChild() {
        Man child = new Man("Alex", "Dexter", 1991);
        familyController.adoptChild(familyController.getFamilyById(0), child);
        assertEquals(3, familyController.getFamilyById(0).countFamily());
    }

    @Test
    void deleteAllChildrenOlderThen() {
        Man child1 = new Man("Alex", "Dexter", 1991);
        Man child2 = new Man("Max", "Dexter", 2010);
        familyController.adoptChild(familyController.getFamilyById(0), child1);
        familyController.adoptChild(familyController.getFamilyById(0), child2);
        familyController.deleteAllChildrenOlderThen(20);
        assertEquals(3, familyController.getFamilyById(0).countFamily());
    }

    @Test
    void count() {
        int result = familyController.count();
        assertEquals(1, result);
    }

    @Test
    void getPets() {
        FamilyController familyController = new FamilyController();
        Human mother1 = new Human("Jessica", "Parker", 1970);
        Human father1 = new Human("Max", "Parker", 1968);
        Family family = new Family(mother1, father1);
        familyController.createNewFamily(mother1, father1);
        Set<Pet> result = familyController.getPets(0);
        assertEquals(family.getPets(), result);
        assertEquals(Collections.emptySet(), result);
    }

    @Test
    void addPet() {
        Dog dog = new Dog("Rock");
        familyController.getFamilyById(0).addPet(dog);
        Set<Pet> result = familyController.getPets(0);
        assertNotEquals(Collections.emptySet(), result);
    }

    @Test
    void deleteFamilyByIndex() {
        Human mother2 = new Human("Jessica2", "Parker", 1970);
        Human father2 = new Human("Max2", "Parker", 1968);
        familyController.createNewFamily(mother2, father2);
        familyController.deleteFamilyByIndex(1);
        assertEquals(1, familyController.count());
    }

    @Test
    void deleteFamilyByFamily() {
        Human mother2 = new Human("Jessica2", "Parker", 1970);
        Human father2 = new Human("Max2", "Parker", 1968);
        familyController.createNewFamily(mother2, father2);
        familyController.deleteFamilyByFamily(familyController.getFamilyById(0));
        assertEquals(1, familyController.count());
    }

    @Test
    void getFamilyById() {
        Family result =  familyController.getFamilyById(0);
        assertEquals("Max", result.getFather().getName());
    }
}