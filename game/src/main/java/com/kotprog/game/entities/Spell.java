package com.kotprog.game.entities;

/**
 * A Spell osztály.
 *
 * Ez az osztály tartalmazza egy varázslat nevét, költségét és manna költségét.
 * Az ezekhez tartozó metódusok is itt vannak.
 */

public class Spell {
    private final String name;
    private final int cost;
    private final int manaCost;

    public Spell(String name, int cost, int manaCost) {
        this.name = name;
        this.cost = cost;
        this.manaCost = manaCost;
    }

    public String getName() {
        return name;
    }
    public int getCost() {
        return cost;
    }
    public int getManaCost() {
        return manaCost;
    }
}
