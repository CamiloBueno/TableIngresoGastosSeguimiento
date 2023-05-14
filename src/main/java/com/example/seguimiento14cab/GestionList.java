package com.example.seguimiento14cab;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GestionList {

    private ObservableList<Gestion> gestiones = FXCollections.observableArrayList();

    private ObservableList<Gestion> gestionesIngresos = FXCollections.observableArrayList();

    private ObservableList<Gestion> gestionesGastos = FXCollections.observableArrayList();

    public ObservableList<Gestion> getGestionesIngresos() {
        return gestionesIngresos;
    }

    public void setGestionesIngresos(ObservableList<Gestion> gestionesIngresos) {
        this.gestionesIngresos = gestionesIngresos;
    }

    public ObservableList<Gestion> getGestionesGastos() {
        return gestionesGastos;
    }

    public void setGestionesGastos(ObservableList<Gestion> gestionesGastos) {
        this.gestionesGastos = gestionesGastos;
    }

    //Constructor privado
    public ObservableList<Gestion> getGestiones() {
        return gestiones;
    }

    public void setGestiones(ObservableList<Gestion> gestiones) {
        this.gestiones = gestiones;
    }

    private GestionList(){}

    private static GestionList instance = null;

    public static GestionList getInstance(){
        if(instance == null){
            instance = new GestionList();
        }
        return instance;
    }
}
