
package es.pablogalvezrodriguez.proyectoarrays;

public class Ocultos {
    int [][] arrayOcultos;
    public Ocultos (Numeros numeros) {
        arrayOcultos = new int [3][3];
        arrayOcultos [0][0] = numeros.nums[0][0];
        arrayOcultos [0][2] = numeros.nums[0][2];
        arrayOcultos [2][0] = numeros.nums[2][0];
        arrayOcultos [2][2] = numeros.nums[2][2];
    }
    
    public void mostrarConsola() {
        for (int y=0; y<3; y++){
            for (int x=0; x<3; x++){
                System.out.print(arrayOcultos[x][y] + " ");
            }
            System.out.println();
            }   
    }
    
    public int getNumPos (int posx, int posy) {
        try {
            return arrayOcultos[posx][posy];
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }
    
    
}
