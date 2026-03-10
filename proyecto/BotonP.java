package proyecto;

import javafx.scene.control.Button;

public class BotonP extends Button {
    public class BotonP(String texto){
        super (texto);
        this.getStyleClass().add("boton-perso");

        this.setOnMouseEntered(e-> this.setScaleX(1.05));
        this.setOnMouseEntered(e-> this.setScaleY(1.05));
        this.setOnMouseExited(e->{
            this.setScaleX(1);
            this.setScaleY(1);
        });
        
    }

    
}