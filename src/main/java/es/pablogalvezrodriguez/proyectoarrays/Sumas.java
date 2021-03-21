/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.pablogalvezrodriguez.proyectoarrays;

import java.util.Random;

/**
 *
 * @author 1DAW03
 */
public class Sumas {
    int [][] sumas;
    
    //array sumas, estos son los cuatro numeros centrales, que suman los numeros que hay que adivinar
    public Sumas(Numeros numeros) {        
        sumas = new int [2][2];
        //Random random = new Random();
        sumas [0][0] = numeros.nums[0][0] + numeros.nums[1][0] + numeros.nums[0][1] + numeros.nums[1][1];
        sumas [1][0] = numeros.nums[1][0] + numeros.nums[2][0] + numeros.nums[1][1] + numeros.nums[2][1];
        sumas [0][1] = numeros.nums[0][1] + numeros.nums[1][1] + numeros.nums[0][2] + numeros.nums[1][2];
        sumas [1][1] = numeros.nums[1][1] + numeros.nums[1][2] + numeros.nums[1][2] + numeros.nums[2][2];
        
    }
    
    public void mostrarConsola() {
        for (int y=0; y<2; y++){
            for (int x=0; x<2; x++){
                System.out.print(sumas[x][y] + " ");
            }
            System.out.println();
            }

        
    }
    
    
    public int getNumAleatorio(int min, int max) {
        Random random = new Random();
        int num = random.nextInt(max-min+1) + min;
        return num;
    }
    
        public int getNumPos (int posx, int posy) {
        try {
            return sumas[posx][posy];
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }
    
}
