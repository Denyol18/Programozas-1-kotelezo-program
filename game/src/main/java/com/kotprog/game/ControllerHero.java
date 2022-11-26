package com.kotprog.game;

import com.kotprog.game.entities.Hero;
import com.kotprog.game.entities.Spell;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * A ControllerHero osztály.
 *
 * Ez az osztály felel a hero.fxml irányításáért, a hősünk tulajdonságainak beállításáért, a varázslatok
 * vásárlásáért és a units.fxml fájl betöltéséért.
 *
 */

public class ControllerHero {

    @FXML Label lblGold;
    @FXML Label lblVrtCost;
    @FXML Label lblVirtue;
    @FXML Label lblAttack;
    @FXML Label lblDefence;
    @FXML Label lblSpellpower;
    @FXML Label lblKnowledge;
    @FXML Label lblLuck;
    @FXML Label lblMorale;

    @FXML Button btnSpellOne;
    @FXML Button btnSpellTwo;
    @FXML Button btnSpellThree;

    @FXML Label lblSplOneName;
    @FXML Label lblSplTwoName;
    @FXML Label lblSplThreeName;

    @FXML Label lblSplOneCost;
    @FXML Label lblSplTwoCost;
    @FXML Label lblSplThreeCost;

    @FXML Label lblSplOneMana;
    @FXML Label lblSplTwoMana;
    @FXML Label lblSplThreeMana;


    String attackStr;
    String defenceStr;
    String spellpowerStr;
    String knowledgeStr;
    String moraleStr;
    String luckStr;
    String virtuePtStr;
    String vrtCostStr;
    String goldStr;

    static Hero hero = new Hero();

    static int attack = hero.getAttack();
    static int defence = hero.getDefence();
    static int spellpower = hero.getSpellpower();
    static int knowledge = hero.getKnowledge();
    static int morale = hero.getMorale();
    static int luck = hero.getLuck();


    private int virtuePt = 0;
    private int gold = 0;
    private int vrtCost = 5;

    public static Spell one = new Spell("Villámcsapás", 60, 5);
    public static Spell two = new Spell("Tűzlabda", 120, 9);
    public static Spell three = new Spell("Feltámasztás", 120, 6);

    private final int spellOneCost = one.getCost();
    private final int spellTwoCost = two.getCost();
    private final int spellThreeCost = three.getCost();

    public static boolean boughtSpellOne = false;
    public static boolean boughtSpellTwo = false;
    public static boolean boughtSpellThree = false;

    /**
     * A setHeroShop függvény.
     *
     * Beállítja azoknak az elemeknek az értékeit, amik kellenek a hős tulajdonságainak fejlesztéséhez és a varázslatok
     * vásárlásához.
     *
     * @param goldStrIn a ControllerDiff-ből érkező arany mennyiség String-ként.
     */

    public void setHeroShop(String goldStrIn) {
        lblGold.setText(String.valueOf(gold));
        lblVrtCost.setText(String.valueOf(vrtCost));
        lblVirtue.setText(String.valueOf(virtuePt));
        lblAttack.setText(String.valueOf(attack));
        lblDefence.setText(String.valueOf(defence));
        lblSpellpower.setText(String.valueOf(spellpower));
        lblKnowledge.setText(String.valueOf(knowledge));
        lblLuck.setText(String.valueOf(luck));
        lblMorale.setText(String.valueOf(morale));


        lblSplOneName.setText(one.getName());
        lblSplTwoName.setText(two.getName());
        lblSplThreeName.setText(three.getName());

        lblSplOneCost.setText(String.valueOf(one.getCost()));
        lblSplTwoCost.setText(String.valueOf(two.getCost()));
        lblSplThreeCost.setText(String.valueOf(three.getCost()));

        lblSplOneMana.setText(String.valueOf(one.getManaCost()));
        lblSplTwoMana.setText(String.valueOf(two.getManaCost()));
        lblSplThreeMana.setText(String.valueOf(three.getManaCost()));


        goldStr = goldStrIn;
        lblGold.setText(goldStr);
        gold = Integer.parseInt(goldStr);

    }

    /**
     * A buyVirtue függvény.
     *
     * Ez a függvény felel a tulajdonságpontok vásárlásáért.
     *
     * @param e egy ActionEvent, ami jelzi, hogy a művelet megtörtént, ez esetben a gombra való kattintás.
     */


    public void buyVirtue(ActionEvent e) {
        if(getGold() - getVrtCost() < 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Hiba :(");
            alert.setHeaderText("Legalább 1 egység vásárláshoz lennie kell elegendő aranynak! \n Nincs elég aranyod!");
            alert.showAndWait();
        }
        else if(getGold() - getVrtCost() < 2) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Hiba :(");
            alert.setHeaderText("Legalább 1 egység vásárláshoz lennie kell elegendő aranynak!");
            alert.showAndWait();
        }
        else {
            setVirtuePt(virtuePt + 1);
            setGold(gold - getVrtCost());
            setVrtCost((int)Math.ceil((getVrtCost() * getMulti())));
            vrtCostStr = String.valueOf(vrtCost);
            lblVrtCost.setText(vrtCostStr);
            virtuePtStr = String.valueOf(virtuePt);
            lblVirtue.setText(virtuePtStr);
            goldStr = String.valueOf(gold);
            lblGold.setText(goldStr);
        }
    }

    /**
     * A buySpell1 függvény.
     *
     * Ez a függvény felel az első számú varázslat megvásárlásáért.
     *
     * @param e egy ActionEvent, ami jelzi, hogy a művelet megtörtént, ez esetben a gombra való kattintás.
     */

    public void buySpell1(ActionEvent e) {
        if(getGold() - getSpellOneCost() < 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Hiba :(");
            alert.setHeaderText("Legalább 1 egység vásárláshoz lennie kell elegendő aranynak! \n Nincs elég aranyod!");
            alert.showAndWait();
        }
        else if (getGold() - getSpellOneCost() < 2) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Hiba :(");
            alert.setHeaderText("Legalább 1 egység vásárláshoz lennie kell elegendő aranynak!");
            alert.showAndWait();
        }
        else {
            btnSpellOne.setDisable(true);
            setGold(gold - getSpellOneCost());
            goldStr = String.valueOf(gold);
            lblGold.setText(goldStr);
            boughtSpellOne = true;
        }
    }


    /**
     * A buySpell2 függvény.
     *
     * Ez a függvény felel az második számú varázslat megvásárlásáért.
     *
     * @param e egy ActionEvent, ami jelzi, hogy a művelet megtörtént, ez esetben a gombra való kattintás.
     */

    public void buySpell2(ActionEvent e) {
        if(getGold() - getSpellTwoCost() < 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Hiba :(");
            alert.setHeaderText("Legalább 1 egység vásárláshoz lennie kell elegendő aranynak! \n Nincs elég aranyod!");
            alert.showAndWait();
        }
        else if(getGold() - getSpellTwoCost() < 2) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Hiba :(");
            alert.setHeaderText("Legalább 1 egység vásárláshoz lennie kell elegendő aranynak!");
            alert.showAndWait();
        }
        else{
            btnSpellTwo.setDisable(true);
            setGold(gold - getSpellTwoCost());
            goldStr = String.valueOf(gold);
            lblGold.setText(goldStr);
            boughtSpellTwo = true;
        }
    }

    /**
     * A buySpell3 függvény.
     *
     * Ez a függvény felel a harmadik számú varázslat megvásárlásáért.
     *
     * @param e egy ActionEvent, ami jelzi, hogy a művelet megtörtént, ez esetben a gombra való kattintás.
     */

    public void buySpell3(ActionEvent e) {
        if(getGold() - getSpellThreeCost() < 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Hiba :(");
            alert.setHeaderText("Legalább 1 egység vásárláshoz lennie kell elegendő aranynak! \n Nincs elég aranyod!");
            alert.showAndWait();
        }
        else if(getGold() - getSpellThreeCost() < 2) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Hiba :(");
            alert.setHeaderText("Legalább 1 egység vásárláshoz lennie kell elegendő aranynak!");
            alert.showAndWait();
        }
        else{
            btnSpellThree.setDisable(true);
            setGold(gold - getSpellThreeCost());
            goldStr = String.valueOf(gold);
            lblGold.setText(goldStr);
            boughtSpellThree = true;
        }
    }

    /**
     * A plusAttack függvény.
     *
     * Ez a függvény felel a támadás tulajdonság növeléséért.
     *
     * @param e egy ActionEvent, ami jelzi, hogy a művelet megtörtént, ez esetben a gombra való kattintás.
     */


    public void plusAttack(ActionEvent e) {
        if(getVirtuePt() <= 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Hiba :(");
            alert.setHeaderText("Nincs felhasználható tulajdonság pontod!");
            alert.showAndWait();
        }
        else if(attack + 1 > 10) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Hiba :(");
            alert.setHeaderText("Egy tulajdonságon legfeljebb 10 tulajdonságpont lehet!");
            alert.showAndWait();
        }
        else {
            setAttack(attack + 1);
            setVirtuePt(virtuePt - 1);
            attackStr = String.valueOf(attack);
            lblAttack.setText(attackStr);
            virtuePtStr = String.valueOf(virtuePt);
            lblVirtue.setText(virtuePtStr);
        }
    }

    /**
     * A plusDefence függvény.
     *
     * Ez a függvény felel a védekezés tulajdonság növeléséért.
     *
     * @param e egy ActionEvent, ami jelzi, hogy a művelet megtörtént, ez esetben a gombra való kattintás.
     */

    public void plusDefence(ActionEvent e) {
        if(getVirtuePt() <= 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Hiba :(");
            alert.setHeaderText("Nincs felhasználható tulajdonság pontod!");
            alert.showAndWait();
        }
        else if(defence + 1 > 10) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Hiba :(");
            alert.setHeaderText("Egy tulajdonságon legfeljebb 10 tulajdonságpont lehet!");
            alert.showAndWait();
        }
        else {
            setDefence(defence + 1);
            setVirtuePt(virtuePt - 1);
            defenceStr = String.valueOf(defence);
            lblDefence.setText(defenceStr);
            virtuePtStr = String.valueOf(virtuePt);
            lblVirtue.setText(virtuePtStr);
        }
    }

    /**
     * A plusSpellpower függvény.
     *
     * Ez a függvény felel a varázserő tulajdonság növeléséért.
     *
     * @param e egy ActionEvent, ami jelzi, hogy a művelet megtörtént, ez esetben a gombra való kattintás.
     */

    public void plusSpellpower(ActionEvent e) {
        if(getVirtuePt() <= 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Hiba :(");
            alert.setHeaderText("Nincs felhasználható tulajdonság pontod!");
            alert.showAndWait();
        }
        else if (spellpower + 1 > 10) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Hiba :(");
            alert.setHeaderText("Egy tulajdonságon legfeljebb 10 tulajdonságpont lehet!");
            alert.showAndWait();
        }
        else {
            setSpellpower(spellpower + 1);
            setVirtuePt(virtuePt - 1);
            spellpowerStr = String.valueOf(spellpower);
            lblSpellpower.setText(spellpowerStr);
            virtuePtStr = String.valueOf(virtuePt);
            lblVirtue.setText(virtuePtStr);
        }
    }

    /**
     * A plusKnowledge függvény.
     *
     * Ez a függvény felel a tudás tulajdonság növeléséért.
     *
     * @param e egy ActionEvent, ami jelzi, hogy a művelet megtörtént, ez esetben a gombra való kattintás.
     */

    public void plusKnowledge(ActionEvent e) {
        if(getVirtuePt() <= 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Hiba :(");
            alert.setHeaderText("Nincs felhasználható tulajdonság pontod!");
            alert.showAndWait();
        }
        else if(knowledge + 1 > 10) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Hiba :(");
            alert.setHeaderText("Egy tulajdonságon legfeljebb 10 tulajdonságpont lehet!");
            alert.showAndWait();
        }
        else {
            setKnowledge(knowledge + 1);
            setVirtuePt(virtuePt - 1);
            knowledgeStr = String.valueOf(knowledge);
            lblKnowledge.setText(knowledgeStr);
            virtuePtStr = String.valueOf(virtuePt);
            lblVirtue.setText(virtuePtStr);
        }
    }

    /**
     * A plusMorale függvény.
     *
     * Ez a függvény felel a morál tulajdonság növeléséért.
     *
     * @param e egy ActionEvent, ami jelzi, hogy a művelet megtörtént, ez esetben a gombra való kattintás.
     */

    public void plusMorale(ActionEvent e) {
        if(getVirtuePt() <= 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Hiba :(");
            alert.setHeaderText("Nincs felhasználható tulajdonság pontod!");
            alert.showAndWait();
        }
        else if(morale + 1 > 10) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Hiba :(");
            alert.setHeaderText("Egy tulajdonságon legfeljebb 10 tulajdonságpont lehet!");
            alert.showAndWait();
        }
        else {
            setMorale(morale + 1);
            setVirtuePt(virtuePt - 1);
            moraleStr = String.valueOf(morale);
            lblMorale.setText(moraleStr);
            virtuePtStr = String.valueOf(virtuePt);
            lblVirtue.setText(virtuePtStr);
        }
    }

    /**
     * A plusLuck függvény.
     *
     * Ez a függvény felel a szerencse tulajdonság növeléséért.
     *
     * @param e egy ActionEvent, ami jelzi, hogy a művelet megtörtént, ez esetben a gombra való kattintás.
     */

    public void plusLuck(ActionEvent e) {
        if(getVirtuePt() <= 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Hiba :(");
            alert.setHeaderText("Nincs felhasználható tulajdonság pontod!");
            alert.showAndWait();
        }
        else if(luck + 1 > 10) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Hiba :(");
            alert.setHeaderText("Egy tulajdonságon legfeljebb 10 tulajdonságpont lehet!");
            alert.showAndWait();
        }
        else {
            setLuck(luck + 1);
            setVirtuePt(virtuePt - 1);
            luckStr = String.valueOf(luck);
            lblLuck.setText(luckStr);
            virtuePtStr = String.valueOf(virtuePt);
            lblVirtue.setText(virtuePtStr);
        }
    }



    /**
     * A toUnitShop függvény.
     *
     * Ez a függvény tölti be a units.fxml fájlt.
     *
     * @param e egy ActionEvent, ami jelzi, hogy a művelet megtörtént, ez esetben a gombra való kattintás.
     * @throws IOException kivétel, ami akkor dobódik, amikor egy i/o művelet elbukik.
     */

    public void toUnitShop(ActionEvent e) throws IOException {
        String goldStr1 = lblGold.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("units.fxml"));
        Parent root = loader.load();

        ControllerUnit controllerUnit = loader.getController();
        controllerUnit.setUnitShop(goldStr1);

        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    public int getAttack() {
        return attack;
    }public int getDefence() {
        return defence;
    }public int getSpellpower() {
        return spellpower;
    }public int getKnowledge() {
        return knowledge;
    }public int getMorale() {
        return morale;
    }public int getLuck() {
        return luck;
    }public int getVirtuePt() {
        return this.virtuePt;
    }public int getVrtCost() {
        return this.vrtCost;
    }public int getGold() {
        return this.gold;
    }public double getMulti() {
        double multi = 1.1;
        return multi;
    }public int getSpellOneCost() {
        return spellOneCost;
    }public int getSpellTwoCost() {
        return spellTwoCost;
    }public int getSpellThreeCost() {
        return spellThreeCost;
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

    public void setVirtuePt(int virtuePt) {
        this.virtuePt = virtuePt;
    }public void setVrtCost(int cost) {
        this.vrtCost = cost;
    }public void setGold(int gold) {
        this.gold = gold;
    }
}
