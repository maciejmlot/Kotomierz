package com.example.kotomierz;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.kotomierz.Cat.*;

public class FatherPollView implements Initializable{
    /**
     * kontroler ankiety ojca
     */
    private String A = "dom1";
    private String a = "rec1";
    private String a2 = "rec2";
    @FXML private VBox fatherContainerPane;
    @FXML private VBox b;
    @FXML private VBox d;
    @FXML private VBox o;
    @FXML private VBox mc;
    @FXML private VBox taA;
    @FXML private VBox c;
    @FXML private VBox l;
    @FXML private VBox sW;
    @FXML private RadioButton w;

    @Override
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /**
         * metoda inicjalizująca kolory oddzielające grupy pól w ankiecie
         */
        fatherContainerPane.setBackground(new Background(new BackgroundFill(Color.web("#708090"), null, null)));
        b.setBackground(new Background(new BackgroundFill(Color.web("#008080"), null, null)));
        d.setBackground(new Background(new BackgroundFill(Color.web("#008080"), null, null)));
        o.setBackground(new Background(new BackgroundFill(Color.web("#008080"), null, null)));
        mc.setBackground(new Background(new BackgroundFill(Color.web("#ffdab5"), null, null)));
        taA.setBackground(new Background(new BackgroundFill(Color.web("#ffdab5"), null, null)));
        c.setBackground(new Background(new BackgroundFill(Color.web("#008080"), null, null)));
        l.setBackground(new Background(new BackgroundFill(Color.web("#ff7f50"), null, null)));
        sW.setBackground(new Background(new BackgroundFill(Color.web("#e6e6fa"), null, null)));
        w.setBackground(new Background(new BackgroundFill(Color.web("#008080"), null, null)));
    }

    @FXML
    public void proceed() {
        /**
         * przejście dalej
         */
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("spawn-view.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Miot");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void setBlack() {
        /**
         * zmiana cechy
         */
        Gene genB = new Gene("b", A, a);
        Gene genD = new Gene("d", A, a);
        Gene genO = new Gene("o", a, a);
        Gene genC = new Gene("c", A, a);
        Gene genW = new Gene("w", a, a);

        father.setGene(6, genC);
        father.setGene(0, genB);
        father.setGene(1,genD);
        father.setGene(2, genO);
        father.setGene(9, genW);
    }

    @FXML public void setChocolate() {
        /**
         * zmiana cechy
         */
        Gene genB = new Gene("b", a, a);
        Gene genD = new Gene("d", A, a);
        Gene genO = new Gene("o", a, a);
        Gene genC = new Gene("c", A, a);
        Gene genW = new Gene("w", a, a);

        father.setGene(6, genC);
        father.setGene(0, genB);
        father.setGene(1,genD);
        father.setGene(2, genO);
        father.setGene(9, genW);
    }

    @FXML public void setCinnamon() {
        /**
         * zmiana cechy
         */
        Gene genB = new Gene("b", a2, a2);
        Gene genD = new Gene("d", A, a);
        Gene genO = new Gene("o", a, a);
        Gene genC = new Gene("c", A, a);
        Gene genW = new Gene("w", a, a);

        father.setGene(6, genC);
        father.setGene(0, genB);
        father.setGene(1,genD);
        father.setGene(2, genO);
        father.setGene(9, genW);
    }

    @FXML public void setLily() {
        /**
         * zmiana cechy
         */
        Gene genB = new Gene("b", a, a);
        Gene genD = new Gene("d", a, a);
        Gene genO = new Gene("o", a, a);
        Gene genC = new Gene("c", A, a);
        Gene genW = new Gene("w", a, a);

        father.setGene(6, genC);
        father.setGene(0, genB);
        father.setGene(1,genD);
        father.setGene(2, genO);
        father.setGene(9, genW);
    }

    @FXML public void setBlue() {
        /**
         * zmiana cechy
         */
        Gene genB = new Gene("b", A, a);
        Gene genD = new Gene("d", a, a);
        Gene genO = new Gene("o", a, a);
        Gene genC = new Gene("c", A, a);
        Gene genW = new Gene("w", a, a);

        father.setGene(6, genC);
        father.setGene(0, genB);
        father.setGene(1,genD);
        father.setGene(2, genO);
        father.setGene(9, genW);
    }

    @FXML public void setGray() {
        /**
         * zmiana cechy
         */
        Gene genB = new Gene("b", a2, a2);
        Gene genD = new Gene("d", a, a);
        Gene genO = new Gene("o", a, a);
        Gene genC = new Gene("c", A, a);
        Gene genW = new Gene("w", a, a);

        father.setGene(6, genC);
        father.setGene(0, genB);
        father.setGene(1,genD);
        father.setGene(2, genO);
        father.setGene(9, genW);
    }

    @FXML public void setRed() {
        /**
         * zmiana cechy
         */
        Gene genB = new Gene("b", a, a);
        Gene genD = new Gene("d", a, a);
        Gene genO = new Gene("o", A, A);
        Gene genC = new Gene("c", A, a);
        Gene genW = new Gene("w", a, a);

        father.setGene(6, genC);
        father.setGene(0, genB);
        father.setGene(1,genD);
        father.setGene(2, genO);
        father.setGene(9, genW);
    }

    @FXML public void setCreamy() {
        /**
         * zmiana cechy
         */
        Gene genB = new Gene("b", a, a);
        Gene genD = new Gene("d", A, a);
        Gene genO = new Gene("o", A, A);
        Gene genC = new Gene("c", A, a);
        Gene genW = new Gene("w", a, a);

        father.setGene(6, genC);
        father.setGene(0, genB);
        father.setGene(1,genD);
        father.setGene(2, genO);
        father.setGene(9, genW);
    }

    @FXML public void setClassic() {
        /**
         * zmiana cechy
         */
        Gene genMc = new Gene("mc", a, a);
        Gene genTa = new Gene("ta", a, a);
        Gene genA = new Gene("a", A, a);
        Gene genC = new Gene("c", A, a);
        Gene genW = new Gene("w", a, a);

        father.setGene(6, genC);
        father.setGene(3, genMc);
        father.setGene(4, genTa);
        father.setGene(5, genA);
        father.setGene(9, genW);
    }

    @FXML public void setTiger() {
        /**
         * zmiana cechy
         */
        Gene genMc = new Gene("mc", A, a);
        Gene genTa = new Gene("ta", a, a);
        Gene genA = new Gene("a", A, a);
        Gene genC = new Gene("c", A, a);
        Gene genW = new Gene("w", a, a);

        father.setGene(6, genC);
        father.setGene(3, genMc);
        father.setGene(4, genTa);
        father.setGene(5, genA);
        father.setGene(9, genW);
    }

    @FXML public void setMottled() {
        /**
         * zmiana cechy
         */
        Gene genMc = new Gene("mc", A, a);
        Gene genTa = new Gene("ta", a, a);
        Gene genA = new Gene("a", A, a);
        Gene genC = new Gene("c", A, a);
        Gene genW = new Gene("w", a, a);

        father.setGene(6, genC);
        father.setGene(3, genMc);
        father.setGene(4, genTa);
        father.setGene(5, genA);
        father.setGene(9, genW);
    }

    @FXML public void setTicked() {
        /**
         * zmiana cechy
         */
        Gene genMc = new Gene("mc", A, a);
        Gene genTa = new Gene("ta", A, a);
        Gene genA = new Gene("a", A, a);
        Gene genC = new Gene("c", A, a);
        Gene genW = new Gene("w", a, a);

        father.setGene(6, genC);
        father.setGene(3, genMc);
        father.setGene(4, genTa);
        father.setGene(5, genA);
        father.setGene(9, genW);
    }

    @FXML public void setUnmottled() {
        /**
         * zmiana cechy
         */
        Gene genMc = new Gene("mc", a, a);
        Gene genTa = new Gene("ta", a, a);
        Gene genA = new Gene("a", a, a);
        Gene genC = new Gene("c", A, a);
        Gene genW = new Gene("w", a, a);

        father.setGene(6, genC);
        father.setGene(3, genMc);
        father.setGene(4, genTa);
        father.setGene(5, genA);
        father.setGene(9, genW);
    }

    @FXML public void setAlbino() {
        /**
         * zmiana cechy
         */
        Gene genB = new Gene("b", A, a);
        Gene genD = new Gene("d", A, a);
        Gene genO = new Gene("o", A, A);
        Gene genMc = new Gene("mc", A, a);
        Gene genTa = new Gene("ta", A, a);
        Gene genA = new Gene("a", A, a);
        Gene genC = new Gene("c", a, a);
        Gene genW = new Gene("w", A, a);

        father.setGene(0, genB);
        father.setGene(1, genD);
        father.setGene(2, genO);
        father.setGene(3, genMc);
        father.setGene(4, genTa);
        father.setGene(5, genA);
        father.setGene(6, genC);
        father.setGene(9, genW);
    }

    @FXML public void setShort() {
        /**
         * zmiana cechy
         */
        Gene genL = new Gene("l", A, A);

        father.setGene(7, genL);
    }

    @FXML public void setLong() {
        /**
         * zmiana cechy
         */
        Gene genL = new Gene("l", a, a);

        father.setGene(7, genL);
    }

    @FXML public void setMorePatchy() {
        /**
         * zmiana cechy
         */
        Gene genS = new Gene("s", A, A);

        father.setGene(8, genS);
    }

    @FXML public void setLessPatchy() {
        /**
         * zmiana cechy
         */
        Gene genS = new Gene("s", A, a);

        father.setGene(8, genS);
    }

    @FXML public void setNoPatchy() {
        /**
         * zmiana cechy
         */
        Gene genS = new Gene("s", a, a);

        father.setGene(8, genS);
    }

    @FXML public void setWhite() {
        /**
         * zmiana cechy
         */
        Gene genB = new Gene("b", A, a);
        Gene genD = new Gene("d", A, a);
        Gene genO = new Gene("o", A, A);
        Gene genMc = new Gene("mc", A, a);
        Gene genTa = new Gene("ta", A, a);
        Gene genA = new Gene("a", A, a);
        Gene genC = new Gene("c", A, a);
        Gene genS = new Gene("s", A, a);
        Gene genW = new Gene("w", A, a);

        father.setGene(0, genB);
        father.setGene(1, genD);
        father.setGene(2, genO);
        father.setGene(3, genMc);
        father.setGene(4, genTa);
        father.setGene(5, genA);
        father.setGene(6, genC);
        father.setGene(8, genS);
        father.setGene(9, genW);
    }
}
