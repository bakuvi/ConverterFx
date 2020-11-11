package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Mesaures {
    private String measure;

    public Mesaures(String mesaure) {
        this.measure = mesaure;
    }

    public String getMesaure() {
        return measure;
    }

    public void setMesaure(String measure) {
        this.measure = measure;
    }

    public static ObservableList<Mesaures> getMeasureList() {
        Mesaures kilogramm = new Mesaures("Киллограммы");
        Mesaures gramm = new Mesaures("Граммы");
        Mesaures tonn = new Mesaures("Тонны");

        ObservableList<Mesaures> list //
                = FXCollections.observableArrayList(gramm, kilogramm, tonn);

        return list;
    }

    @Override
    public String toString() {
        return measure;
    }
}
