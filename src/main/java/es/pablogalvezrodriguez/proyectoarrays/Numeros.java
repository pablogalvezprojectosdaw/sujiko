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
public class Numeros {
    int[][] nums;
    
    public Numeros() {        
    nums = new int [3][3];
    //Random random = new Random();
    for (int y=0; y<3; y++){
            for (int x=0; x<3; x++){
            nums [x][y] = getNumAleatorio(1,9);
            }
        }
    }
    
    public void mostrarConsola() {
        for (int y=0; y<3; y++){
            for (int x=0; x<3; x++){
                System.out.print(nums[x][y] + " ");
            }
            System.out.println();
            }
    }
    
    
    public int getNumAleatorio(int min, int max) {
        Random random = new Random();
        int num = random.nextInt(max-min+1) + min;
        return num;
    }
    
    
}
