package org.example;

import java.util.Set;

public class RoboCat extends Pet {
    public RoboCat(String nickname) {
        super(nickname);
    }

    public RoboCat() {
    }

    public RoboCat(String nickname, byte age, byte trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }

    @Override
    public void respond(String _nickname) {
        System.out.println("Привіт, хазяїн. Я - " + _nickname + ". Я скучив!");
    }
}
