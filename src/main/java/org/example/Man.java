package org.example;

import java.text.ParseException;
import java.util.Map;

public final class Man extends Human {
    public Man(String name, String surname, long birthDate, Pet pet) {
        super(name, surname, birthDate, pet);
    }

    public Man(String name, String surname, long birthDate) {
        super(name, surname, birthDate);
    }

    public Man(String name, String surname, long birthDate, int iq, Map<DayOfWeek, String> schedule, Pet pet) {
        super(name, surname, birthDate, iq, schedule, pet);
    }

    public Man(String name, String surname, String birthDate, int iq) throws ParseException {
        super(name, surname, birthDate, iq);
    }

    public Man(String name, String surname, long birthDate, int iq, Map<DayOfWeek, String> schedule) {
        super(name, surname, birthDate, iq, schedule);
    }

    public Man(String name, String surname, long birthDate, int iq, Map<DayOfWeek, String> schedule, Pet pet, String gender) {
        super(name, surname, birthDate, iq, schedule, pet, gender);
    }


    public Man() {
    }

    @Override
    public void greetPet() {
        if (getFamily().getPets() != null) {
            for (Pet pet : getFamily().getPets()) {
                System.out.println("Привіт, " + getFamily().findOnePet(pet).getNickname() + ". Ти дуже гарний!!!");
            }
        } else {
            System.out.println("no pets");
        }
    }

    public void repairCar() {
        System.out.println("Треба перевірити авто.");
    }
}
