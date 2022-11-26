package com.kotrpog.game;

import com.kotprog.game.ControllerHero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestControllerHero {
    @Test
    public void testSetters() {
        ControllerHero controllerHero = new ControllerHero();
        controllerHero.setGold(1300);
        controllerHero.setVrtCost(5);
        controllerHero.setVirtuePt(1);

        assertEquals(1300, controllerHero.getGold(), "Az arany mennyiség nincs jól beállítva");
        assertEquals(5, controllerHero.getVrtCost(), "A tulajdonságpont ára nincs jól beállítva");
        assertEquals(1, controllerHero.getVirtuePt(), "A megvásárolt tulajdonságpontok száma nincs jól beállítva");

        ControllerHero controllerHero1 = new ControllerHero();
        controllerHero1.setGold(1000);
        controllerHero1.setVrtCost(13);
        controllerHero1.setVirtuePt(5);

        assertEquals(1000, controllerHero1.getGold(), "Az arany mennyiség nincs jól beállítva");
        assertEquals(13, controllerHero1.getVrtCost(), "A tulajdonságpont ára nincs jól beállítva");
        assertEquals(5, controllerHero1.getVirtuePt(), "A megvásárolt tulajdonságpontok száma nincs jól beállítva");

        ControllerHero controllerHero2 = new ControllerHero();
        controllerHero2.setGold(700);
        controllerHero2.setVrtCost(6);
        controllerHero2.setVirtuePt(11);

        assertEquals(700, controllerHero2.getGold(), "Az arany mennyiség nincs jól beállítva");
        assertEquals(6, controllerHero2.getVrtCost(), "A tulajdonságpont ára nincs jól beállítva");
        assertEquals(11, controllerHero2.getVirtuePt(), "A megvásárolt tulajdonságpontok száma nincs jól beállítva");
    }
}
