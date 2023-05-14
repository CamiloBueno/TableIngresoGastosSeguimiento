package com.example.seguimiento14cab;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class RegistrarMontoController implements Initializable {
    @FXML
    public TextField descripcionTf;

    @FXML
    private TextField fechaTf;

    @FXML
    private ComboBox<String> ingresoGastoCb;

    @FXML
    private TextField montoTf;

    @FXML
    private Button registrarBt;

    ObservableList<String> ingresoGastoCbcontent =
            FXCollections.observableArrayList(
                    "Ingreso",
                    "Gasto"
            );
    private Date date;


    @FXML
    void RegistrarMoney(ActionEvent event) {
        //al presionar el boton registrar. llamar las entradas

        String tipo = ingresoGastoCb.getValue();

        double monto = Double.parseDouble(montoTf.getText());//se parsea por que originalmente es String siempre

        String descripcion = descripcionTf.getText();

        String fecha = fechaTf.getText();

        Gestion gestion = new Gestion(monto, descripcion, fecha, tipo);

        GestionList.getInstance().getGestiones().add(gestion);
        if(tipo.toLowerCase().equals(("ingreso"))){
            GestionList.getInstance().getGestionesIngresos().add(gestion);
        }else{
            GestionList.getInstance().getGestionesGastos().add(gestion);

        }
        abrirVentana();

        registrarBt.
    }

    public int compareTo(RegistrarMontoController register){
        return register.date.compareTo(this.date);
    }



    public void abrirVentana(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        Stage thisStage = (Stage) registrarBt.getScene().getWindow();
        thisStage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ingresoGastoCb.setItems(ingresoGastoCbcontent);

    }


}
