package com.example.rpg;

import java.util.ArrayList;

public abstract class Hero {
    static int lifePoints;
    int armor;
    int power;

    Potion potion=new Potion();

    ArrayList<Potion> listePotion=new ArrayList<>();

    public int getLifePoints() {
        return lifePoints;
    }

    public int getPower() {
        return power;
    }
}
