package com.kotprog.game.entities;


/**
 * A Unit osztály.
 *
 * Ez az osztály egy egység adatait tartalmazza és az azokhoz kapcsolódó metódusokat.
 */

public class Unit {
    private final String name;
    private final int cost;
    private final int minDamage;
    private final int maxDamage;
    private final int health;
    private final int speed;
    private final int initiative;
    private final String special;

    public Unit(String name, int cost, int minDamage, int maxDamage, int health, int speed, int initiative, String special) {
        this.name = name;
        this.cost = cost;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.health = health;
        this.speed = speed;
        this.initiative = initiative;
        this.special = special;
    }

    public String getName() {
        return name;
    }
    public int getCost() {
        return cost;
    }
    public int getMinDamage() {
        return minDamage;
    }
    public int getMaxDamage() {
        return maxDamage;
    }
    public int getHealth() {
        return health;
    }
    public int getSpeed() {
        return speed;
    }
    public int getInitiative() {
        return initiative;
    }
    public String getSpecial() {
        return special;
    }


}
