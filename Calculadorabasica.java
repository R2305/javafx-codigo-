package com.example.calculadora;

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class Calculadorabasica extends Application {

    private TextField txt1;
    private TextField txt2;
    private Label lblResultado;

    public static void main(String[] args) {
        Application.launch(Calculadorabasica.class, args);
    }

    @Override
    public void start(Stage stage) {

        MenuBar menuBar = new MenuBar();

        Menu menuArchivo = new Menu("Archivo");
        MenuItem itemAcerca = new MenuItem("Acerca de");
        MenuItem itemLimpiar = new MenuItem("Limpiar");
        MenuItem itemSalir = new MenuItem("Salir");

        menuArchivo.getItems().addAll(itemAcerca, itemLimpiar, itemSalir);
        menuBar.getMenus().add(menuArchivo);

        Label titulo = new Label("Calculadora Basica");
        titulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #0d47a1;");

        txt1 = new TextField();
        txt1.setPromptText("Número 1");

        txt2 = new TextField();
        txt2.setPromptText("Número 2");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        grid.add(new Label("Numero 1:"), 0, 0);
        grid.add(txt1, 1, 0);

        grid.add(new Label("Numero 2:"), 0, 1);
        grid.add(txt2, 1, 1);

        Button btnSuma = new Button("Suma");
        Button btnResta = new Button("Resta");
        Button btnMulti = new Button("Multiplicacion");
        Button btnDiv = new Button("Division");

        btnSuma.setStyle("-fx-background-color: #64b5f6;");
        btnResta.setStyle("-fx-background-color: #64f673;");
        btnMulti.setStyle("-fx-background-color: #c714c7;");
        btnDiv.setStyle("-fx-background-color: #d9d31f;");

        btnSuma.setMaxWidth(Double.MAX_VALUE);
        btnResta.setMaxWidth(Double.MAX_VALUE);
        btnMulti.setMaxWidth(Double.MAX_VALUE);
        btnDiv.setMaxWidth(Double.MAX_VALUE);

        GridPane gridBotones = new GridPane();
        gridBotones.setHgap(10);
        gridBotones.setVgap(10);

        gridBotones.add(btnSuma, 0, 0);
        gridBotones.add(btnResta, 1, 0);
        gridBotones.add(btnMulti, 0, 1);
        gridBotones.add(btnDiv, 1, 1);

        lblResultado = new Label("Resultado:");
        lblResultado.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #1b5e20;");

        btnSuma.setOnAction(e -> operar("+"));
        btnResta.setOnAction(e -> operar("-"));
        btnMulti.setOnAction(e -> operar("*"));
        btnDiv.setOnAction(e -> operar("/"));

        itemLimpiar.setOnAction(e -> limpiar());
        itemSalir.setOnAction(e -> stage.close());

        itemAcerca.setOnAction(e -> {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Acerca de");
            alerta.setHeaderText(null);
            alerta.setContentText("Calculadora Basica con JavaFX");
            alerta.showAndWait();
        });

        VBox root = new VBox(15, menuBar, titulo, grid, gridBotones, lblResultado);
        root.setPadding(new Insets(15));
        root.setAlignment(Pos.TOP_CENTER);
        root.setStyle("-fx-background-color: #e3f2fd;");

        Scene scene = new Scene(root, 400, 350);

        stage.setTitle("Calculadora Basica con JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    private void operar(String op) {
        try {
            double n1 = Double.parseDouble(txt1.getText());
            double n2 = Double.parseDouble(txt2.getText());
            double res = 0;

            switch (op) {
                case "+":
                    res = n1 + n2;
                    break;
                case "-":
                    res = n1 - n2;
                    break;
                case "*":
                    res = n1 * n2;
                    break;
                case "/":
                    if (n2 == 0) {
                        mostrarAlerta("No se puede dividir entre cero.");
                        return;
                    }
                    res = n1 / n2;
                    break;
            }

            lblResultado.setText("Resultado: " + res);

        } catch (NumberFormatException e) {
            mostrarAlerta("Ingresa valores numericos validos.");
        }
    }

    private void limpiar() {
        txt1.clear();
        txt2.clear();
        lblResultado.setText("Resultado:");
    }

    private void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Advertencia");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}