package org.example.DAO;

import org.example.Family;
import org.example.Human;
import org.example.Pet;

import java.util.List;
import java.util.Set;

public interface FamilyDao {
    List<Family> getAllFamilies();
    void setAllFamilies(List<Family> families);
    Family getFamilyByIndex(int index);
    boolean deleteFamily(int index);
    boolean deleteFamily(Family family);
    void saveFamily(Family family);
}
