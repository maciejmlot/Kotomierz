package com.example.kotomierz;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import static com.example.kotomierz.Cat.father;
import static com.example.kotomierz.Cat.mother;

public class SpawnView implements Initializable {
    /**
     * kontroler widoku podsumowania miotu
     */
    @FXML private Label result1;
    @FXML private Label result2;
    @FXML private VBox spawnContainerPane;

    @FXML
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /**
         * metoda inicjalizująca kolor tła
         */
        spawnContainerPane.setBackground(new Background(new BackgroundFill(Color.web("#708090"), null, null)));
    }

    @FXML
    public void printResult() {
        /**
         * metoda przedstawiająca wynik krzyżowania matki o ojcem
         */
        Map<String, Integer> spawnList;
        List<Map<String, Integer>> spawnMap = new ArrayList<Map<String, Integer>>();
        spawnMap = Cat.intercourse();
        String res = "";
        mother.setPhenotype();
        System.out.printf(mother.getPhenotype());

        spawnList = spawnMap.get(0);
        res += "Wybarwienie:\n";
        for (Map.Entry<String, Integer> trait : spawnList.entrySet()) {
            res += trait.getKey() + " " + trait.getValue() + "%\n";
        }

        result1.setText(res);
        father.setPhenotype();
        res = "";
        System.out.printf(father.getPhenotype());

        spawnList = spawnMap.get(1);
        res += "\nPręgowanie:\n";
        for (Map.Entry<String, Integer> trait : spawnList.entrySet()) {
            res += trait.getKey() + " " + trait.getValue() + "%\n";
        }

        spawnList = spawnMap.get(2);
        res += "\nDługość sierści:\n";
        for (Map.Entry<String, Integer> trait : spawnList.entrySet()) {
            res += trait.getKey() + " " + trait.getValue() + "%\n";
        }

        spawnList = spawnMap.get(3);
        res += "\nŁaty:\n";
        for (Map.Entry<String, Integer> trait : spawnList.entrySet()) {
            res += trait.getKey() + " " + trait.getValue() + "%\n";
        }

        result2.setText(res);
    }

    @FXML
    public void close() {
        /**
         * metoda zamyka program
         */
        Platform.exit();
    }
}
