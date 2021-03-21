/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.pablogalvezrodriguez.proyectoarrays;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
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
    GridPane sujikoView = new GridPane(); //gridpane principal
    Ocultos ocultos;
    GridPane sumasView = new GridPane(); //gridpane de las sumas
    Sumas sumas;
    Label [][] labelArray = new Label[3][3]; //array de labels, un array que se podrá cambiar en el juego a base de "settext"
    String strNum1;
    Numeros nums;
    int colClic; //clic de columna
    int filClic; //clic de fila
    final int TAM_X = 100;
    final int TAM_Y = 100;
    public SujikoView (Ocultos ocultos, Sumas sumas, Numeros numeros, CompAcierto compAcierto){
        
        //montaje del array
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
                    labelArray [x][y] = label;
                    sujikoView.add(label, x, y);
                } else {
                    Rectangle r = new Rectangle();
                    r.setWidth(TAM_X);
                    r.setHeight(TAM_Y);
                    r.setFill(Color.RED);
                    String strNum = String.valueOf(num);
                    Label nonum = new Label(strNum);
                    nonum.setMinWidth(TAM_X);
                    nonum.setMinHeight(TAM_Y);
                    nonum.setAlignment(Pos.CENTER);
                    nonum.setFont(new Font("Impact", 30));
                    labelArray [x][y] = nonum;
                    sujikoView.add(nonum, x, y);
                    
                    
                }
            }
        }

        
        //montage del array de sumas
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
        
        //montaje de los botones, cada uno puede cambiar el digito del gridpane principal, tanto visual como logicamente
        
        Button button1 = new Button("1");
        button1.setTranslateX(50);
        button1.setTranslateY(410);
        button1.setOnAction((ActionEvent e) -> {
            labelArray[colClic][filClic].setText("1");
            ocultos.arrayOcultos[colClic][filClic] = 1;
            compAcierto.tableroCompleto(ocultos);
            if (compAcierto.tableroCompleto(ocultos) == false) {
                System.out.println("el tablero no está completo");
            } else {
                compAcierto.compArrays(numeros, ocultos);
            }
            
        });
        
        Button button2 = new Button("2");
        button2.setTranslateX(100);
        button2.setTranslateY(410);
        button2.setOnAction((ActionEvent e) -> {
            labelArray[colClic][filClic].setText("2");
            ocultos.arrayOcultos[colClic][filClic] = 2;
            if (compAcierto.tableroCompleto(ocultos) == false) {
                System.out.println("el tablero no está completo");
            } else {
                compAcierto.compArrays(numeros, ocultos);
            }
        });
        
        Button button3 = new Button("3");
        button3.setTranslateX(150);
        button3.setTranslateY(410);
        button3.setOnAction((ActionEvent e) -> {
            labelArray[colClic][filClic].setText("3");
            ocultos.arrayOcultos[colClic][filClic] = 3;
            if (compAcierto.tableroCompleto(ocultos) == false) {
                System.out.println("el tablero no está completo");
            } else {
                compAcierto.compArrays(numeros, ocultos);
            }
        });
        
        Button button4 = new Button("4");
        button4.setTranslateX(200);
        button4.setTranslateY(410);
        button4.setOnAction((ActionEvent e) -> {
            labelArray[colClic][filClic].setText("4");
            ocultos.arrayOcultos[colClic][filClic] = 4;
            if (compAcierto.tableroCompleto(ocultos) == false) {
                System.out.println("el tablero no está completo");
            } else {
                compAcierto.compArrays(numeros, ocultos);
            }
        });
        
        Button button5 = new Button("5");
        button5.setTranslateX(250);
        button5.setTranslateY(410);
        button5.setOnAction((ActionEvent e) -> {
            labelArray[colClic][filClic].setText("5");
            ocultos.arrayOcultos[colClic][filClic] = 5;
            if (compAcierto.tableroCompleto(ocultos) == false) {
                System.out.println("el tablero no está completo");
            } else {
                compAcierto.compArrays(numeros, ocultos);
            }
        });
        
        Button button6 = new Button("6");
        button6.setTranslateX(300);
        button6.setTranslateY(410);
        button6.setOnAction((ActionEvent e) -> {
            labelArray[colClic][filClic].setText("6");
            ocultos.arrayOcultos[colClic][filClic] = 6;
            if (compAcierto.tableroCompleto(ocultos) == false) {
                System.out.println("el tablero no está completo");
            } else {
                compAcierto.compArrays(numeros, ocultos);
            }
        });
        
        Button button7 = new Button("7");
        button7.setTranslateX(350);
        button7.setTranslateY(410);
        button7.setOnAction((ActionEvent e) -> {
            labelArray[colClic][filClic].setText("7");
            ocultos.arrayOcultos[colClic][filClic] = 7;
            if (compAcierto.tableroCompleto(ocultos) == false) {
                System.out.println("el tablero no está completo");
            } else {
                compAcierto.compArrays(numeros, ocultos);
            }
        });
        
        Button button8 = new Button("8");
        button8.setTranslateX(400);
        button8.setTranslateY(410);
        button8.setOnAction((ActionEvent e) -> {
            labelArray[colClic][filClic].setText("8");
            ocultos.arrayOcultos[colClic][filClic] = 8;
            if (compAcierto.tableroCompleto(ocultos) == false) {
                System.out.println("el tablero no está completo");
            } else {
                compAcierto.compArrays(numeros, ocultos);
            }
        });
        
        Button button9 = new Button("9");
        button9.setTranslateX(450);
        button9.setTranslateY(410);
        button9.setOnAction((ActionEvent e) -> {
            labelArray[colClic][filClic].setText("9");
            ocultos.arrayOcultos[colClic][filClic] = 9;
            if (compAcierto.tableroCompleto(ocultos) == false) {
                System.out.println("el tablero no está completo");
            } else {
                compAcierto.compArrays(numeros, ocultos);
            }
        });
        
        
        
       Button reinicio = new Button("Reiniciar");
       reinicio.setTranslateX(400);
       reinicio.setTranslateY(250);
       reinicio.setOnAction((ActionEvent e) -> {
          
       });

       
        this.getChildren().add(sujikoView);
        this.getChildren().add(sumasView);
        
        this.getChildren().add(suma1);
        this.getChildren().add(suma2);
        this.getChildren().add(suma3);
        this.getChildren().add(suma4);
        
        
        this.getChildren().add(button1);
        this.getChildren().add(button2);
        this.getChildren().add(button3);
        this.getChildren().add(button4);
        this.getChildren().add(button5);
        this.getChildren().add(button6);
        this.getChildren().add(button7);
        this.getChildren().add(button8);
        this.getChildren().add(button9);
        this.getChildren().add(reinicio);
        this.mouseController();
        
    }
    
    
    //Control del mouse
        private void mouseController() {
        this.setOnMouseClicked((MouseEvent mouseEvent) -> {
            System.out.println("X: " + mouseEvent.getX() + ", Y: "+ mouseEvent.getY() );
            colClic = (int)(mouseEvent.getX() / TAM_X);
            filClic = (int)(mouseEvent.getY() / TAM_Y);
            System.out.println("Col: " + colClic + ", Fil: " + filClic);
            int num = ocultos.getNumPos(colClic, filClic);
            System.out.println("Número: " + num);
            
        });
        }
    
}
