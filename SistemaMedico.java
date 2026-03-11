import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SistemaMedico extends Application {

    @Override
    public void start(Stage stage) {

        Label lblTitulo = new Label("Sistema Médico");

        TextField txtusuario = new TextField();
        txtusuario.setPromptText("Usuario");

        PasswordField txtPass = new PasswordField();
        txtPass.setPromptText("Password");

        Button btnLogin = new Button("Login");
        Label lblMensaje = new Label("");

        VBox loginLayout = new VBox(10, lblTitulo, txtusuario, txtPass, btnLogin, lblMensaje);
        Scene loginScene = new Scene(loginLayout, 400, 300);

        btnLogin.setOnAction(e -> {

            String usuario = txtusuario.getText();
            String pass = txtPass.getText();

            if (usuario.equals("admin") && pass.equals("admin123")) {

                Label titulo = new Label("Sistema de citas medicas");

                TextField txtNombre = new TextField();
                txtNombre.setPromptText("Nombre del paciente");

                TextField txtFecha = new TextField();
                txtFecha.setPromptText("Fecha de la cita (dd/mm/yyyy)");

                Button btnGuardar = new Button("Guardar cita");
                Label lblResultado = new Label("");

                btnGuardar.setOnAction(ev -> {

                    String nombre = txtNombre.getText();
                    String fecha = txtFecha.getText();

                    if (nombre.isEmpty() || fecha.isEmpty()) {
                        lblResultado.setText("Por favor complete todos los campos");
                    } else {
                        lblResultado.setText("Cita guardada para " + nombre + " el " + fecha);
                    }

                });

                VBox citasLayout = new VBox(10, titulo, txtNombre, txtFecha, btnGuardar, lblResultado);
                Scene citasScene = new Scene(citasLayout, 400, 300);

                stage.setScene(citasScene);
                stage.setTitle("Sistema de citas medicas");

            } else {
                lblMensaje.setText("Usuario o contraseña incorrectos");
            }

        });

        stage.setScene(loginScene);
        stage.setTitle("Sistema Médico");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}