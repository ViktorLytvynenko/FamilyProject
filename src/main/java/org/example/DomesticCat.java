package org.example;

import java.util.Set;

public class DomesticCat extends Pet implements Foul {
    public DomesticCat(String nickname) {
        super(nickname);
    }

    public DomesticCat() {
    }

    public DomesticCat(String nickname, byte age, byte trickLevel, Set<String> habits) {
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
