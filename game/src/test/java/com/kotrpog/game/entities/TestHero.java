package com.kotrpog.game.entities;

import com.kotprog.game.entities.Hero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestHero {

    @Test
    public void testSetters() {
        Hero hero = new Hero();
        hero.setAttack(2);
        hero.setDefence(5);
        hero.setSpellpower(9);
        hero.setKnowledge(3);
        hero.setMorale(1);
        hero.setLuck(7);

        assertEquals(2, hero.getAttack(), "A hős támadás tulajdonsága nincs jól beállítva");
        assertEquals(5, hero.getDefence(), "A hős védekezés tulajdonsága nincs jól beállítva");
        assertEquals(9, hero.getSpellpower(), "A hős varázserő tulajdonsága nincs jól beállítva");
        assertEquals(3, hero.getKnowledge(), "A hős tudás tulajdonsága nincs jól beállítva");
        assertEquals(1, hero.getMorale(), "A hős morál tulajdonsága nincs jól beállítva");
        assertEquals(7, hero.getLuck(),"A hős szerencse tulajdonsága nincs jól beállítva");


        Hero hero1 = new Hero();
        hero1.setAttack(9);
        hero1.setDefence(6);
        hero1.setSpellpower(2);
        hero1.setKnowledge(5);
        hero1.setMorale(5);
        hero1.setLuck(1);

        assertEquals(9, hero1.getAttack(), "A hős támadás tulajdonsága nincs jól beállítva");
        assertEquals(6, hero1.getDefence(), "A hős védekezés tulajdonsága nincs jól beállítva");
        assertEquals(2, hero1.getSpellpower(), "A hős varázserő tulajdonsága nincs jól beállítva");
        assertEquals(5, hero1.getKnowledge(), "A hős tudás tulajdonsága nincs jól beállítva");
        assertEquals(5, hero1.getMorale(), "A hős morál tulajdonsága nincs jól beállítva");
        assertEquals(1, hero1.getLuck(),"A hős szerencse tulajdonsága nincs jól beállítva");

        Hero hero2 = new Hero();
        hero2.setAttack(1);
        hero2.setDefence(2);
        hero2.setSpellpower(6);
        hero2.setKnowledge(7);
        hero2.setMorale(2);
        hero2.setLuck(10);

        assertEquals(1, hero2.getAttack(), "A hős támadás tulajdonsága nincs jól beállítva");
        assertEquals(2, hero2.getDefence(), "A hős védekezés tulajdonsága nincs jól beállítva");
        assertEquals(6, hero2.getSpellpower(), "A hős varázserő tulajdonsága nincs jól beállítva");
        assertEquals(7, hero2.getKnowledge(), "A hős tudás tulajdonsága nincs jól beállítva");
        assertEquals(2, hero2.getMorale(), "A hős morál tulajdonsága nincs jól beállítva");
        assertEquals(10, hero2.getLuck(),"A hős szerencse tulajdonsága nincs jól beállítva");


    }
}
