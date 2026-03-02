import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ATMApp extends Application {

    private double saldo = 1000.00; // saldo inicial
    private Label lblSaldo;
    private Label lblMensaje;
    private TextField txtMonto;

    @Override
    public void start(Stage primaryStage) {

        // Título
        Label titulo = new Label("CAJERO AUTOMÁTICO");
        titulo.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // Mostrar saldo
        lblSaldo = new Label("Saldo actual: $" + saldo);

        // Campo monto
        txtMonto = new TextField();
        txtMonto.setPromptText("Ingrese monto");

        // Botones
        Button btnDepositar = new Button("Depositar");
        Button btnRetirar = new Button("Retirar");
        Button btnConsultar = new Button("Consultar Saldo");
        Button btnSalir = new Button("Salir");

        // Área de mensaje
        lblMensaje = new Label();

        // Acciones
        btnDepositar.setOnAction(e -> depositar());
        btnRetirar.setOnAction(e -> retirar());
        btnConsultar.setOnAction(e -> consultarSaldo());
        btnSalir.setOnAction(e -> primaryStage.close());

        // Layout botones
        VBox botones = new VBox(10, btnDepositar, btnRetirar, btnConsultar, btnSalir);
        botones.setAlignment(Pos.CENTER);

        VBox root = new VBox(15, titulo, lblSaldo, txtMonto, botones, lblMensaje);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 350, 400);

        primaryStage.setTitle("ATM - JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void depositar() {
        try {
            double monto = Double.parseDouble(txtMonto.getText());
            if (monto > 0) {
                saldo += monto;
                lblMensaje.setText("Depósito exitoso.");
                actualizarSaldo();
            } else {
                lblMensaje.setText("Ingrese un monto válido.");
            }
        } catch (NumberFormatException e) {
            lblMensaje.setText("Ingrese un número válido.");
        }
        txtMonto.clear();
    }

    private void retirar() {
        try {
            double monto = Double.parseDouble(txtMonto.getText());
            if (monto > 0 && monto <= saldo) {
                saldo -= monto;
                lblMensaje.setText("Retiro exitoso.");
                actualizarSaldo();
            } else {
                lblMensaje.setText("Fondos insuficientes.");
            }
        } catch (NumberFormatException e) {
            lblMensaje.setText("Ingrese un número válido.");
        }
        txtMonto.clear();
    }

    private void consultarSaldo() {
        lblMensaje.setText("Saldo disponible: $" + saldo);
    }

    private void actualizarSaldo() {
        lblSaldo.setText("Saldo actual: $" + saldo);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
