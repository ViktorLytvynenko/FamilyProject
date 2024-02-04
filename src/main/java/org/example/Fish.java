package org.example;

import java.util.Set;

public class Fish extends Pet implements Foul {
    public Fish(String nickname) {
        super(nickname);
    }

    public Fish() {
    }

    public Fish(String nickname, byte age, byte trickLevel, Set<String> habits) {
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
