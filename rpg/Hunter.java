package com.example.rpg;

import java.util.ArrayList;

public class Hunter extends Hero {
    int weaponsDamage;
    int weapons;
    public Hunter( int lifePoints, int armor, int power, int weaponsDamage, int weapons){

        this.lifePoints=lifePoints;
        this.armor=armor;
        this.power=power;
        this.weaponsDamage=weaponsDamage;
        this.weapons= weapons;
        //this.listePotion=listePotion;
    }

}
