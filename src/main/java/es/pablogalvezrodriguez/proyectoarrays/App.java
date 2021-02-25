package es.pablogalvezrodriguez.proyectoarrays;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

//sujiko

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Pane paneRoot = new Pane();
        var scene = new Scene(paneRoot, 640, 480);
        stage.setScene(scene);
        stage.show();
        
        Numeros numeros = new Numeros();
        
        Sumas sumas = new Sumas(numeros);
        
        numeros.mostrarConsola();
        sumas.mostrarConsola();
        
    }

    public static void main(String[] args) {
        launch();
    }

    
    
}