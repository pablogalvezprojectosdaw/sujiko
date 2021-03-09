/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.pablogalvezrodriguez.proyectoarrays;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author 1DAW03
 */
public class SujikoView extends GridPane {
    Numeros numeros;
    
    public SujikoView (Numeros numeros){
        this.numeros = numeros;
        this.setMaxWidth(300);
        this.setMaxHeight(300);
        this.setStyle("-fx-grid-lines-visible: true");
        for (int y=0; y<3; y++) {
            for (int x=0; x<3; x++) {
                int num = numeros.getNumPos (x, y);
                if(num != 0) {
                    String strNum = String.valueOf(num);
                    Label label = new Label(strNum);
                    label.setPrefWidth(100);
                    label.setPrefHeight(100);
                    label.setAlignment(Pos.CENTER);
                    this.add(label, x, y);
                } else {
                    Rectangle r = new Rectangle();
                    r.setWidth(100);
                    r.setHeight(100);
                    r.setFill(Color.RED);
                    this.add(r, x, y);
                }
            }
        }
    }
}
