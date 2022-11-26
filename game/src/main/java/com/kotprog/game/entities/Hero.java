package com.kotprog.game.entities;

/**
 * A Hero class.
 *
 * A saját hősünk tulajdonságait és az azokhoz tartozó metódusokat tartalmazza.
 * Minden tulajdonság 1-re van alapból állítva.
 */

public class Hero  {
    private int attack;
    private int defence;
    private int spellpower;
    private int knowledge;
    private int morale;
    private int luck;

    public Hero() {
        setAttack(1);
        setDefence(1);
        setSpellpower(1);
        setKnowledge(1);
        setMorale(1);
        setLuck(1);
    }

    public int getAttack() {
        return attack;
    }
    public int getDefence() {
        return defence;
    }
    public int getSpellpower() {
        return spellpower;
    }
    public int getKnowledge() {
        return knowledge;
    }
    public int getMorale() {
        return morale;
    }
    public int getLuck() {
        return luck;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }public void setDefence(int defence) {
        this.defence = defence;
    }public void setSpellpower(int spellpower) {
        this.spellpower = spellpower;
    }public void setKnowledge(int knowledge) {
        this.knowledge = knowledge;
    }public void setMorale(int morale) {
        this.morale = morale;
    }public void setLuck(int luck) {
        this.luck = luck;
    }
}
