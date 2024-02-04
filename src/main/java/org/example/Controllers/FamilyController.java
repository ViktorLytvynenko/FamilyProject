package org.example.Controllers;

import org.example.Exceptions.FamilyOverflowException;
import org.example.Family;
import org.example.Human;
import org.example.Pet;
import org.example.Services.FamilyService;

import java.util.List;
import java.util.Set;

public class FamilyController {
    FamilyService familyService;

    public FamilyController() {
        this.familyService = new FamilyService();
    }

    public List<Family> getAllFamilies() {
        return familyService.getAllFamilies();
    }

    public void createNewFamily(Human human1, Human human2) {
        familyService.createNewFamily(human1, human2);
    }

    public void displayAllFamilies() {
        familyService.displayAllFamilies();
    }

    public List<Family> getFamiliesBiggerThan(int quantity) {
        return familyService.getFamiliesBiggerThan(quantity);
    }

    public List<Family> getFamiliesLessThan(int quantity) {
        return familyService.getFamiliesLessThan(quantity);
    }

    public int countFamiliesWithMemberNumber(int quantity) {
        return familyService.countFamiliesWithMemberNumber(quantity);
    }

    public Family bornChild(Family family, String boyName, String girlName) throws FamilyOverflowException {
        return familyService.bornChild(family, boyName, girlName);
    }

    public Family adoptChild(Family family, Human human) throws FamilyOverflowException {
        return familyService.adoptChild(family, human);
    }

    public void deleteAllChildrenOlderThen(int age) {
        familyService.deleteAllChildrenOlderThen(age);
    }

    public int count() {
        return familyService.count();
    }

    public Set<Pet> getPets(int index) {
        return familyService.getPets(index);
    }

    public void addPet(int familyIndex, Pet pet) {
        familyService.addPet(familyIndex, pet);
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyService.deleteFamilyByIndex(index);
    }

    public boolean deleteFamilyByFamily(Family family) {
        return familyService.deleteFamilyByFamily(family);
    }

    public Family getFamilyById(int index) {
        return familyService.getFamilyById(index);
    }

    public void setAllFamilies(List<Family> families) {
        familyService.setAllFamilies(families);
    }
}