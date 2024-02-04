package org.example.DAO;

import org.example.Family;
import org.example.LoggerService;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {
    private List<Family> families;

    public CollectionFamilyDao() {
        this.families = new ArrayList<>();
    }

    @Override
    public List<Family> getAllFamilies() {
        LoggerService.info("Отримання списку сімей");
        return this.families;
    }

    @Override
    public void setAllFamilies(List<Family> families) {
        LoggerService.info("Запис списку сімей");
        this.families = families;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        try {
            LoggerService.info("Отримання сім'ї по індексу");
            return this.families.get(index);
        } catch (Exception e) {
            LoggerService.error("Помилка при отриманні сім'ї по індексу " + e.getMessage());
            throw e;
        }
    }

    @Override
    public boolean deleteFamily(int index) {
        try {
            LoggerService.info("Видалення сім'ї по індексу");
            if (index >= 0 && index < this.families.size()) {
                this.families.remove(index);
                return true;
            }
        } catch (Exception e) {
            LoggerService.error("Помилка при видаленні сім'ї по індексу " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteFamily(Family family) {
        try {
            LoggerService.info("Видалення сім'ї по типу сім'ї");
            if (families.size() > 0) {
                this.families.remove(family);
                return true;
            }
        } catch (Exception e) {
            LoggerService.error("Помилка при видаленні сім'ї по типу сім'ї " + e.getMessage());
        }
        return false;
    }

    @Override
    public void saveFamily(Family family) {
        try {
            LoggerService.info("Збереження сім'ї");
            if (this.families.contains(family)) {
                int index = families.indexOf(family);
                this.families.set(index, family);
            } else {
                families.add(family);
            }
        } catch (Exception e) {
            LoggerService.error("Помилка при збереженні сім'ї " + e.getMessage());
        }
    }
}