/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.pablogalvezrodriguez.proyectoarrays;

/**
 *
 * @author 1DAW03
 */
public class CompAcierto {
    
    public CompAcierto (Numeros numeros, Ocultos ocultos) {
        
    }
    

    
    public boolean tableroCompleto (Ocultos ocultos) {
        for (int y=0; y<3; y++) {
            for (int x=0; x<3; x++) {
                int hayCeroOcultos = ocultos.getNumPos (x, y);
                if (hayCeroOcultos == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void compArrays (Numeros numeros, Ocultos ocultos) {
        for (int y=0; y<3; y++) {
            for (int x=0; x<3; x++) {
                int compOcultos = ocultos.getNumPos (x, y);
                int compNumeros = numeros.getNumPos (x, y);
                    if (compOcultos == compNumeros) {
                        System.out.println("wow lo has conseguido");
                    }
                }
            }
        }

}
