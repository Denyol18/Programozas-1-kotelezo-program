package com.kotprog.game;

import com.kotprog.game.entities.Unit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * A ControllerUnit osztály.
 *
 * Ez az osztály felel a units.fxml irányításáért, és az egységek vásárlásáért. Megjeleníti az egységek tulajdonságait, majd
 * a vásárlás után megnyit egy új ablakot, amin megjelenik a csatatér.
 */

public class ControllerUnit {


    @FXML Label lblGold;
    @FXML Label lblBoughtF;
    @FXML Label lblBoughtA;
    @FXML Label lblBoughtG;
    @FXML Label lblBoughtI;
    @FXML Label lblBoughtAN;
    @FXML TextField txtFarmer;
    @FXML TextField txtArcher;
    @FXML TextField txtGriff;
    @FXML TextField txtInquisitor;
    @FXML TextField txtAngel;
    @FXML Button btnBattlefield;

    String goldStr;
    String farmerStr = "0";
    String archerStr = "0";
    String griffStr = "0";
    String inquisitorStr = "0";
    String angelStr = "0";
    String boughtFStr = "0";
    String boughtAStr = "0";
    String boughtGStr = "0";
    String boughtIStr = "0";
    String boughtANStr = "0";

    public Unit farmer = new Unit("Földműves", 2, 1, 1, 3, 4, 8, "nincs");
    public Unit archer = new Unit("Íjász", 6, 2, 4, 7, 4, 9, "lövés");
    public Unit griff = new Unit("Griff", 15, 5, 10, 30, 7, 15, "végtelen visszatámadás");
    public Unit inquisitor = new Unit("Inkvizítor", 20, 9, 12, 80, 5, 10, "varázslás");
    public Unit angel = new Unit("Angyal", 40, 45, 45, 180, 6, 11, "repülés");

    @FXML Label lblFarmerName;
    @FXML Label lblArcherName;
    @FXML Label lblGriffName;
    @FXML Label lblInquisitorName;
    @FXML Label lblAngelName;

    @FXML Label lblFarmerCost;
    @FXML Label lblArcherCost;
    @FXML Label lblGriffCost;
    @FXML Label lblInquisitorCost;
    @FXML Label lblAngelCost;

    @FXML Label lblFarmerDamage;
    @FXML Label lblArcherDamage;
    @FXML Label lblGriffDamage;
    @FXML Label lblInquisitorDamage;
    @FXML Label lblAngelDamage;

    @FXML Label lblFarmerHealth;
    @FXML Label lblArcherHealth;
    @FXML Label lblGriffHealth;
    @FXML Label lblInquisitorHealth;
    @FXML Label lblAngelHealth;

    @FXML Label lblFarmerSpeed;
    @FXML Label lblArcherSpeed;
    @FXML Label lblGriffSpeed;
    @FXML Label lblInquisitorSpeed;
    @FXML Label lblAngelSpeed;

    @FXML Label lblFarmerInitiative;
    @FXML Label lblArcherInitiative;
    @FXML Label lblGriffInitiative;
    @FXML Label lblInquisitorInitiative;
    @FXML Label lblAngelInitiative;

    @FXML Label lblFarmerSpecial;
    @FXML Label lblArcherSpecial;
    @FXML Label lblGriffSpecial;
    @FXML Label lblInquisitorSpecial;
    @FXML Label lblAngelSpecial;

    private int gold;
    final int farmerCost = farmer.getCost();
    final int archerCost = archer.getCost();
    final int griffCost = griff.getCost();
    final int inquisitorCost = inquisitor.getCost();
    final int angelCost = angel.getCost();


    public void setUnitShop(String goldStrIn) {
        lblFarmerName.setText(farmer.getName());
        lblArcherName.setText(archer.getName());
        lblGriffName.setText(griff.getName());
        lblInquisitorName.setText(inquisitor.getName());
        lblAngelName.setText(angel.getName());

        lblFarmerCost.setText(String.valueOf(farmerCost));
        lblArcherCost.setText(String.valueOf(archerCost));
        lblGriffCost.setText(String.valueOf(griffCost));
        lblInquisitorCost.setText(String.valueOf(inquisitorCost));
        lblAngelCost.setText(String.valueOf(angelCost));

        lblFarmerDamage.setText(farmer.getMinDamage() +"-"+ farmer.getMaxDamage());
        lblArcherDamage.setText(archer.getMinDamage() +"-"+ archer.getMaxDamage());
        lblGriffDamage.setText(griff.getMinDamage() +"-"+ griff.getMaxDamage());
        lblInquisitorDamage.setText(inquisitor.getMinDamage() +"-"+ inquisitor.getMaxDamage());
        lblAngelDamage.setText(angel.getMinDamage() +"-"+ angel.getMaxDamage());

        lblFarmerHealth.setText(String.valueOf(farmer.getHealth()));
        lblArcherHealth.setText(String.valueOf(archer.getHealth()));
        lblGriffHealth.setText(String.valueOf(griff.getHealth()));
        lblInquisitorHealth.setText(String.valueOf(inquisitor.getHealth()));
        lblAngelHealth.setText(String.valueOf(angel.getHealth()));

        lblFarmerSpeed.setText(String.valueOf(farmer.getSpeed()));
        lblArcherSpeed.setText(String.valueOf(archer.getSpeed()));
        lblGriffSpeed.setText(String.valueOf(griff.getSpeed()));
        lblInquisitorSpeed.setText(String.valueOf(inquisitor.getSpeed()));
        lblAngelSpeed.setText(String.valueOf(angel.getSpeed()));

        lblFarmerInitiative.setText(String.valueOf(farmer.getInitiative()));
        lblArcherInitiative.setText(String.valueOf(archer.getInitiative()));
        lblGriffInitiative.setText(String.valueOf(griff.getInitiative()));
        lblInquisitorInitiative.setText(String.valueOf(inquisitor.getInitiative()));
        lblAngelInitiative.setText(String.valueOf(angel.getInitiative()));

        lblFarmerSpecial.setText(farmer.getSpecial());
        lblArcherSpecial.setText(archer.getSpecial());
        lblGriffSpecial.setText(griff.getSpecial());
        lblInquisitorSpecial.setText(inquisitor.getSpecial());
        lblAngelSpecial.setText(angel.getSpecial());

        goldStr = goldStrIn;
        lblGold.setText(goldStr);
        gold = Integer.parseInt(goldStr);
        btnBattlefield.setDisable(true);
    }
    public void buyFarmer(ActionEvent e) {
        int temp;
        try {
            farmerStr = txtFarmer.getText();
            temp = Integer.parseInt(farmerStr);
            int temp1 = temp;
            if(temp == 0 || temp < 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Hiba :(");
                alert.setHeaderText("Pozitív egész számot adj meg!");
                alert.showAndWait();
            }
            else {
                temp *= getFarmerCost();
                if (getGold() <= 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Hiba :(");
                    alert.setHeaderText("Nincs több aranyod!");
                    alert.showAndWait();
                } else if (getGold() - temp < 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Hiba :(");
                    alert.setHeaderText("Nincs elég aranyod!");
                    alert.showAndWait();
                } else {
                    setGold(gold -= temp);
                    goldStr = String.valueOf(gold);
                    lblGold.setText(goldStr);
                    boughtFStr = lblBoughtF.getText();
                    int temp2 = Integer.parseInt(boughtFStr);
                    temp2 += temp1;
                    boughtFStr = String.valueOf(temp2);
                    lblBoughtF.setText(boughtFStr);
                    btnBattlefield.setDisable(false);
                }
            }
        } catch (Exception exception) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Hiba :(");
            alert.setHeaderText("Pozitív egész számot adj meg!");
            alert.showAndWait();
        }

    }
    public void buyArcher(ActionEvent e) {
        int temp;
        try {
            archerStr = txtArcher.getText();
            temp = Integer.parseInt(archerStr);
            if (temp == 0 || temp < 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Hiba :(");
                alert.setHeaderText("Pozitív egész számot adj meg!");
                alert.showAndWait();
            }
            else {
                int temp1 = temp;
                temp *= getArcherCost();
                if (getGold() <= 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Hiba :(");
                    alert.setHeaderText("Nincs több aranyod!");
                    alert.showAndWait();
                } else if (getGold() - temp < 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Hiba :(");
                    alert.setHeaderText("Nincs elég aranyod!");
                    alert.showAndWait();
                } else {
                    setGold(gold -= temp);
                    goldStr = String.valueOf(gold);
                    lblGold.setText(goldStr);
                    boughtAStr = lblBoughtA.getText();
                    int temp2 = Integer.parseInt(boughtAStr);
                    temp2 += temp1;
                    boughtAStr = String.valueOf(temp2);
                    lblBoughtA.setText(boughtAStr);
                    btnBattlefield.setDisable(false);
                }
            }
        } catch (Exception exception) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Hiba :(");
            alert.setHeaderText("Pozitív egész számot adj meg!");
            alert.showAndWait();
        }

    }
    public void buyGriff(ActionEvent e) {
        int temp;
        try {
            griffStr = txtGriff.getText();
            temp = Integer.parseInt(griffStr);
            if(temp == 0 || temp < 0)  {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Hiba :(");
                alert.setHeaderText("Pozitív egész számot adj meg!");
                alert.showAndWait();
            }
            else {
                int temp1 = temp;
                temp *= getGriffCost();
                if (getGold() <= 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Hiba :(");
                    alert.setHeaderText("Nincs több aranyod!");
                    alert.showAndWait();
                } else if (getGold() - temp < 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Hiba :(");
                    alert.setHeaderText("Nincs elég aranyod!");
                    alert.showAndWait();
                } else {
                    setGold(gold -= temp);
                    goldStr = String.valueOf(gold);
                    lblGold.setText(goldStr);
                    boughtGStr = lblBoughtG.getText();
                    int temp2 = Integer.parseInt(boughtGStr);
                    temp2 += temp1;
                    boughtGStr = String.valueOf(temp2);
                    lblBoughtG.setText(boughtGStr);
                    btnBattlefield.setDisable(false);
                }
            }
        } catch (Exception exception)  {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Hiba :(");
            alert.setHeaderText("Pozitív egész számot adj meg!");
            alert.showAndWait();
        }
    }

    public void buyInquisitor(ActionEvent e) {
        int temp;
        try {
            inquisitorStr = txtInquisitor.getText();
            temp = Integer.parseInt(inquisitorStr);
            if(temp == 0 || temp < 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Hiba :(");
                alert.setHeaderText("Pozitív egész számot adj meg!");
                alert.showAndWait();
            }
            else {
                int temp1 = temp;
                temp *= getInquisitorCost();
                if (getGold() <= 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Hiba :(");
                    alert.setHeaderText("Nincs több aranyod!");
                    alert.showAndWait();
                } else if (getGold() - temp < 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Hiba :(");
                    alert.setHeaderText("Nincs elég aranyod!");
                    alert.showAndWait();
                } else {
                    setGold(gold -= temp);
                    goldStr = String.valueOf(gold);
                    lblGold.setText(goldStr);
                    boughtIStr = lblBoughtI.getText();
                    int temp2 = Integer.parseInt(boughtIStr);
                    temp2 += temp1;
                    boughtIStr = String.valueOf(temp2);
                    lblBoughtI.setText(boughtIStr);
                    btnBattlefield.setDisable(false);
                }
            }
        } catch (Exception exception) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Hiba :(");
            alert.setHeaderText("Pozitív egész számot adj meg!");
            alert.showAndWait();
        }
    }

    public void buyAngel(ActionEvent e) {
        int temp;
        try {
            angelStr = txtAngel.getText();
            temp = Integer.parseInt(angelStr);
            if(temp == 0 || temp < 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Hiba :(");
                alert.setHeaderText("Pozitív egész számot adj meg!");
                alert.showAndWait();
            }
            else {
                int temp1 = temp;
                temp *= getAngelCost();
                if (getGold() <= 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Hiba :(");
                    alert.setHeaderText("Nincs több aranyod!");
                    alert.showAndWait();
                } else if (getGold() - temp < 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Hiba :(");
                    alert.setHeaderText("Nincs elég aranyod!");
                    alert.showAndWait();
                } else {
                    setGold(gold -= temp);
                    goldStr = String.valueOf(gold);
                    lblGold.setText(goldStr);
                    boughtANStr = lblBoughtAN.getText();
                    int temp2 = Integer.parseInt(boughtANStr);
                    temp2 += temp1;
                    boughtANStr = String.valueOf(temp2);
                    lblBoughtAN.setText(boughtANStr);
                    btnBattlefield.setDisable(false);
                }
            }
        } catch (Exception exception) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Hiba :(");
            alert.setHeaderText("Pozitív egész számot adj meg!");
            alert.showAndWait();
        }
    }


    public void toBattlefield(ActionEvent e) {

        Stage stage = (Stage) btnBattlefield.getScene().getWindow();
        stage.close();
        ControllerBattle controllerTactics = new ControllerBattle();
        controllerTactics.battlefield(lblBoughtF, lblBoughtA, lblBoughtG, lblBoughtI, lblBoughtAN);
    }


    public int getFarmerCost() {
        return farmerCost;
    }public int getArcherCost() {
        return archerCost;
    }public int getGriffCost() {
        return griffCost;
    }public int getInquisitorCost() {
        return inquisitorCost;
    }public int getAngelCost() {
        return angelCost;
    }public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
