package org.example.Services;

import org.example.*;
import org.example.DAO.CollectionFamilyDao;
import org.example.Exceptions.FamilyOverflowException;

import java.time.Year;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FamilyService {
    private CollectionFamilyDao familyDao = new CollectionFamilyDao();
    private static final int MAX_FAMILY_SIZE = 7;

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        if (!getAllFamilies().isEmpty()) {
            System.out.println("All families:");
            List<Family> allFamilies = familyDao.getAllFamilies();
            List<String> familyString = allFamilies.stream()
                    .map(family -> family.prettyFormat()).collect(Collectors.toList());
            IntStream.range(0, allFamilies.size())
                    .forEach(index -> System.out.println(index + 1 + ". " + familyString.get(index)));
        } else {
            System.out.println("No families");
        }
    }

    public List<Family> getFamiliesBiggerThan(int quantity) {
        AtomicInteger counter = new AtomicInteger(0);
        return familyDao.getAllFamilies()
                .stream()
                .filter(family -> family.countFamily() > quantity)
                .peek(family -> {
                    int index = counter.incrementAndGet();
                    System.out.println(index + ". " + family.prettyFormat());
                })
                .collect(Collectors.toList());
    }

    public List<Family> getFamiliesLessThan(int quantity) {
        AtomicInteger counter = new AtomicInteger(0);
        return familyDao.getAllFamilies()
                .stream()
                .filter(family -> family.countFamily() < quantity)
                .peek(family -> {
                    int index = counter.incrementAndGet();
                    System.out.println(index + ". " + family.prettyFormat());
                })
                .collect(Collectors.toList());
    }

    public int countFamiliesWithMemberNumber(int quantity) {
        AtomicInteger counter = new AtomicInteger(0);
        return (int) familyDao.getAllFamilies()
                .stream()
                .filter(family -> family.countFamily() == quantity)
                .peek(family -> {
                    int index = counter.incrementAndGet();
                    System.out.println(index + ". " + family.prettyFormat());
                })
                .count();
    }

    public void createNewFamily(Human human1, Human human2) {
        Family family = new Family(human1, human2);
        familyDao.saveFamily(family);
    }

    public Family bornChild(Family family, String boyName, String girlName) throws FamilyOverflowException {
        if (family.countFamily() < MAX_FAMILY_SIZE) {
            String childName = Math.random() < 0.5 ? boyName : girlName;
            Human child;
            if (childName.equals(boyName)) {
                child = new Man();
                child.setGender("boy");
            } else if (childName.equals(girlName)) {
                child = new Woman();
                child.setGender("girl");
            } else {
                child = new Human();
            }
            child.setFamily(family);
            child.setSurname(family.getFather().getSurname());
            child.setName(childName);
            family.addChild(child);
            return family;
        } else {
            throw new FamilyOverflowException("Досягнут ліміт по кількості у сім'ї");
        }
    }

    public Family adoptChild(Family family, Human human) throws FamilyOverflowException {
        if (family.countFamily() < MAX_FAMILY_SIZE) {
            family.addChild(human);
            familyDao.saveFamily(family);
            return family;
        } else {
            throw new FamilyOverflowException("Досягнут ліміт по кількості у сім'ї");
        }
    }

    public void deleteAllChildrenOlderThen(int age) {
        Year currentYear = Year.now();
        familyDao.getAllFamilies().forEach(family -> {
            family.setChildren(
                    family.getChildren().stream()
                            .filter(human -> {
                                int birthYear = human.calculateBirthdayZonedDateTime(human.getBirthDate()).getYear();
                                int ageOfHuman = currentYear.getValue() - birthYear;
                                return ageOfHuman <= age;
                            })
                            .toList()
            );
            familyDao.saveFamily(family);
        });
    }

    public int count() {
        System.out.println("The quantity of families is " + familyDao.getAllFamilies().size());
        return familyDao.getAllFamilies().size();
    }

    public Set<Pet> getPets(int index) {
        Family family = familyDao.getFamilyByIndex(index);
        System.out.println("This family has pets: " + family.getPets());
        return family.getPets();
    }

    public void addPet(int familyIndex, Pet pet) {
        if (familyIndex >= 0 && familyIndex < familyDao.getAllFamilies().size()) {
            familyDao.getAllFamilies().get(familyIndex).addPet(pet);
        }
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyDao.deleteFamily(index);
    }

    public boolean deleteFamilyByFamily(Family family) {
        return familyDao.deleteFamily(family);
    }

    public Family getFamilyById(int index) {
        return familyDao.getFamilyByIndex(index);
    }

    public void setAllFamilies(List<Family> families) {
        familyDao.setAllFamilies(families);
    }
}
