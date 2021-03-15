/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.pablogalvezrodriguez.proyectoarrays;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

/**
 *
 * @author 1DAW03
 */
public class SujikoView extends Group {
    GridPane sujikoView = new GridPane();
    Ocultos ocultos;
    GridPane sumasView = new GridPane();
    Sumas sumas;
    final int TAM_X = 100;
    final int TAM_Y = 100;
    public SujikoView (Ocultos ocultos, Sumas sumas){
        
        this.ocultos = ocultos;
        sujikoView.setMaxWidth(TAM_X);
        sujikoView.setMaxHeight(TAM_Y);
        //sujikoView.setScaleX(0.5);
        //sujikoView.setScaleY(0.5);
        sujikoView.setStyle("-fx-grid-lines-visible: true");
        for (int y=0; y<3; y++) {
            for (int x=0; x<3; x++) {
                int num = ocultos.getNumPos (x, y);
                if(num != 0) {
                    String strNum = String.valueOf(num);
                    Label label = new Label(strNum);
                    label.setPrefWidth(TAM_X);
                    label.setPrefHeight(TAM_Y);
                    label.setAlignment(Pos.CENTER);
                    label.setFont(new Font("Impact", 30));
                    sujikoView.add(label, x, y);
                } else {
                    Rectangle r = new Rectangle();
                    r.setWidth(TAM_X);
                    r.setHeight(TAM_Y);
                    r.setFill(Color.RED);
                    sujikoView.add(r, x, y);
                }
            }
        }

        String strSuma1 = String.valueOf(sumas.sumas [0][0]);
        Label suma1 = new Label(strSuma1);
        suma1.setFont(new Font("Impact", 30));
        suma1.setTranslateX(85);
        suma1.setTranslateY(80);
        
        Circle circulo1 = new Circle(30);
        circulo1.setTranslateX(70);
        circulo1.setTranslateY(70);
        circulo1.setStroke(Color.BLACK);
        circulo1.setFill(Color.SILVER);
        
        
        String strSuma2 = String.valueOf(sumas.sumas [1][0]);
        Label suma2 = new Label(strSuma2);
        suma2.setFont(new Font("Impact", 30));
        suma2.setTranslateX(185);
        suma2.setTranslateY(80);
        
        Circle circulo2 = new Circle(30);
        circulo2.setTranslateX(170);
        circulo2.setTranslateY(70);
        circulo2.setStroke(Color.BLACK);
        circulo2.setFill(Color.SILVER);
        
        
        String strSuma3 = String.valueOf(sumas.sumas [0][1]);
        Label suma3 = new Label(strSuma3);
        suma3.setFont(new Font("Impact", 30));
        suma3.setTranslateX(85);
        suma3.setTranslateY(180);
        
        Circle circulo3 = new Circle(30);
        circulo3.setTranslateX(70);
        circulo3.setTranslateY(170);
        circulo3.setStroke(Color.BLACK);
        circulo3.setFill(Color.SILVER);
        
        
        String strSuma4 = String.valueOf(sumas.sumas [1][1]);
        Label suma4 = new Label(strSuma4);
        suma4.setFont(new Font("Impact", 30));
        suma4.setTranslateX(185);
        suma4.setTranslateY(180);
        
        Circle circulo4 = new Circle(30);
        circulo4.setTranslateX(170);
        circulo4.setTranslateY(170);
        circulo4.setStroke(Color.BLACK);
        circulo4.setFill(Color.SILVER);
        
        
        
        sumasView.getChildren().add(circulo1);
        sumasView.getChildren().add(circulo2);
        sumasView.getChildren().add(circulo3);
        sumasView.getChildren().add(circulo4);
        
        //sumasView.getChildren().add(suma2);
        
        

        this.getChildren().add(sujikoView);
        this.getChildren().add(sumasView);
        this.getChildren().add(suma1);
        this.getChildren().add(suma2);
        this.getChildren().add(suma3);
        this.getChildren().add(suma4);
        this.mouseController();
    }
        private void mouseController() {
        this.setOnMouseClicked((MouseEvent mouseEvent) -> {
            System.out.println("X: " + mouseEvent.getX() + ", Y: "+ mouseEvent.getY() );
            int colClic = (int)(mouseEvent.getX() / TAM_X);
            int filClic = (int)(mouseEvent.getY() / TAM_Y);
            System.out.println("Col: " + colClic + ", Fil: " + filClic);
            int num = ocultos.getNumPos(colClic, filClic);
            System.out.println("Número: " + num);
        });
        }
    
}
