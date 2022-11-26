package com.kotrpog.game.entities;

import com.kotprog.game.entities.Unit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUnit {
    @Test
    public void testConstructor() {
        Unit unit = new Unit("Földműves", 2, 1, 1, 3, 4, 8, "nincs");
        assertEquals("Földműves", unit.getName(), "Az egység neve nincs jól beállítva");
        assertEquals(1, unit.getMinDamage(), "Az egység minimális sebzése nincs jól beállítva");
        assertEquals("nincs", unit.getSpecial(), "Az egység speciális képessége nincs jól beállítva");
    }
}
