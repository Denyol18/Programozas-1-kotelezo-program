package com.kotprog.game.entities;

import com.kotprog.game.ControllerDiff;

import java.util.Random;

/**
 * Az EnemyHero osztály.
 *
 * Az ellefél hősének tulajdnonságainak beállítása történik itt, illetve a varázslatainak kiválasztása.
 * A kiválasztott nehézségi fokozat figyelembe van véve itt.
 */

public class EnemyHero {

    ControllerDiff controllerDiff = new ControllerDiff();

    Random r = new Random();
    int minR = 1;
    int maxR;

    Random x = new Random();
    public int boughtSpells;

    private int enemyAttack;
    private int enemyDefence;
    private int enemySpellpower;
    private int enemyKnowledge;
    private int enemyMorale;
    private int enemyLuck;

    public EnemyHero() {
        if(controllerDiff.isBEasy()) {
            maxR = 4;
            enemyAttack = r.nextInt(maxR - minR) + minR;
            enemyDefence = r.nextInt(maxR - minR) + minR;
            enemySpellpower = r.nextInt(maxR - minR) + minR;
            enemyKnowledge = r.nextInt(maxR - minR) + minR;
            enemyMorale = r.nextInt(maxR - minR) + minR;
            enemyLuck = r.nextInt(maxR - minR) + minR;
            boughtSpells = x.nextInt(2);
        }
        else if(controllerDiff.isBMedium()) {
            maxR = 7;
            enemyAttack = r.nextInt(maxR - minR) + minR;
            enemyDefence = r.nextInt(maxR - minR) + minR;
            enemySpellpower = r.nextInt(maxR - minR) + minR;
            enemyKnowledge = r.nextInt(maxR - minR) + minR;
            enemyMorale = r.nextInt(maxR - minR) + minR;
            enemyLuck = r.nextInt(maxR - minR) + minR;
            int min = 1;
            boughtSpells = x.nextInt(3- min) + min;
        }
        else if(controllerDiff.isBHard()) {
            maxR = 11;
            enemyAttack = r.nextInt(maxR - minR) + minR;
            enemyDefence = r.nextInt(maxR - minR) + minR;
            enemySpellpower = r.nextInt(maxR - minR) + minR;
            enemyKnowledge = r.nextInt(maxR - minR) + minR;
            enemyMorale = r.nextInt(maxR - minR) + minR;
            enemyLuck = r.nextInt(maxR - minR) + minR;
            int min = 2;
            boughtSpells = x.nextInt(4- min) + min;
        }
    }


    public int getEnemyAttack() {
        return enemyAttack;
    }
    public int getEnemyDefence() {
        return enemyDefence;
    }
    public int getEnemySpellpower() {
        return enemySpellpower;
    }
    public int getEnemyKnowledge() {
        return enemyKnowledge;
    }
    public int getEnemyMorale() {
        return enemyMorale;
    }
    public int getEnemyLuck() {
        return enemyLuck;
    }
}
