package org.example;

import java.io.Serializable;
import java.util.*;
import java.util.stream.IntStream;

public class Family implements HumanCreator, Serializable {
    static {
        System.out.println("Loading new Class Family");
    }

    {
        System.out.println("Creating new Family Object");
    }

    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pets;

    public Family(Human mother, Human father) {
        if (mother == null || father == null) {
            throw new IllegalArgumentException("Must be two parents");
        }
        this.mother = mother;
        this.father = father;

        this.mother.setFamily(this);
        this.father.setFamily(this);

        this.children = new ArrayList<>();
        this.pets = new HashSet<>();
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public Pet addPet(Pet pet) {
        pets.add(pet);
        pet.setFamily(this);
        return pet;
    }

    public Pet findOnePet(Pet onePet) {
        if (pets != null) {
            for (Pet pet : pets) {
                if (pet.equals(onePet)) {
                    return pet;
                }
            }
        }
        return null;
    }

    public void addChild(Human child) {
        this.children.add(child);
        child.setFamily(this);
    }

    public boolean deleteChild(Human child) {
        return this.children.remove(child);
    }

    public boolean deleteChild(int index) {
        if (index < 0 || index >= children.size()) {
            return false;
        }
        Human child = children.remove(index);
        if (child != null) {
            child.setFamily(null);
            return true;
        } else {
            return false;
        }
    }

    public String prettyFormat() {
        String motherPrettyFormat = "\tmother: {name=" + getMother().getName() + ", surname=" + getMother().getSurname()
                + ", birthDate=" + getMother().convertToMillisRevert() + ", iq=" + getMother().getIq() + ", schedule={"
                + getMother().getSchedule() + "}}";
        String fatherPrettyFormat = "\tfather: {name=" + getFather().getName() + ", surname=" + getFather().getSurname()
                + ", birthDate=" + getFather().convertToMillisRevert() + ", iq=" + getFather().getIq() + ", schedule={"
                + getFather().getSchedule() + "}}";
        StringBuilder boy = new StringBuilder();
        StringBuilder girl = new StringBuilder();
        StringBuilder human = new StringBuilder();
        StringBuilder children = new StringBuilder();
        if (!this.getChildren().isEmpty()) {
            boy.append("\n\t\tboy: ");
            girl.append("\n\t\tgirl: ");
            human.append("\n\t\thuman: ");
            children.append("\nchildren:");
            for (Human child : this.getChildren()) {
                if (child.getGender() != null) {
                    if (child.getGender().equals("boy")) {
                        children.append(boy.append("{name=").append(child.getName()).append(", surname=")
                                .append(child.getSurname()).append(", birthDate=").append(child.convertToMillisRevert())
                                .append(", iq=").append(child.getIq()).append(", schedule={")
                                .append(child.getSchedule()).append("}}"));
                    } else {
                        children.append(girl.append("{name=").append(child.getName()).append(", surname=")
                                .append(child.getSurname()).append(", birthDate=").append(child.convertToMillisRevert())
                                .append(", iq=").append(child.getIq()).append(", schedule={")
                                .append(child.getSchedule()).append("}}"));
                    }
                } else {
                    children.append(human.append("{name=").append(child.getName()).append(", surname=")
                            .append(child.getSurname()).append(", birthDate=").append(child.convertToMillisRevert())
                            .append(", iq=").append(child.getIq()).append(", schedule={").append(child.getSchedule())
                            .append("}}"));
                }
            }
        }
        StringBuilder pets = new StringBuilder();
        if (!this.getPets().isEmpty()) {
            pets.append("\n\t");
            pets.append("pets: ");
            pets.append(this.getPets().stream().map(Pet::toString).toList());
        }
        return "Family:\n" + motherPrettyFormat + "\n" + fatherPrettyFormat + children + pets;
    }

    public int countFamily() {
        return children.size() + 2;
    }

    @Override
    public String toString() {
        return "Family{mother=" + this.mother + ", father=" + this.father + ", children=" + this.children + ", pet=" + this.pets + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) &&
                Objects.equals(father, family.father) &&
                Objects.equals(children, family.children) &&
                Objects.equals(pets, family.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father, pets);
    }

    protected void finalize() throws Throwable {
        System.out.println("Deleting from class Family object " + this);
        super.finalize();
    }

    @Override
    public void bornChild(Human child) {
        Random random = new Random();
        int num = random.nextInt(0, 2);
        int nameIndex = random.nextInt(Names.values().length);
        int iq = (this.father.getIq() + this.mother.getIq()) / 2;
        if (num == 0) {
            Man man = new Man();
            man.setFamily(this);
            man.setSurname(this.father.getSurname());
            man.setName(String.valueOf(Names.values()[nameIndex]));
            man.setIq(iq);
            this.addChild(man);
        } else {
            Woman woman = new Woman();
            woman.setFamily(this);
            woman.setSurname(this.father.getSurname());
            woman.setName(String.valueOf(Names.values()[nameIndex]));
            woman.setIq(iq);
            this.addChild(woman);
        }
    }
}