package com.example.application;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculadoraAv extends Application {
    private  TextField pantalla;
    public static void main(String[] args) {Application.launch(HelloApplication.class, args);
        launch (args);
    }
    @Override
    public void start (Stage stage){
        pantalla = new TextField();
        pantalla.setEditable(false);
        pantalla.setStyle("-fx-font-size: 20px;");
        pantalla.setPrefHeight(50);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        String [] numeros = {
        "7","8","9",
        "4","5","6",
        "1","2","3",
        "0"
        };
        int fila = 0;
        int col = 0;

        for (String num : numeros){
            Button btn = crearBoton(num);
            btn.setOnAction(e->agregarTexto(num));
            grid.add(btn,col,fila);

        }
    }

    Button btnSuma = crearBoton ("+");
    btnSuma.setOnAction(e->agregarTexto("+"));

    Button btnResta = crearBoton ("-");
    btnResta.setOnAction(e->agregarTexto("-"));

    Button btnMulti = crearBoton ("*");
    btnMulti.setOnAction(e->agregarTexto("*"));

    Button btnDiv = crearBoton ("/");
    btnDiv.setOnAction(e->agregarTexto("/"));

    Button btnIgual = crearBoton ("=");
    btnIgual.setOnAction(e->agregarTexto("="));

    Button btnLimpiar = crearBoton ("C");
    btnLimpiar.setOnAction(e->pantalla.clear());

    grid.add(btnDiv,3,0);
    grid.add(btnMulti,3,1);
    grid.add(btnResta,3,2);
    grid.add(btnSuma,3,3);
    grid.add(btnLimpiar,1,4);
    grid.add(btnIgual,2,4);

    Vbox root = new vbox (10,pantalla,grid);
    root.setPadding(new Insets(15));
    root.setAligment(Pos.CENTER);

    Scene scene = new Scene (root,300,350);

    stage.setTitle("Calculadora JavaFx Avanzada");
    stage.setScene(scene);
    stage.show();

}

private void agregarTexto(String valor){
    pantalla.setText(pantalla.getText() +valor);
}
private void crearBoton (String texto){
    Button btn = new Button (texto);
    btn.setPrefSize(60,60);
    btn.setMaxSize(Double.MAx_VALUE,Double.MAX_VALUE);
    return btn;
}
