/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package videojuegorpg;

/**
 *
 * @author Javier Ariza
 */
public class Videojuegorpg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JefeFinal j = new JefeFinal();
        Enemigo e = new Enemigo("Yasi" , 1);
        Jugador j1 = new Jugador("Javi" , "Mago");
        j1.iniciarClase();
        e.calcularEstadisticasEnemigo();
     
        
       
        
        System.out.println(j1);
        System.out.println(e);
        e.atacar(j1);
        
        System.out.println(j1);
        // TODO code application logic here
    }
    
}
