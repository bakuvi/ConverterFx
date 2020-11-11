package sample;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import javax.swing.event.ChangeEvent;


public class Controller {

    @FXML
    private ChoiceBox<Mesaures> choiseboxId;

    @FXML
    private TextField textField;


    @FXML
    private Text tonnsText;

    @FXML
    private Text kiloText;

    @FXML
    private Text gramsText;

    @FXML
    void initialize() {
        ObservableList<Mesaures> observableList = Mesaures.getMeasureList();
        choiseboxId.setItems(observableList);
       ChangeListener<Mesaures> changeListener= new ChangeListener<Mesaures>() {

           @Override
           public void changed(ObservableValue<? extends Mesaures> observableValue, Mesaures mesaures, Mesaures t1) {
               if (textField.getCharacters().length() > 0)
                   setValues();
           }


       };


        choiseboxId.getSelectionModel().selectFirst();
        choiseboxId.getSelectionModel().selectedItemProperty().addListener(changeListener);
    }


    private void setValues() {

if (choiseboxId.getValue()!=null){
        switch (choiseboxId.getValue().toString()) {
            case "Тонны":
                ifTonns(textField.getText());
                break;
            case "Киллограммы":
                ifKilos(textField.getText());
                break;
            case "Граммы":
                ifGrams(textField.getText());
                break;
        }}

    }

    private void ifTonns(String number) {
        Double grams = Double.valueOf(number) * 1_000_000;
        Double kilos = Double.valueOf(number) * 1_000;
        tonnsText.setText(number);
        kiloText.setText(kilos.toString());
        gramsText.setText(grams.toString());
    }

    private void ifKilos(String number) {
        Double grams = Double.valueOf(number) * 1_000;
        Double tonns = Double.valueOf(number) / 1000;
        tonnsText.setText(tonns.toString());
        kiloText.setText(number);
        gramsText.setText(grams.toString());
    }

    private void ifGrams(String number) {
        Double kilos = Double.valueOf(number) / 1_000;
        Double tonns = Double.valueOf(number) / 1000_000;
        tonnsText.setText(tonns.toString());
        kiloText.setText(kilos.toString());
        gramsText.setText(number);
    }
}
