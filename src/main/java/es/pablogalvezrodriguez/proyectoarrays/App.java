package es.pablogalvezrodriguez.proyectoarrays;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

//sujiko

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane paneRoot = new BorderPane();
        var scene = new Scene(paneRoot, 640, 480);
        stage.setScene(scene);
        stage.show();
        
        Numeros numeros = new Numeros();
        
        Sumas sumas = new Sumas(numeros);
        
        Ocultos ocultos = new Ocultos(numeros);
        
        CompAcierto compAcierto = new CompAcierto (numeros, ocultos);
        
        
        SujikoView sujikoView = new SujikoView(ocultos, sumas, numeros,compAcierto);
        
        
        
        
        paneRoot.setCenter(sujikoView);
        
        
        
        
        
        
        
        
        numeros.mostrarConsola();
        sumas.mostrarConsola();
        ocultos.mostrarConsola();

        
        
    }

    public static void main(String[] args) {
        launch();
    }

    
    
}