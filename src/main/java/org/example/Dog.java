package org.example;

import java.util.Set;

public class Dog extends Pet implements Foul {
    public Dog(String nickname) {
        super(nickname);
    }

    public Dog() {
    }

    public Dog(String nickname, byte age, byte trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }

    @Override
    public void respond(String _nickname) {
        System.out.println("Привіт, хазяїн. Я - " + _nickname + ". Я скучив!");
    }

    @Override
    public void foul() {
        System.out.println("Потрібно добре замести сліди...");
    }
}
