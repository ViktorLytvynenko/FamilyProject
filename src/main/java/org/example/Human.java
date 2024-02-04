package org.example;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.logging.SimpleFormatter;

public class Human implements Serializable {
    static {
        System.out.println("Loading new Class Human");
    }

    {
        System.out.println("Creating new Human Object");
    }

    private String name;
    private String surname;
    private long birthDate;
    private int iq;
    private Map <DayOfWeek, String> schedule;
    private Family family;
    private Pet pet;
    private String gender;

    public void greetPet() {
        if (getFamily().getPets() != null) {
            for (Pet pet : getFamily().getPets()) {
                System.out.println("Привіт, " + this.family.findOnePet(pet).getNickname());
            }
        } else {
            System.out.println("no pets");
        }
    }

    public void describePet() {
        if (getFamily().getPets() != null) {
            for (Pet pet : getFamily().getPets()) {
                String trickLevel = (this.family.findOnePet(pet).getTrickLevel() > 50) ? "дуже хитрий" : "майже не хитрий";
                System.out.println("У мене є " + this.family.findOnePet(pet).getSpecies() + ", їй " + this.family.findOnePet(pet).getAge() + " років, він " + trickLevel);
            }
        } else {
            System.out.println("no pets");
        }
    }

    public boolean feedPet(boolean timeToFeed) {
        if (getFamily().getPets() != null) {
            if (timeToFeed) {
                for (Pet pet : getFamily().getPets()) {
                    System.out.println("Хм... треба мені годувати " + this.family.findOnePet(pet).getNickname() + ".");
                }
                return true;
            } else {
                Random random = new Random();
                byte randomNumber = (byte) random.nextInt(101);
                for (Pet pet : getFamily().getPets()) {
                    if (this.family.findOnePet(pet).getTrickLevel() > randomNumber) {
                        System.out.println("Хм... треба мені годувати " + this.family.findOnePet(pet).getNickname() + ".");
                        return true;
                    } else {
                        System.out.println("Думаю, " + this.family.findOnePet(pet).getNickname() + " не голодний.");
                    }
                }
                return false;
            }
        }
        return false;
    }

    public Human(String name, String surname, long birthDate, Pet pet) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.pet = pet;
    }

    public Human(String name, String surname, long birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public Human(String name, String surname, long birthDate, int iq, Map <DayOfWeek, String> schedule, Pet pet) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.iq = iq;
        this.schedule = schedule;
        this.pet = pet;
    }

    public Human(String name, String surname, long birthDate, int iq, Map <DayOfWeek, String> schedule, Pet pet, String gender) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.iq = iq;
        this.schedule = schedule;
        this.pet = pet;
        this.gender = gender;
    }

    public Human() {
    }

    public Human(String name, String surname, long birthDate, int iq, Map <DayOfWeek, String> schedule) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.iq = iq;
        this.schedule = schedule;
    }

    public Human(String name, String surname, String birthDate, int iq) throws ParseException {
        this.name = name;
        this.surname = surname;
        this.birthDate = this.convertToMillis(birthDate);
        this.iq = iq;
    }


    public void setFamily(Family family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public long getBirthDate() {
        return birthDate;
    }

    public int getIq() {
        return iq;
    }

    public Map <DayOfWeek, String> getSchedule() {
        return schedule;
    }

    public Family getFamily() {
        return family;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public void setSchedule(Map <DayOfWeek, String> schedule) {
        this.schedule = schedule;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long convertToMillis(String birthDate) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = simpleDateFormat.parse(birthDate);
        return date.getTime();
    }

    public String convertToMillisRevert() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date(birthDate);
        return simpleDateFormat.format(date);
    }

    public ZonedDateTime calculateBirthdayZonedDateTime(long birthDate) {
        Instant instant = Instant.ofEpochSecond(birthDate);
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, ZoneId.of("Europe/Kiev"));
        return zonedDateTime;
    }

    public String describeAge() {
        long currentTimeMillis = System.currentTimeMillis();
        long days = (currentTimeMillis - birthDate) / 1000 / 60 / 60 / 24;
        int years = (int) (days / 365);
        int months = (int) ((days % 365) / 30);
        int remainingDays = (int) (days % 30);
        return String.format("%d years, %d months, and %d days", years, months, remainingDays);
    }

    @Override
    public String toString() {
        return "Human{name='" + this.name + "', surname='" + this.surname + "', birthDate=" + this.convertToMillisRevert() + ", iq=" + this.iq + ", schedule=" + this.schedule + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(name, human.name) &&
                Objects.equals(surname, human.surname) &&
                Objects.equals(birthDate, human.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDate);
    }

    protected void finalize() throws Throwable {
        System.out.println("Deleting from class Human object " + this);
        super.finalize();
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
