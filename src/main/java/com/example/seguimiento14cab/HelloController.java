package com.example.seguimiento14cab;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    public TableColumn montoC;
    @FXML
    public TableColumn descripcionC;
    @FXML
    public TableColumn fechaC;
    @FXML
    public TableView tablaGestionTv;
    @FXML
    public Label balanceLb;
    @FXML
    public Button registrarMovimientoBt;
    @FXML
    public Button refreshBt;
    @FXML
    private Button gastosBt;

    @FXML
    private Button ingresosBt;

    @FXML
    private Button resumenBt;
    @FXML
    public void regMovimiento(ActionEvent actionEvent) throws IOException {
        //para abrir una ventana diferente o la siguiente
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("registrarMonto.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        //para cerrar la ventana actual que es la que me lleva a la siguiente
        Stage thisStage = (Stage) ingresosBt.getScene().getWindow();
        thisStage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        montoC.setCellValueFactory(new PropertyValueFactory<>("monto"));
        descripcionC.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        fechaC.setCellValueFactory(new PropertyValueFactory<>("fecha"));


        tablaGestionTv.setItems(GestionList.getInstance().getGestiones());

    }
    @FXML //ponemos esto en el metodo para que se conecte el boton con el metodo
    public void balance(){

        //Ingresos - gastos
        ObservableList<Gestion> list = GestionList.getInstance().getGestiones();
        double balance = 0;
        for (int i = 0; i < list.size(); i++) {

            if(list.get(i).getTipo().toLowerCase().equals("ingreso")){
                balance += list.get(i).getMonto();
            }else{
                balance -= list.get(i).getMonto();
            }
        }
        balanceLb.setText("" + balance);
    }

    public void viewGastosBt(ActionEvent actionEvent) {
        tablaGestionTv.setItems(GestionList.getInstance().getGestionesGastos());
    }

    public void viewIngresosBt(ActionEvent actionEvent) {
        tablaGestionTv.setItems(GestionList.getInstance().getGestionesIngresos());
    }

    public void viewBothBt(ActionEvent actionEvent) {
        tablaGestionTv.setItems(GestionList.getInstance().getGestiones());
    }
}


