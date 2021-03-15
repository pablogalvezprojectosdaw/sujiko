
package es.pablogalvezrodriguez.proyectoarrays;

public class Ocultos {
    int [][] ocultos;
    public Ocultos (Numeros numeros) {
        ocultos = new int [3][3];
        ocultos [0][0] = numeros.nums[0][0];
        ocultos [0][2] = numeros.nums[0][2];
        ocultos [2][0] = numeros.nums[2][0];
        ocultos [2][2] = numeros.nums[2][2];
    }
    
    public void mostrarConsola() {
        for (int y=0; y<3; y++){
            for (int x=0; x<3; x++){
                System.out.print(ocultos[x][y] + " ");
            }
            System.out.println();
            }   
    }
    
    public int getNumPos (int posx, int posy) {
        try {
            return ocultos[posx][posy];
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }
    
    
}
