package com.example.main ;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Launcher extends Application {
    @Override
    public void start (Stage stage) {
        //etiqueta de bienvenida
        Label etiquetaTitulo = new Label("HOLA MUNDO");
        etiquetaTitulo.setStyle("-fx-front-size: 16px; -fx-front-weight: bold;");

        //campo de texto para ingresar el nombre
        TextField campoNombre = new TextField();
        campoNombre.setPromptText("Escribe tu nombre:");

        // Botón de acción
        Button botonSaludar = new Button ("saludar");

        //Etiqueta para mostrar el resultado
        Label etiquetaResultado = new Label ();

        //Evento del botón
        botonSaludar.setOnAction( e ->{
            String nombre =campoNombre.getText();
            if (nombre.isEmpty()) {
                etiquetaResultado.setText("por favor, escribe tu nombre: ");
            } else {
                etiquetaResultado.setText("Hola" + nombre + ",bienvenido al curso");
                botonSaludar.setText("Saludar de nuevo");
            }
        });
        // contenedor vertical
        VBox contenedor = new VBox (10);
        contenedor.getChildren().addAll(
                etiquetaTitulo,
                campoNombre,
                botonSaludar,
                etiquetaResultado
        );
        contenedor.setStyle ("-fx-padding:20;");
        //Escena
        Scene escena  = new Scene (contenedor, 420, 250);
        //Configuración del escenario (ventana)
        stage.setTitle("Mi primera interfaz JavaFx");
        stage.setScene(escena);
        stage.show();


    }
    public static void main (String [] args){
        launch (args);
    }
}