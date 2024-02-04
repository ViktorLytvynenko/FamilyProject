package org.example;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public abstract class Pet implements Serializable {
    static {
        System.out.println("Loading new Class Pet");
    }

    {
        System.out.println("Creating new Pet Object");
    }

    private Species species = Species.UNKNOWN;
    private String nickname;
    private byte age;
    private byte trickLevel;
    private Set<String> habits;
    private Family family;

    public void eat() {
        System.out.println("Я ї'м!");
    }

    public abstract void respond(String _nickname);

    private static boolean validateTrickLevel(byte trickLevel) {
        return trickLevel >= 0 && trickLevel <= 100;
    }

    public Pet(String nickname) {
        this.nickname = nickname;
    }

    public Pet() {
    }

    public Pet(String nickname, byte age, byte trickLevel, Set<String> habits) {
        this.nickname = nickname;
        this.age = age;
        if (Pet.validateTrickLevel(trickLevel))
            this.trickLevel = trickLevel;
        else throw new IllegalArgumentException("It must be a number from 0 to 100");
        this.habits = habits;
    }

    public Species getSpecies() {
        return species;
    }

    public String getNickname() {
        return nickname;
    }

    public byte getAge() {
        return age;
    }

    public byte getTrickLevel() {
        return trickLevel;
    }

    public Set<String> getHabits() {
        return habits;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public void setTrickLevel(byte trickLevel) {
        this.trickLevel = trickLevel;
    }

    public void setHabits(Set<String> habits) {
        this.habits = habits;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return this.species + "{nickname='" + this.nickname + "', age=" + this.age + ", trickLevel=" + this.trickLevel + ", habits=" + this.habits + ", canFly=" + this.species.isCanFly() + ", numberOfLegs=" + this.species.getNumberOfLegs() + ", hasFur=" + this.species.isHasFur() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(species, pet.species) &&
                Objects.equals(nickname, pet.nickname) &&
                Objects.equals(age, pet.age) &&
                Objects.equals(trickLevel, pet.trickLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, nickname, age, trickLevel);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Deleting from class Pet object " + this);
        super.finalize();
    }
}