/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.vehiculos.aplicacion;

import ar.com.educacionit.vehiculos.entidades.Auto;
import ar.com.educacionit.vehiculos.presentacion.controladores.ConcesionariaControlador;
import ar.com.educacionit.vehiculos.presentacion.controladores.EdicionControlador;
import ar.com.educacionit.vehiculos.presentacion.controladores.VentanaMaestraControlador;
import ar.com.educacionit.vehiculos.presentacion.ventanas.Ventanas;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Rodolfo Durante
 */
public class APPConcesionaria extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private boolean internalWindowIsOpen = false;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle(Ventanas.VentanaPrincipal.getTitle());
        this.primaryStage.setMaximized(true);
        // this.primaryStage.setFullScreen(true);
        initVentanaMaestra();

    }

    public void initVentanaMaestra() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(Ventanas.VentanaPrincipal.getPath()));
            rootLayout = (BorderPane) loader.load();

            VentanaMaestraControlador controller = loader.getController();
            controller.setMainApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarVentanaModal(Ventanas ventana, Stage stage, Object entidad) {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(APPConcesionaria.class.getResource(ventana.getPath()));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle(ventana.getTitle());
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.setResizable(false);
            
            // Setea la entidad en el controller.
            EdicionControlador controller = loader.getController();            
            controller.setearEntidad(entidad);

            dialogStage.showAndWait();
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarVentanaInterna(Ventanas ventana) {
        if (!ventana.getIsopen()) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(ventana.getPath()));
                AnchorPane contactABM = (AnchorPane) loader.load();

                ConcesionariaControlador controller = loader.getController();
                controller.setMainApp(this);

                Stage internalStage = new Stage();
                internalStage.setTitle(ventana.getTitle());
                internalStage.initModality(Modality.NONE);
                internalStage.initOwner(primaryStage);
                Scene scene = new Scene(contactABM);
                internalStage.setScene(scene);
                internalStage.show();
                
                internalStage.setMinWidth(300);
                internalStage.setMinHeight(400);
                
                ventana.setIsopen(true);
                internalStage.setOnHidden((WindowEvent we) -> {
                    ventana.setIsopen(false);
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }


}
